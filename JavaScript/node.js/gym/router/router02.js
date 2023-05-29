//导入
var express = require('express')
var bodyParser = require('body-parser')
var runsql = require('../utils/runsql')
const code = require('svg-captcha')
const redis = require('redis')
const session = require("express-session")

var app = express() 

//配置session
app.use(session({
    secret: "Tjw",	// 对cookie进行签名
    name: "session",// cookie名称，默认为connect.sid
    resave: false,	// 强制将会话保存回会话容器
    rolling: true,	// 强制在每个response上设置会话标识符cookie
    saveUninitialized:true,
    cookie: {
        // 5分钟
     	maxAge: 300000
    }
})) 
 
//配置redis
const client = redis.createClient({
    host: "192.168.56.101",	//	redis地址
    port: 6371	// 端口号
})
// 监听连接事件
client.on("connect", error => {
    if(!error) {
        console.log("connect to redis")
    }
})
// 监听错误事件
client.on("error", error => {
    throw new Error(error)
})
function setString(key, value, expire) {
    return new Promise((resolve, reject) => {
        client.set(key, value, (error, replay) => {
            if(error) {
                reject("设置失败")
            }
            if(expire) {
                client.expire(key, expire);
            }
            resolve("设置成功")
        });
    })
}
function getString(key) {
    return new Promise((resolve, reject) => {
        if(key) {
            client.get(key, (error, replay) => {
                if(error) {
                    reject(`获取${key}失败`)
                }
                resolve(replay);
            })
        }
    })
}

//建立一个路由
var router = express.Router()
router.use(bodyParser.urlencoded({ extended: false }))
router.use(bodyParser.json())

//首页
router.get('/', (req, res) => {
    res.render('index.html')
})

//验证码配置
function createCode() {
    return code.create({
        size: 4,
        ignoreChars: "0o1iIl",
        noise: 5,
        color: true,
        background: "#fff",
        fontSize: 60
    })
}
//获取验证码图片
router.get('/code', (req, res) => {
    let code = createCode()
    setString(req.sessionID, code.text.toLowerCase(), 300)
    res.type('svg')
    res.status(200).send(code.data)
    res.end()
})

//登录
router.post('/api/login/login', (req, res) => {
    // signedCookies即被签名过的cookie
    if(!req.signedCookies.session) {
        res.send({success: "no", msg: "验证码过期"})
        return
    }
    let code = req.body.code.toLowerCase()
    let username = req.body.username
    let password = req.body.password
    let userType = req.body.userType
    getString(req.signedCookies.session).then(data => {
        if(code === data) {
            console.log("验证码正确")
            let sql = `select * from sys_user where username = '${username}' and password = ${password} and user_type = ${userType}`
            console.log('SQL: ', sql)
            runsql(sql, (error, result) => {
                if (error) {
                    res.send({success: "no", msg: "用户名或密码错误"})
                    return
                } else {
                    // 根据登录用户名设置cookie，并规定只能cookie存活30分钟
                    res.cookie("uid", username, {maxAge: 300000})
                    res.send(result)
                }
            })
        }else {
            res.send({success: "no", msg: "验证码错误"})
        }
    }).catch(err => {
        console.log(err)
    })
})

//热销课程
router.get('/api/home/getHotCourse', (req, res) => {
    let sql = `select c.course_name as name,count(mc.member_course_id) as value from course as c
    left join member_course as mc  on c.course_id = mc.course_id
    GROUP BY c.course_id`
    runsql(sql, (error, result) => {
        if (error) {
            console.log('执行失败: ', error)
            return
        } else {
            res.send(result)
        }
    })
})

//热销卡
router.get('/api/home/getHotCards', (req, res) => {
    let sql = `select ma.card_type as name,count(ma.apply_id) as value from member_apply as ma
    GROUP BY ma.card_type,ma.card_day
    order by value desc
    limit 7`
    runsql(sql, (error, result) => {
        if (error) {
            console.log('执行失败: ', error)
            return
        } else {
            res.send(result)
        }
    })
})

//热销商品
router.get('/api/home/getHotGoods', (req, res) => {
    let sql = `select g.name ,sum(gd.num) as value from goods as g
    inner join goods_order as gd  on gd.goods_id = g.goods_id
    GROUP BY g.goods_id
    order by value desc
    limit 7`
    runsql(sql, (error, result) => {
        if (error) {
            console.log('执行失败: ', error)
            return
        } else {
            res.send(result)
        }
    })
})

//导出
module.exports = router

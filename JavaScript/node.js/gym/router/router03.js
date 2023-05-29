//导入
var express = require('express')
var bodyParser = require('body-parser')
var runsql = require('../utils/runsql')
const code = require('svg-captcha')

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
//验证码图片
router.get('/code', (req, res) => {
    let code = createCode()
    req.session.code = code.text.toLowerCase();
    res.type('svg')
    res.status(200).send(code.data)
    res.end()
})
 
//登录
router.post('/api/login/login', (req, res) => {
    let code = req.body.code.toLowerCase()
    let username = req.body.username
    let password = req.body.password
    let userType = req.body.userType
    let sql = `select * from sys_user where username = '${username}' and password = ${password} and user_type = ${userType}`
    runsql(sql, (error, result) => {
        if (error || result.length == 0) {
            res.send({code: '400'})
            return
        } else {
            res.send({code: '200', data: result})
        }
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
            res.send({code: '400'})
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
            res.send({code: '400'})
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
            res.send({code: '400'})
            return
        } else {
            res.send(result)
        }
    })
})
 
//反馈列表
router.get('/api/home/getSuggest', (req, res) => {
    let sql = `select * from suggest limit 0, 3`
    runsql(sql, (error, result) => {
        if (error) {
            console.log('执行失败: ', error)
            res.send({code: '400'})
            return
        } else {
            res.send(result)
        }
    })
}) 

//会员总数
router.get('/api/home/memberCount', (req, res) => {
    let sql = `SELECT count(*) FROM member`
    runsql(sql, (error, result) => {
        if (error) {
            console.log('执行失败: ', error)
            res.send({code: '400'})
            return
        } else {
            res.send(result)
        }
    })
})

//员工总数
router.get('/api/home/userCount', (req, res) => {
    let sql = `SELECT count(*) FROM sys_user`
    runsql(sql, (error, result) => {
        if (error) {
            console.log('执行失败: ', error)
            res.send({code: '400'})
            return
        } else {
            res.send(result)
        }
    })
})

//器材总数
router.get('/api/home/materialCount', (req, res) => {
    let sql = `SELECT count(*) FROM material`
    runsql(sql, (error, result) => {
        if (error) {
            console.log('执行失败: ', error)
            res.send({code: '400'})
            return
        } else {
            res.send(result)
        }
    })
})

//失物总数
router.get('/api/home/lostCount', (req, res) => {
    let sql = `SELECT count(*) FROM lost`
    runsql(sql, (error, result) => {
        if (error) {
            console.log('执行失败: ', error)
            res.send({code: '400'})
            return
        } else {
            res.send(result)
        }
    })
})


//导出
module.exports = router

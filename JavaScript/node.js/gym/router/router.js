//导入
var express = require('express'); 
var bodyParser = require('body-parser');
var runsql = require('../utils/runsql');

//建立一个路由
var router = express.Router();

//首页
router.get('/', (req, res) => {
    res.render('index.html')
})

//验证码


//登录
router.post('/api/login/login', (req, res) => {
    let username = req.body.username
    let password = req.body.password
    let userType = req.body.userType
    let sql = `select * from sys_user where username = '${username}' and password = ${password} and user_type = ${userType}`
    console.log('SQL: ', sql);
    runsql(sql, (error, result) => {
        if (error) {
            console.log('执行失败: ', error);
            return;
        }else{
            res.send(result)  
        }
    })
})

//

//导出
module.exports = router
//操作数据库
var express = require('express');
var runsql = require('../util/runsql.js');

//建立路由容器
var router = express.Router();

//查询
var sql01 = "select * from user";

//首页
router.get('/', (req, res) => {
    runsql(sql01, (err,result) => {
        if(err){
            console.log(err);
            return;
        }
        res.render('index.html', {
            items : result
        });

    });
});

//mysql查询user信息


module.exports = router;

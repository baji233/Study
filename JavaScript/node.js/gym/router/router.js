//导入
var express = require('express'); 
var bodyParser = require('body-parser');
var runsql = require('../utils/runsql');

//建立一个路由
var router = express.Router();

router.get('/', (req, res) => {
    res.render('index.html')
})

//导出
module.exports = router
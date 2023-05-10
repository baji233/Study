var express = require('express');
var temp = require('express-art-template');//处理get请求的模块
var bodyParser = require('body-parser');//处理post请求
var router = require('./router/router01.js'); //导入路由文件
//服务器
var app = express();
//使用模板引擎
app.engine('html',temp);
app.use(bodyParser.urlencoded({extended: false}));
//可以直接访问静态网页
app.use('/public',express.static('public'));
app.use(router);

//启动server, 127.0.0.0:9090
app.listen(9090,()=>{
	console.log('服务器已启动!');
});
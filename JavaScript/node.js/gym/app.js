//导入
var express = require('express')
var temp = require('express-art-template')
var bodyParser = require('body-parser')
var router = require('./router/router')

//创建服务器
const app = express()

//使用模板引擎
app.engine('html',temp);
app.use(bodyParser.urlencoded({extended: false}));

//静态网页可以直接访问
app.use('/public', express.static('public'))

//中间件：对所有的请求都进行跨域访问设置处理
app.all('*',function(req,res,next){
    res.header("Access-Control-Allow-Credentials", true);
    res.header("Access-Control-Allow-Origin", "*");
    res.header('Access-Control-Allow-Methods', '*');
    res.header("Access-Control-Allow-Headers", "X-Requested-With","Content-Type","token");
    next(); //执行下一个中间件
});

//所有路由移动到router文件
app.use(router)

//启动服务器并接收两个配置参数: 一个是对应的端口号, 一个是启动成功的回调函数
app.listen(9500, () => {
    console.log('服务器启动成功: http://localhost:9500/');
})
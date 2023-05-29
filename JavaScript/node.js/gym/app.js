//导入
var express = require('express')
var temp = require('express-art-template')
var bodyParser = require('body-parser')
var router = require('./router/router')
var session = require('express-session')
var cookieParser = require('cookie-parser')

//创建服务器
const app = express()

//开启cookie并且配置session的内容
app.use(cookieParser())

//配置session 
app.use(session({
    secret: "tjw",
    name: 'connect.sid',
    resave: false,
    saveUninitialized: true,
    cookie:{ maxAge:80*1000, }, //设置cookie的过期时间
}));

//接收post发送的数据
app.use(express.json({ limit: '1024mb' }));
app.use(bodyParser.urlencoded({
    extended: true
}));
app.use(bodyParser.json());

//使用模板引擎
app.engine('html', temp);
app.use(bodyParser.urlencoded({ extended: false }));

//静态网页可以直接访问
app.use('/public', express.static('public'))

// //中间件：对所有的请求都进行跨域访问设置处理
app.all('*', function (req, res, next) {
    res.header("Access-Control-Allow-Credentials", true);
    //响应头指定了该响应的资源是否被允许与给定的origin共享。*表示所有域都可以访问，同时可以将*改为指定的url，表示只有指定的url可以访问到资源 
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", " Origin, X-Requested-With, Content-Type, Accept");
    //允许请求资源的方式
    res.header("Access-Control-Allow-Methods", "*");
    res.header("X-Powered-By", ' 3.2.1');
    res.header("Content-Type", "application/json;charset=utf-8");
    next();
});

//所有路由移动到router文件
app.use(router)

//启动服务器并接收两个配置参数: 一个是对应的端口号, 一个是启动成功的回调函数
app.listen(9500, () => {
    console.log('服务器启动成功: http://localhost:9500/');
})


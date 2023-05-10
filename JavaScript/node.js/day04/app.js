// //引入模块
// var express = require('express');
// var temp = require('express-art-template')
// var bodyParser = require('body-parser')
// var router = require('./router/router')
// //服务器
// var app =express();
// //使用模板引擎
// app.engine('html',temp);
// app.use(bodyParser.urlencoded({extended:false}));
// //静态网页可以直接访问 css ,js
// app.use('/public',express.static('public'));
// //允许跨域
// app.all('*',function(req,res,next){
//     res.header("Access-Control-Allow-Credentials",true);
//     res.header("Access-Control-Allow-Origin","*");
//     res.header("Access-Control-Allow-Headers","X-Requested-With","Content-Type");
//     res.header("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");
//     //执行下一个中间件
//     next();
// })

//引入模块
var router = require('./router/router')
var express = require('express');
var temp =require('express-art-template')
var bodyParser = require('body-parser')
var runsql = require('./utils/runsql.js');
//服务器
var app = express();
//使用模板引擎
app.engine('html',temp);
app.use(bodyParser.urlencoded({extended: false}));
// 静态网页可以直接访问  css,js
app.use('/public', express.static('public'))
//中间件：对所有的请求都进行跨域访问设置处理
app.all('*',function(req,res,next){
    res.header("Access-Control-Allow-Credentials", true);
    res.header("Access-Control-Allow-Origin", "*");
    res.header('Access-Control-Allow-Methods', '*');
    res.header("Access-Control-Allow-Headers", "X-Requested-With","Content-Type","token");

    //执行下一个中间件
    next();
});

//所有路由移动到其他文件里
app.use(router)
//json返回
app.get('/json',(req,res)=>{
    let stu = {
        name: 'temo',
        age: 18,
        sex: '男'
    };
    res.send(stu);
})

//接收前端axios的请求

//post服务
app.post('/books', (req, res) => {
    let tk =  req.headers.token ;
    if(tk){
        res.send('POST参数!' + req.body.uname + req.body.pwd)
    }else{
        res.send('非法用户，拒绝服务')
    }
})

// delete请求
app.delete('/books/:id', (req, res) => {
    res.send('delete参数=' + req.params.id)
})

// 接受put json
app.put('/books/:id', (req, res) => {
    res.send('PUT请求传递参数!' 
     + req.params.id
     + '--' + req.body.stname 
     + '--' + req.body.age)
})


//路由
app.listen(9099,()=>{
    console.log('服务器启动 http://127.0.0.1:9099/page/1')

})


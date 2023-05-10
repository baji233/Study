var express = require('express');
var temp = require('express-art-template');//处理get请求的模块
var bodyParser = require('body-parser');//处理post请求
//服务器
var app = express();
//使用模板引擎
app.engine('html',temp);
app.use(bodyParser.urlencoded({extended: false}));

//路由 -> 首页
app.get('/', function(req, res){
	res.render('index.html',{
		name: '小明',
		age: 18,
		orders: [
			{id:1, title:'t1', price: 10},
			{id:2, title:'t2', price: 20},
			{id:3, title:'t3', price: 14},
			{id:4, title:'t4', price: 15}
		]
	})
});

app.get('/cart',function(req, res){
	res.render('cart.html');
});

app.get('/login',function(req,res){
	res.render('login.html');
});

// //处理登录表单提交的get请求,不能处理post请求
// app.get('/dologin',function(req, res){
// 	var name = req.query.name;
// 	var password = req.query.password;
// 	let html = `<h1>登录成功</h1>
// 	<h1>${name}</h1> -- <h1>${password}</h1>`;
// 	res.send(html);
// });

//处理post请求
app.post('/dologin',function(req, res){
	var name = req.body.name;
	var password = req.body.password;
	let html = `<h1>登录成功</h1>
	<h1>${name}</h1> -- <h1>${password}</h1>`;
	res.send(html);
});

//restful 路径参数
app.get('/movie/:mid',(req, res) => {
	let mid = req.params.mid;
	let html = `<h1>模仿${mid}<h1/>`;
	res.send(html);
});



//启动server, 127.0.0.0:9090
app.listen(9090,()=>{
	console.log('服务器已启动!');
});
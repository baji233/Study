
var express = require('express');
//服务器
var app = express();

//路由 首页
app.get('/', function(req, res){
	
	
	res.send('hello server! <a href="#">百度</a>');
});

//启动server, 127.0.0.0:9090
app.listen(9090,()=>{
	console.log('服务器已启动!');
});



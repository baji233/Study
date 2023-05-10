/*读取网页并显示到浏览器上*/
const http = require('http'); //导入http包
var fs =require('fs'); //文件系统

const hostname = '127.0.0.1'; //主机
const port = 3000; //端口

//创建一个服务
const server = http.createServer((req, res) => {
  res.statusCode = 200; //相应状态码200
  res.setHeader('Content-Type', 'text/html;charset=utf-8'); //设置相应头
  var url = req.url;
  console.log('您正在访问:', url);
  if(url == '/login.html'){
	  //访问登陆页面
	  var rf = fs.readFile('./login.html','utf-8',(err,data)=>{
	    if(err){
	    		console.log('文件读取失败',err);
	    		return;
	    	}
	    	res.end(data);
	    }); //readFile()的参数:文件名,字符集,回调函数 
	  
  }else if(url == '/'){
	  //访问首页
	  var rf = fs.readFile('./index.html','utf-8',(err,data)=>{
	  if(err){
	  		console.log('文件读取失败',err);
	  		return;
	  	}
	  	res.end(data);
	  }); //readFile()的参数:文件名,字符集,回调函数 
	  
  }else{
	  //页面不存在
	  var rf = fs.readFile('./404.html','utf-8',(err,data)=>{
	  if(err){
	  		console.log('文件读取失败',err);
	  		return;
	  	}
	  	res.end(data);
	  }); //readFile()的参数:文件名,字符集,回调函数 
	  
  }
});

//服务监听
server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`); //监听成功回调
});


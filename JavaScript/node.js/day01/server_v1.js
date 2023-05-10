// const http = require('http'); //导入http包

// const hostname = '127.0.0.1'; //主机
// const port = 3000; //端口

// //创建一个服务
// const server = http.createServer((req, res) => {
//   res.statusCode = 200; //相应状态码200
//   res.setHeader('Content-Type', 'text/plain'); //设置相应头
//   res.write();
//   res.end('Hello World\n'); //发送信息 => Hello World
// });

// //服务监听
// server.listen(port, hostname, () => {
//   console.log(`Server running at http://${hostname}:${port}/`); //监听成功回调
// });

/*读取网页并显示到浏览器上*/
const http = require('http'); //导入http包
var fs =require('fs'); //文件系统

const hostname = '127.0.0.1'; //主机
const port = 3000; //端口

//创建一个服务
const server = http.createServer((req, res) => {
  res.statusCode = 200; //相应状态码200
  res.setHeader('Content-Type', 'text/html;charset=utf-8'); //设置相应头
  var rf = fs.readFile('./index.html','utf-8',(err,data)=>{
  if(err){
  		console.log('文件读取失败',err);
  		return;
  	}
  	res.end(data);
  }); //readFile()的参数:文件名,字符集,回调函数 
});

//服务监听
server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`); //监听成功回调
});


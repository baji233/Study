var fs =require('fs'); //文件系统

//读取文件
fs.readFile('./hello.js','utf-8',(err,data)=>{
	if(err){
		console.log('文件读取失败',err);
		return;
	}
	console.log(data);
}); //readFile()的参数:文件名,字符集,回调函数 

//写入文件
var data = '国服龙龟';
fs.writeFile('test.txt',data,(err)=>{
	if(err){
		console.log('文件写入失败',err);
		return;
	}
	console.log('写入成功');


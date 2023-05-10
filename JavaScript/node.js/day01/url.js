var url = require('url'); //分析url
var path = "https://www.baidu.com?username=tjw&&password=123456";
var t = url.parse(path, true);

console.log(t);
console.log('用户名:', t.query.username);
console.log('密码:', t.query.password);
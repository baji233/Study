/**
 * 使用node.js访问数据库
 */
var mysql = require('mysql');

var conn = mysql.createConnection({
    host : 'localhost',
    user : 'root',
    password : '88888888',
    database : 'tjwdb'
});

//连接
conn.connect();

//查询
var sql01 = "select * from user";
//执行
conn.query(sql01, (err, result, fields) => {
    if(err){
        console.log('查询错误:', err);
        return;
    }else{
        for(let r of result){
            console.log(r.userId, r.userName);
        }
    }
}); 


// //添加
// var sql02 = "insert into user values(null,'jay00','9899','294906457@qq.com','19','3')";
// conn.query(sql02, (err, result, fields) => {
//     if(err){
//         console.log('查询错误:', err);
//     }else{
//         console.log(result);
//     }
// });



//关闭
conn.end();
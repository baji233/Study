/** 
 * Node.js连接MySqL数据库
 * */  

//导入
var mysql = require('mysql')

//配置
var mydb = {
     host: 'localhost',
     user: 'root',
     password: '88888888',
     database: 'cxy'
}

//连接
function runsql(sql, callback, val = null) {
    var conn = mysql.createConnection(mydb)
    conn.connect()
    if(val == null) {
        conn.query(sql, callback)
    }else {
        conn.query(sql, callback, val)
    }
    conn.end()
}

//导出
module.exports = runsql


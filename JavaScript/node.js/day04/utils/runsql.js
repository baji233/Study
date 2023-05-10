/**
 * node js 如何访问数据库
 */
var mysql = require('mysql');
var mydb = {
    host : 'localhost',
    user : 'root',
    password : '88888888',
    database : 'tjwdb'
};
//连接

function runsql(sql,callback,val = null){
    //连接
    var conn = mysql.createConnection(mydb);
    conn.connect();
    if(val == null){
        conn.query(sql,callback)
    }else{
        conn.query(sql,callback,val)
    }


    conn.end();
}

//导出
module.exports = runsql;
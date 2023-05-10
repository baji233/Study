var mysql = require('mysql'); //导入

var mydb = {
    host : 'localhost',
    user : 'root',
    password : '88888888',
    database : 'tjwdb'
};

function runSql(sql, callback, vals = null) {
    var conn = mysql.createConnection(mydb);
    conn.connect(); //开始连接
    if(vals == null){
        conn.query(sql, callback);
    }else{
        conn.query(sql, vals, callback);
    }
    conn.end(); //释放资源
}

module.exports = runSql //导出
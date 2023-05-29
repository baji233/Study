// 引入 mysql
const mysql = require('mysql');

// 创建连接池
const pool = mysql.createPool(
  {
    host: 'localhost',
    port: 3306,
    user: 'root',
    password: '123456',
    database: 'fitness',
    connectionLimit: 10, // 设置连接池大小
  }
);

// 单条 sql 语句
function singleSql(sql, params) {
  return new Promise((resolve, reject) => {
    pool.getConnection((err, connection) => {
      if (err) {
        return reject(err);
      }
      // 对数据库进行 sql 语句操作
      connection.query(sql, params, (err, result) => {
        if (err) {
          return reject(err);
        }
        resolve(result);
      });

      // 关闭此次 mysql 的连接
      connection.release();
    });
  });
}

// 进行事务操作
function beginTransaction(getSqlPromises) {
  return new Promise((resolve, reject) => {
    pool.getConnection((err, connection) => {
      if (err) {
        return reject('连接创建失败', err);
      }
      // 开启事务
      connection.beginTransaction(err => {
        if (err) {
          return reject('开启事务失败', err);
        }

        Promise.all(getSqlPromises(connection)).then(result => {
          // 以上 sql 都成功，提交事务
          connection.commit();
          resolve(result);
        }, err => {
          // 事务回滚
          connection.rollback();
          reject(err);
        });
      });
      // 无论是否发生错误，都释放连接
      connection.release();
    });
  });
}


module.exports = {
  singleSql,
  beginTransaction,
}

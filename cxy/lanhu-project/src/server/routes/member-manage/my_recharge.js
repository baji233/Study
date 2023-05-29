const express = require('express');
const router = express.Router();
const { singleSql, beginTransaction } = require('../../db');

// 查询member_recharge 表
router.get('/list', (req, res) => {
  let {cp, ps} = req.query;
  cp = parseInt(cp) || 1;
  ps = ps || 5;
  let total = ps * cp;
  // 404 响应
  /* const isExceedMaxPages = Math.ceil(parseInt(total / ps)) < cp;
  if (isExceedMaxPages) {
    return res.send({
      code: 404,
      message: '没有当前页，404 => 文件位置：'+__dirname+"\\member_recharge.js"
    }); 
  } */
  singleSql(
    'select * from member_recharge limit ?,?',
    [total - ps, +ps]
  ).then(async result => {
    result.sort((a, b) => b.card_id - a.card_id);
    const sqlPromises = connection => {
      return result.map(item => {
        return new Promise((resolve, reject) => {
          connection.query(
            'select * from member where member_id = ?', item.member_id, 
            (err, result) => {
              if (err) {
                return reject(err);
              }
              item.create_time = new Date(item.create_time).toLocaleString();
              item.member = result[0];
              resolve('成功');
            });
        });
      });
    }
    await beginTransaction(sqlPromises);
    res.status(200).send(result);
  }).catch (err => {
    console.log('查询 member_recharge 表时出现异常，'+
      '错误函数：router.get("/list"), ' +
      '错误文件：'+__dirname+'\\member_recharge.js, \n错误原因：', err);
    res.status(500).send(err);
  });
});

// 获取总条数
router.get('/count', (req, res) => {
  singleSql('select count(*) as count from member_recharge').then(([result]) => {
    res.status(200).send(`${result.count}`);
  }).catch(err => {
    console.log('获取 member_recharge 表总条数时出现异常，'+
      '错误函数：router.get("/count"), ' +
      '错误文件：'+__dirname+'\\member_recharge.js, \n错误原因：', err);
    res.status(500).send(err);
  });
});

module.exports = router;
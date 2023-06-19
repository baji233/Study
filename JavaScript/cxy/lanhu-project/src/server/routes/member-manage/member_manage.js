const express = require('express');
const router = express.Router();
const { singleSql, beginTransaction } = require('../../db');

// 查询member 表
router.get('/list', (req, res) => {
  let {cp, ps, n, p, m} = req.query;
  cp = parseInt(cp) || 1;
  ps = ps || 5;
  let total = ps * cp;
  // 404 响应
  /* const isExceedMaxPages = Math.ceil(parseInt(total / ps)) < cp;
  if (isExceedMaxPages) {
    return res.send({
      code: 404,
      message: '没有当前页，404 => 文件位置：'+__filename
    });
  } */
  singleSql(
    `select * from member where
      name like ? and
      phone like ? and
      username like ? limit ?,?`,
    [n ? `%${n}%` : '%%',
    p ? `%${p}%` : '%%',
    m ? `%${m}%` : '%%',
    total - ps, +ps]
  ).then(result => {
    result.sort((a, b) => b.member_id - a.member_id);
    res.status(200).send(result);
  }).catch (err => {
    console.log('查询 member 表时出现异常，'+
      '错误函数：router.get("/list"), ' +
      '错误文件：'+__filename+', \n错误原因：', err);
    res.status(500).send(err);
  });
});

// 获取总条数
router.get('/count', (req, res) => {
  const {n, p, m} = req.query;
  singleSql(
    `select count(*) as count from member where
    name like ? and
    phone like ? and
    username like ?`,
    [n ? `%${n}%` : '%%',
    p ? `%${p}%` : '%%',
    m ? `%${m}%` : '%%', ]
  ).then(([result]) => {
    res.status(200).send(`${result.count}`);
  }).catch(err => {
    console.log('获取 member 表总条数时出现异常，'+
      '错误函数：router.get("/count"), ' +
      '错误文件：'+__filename+', \n错误原因：', err);
    res.status(500).send(err);
  });
});

// 删除
router.delete('/delete/:id', (req, res) => {
  singleSql(
    'delete from member where member_id = ?',
    req.params.id
  ).then(result => {
    res.status(200).send(result[0]);
  }).catch(err => {
    console.log('在删除 member 表中的一条数据时出现异常，' +
      '错误函数：router.delete("/delete/:id"), ' +
      '错误文件 => '+__filename+", \n错误消息 => " ,err);
    res.status(500).send(err);
  });
});

// 增加
router.post('/add', (req, res) => {
  singleSql(
    'insert into member set ?',
    req.body
  ).then(result => {
    res.status(200).send(result);
  }).catch(err => {
    console.log('增加 member 表时出现异常，'+
    '错误函数：router.post("/add"), '+
    '错误文件：'+__filename+", \n错误原因 =>", err);
    res.status(500).send(err);
  });
});

// 修改会员
router.put('/update', (req, res) => {
  // console.log(req.body, 'request');
  const sqlPromises = connection => {
    const sqlObjs = [];
    for (const item of req.body) {
      sqlObjs.push({
        sql: 'update member set ? where member_id = ?',
        data: item,
      })
    }

    return sqlObjs.map(({sql, data}) => {
      return new Promise((resolve, reject) => {
        connection.query(sql, [data, data.member_id], (err, result) => {
          if (err) {
            reject(err);
          } else {
            resolve(result[0]);
          }
        });
      });
    })
  }
  beginTransaction(sqlPromises)
    .then(result => res.status(200).send(result))
    .catch(err => {
      console.log('修改会员信息出错，'+
      '出错函数：router.put("/update"), '+
      '出错文件：'+__filename+", 出错原因 => ", err);
      res.status(500).send(err);
  });
});
module.exports = router;

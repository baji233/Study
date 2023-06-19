const express = require('express');
const router = express.Router();
const { singleSql } = require('../../db');

// 查询 suggest 表, 分页查询
router.get('/list', (req, res) => {
  let {cp, ps, w} = req.query;
  cp = parseInt(cp) || 1;
  ps = ps || 5;
  let total = ps * cp;
  // 404 响应
  /* const isExceedMaxPages = Math.ceil(parseInt(total / ps)) < cp;
  if (isExceedMaxPages) {
    return res.send({
      code: 404,
      message: '没有当前页，404 => 文件位置：'+__filename+""
    }); 
  } */
  singleSql(
    'select * from suggest where title like ? limit ?,?',
    [w ? `%${w}%` : '%%', total - ps, +ps]
  ).then(result => {
    result.sort((a, b) => b.id - a.id);
    res.status(200).send(result);
  }).catch (err => {
    console.log('查询 suggest 表时出现异常，'+
      '错误函数：router.get("/list"), ' +
      '错误文件：'+__filename+', \n错误原因：', err);
    res.status(500).send(err);
  });
});

// 获取总条数
router.get('/count', (req, res) => {
  const {w} = req.query;
  singleSql(
    'select count(*) as count from suggest where title like ?',
    w ? `%${w}%` : '%%'
  ).then(([result]) => {
    res.status(200).send(`${result.count}`);
  }).catch(err => {
    console.log('获取 suggest 表总条数时出现异常，'+
      '错误函数：router.get("/count"), ' +
      '错误文件：'+__filename+', \n错误原因：', err);
    res.status(500).send(err);
  });
});

// 删除
router.delete('/delete/:id', (req, res) => {
  singleSql(
    'delete from suggest where id = ?',
    req.params.id
  ).then(result => {
    res.status(200).send(result[0]);
  }).catch(err => {
    console.log('在删除 suggest 表中的一条数据时出现异常，' +
      '错误函数：router.delete("/delete/:id"), ' +
      '错误文件 => '+__filename+", \n错误消息 => " ,err);
    res.status(500).send(err);
  });
});

// 增加
router.post('/add', (req, res) => {
  singleSql(
    'insert into suggest set ?',
    req.body
  ).then(result => {
    res.status(200).send(result[0]);
  }).catch(err => {
    console.log('增加 suggest 表时出现异常，'+
    '错误函数：router.post("/add"), '+
    '错误文件：'+__filename+", \n错误原因 =>", err);
    res.status(500).send(err);
  });
});

// 修改会员卡的种类
router.put('/update', (req, res) => {
  singleSql('update suggest set ? where id = ?', [req.body, req.body.id])
    .then(result => res.status(200).send(result[0]))
    .catch(err => {
    console.log('修改多条失物信息出错，'+
    '出错函数：router.put("/update"), '+
    '出错文件：'+__filename+", 出错原因 => ", err);
    res.status(500).send(err);
  });
});

module.exports = router;
const express=require('express')
const router=express.Router();
const { singleSql } = require('../db');
//查询所有
router.get('/getAll',(req,res)=>{
  let sql="select * from goods_order"
  singleSql(sql).then(result=>{
    res.status(200).send(result)
  }).catch(err=>{
    console.log('查询 goods_order 表时出现异常，'+
      '错误函数：router.get("/getAll"), ' +
      '错误文件：'+__filename+', \n错误原因：',err)
    res.status(500).send(err)
  })
})
//分页查询
router.get('/getPage',(req,res)=>{
  let {name,pageSize,pageNum}=req.query;
  console.log(name)
  let sql="select * from goods_order where name like ? limit ?,?"
  singleSql(sql, [name ? `%${name}%` : '', pageNum ? (+pageNum) : '', pageSize ? (+pageSize) : '']).then(result => {
    res.status(200).send(result)
  }).catch(err => {
    console.log('获取 goods_order 表分页条数时出现异常，'+
      '错误函数：router.get("/getPage"), ' +
      '错误文件：'+__filename+', \n错误原因：',err)
    res.status(500).send(err)
  })
})
//删除
router.delete('/delete/:id', (req, res) => {
  let sql='delete from goods_order where order_id=?';
  singleSql(sql,req.params.id).then(result => {
    res.status(200).send(result)
  }).catch(err=>{
    console.log('获取 goods_order 表分页条数时出现异常，'+
      '错误函数：router.get("/getPage"), ' +
      '错误文件：'+__filename+',\n错误原因：',err);
    res.status(500).send(err)
  })
})
//添加和修改
router.post('/insert',(req,res)=>{
  let sql= 'insert into goods set ?';
  singleSql(sql,req.body).then(result=>{
    res.status(200).send(result);
  }).catch(err=>{
    console.log('添加 goods_order 数据时出现异常，'+
      '错误函数：router.get("/insert"), ' +
      '错误文件：'+__filename+',\n错误原因：',err)
    res.status(500).send(err);
  })
})
router.put('/update',(req,res)=>{
  let sql= 'update goods_order set ? where order_id=?';
  singleSql(sql,[req.body,req.body.order_id]).then(result=>{
    res.status(200).send(result);
  }).catch(err=>{
    console.log('修改 goods_order 数据时出现异常，'+
      '错误函数：router.get("/update"), ' +
      '错误文件：'+__filename+',\n错误原因：',err)
    res.status(500).send(err);
  })
})
module.exports=router;

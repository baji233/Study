const express=require('express')
const router=express.Router();
const { singleSql } = require('../db');
const multer=require('multer')
const path=require('path')
const uuid=require('uuid/v1')
const upload=multer({
  dest:path.join(process.cwd(),'/public/upload')
}) 
const fs=require('fs')
//查询所有
router.get('/getAll',(req,res)=>{
  let sql="select * from goods"
  singleSql(sql).then(result=>{
    res.status(200).send(result)
  }).catch(err=>{
    console.log('查询 goods 表时出现异常，'+
      '错误函数：router.get("/getAll"), ' +
      '错误文件：'+__filename+', \n错误原因：',err)
    res.status(500).send(err)
  })
})
router.get('/select',(req,res)=>{
  let {goodsid}=req.query;
  let sql="select * from goods where goods_id=?"
  singleSql(sql,goodsid).then(result=>{
    res.status(200).send(result)
  }).catch(err=>{
    console.log('查询 goods 表时出现异常，'+
      '错误函数：router.get("/getAll"), ' +
      '错误文件：'+__filename+', \n错误原因：',err)
    res.status(500).send(err)
  })
})

//分页查询
router.get('/getNamePage',(req,res)=>{
  let {name,pageSize,pageNum}=req.query;
  console.log(req.query)
  let sql="select * from goods where name like ? limit ?,?"
  singleSql(sql, [name ? `%${name}%` : '%%', pageNum ? (+pageNum) : 0, pageSize ? (+pageSize) : 5]).then(result => {
    res.status(200).send(result)
  }).catch(err => {
    console.log('获取 goods 表分页条数时出现异常，'+
      '错误函数：router.get("/getNamePage"), ' +
      '错误文件：'+__filename+', \n错误原因：',err)
    res.status(500).send(err)
  })
})
router.get('/getPage',(req,res)=>{
  let {pageSize,pageNum}=req.query;
  let sql="select * from goods limit ?,?"
  singleSql(sql, [pageNum ? (+pageNum) : 0, pageSize ? (+pageSize) : 5]).then(result => {
    res.status(200).send(result)
  }).catch(err => {
    console.log('获取 goods 表分页条数时出现异常，'+
      '错误函数：router.get("/getPage"), ' +
      '错误文件：'+__filename+', \n错误原因：',err)
    res.status(500).send(err)
  })
})
router.get('/getNameAll',(req,res)=>{
  let {name}=req.query;

  let sql="select * from goods where name like ?"
  singleSql(sql, [name ? `%${name}%` : '%%']).then(result => {
    res.status(200).send(result)
  }).catch(err => {
    console.log('获取 goods 表分页条数时出现异常，'+
      '错误函数：router.get("/getNamePage"), ' +
      '错误文件：'+__filename+', \n错误原因：',err)
    res.status(500).send(err)
  })
})

//删除
router.delete('/delete/:id', (req, res) => {
  let sql='delete from goods where goods_id=?';
  singleSql(sql,req.params.id).then(result => {
    res.status(200).send(result)
  }).catch(err=>{
    console.log('获取 goods 表分页条数时出现异常，'+
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
    console.log('添加 goods 数据时出现异常，'+
      '错误函数：router.get("/insert"), ' +
      '错误文件：'+__filename+',\n错误原因：',err)
    res.status(500).send(err);
  })
})
router.put('/update',(req,res)=>{
  let sql= 'update goods set ? where goods_id=?';
  singleSql(sql,[req.body,req.body.goods_id]).then(result=>{
    res.status(200).send(result);
  }).catch(err=>{
    console.log('修改 goods 数据时出现异常，'+
      '错误函数：router.get("/update"), ' +
      '错误文件：'+__filename+',\n错误原因：',err)
    res.status(500).send(err);
  })
})
router.post('/upload',upload.single('file'),((req,res)=> {
  console.log(req.file)
  fs.readFile(req.file.path,(err, data) => {
    if (err) {
      res.send('图片上传失败')
    }
    let name=uuid().replace(/-/g, '').concat('.'+req.file.originalname.split('.')[req.file.originalname.split('.').length-1]);
    fs.writeFile(path.join(process.cwd(), '/public/upload', name), data, err => {
      if (err) {
        res.send('文件写入失败')
      }
      fs.unlinkSync(req.file.path)
      let json ={code:200,data:name}
      res.send(json)
    })
  })
}))
module.exports=router;

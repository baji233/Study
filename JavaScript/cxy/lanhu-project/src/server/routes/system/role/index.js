const express = require('express');
const router = express.Router();
const { singleSql } = require('../../../db');

router.post('/slectList', (req, res) => {
    let { role_name, pageIndex, PageSize } = req.body;
    let pagebegin = (pageIndex - 1) * PageSize;
    let sql = "select * from sys_role where 1=1";
    if (role_name != '') {
        sql += ` and role_name like '%${role_name}%'`
    }
    sql += ` limit ${pagebegin},${PageSize}`;
    singleSql(sql)
        .then(result => {
            res.status(200).send(result);
        })
        .catch(err => {
            console.log(err)
            res.status(500).send(err)
        })
})

router.post("/selectCount", (req, res) => {
    let sql = "select count(*) as total  from sys_role where 1=1";
    if (req.body.role_name != '') {
        sql += ` and role_name like '%${req.body.role_name}%'`
    }
    
    singleSql(sql)
        .then(result => {
            res.status(200).send(result);
        })
        .catch(err => {
            console.log(err)
            res.status(500).send(err)
    })  
})

router.get('/deleteJueSe/:roleId',(req,res)=>{
    let sql=`delete from sys_role where role_id=${req.params.roleId}`;
    singleSql(sql)
        .then(result => {
            let json={code:200,message:'成功'}
            res.status(200).send(json);
        })
        .catch(err => {
            console.log(err)
            res.status(500).send(err)
    })  
})

router.post('/insertJueSe',(req,res)=>{
    let sql=`insert into sys_role set ?`;
    singleSql(sql, req.body)
        .then(result => {
            let json={code:200,message:'成功'}
            res.status(200).send(json);
        })
        .catch(err => {
            console.log(err)
            res.status(500).send(err)
    })  
})
router.get('/selectOneById/:roleId',(req,res)=>{
    let sql=`select * from sys_role where role_id=${req.params.roleId}`;
    singleSql(sql)
    .then(result=>{
        let json={code:200,data:result}
        res.send(json);
    })
    .catch(err=>{
        console.log(err);
        res.send(err)
    })  

})
router.post('/updateJueSe',(req,res)=>{
    singleSql('update sys_role set ? where role_id=?', [req.body, req.body.role_id])
    .then(result=>{
        let json={code:200,message:'成功'}
        res.send(json);
    })
    .catch(err=>{
        console.log(err);
        res.send(err)
    })  
})

module.exports = router;
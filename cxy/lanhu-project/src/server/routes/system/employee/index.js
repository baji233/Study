const express = require('express');
const router = express.Router();
const { singleSql } = require('../../../db');

router.post("/userSelectList", (req, res) => {
    let body = req.body;
    let pageIndex = body.pageIndex;
    let pageSize = body.pageSize;
    let pagebegin = (pageIndex - 1) * pageSize
    let sql = "select * from sys_user where 1=1 "
    if (body.phone != '') {
        sql += ' and phone=' + body.phone
    }
    if (body.name != '') {
        sql += ` and nick_name like '%${body.name}%'`
    }
    sql += `limit ${pagebegin},${pageSize}`;
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
    let sql = "select count(*) as total  from sys_user where 1=1";
    let body = req.body;
    if (body.phone != '') {
        sql += ' and phone=' + body.phone
    }
    if (body.name != '') {
        sql += ` and nick_name like '%${body.name}%'`
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

router.get("/deleteUser/:id", (req, res) => {
    let id = req.params.id;
    let sql = "delete from sys_user where user_id=" + id;
    singleSql(sql)
        .then(result => {
            let json = { code: 200, message: '成功' }
            res.status(200).send(json);
        })
        .catch(err => {
            console.log(err)
            res.status(500).send(err)
        })
})

router.get("/selectOneById/:id", (req, res) => {
    let sql = `select * from sys_user where user_id=${req.params.id}`;
    singleSql(sql)
        .then(result => {
            let json = { code: 200, data: result };
            res.send(json)
        })
        .catch(err => {
            console.log(err);
            res.status.send(err)
        })
})

router.post('/updateUserById', (req, res) => {
    let { nick_name, sex, email, status, user_type, salary, user_id, phone, username } = req.body
    let sql = `update sys_user set username="${username}",nick_name="${nick_name}",sex="${sex}",phone="${phone}",email="${email}",status="${status}",user_type="${user_type}",salary=${salary} where user_id=${user_id}`;

    singleSql(sql)
        .then(result => {
            let json = { code: 200, message: '成功' };
            res.send(json)
        })
        .catch(err => {
            console.log(err);
            res.send(err)
        })

})
router.post('/insertUser', (req, res) => {
    let sql = `insert into sys_user set ?`;
    singleSql(sql, req.body)
        .then(result => {
            let json = { code: 200, message: '成功' };
            res.send(json)
        })
        .catch(err => {
            console.log(err);
            res.send(err)
        })
})
router.get("/updatePasswordById/:password/:userId", (req, res) => {
    let sql = `update sys_user set password=${req.params.password} where user_id=${req.params.userId}`;
    singleSql(sql)
        .then(result => {
            let json = { code: 200, message: '成功' };
            res.send(json)
        })
        .catch(err => {
            console.log(err);
            res.status.send(err)
        })
})

module.exports = router;
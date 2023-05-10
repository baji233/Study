var express = require('express');
var bodyParser = require('body-parser');//处理post请求
//建立一个路由
var router = express.Router();
//导入sql工具类
var runsql = require('../utils/runsql');

//首页分页
let p; //当前页码
router.get('/page/:pageno', (req, res) => {
    p = req.params.pageno;
    let no = (p - 1) * 10;
    console.log('页=', p);
    let sql01 = `SELECT universityNo,schoolName,province,ranking
                from university
                LIMIT ${no},10`;

    let sql02 = `SELECT COUNT(*) from university`;
    runsql(sql01, (error, result) => {
        if (error) {
            console.log('执行失败', error)
            return;
        }
        // runsql(sql02, (error, result) => {
        //     if (error) {
        //         console.log('执行失败', error)
        //         return;
        //     }
        //     var counts = result[0]['COUNT(*)'];
        //     console.log('总条数:', counts);
        // });
        // console.log('返回=', result);
        res.render('index.html', {
            items: result,
            page : p,
            // count : counts 
        });
    });
});

//修改功能:返回学校修改页面
router.get('/edit/:sno', (req, res) => {
    let no = req.params.sno;
    console.log('学校', no);
    let sql = `SELECT universityNo,schoolName,ranking,province
    FROM university
    where universityNo = ${no}`;
    runsql(sql, (err, result) => {
        if (err) {
            console.log('执行失败', err);
            return;
        }
        console.log('返回:', result)
        res.render('edit.html', {
            school : result[0]
        });
    })
})

//修改学校信息:处理post请求
router.post('/edit_info',function(req, res){
    console.log('请求体:',req.body);
    let sql = `UPDATE university 
    SET schoolName = '${req.body.sname}' , province= '${req.body.prov}' , ranking= ${req.body.rank} 
    WHERE universityNo = ${req.body.id}`;
    runsql(sql, (err, result) => {
        if (err) {
            console.log('执行失败', err);
            return;
        }else{
            console.log('返回:', result);
            res.redirect(`/page/`+p); //刷新
        }
    });
})

//删除功能
router.get('/del/:sno', (req, res) => {
    req.params
    let no = req.params.sno;
    console.log('学校', no);
    let sql = `DELETE FROM university WHERE universityNo = ${no}`;
    runsql(sql, (err, result) => {
        if (err) {
            console.log('执行失败', err);
            return;
        }else{
            console.log('返回:', result);
            res.redirect(`/page/`+p); //刷新
        }
    })
})


//导出
module.exports = router
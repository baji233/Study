const express = require("express")
const { singleSql} = require('../db');
const router = express.Router();

router.get('/getHotCourse', (req, res) => {
  let sql = `select c.course_name as name,count(mc.member_course_id) as value from course as c
  left join member_course as mc  on c.course_id = mc.course_id
  GROUP BY c.course_id`
  singleSql(sql, (error, result) => {
    if (error) {
      console.log('执行失败: ', error)
      res.send({ code: '400' })
      return
    } else {
      res.send(result)
    }
  })
})

//热销卡
router.get('/getHotCards', (req, res) => {
  let sql = `select ma.card_type as name,count(ma.apply_id) as value from member_apply as ma
  GROUP BY ma.card_type,ma.card_day
  order by value desc
  limit 7`
  singleSql(sql, (error, result) => {
    if (error) {
      console.log('执行失败: ', error)
      res.send({ code: '400' })
      return
    } else {
      res.send(result)
    }
  })
})

//热销商品
router.get('/getHotGoods', (req, res) => {
  let sql = `select g.name ,sum(gd.num) as value from goods as g
  inner join goods_order as gd  on gd.goods_id = g.goods_id
  GROUP BY g.goods_id
  order by value desc
  limit 7`
  singleSql(sql, (error, result) => {
    if (error) {
      console.log('执行失败: ', error)
      res.send({ code: '400' })
      return
    } else {
      res.send(result)
    }
  })
})

//反馈列表
router.get('/getSuggest', (req, res) => {
  let sql = `select * from suggest limit 0, 3`
  singleSql(sql, (error, result) => {
    if (error) {
      console.log('执行失败: ', error)
      res.send({ code: '400' })
      return
    } else {
      res.send(result)
    }
  })
})

//会员总数
router.get('/memberCount', (req, res) => {
  let sql = `SELECT count(*) as count FROM member`
  singleSql(sql, (error, result) => {
    if (error) {
      console.log('执行失败: ', error)
      res.send({ code: '400' });
    } else {
      res.status(200).send(`${result[0].count}`);
    }
  })
})

//员工总数
router.get('/userCount', (req, res) => {
  let sql = `SELECT count(*) as count FROM sys_user`
  singleSql(sql, (error, result) => {
    if (error) {
      console.log('执行失败: ', error)
      res.send({ code: '400' })
      return
    } else {
      res.status(200).send(`${result[0].count}`);
    }
  })
})

//器材总数
router.get('/materialCount', (req, res) => {
  let sql = `SELECT count(*) as count FROM material`
  singleSql(sql, (error, result) => {
    if (error) {
      console.log('执行失败: ', error)
      res.send({ code: '400' })
      return
    } else {
      res.status(200).send(`${result[0].count}`);
    }
  })
})

//失物总数
router.get('/lostCount', (req, res) => {
  let sql = `SELECT count(*) as count FROM lost`
  singleSql(sql, (error, result) => {
    if (error) {
      console.log('执行失败: ', error)
      res.send({ code: '400' })
      return
    } else {
      res.status(200).send(`${result[0].count}`);
    }
  })
})

module.exports = router;
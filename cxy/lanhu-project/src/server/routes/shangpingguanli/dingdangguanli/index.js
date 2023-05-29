const express = require('express');
const router = express.Router();
const { singleSql } = require('../../../db');
router.post('/selectList',(req,res)=>{
    let {name,pageIndex,pageSize}=req.body;
    pageIndex=parseInt(pageIndex)
    pageSize=parseInt(pageSize)
    let pagebenig=(pageIndex-1)*pageSize;
    singleSql('select * from goods_order where name like ? limit ?,?',
        [name?`%${name}%`:'%%',pagebenig,pageSize]
    ).then(resule=>{
        let json ={code:200,data:resule}
        return res.send(json);
    })
    .catch(error=>{
        console.log(error);
        return res.send(error)
    })   
})

router.post('/selectCount',(req,res)=>{
    let {name} =req.body;
    singleSql('select count(*) as total from goods_order where name like ? ',
        [name?`%${name}%`:'%%']
    ).then(resule=>{
        let json ={code:200,data:resule}
        return res.send(json);
    })
    .catch(error=>{
        console.log(error);
        return res.send(error)
    }) 
})

router.get("/delete/:orderId",(req,res)=>{
    singleSql('delete from goods_order where order_id= ?',
    req.params.orderId
    ).then(resule=>{
        let json ={code:200,message:"成功"}
        return res.send(json);
    })
    .catch(error=>{
        console.log(error);
        return res.send(error)
    }) 
})

router.get("/selectOneById/:orderId",(req,res)=>{
    singleSql('select * from goods_order where order_id= ?',
    req.params.orderId
    ).then(resule=>{
        let json ={code:200,data:resule}
        return res.send(json);
    })
    .catch(error=>{
        console.log(error);
        return res.send(error)
    }) 
})

router.post('/updateById',(req,res)=>{
    let {name,price,unit,specs,order_id} =req.body
    singleSql('update goods_order set name=?,price=?,unit=?,specs=?   where order_id=?',
    [name,price,unit,specs,order_id]
    ).then(resule=>{
        let json ={code:200,message:"成功"}
        return res.send(json);
    })
    .catch(error=>{
        console.log(error);
        return res.send(error)
    }) 
})

router.post('/add',(req,res)=>{
    singleSql('insert into goods_order set ?',
    req.body
    ).then(resule=>{
        let json ={code:200,message:"成功"}
        return res.send(json);
    })
    .catch(error=>{
        console.log(error);
        return res.send(error)
    }) 
})

module.exports=router;
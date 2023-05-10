package com.itmk.web.goods_order.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.utils.ResultUtils;
import com.itmk.utils.ResultVo;
import com.itmk.web.goods.entity.Goods;
import com.itmk.web.goods.entity.GoodsParm;
import com.itmk.web.goods.service.GoodsService;
import com.itmk.web.goods_order.entity.GoodsOrder;
import com.itmk.web.goods_order.entity.OrderItem;
import com.itmk.web.goods_order.entity.OrderParm;
import com.itmk.web.goods_order.service.GoodsOrderService;
import com.itmk.web.sys_user.entity.SysUser;
import com.itmk.web.sys_user.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@RestController
@RequestMapping("/api/order")
public class GoodsOrderController {
    @Autowired
    private GoodsOrderService goodsOrderService;

    //下单
    @PreAuthorize("hasAuthority('sys:orderList:down')")
    @PostMapping("/down")
    public ResultVo down(@RequestBody OrderParm parm){
        List<OrderItem> list = parm.getOrderList();
        if(list.size() == 0){
            return ResultUtils.error("请选择商品!");
        }
        goodsOrderService.downOrder(parm);
        return ResultUtils.success("下单成功!");
    }

    //列表
    @GetMapping("/list")
    public ResultVo list(GoodsParm parm){
        //构造分页对象
        IPage<GoodsOrder> page = new Page<>(parm.getCurrentPage(),parm.getPageSize());
        //构造查询条件
        QueryWrapper<GoodsOrder> query = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(parm.getName())){
            query.lambda().like(GoodsOrder::getName,parm.getName());
        }
        query.lambda().orderByDesc(GoodsOrder::getCreateTime);
        IPage<GoodsOrder> list = goodsOrderService.page(page, query);
        return ResultUtils.success("查询成功",list);
    }
}

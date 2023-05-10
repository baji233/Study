package com.itmk.web.goods_order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.exception_advice.BusinessException;
import com.itmk.web.goods.entity.Goods;
import com.itmk.web.goods.service.GoodsService;
import com.itmk.web.goods_order.entity.GoodsOrder;
import com.itmk.web.goods_order.entity.OrderItem;
import com.itmk.web.goods_order.entity.OrderParm;
import com.itmk.web.goods_order.mapper.GoodsOrderMapper;
import com.itmk.web.goods_order.service.GoodsOrderService;
import com.itmk.web.home.entity.EchartItem;
import com.itmk.web.sys_user.entity.SysUser;
import com.itmk.web.sys_user.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Service
public class GoodsOrderServiceImpl extends ServiceImpl<GoodsOrderMapper, GoodsOrder> implements GoodsOrderService {
   @Autowired
    private GoodsService goodsService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Override
    public List<EchartItem> hotGoods() {
        return this.baseMapper.hotGoods();
    }

    @Override
    public List<EchartItem> hotCards() {
        return this.baseMapper.hotCards();
    }

    @Override
    public List<EchartItem> hotCourse() {
        return this.baseMapper.hotCourse();
    }

    @Override
    public void downOrder(OrderParm parm) {
        //根据用户id查询用户信息
        SysUser user = sysUserService.getById(parm.getUserId());
        List<OrderItem> list = parm.getOrderList();
        List<GoodsOrder> orderList = new ArrayList<>();
        List<Goods> goodsList = new ArrayList<>();
        for(int i = 0;i<list.size();i++){
            GoodsOrder order = new GoodsOrder();
            Long goodsId = list.get(i).getGoodsId();
            //获取商品的信息
            Goods goods = goodsService.getById(goodsId);
            BeanUtils.copyProperties(goods,order);
            //设置数量
            order.setNum(list.get(i).getNum());
            order.setControlUser(user.getNickName());
            //设置订单金额
            BigDecimal number = BigDecimal.valueOf(list.get(i).getNum());
            BigDecimal price = goods.getPrice();
            //总价
            BigDecimal total = number.multiply(price);
            BigDecimal totalPrice = total.setScale(2, BigDecimal.ROUND_HALF_UP);
            order.setTotalPrice(totalPrice);
            order.setCreateTime(new Date());
            orderList.add(order);
            Goods goods1 = new Goods();
            goods1.setGoodsId(goods.getGoodsId());
            Integer store = goods.getStore();
            if(store == 0 || list.get(i).getNum()>goods.getStore()){
                throw new BusinessException(500,"【"+goods.getName()+"】库存不足!");
            }
            goods1.setStore(goods.getStore()-list.get(i).getNum());
            goodsList.add(goods1);
        }
        //减库存
        goodsService.updateBatchById(goodsList);
        //生成订单
        goodsOrderService.saveBatch(orderList);
    }
}

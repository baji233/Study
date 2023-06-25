import { request } from '../../utils/request'

Page({

  data: {
    goodsObj: {}
  },

  onLoad(options) {
    //获取具体商品id
    let {goods_id} = options
    this.getGoods(goods_id)
  },

  async getGoods(goods_id) {
    let ret = await request({url: '/goods/detail', data:{goods_id}})
    let obj = ret.message //所有属性
     //所需属性
    let goodsObj = {
      goods_id: obj.goods_id,
      goods_name: obj.goods_name,
      goods_price: obj.goods_price,
      pics: obj.pics,
      goods_introduce: obj.goods_introduce.replace(/\.webp/g, '.jpg')
    }
    this.setData({goodsObj: goodsObj})
  },

  //加入购物车(商品信息存在本地存储)
  addCart() {
    let {goodsObj} = this.data
    let cart = wx.getStorageSync('cart') || []
    //先判断购物车内是否已有该商品
    let index = cart.findIndex(v => v.goods_id == goodsObj.goods_id)
    if(index == -1) {
      //未找到商品
      goodsObj.num = 1 //商品数量=1
      goodsObj.check = true //选中状态
      cart.push(goodsObj)
    }else {
      //已存在该商品
      cart[index].num++ //商品数量累加
    }
    //存入本地
    console.log(cart);
    wx.setStorageSync('cart', cart)
  }
})
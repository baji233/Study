// pages/cart/cart.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    //购物车数组
    cart: [],
    allChecked: false,
    totalPrice: 0,
    totalNum: 0,
    nullcart: 'https://hbimg.huabanimg.com/a4064bdab5f6c800ed664014f3eb7d13a4dd25b3138d0-hYHe07_fw658'
  },
  //商品复选框改变时
  goodsItemChange(e) {
    let {id} = e.currentTarget.dataset
    let check = e.detail.value.length
    let {cart} = this.data
    //查找购物车中的商品位置
    let index = cart.findIndex(v => v.goods_id == id)
    cart[index].check = check==0?false:true
    this.setCart(cart)
  },
  //统一修改购物车
  setCart(cart) {
    // (总价格, 总数量, 总全选)
    let allChecked = true
    let totalPrice = 0
    let totalNum = 0
    cart.forEach(v => {
      if(v.check) {
        //商品已选中: 计算商品总价和总数
        totalPrice += v.goods_price * v.num
        totalNum += v.num
      } else {
        //取消全选勾选
        allChecked = false
      }
    })
    // 判断购物车数组是否为空
    if(cart.length == 0) {
      allChecked = false
    }
    this.setData({cart, allChecked, totalPrice, totalNum})
    wx.setStorageSync('cart', cart)
  },
  //全选按钮
  allChecked() {
    let {allChecked, cart} = this.data
    allChecked = !allChecked
    cart.forEach(v => v.check = allChecked)
    this.setCart(cart)
  },
  //调整数量(+ -)
  numChange(e) {
    let {cart} = this.data
    let {op, id} = e.currentTarget.dataset
    let index = cart.findIndex(v => v.goods_id == id)
    if(cart[index].num == 1 && op == -1) {
      cart.splice(index, 1)
    } else {
      cart[index].num += op
    }
    this.setCart(cart)
  },
  
  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {
    //从本地存储中获取购物车数据
    let cart = wx.getStorageSync('cart') || []
    let allChecked = cart.every(v => v.check)
    this.setData({cart, allChecked})
    this.setCart(cart)
  },
})
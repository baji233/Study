// pages/cart/cart.js
Page({
    data: {
        //购物车数组
        cart: [],
        allChecked: false,
        totalPrice: 0,
        totalNum: 0,
        nullpic: 'http://hbimg.b0.upaiyun.com/e1b1467beea0a9c7d6a56b32bac6d7e5dcd914f7c3e6-YTwUd6_fw658'
    },
    onLoad(options) {

    },
    onShow() {
        //本地存储
        let cart =  wx.getStorageSync('cart')||[]
        let allChecked =  cart.every( v=> v.check)
        this.setData({cart , allChecked})
        this.setCart(cart)
    },
    //商品复选改变
    goodsItemChange(e){
        let {id } =e.currentTarget.dataset
        let check =  e.detail.value.length
        let {cart} = this.data 
        //查找车中商品位置
        let index =  cart.findIndex( v=> v.goods_id == id)
        cart[index].check =  check==0?false:true
        this.setCart(cart)
    },
    //统一的修改
    setCart(cart){
       let  allChecked= true
       let  totalPrice =0
       let  totalNum = 0
       console.log( cart );
       cart.forEach( v=>{
            if(v.check ){
                totalPrice += v.goods_price * v.num
                totalNum += v.num
            }else{
                allChecked = false 
            }
       })
    //    //车空，不会全选
       if(cart.length ==0){
         allChecked = false
       }
       this.setData({ 
         allChecked , totalPrice ,totalNum
       })
       wx.setStorageSync('cart', cart);
    },
    onHide() {

    },
    onUnload() {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh() {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom() {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage() {

    }
})
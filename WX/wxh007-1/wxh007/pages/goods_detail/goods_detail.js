import {request} from '../../utils/request'
Page({
    data: {
        goodsObj: {}
    },
    onLoad(options) {
        let {goods_id} =  options;
        console.log( goods_id);
        this.getGoods(goods_id);
    },
    async getGoods(goods_id){
      let ret = await request({url:'/goods/detail',data:{goods_id}})
      let obj = ret.message   //所有属性
      let goodsObj = {
        goods_id: obj.goods_id,
        goods_name: obj.goods_name,
        goods_price: obj.goods_price,
        pics: obj.pics,
        goods_introduce: obj.goods_introduce.replace(/\.webp/g, '.jpg')
      }
      this.setData({ goodsObj})
      console.log( ret );
    },
    addCart(){
        //信息存哪里？？
        let {goodsObj} = this.data
        let cart = wx.getStorageSync('cart') || []
        //车里有此商品
        let index = cart.findIndex( v=> v.goods_id ==  goodsObj.goods_id)
        if(index == -1 ){
            goodsObj.num = 1  //数量1
            goodsObj.check = true //选中
            cart.push( goodsObj )
        }else{
            cart[index].num++  //数量累加
        }
        //存入本地
        console.log( cart );
        wx.setStorageSync('cart', cart)
    },
    onReady() {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow() {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide() {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
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
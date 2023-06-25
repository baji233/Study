// pages/orders/orders.js
import { request } from '../../utils/request'

Page({

  /**
   * 页面的初始数据
   */
  data: {
    tabs: [
      {id: 0, name: '全部', isActive: true},
      {id: 1, name: '待付款', isActive: false},
      {id: 2, name: '待发货', isActive: false},
      {id: 3, name: '退款/退货', isActive: false}
    ],
    orders_info: [
      {number: 'GD20190427000000000567', price: 279, date: '2019/4/27下午4:48:06'},
      {number: 'GD20190426000000000563', price: 13999, date: '2019/4/27下午4:48:06'},
      {number: 'GD20190426000000000562', price: 4500, date: '2019/4/27下午4:48:06'},
      {number: 'GD20190426000000000561', price: 1500, date: '2019/4/27下午4:48:06'},
      {number: 'GD20190426000000000532', price: 200, date: '2019/4/27下午4:48:06'},
      {number: 'GD20190426000000000552', price: 78800, date: '2019/4/27下午4:48:06'},
      {number: 'GD20190426000000000560', price: 1100, date: '2019/4/27下午4:48:06'},
      {number: 'GD20190426000000000545', price: 890, date: '2019/4/27下午4:48:06'},
      {number: 'GD20190426000000000589', price: 500, date: '2019/4/27下午4:48:06'},

    ]
  },
  //获取订单信息
  async getOrder() {
    let ret = await request({url: '/my/orders/all'})
    console.log(ret);
    this.setData({orders_info: ret.messgae})
  },
  //选项卡改变时
  itemChange(e) {
    let {index} = e.detail
    let {tabs} = this.data
    tabs.forEach((v,i) => i == index? v.isActive = true : v.isActive = false)
    this.setData({tabs})
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {
    // this.getOrder()
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
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
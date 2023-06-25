// pages/goods_list/goods_list.js
import { request } from '../../utils/request'

Page({

  data: {
    //商品列表
    goodsList: [],
    tabs: [
      {id: 0, name: '综合', isActive: true},
      {id: 1, name: '销量', isActive: false},
      {id: 2, name: '价格', isActive: false}
    ],
    nullimg: 'https://bpic.588ku.com/element_origin_min_pic/01/50/79/61574564445862e.jpg',

  },
  QueryParams: {
    query: '',
    cid: '',
    pagenum: 1,
    pagesize: 10
  },
  //总页数
  pages: 0,

  onLoad(options) {
    //页面传值
    let cid = options.cid;
    this.QueryParams.cid = cid
    this.getGoodsList()
  },
  async getGoodsList() {
    let ret = await request({url: '/goods/search', data: this.QueryParams})
    let total = ret.message.total
    this.pages = Math.ceil(total / this.QueryParams.pagesize)
    let arr = [...this.data.goodsList, ...ret.message.goods]
    this.setData({goodsList: arr})
  },
  //选项卡改变时
  itemChange(e) {
    let {index} = e.detail
    let {tabs} = this.data
    tabs.forEach((v,i) => i == index? v.isActive = true : v.isActive = false)
    this.setData({tabs})
  },
  //上划: 到达底部后加载下一页
  onReachBottom() {
    if(this.QueryParams.pagenum >= this.pages) {
      wx.showToast({
        title: '已经到最后一页了',
      })
      return
    }
    this.QueryParams.pagenum++
    this.getGoodsList()
  },
  //下滑: 重新显示第一页数据
  onPullDownRefresh() {
    this.QueryParams.pagenum = 1
    this.setData({
      goodsList: []
    })
    this.getGoodsList()
  }
  
})
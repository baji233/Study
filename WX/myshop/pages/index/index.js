import {request} from '../../utils/request'

// 获取应用实例
const app = getApp()

Page({
  data: {
      //轮播图数组
      swiperList: [],
      //导航栏
      catesList: [],
      floorList: []
  },
  onLoad() {
      this.getSwiperList()
      this.getCatesList()
      this.getFloorList()
  },
  async getSwiperList() {
      let ret = await request({url:'/home/swiperData'})
      this.setData({swiperList: ret.message})
  },
  async getCatesList() {
      let ret = await request({url:'/home/catitems'})
      this.setData({catesList: ret.message})
  },
  async getFloorList() {
    let ret = await request({url:'/home/floordata'})
    this.setData({floorList: ret.message})
  }
})

// index.js
import {request} from '../../utils/request'
const app = getApp()
Page({
  data: {
    //轮播图数组
    swiperList: [],
    catesList:[],
    floorList:[]
  },
  onLoad() {
     this.getSwiperList() 
     this.getCatesList()
     this.getFloorList()
  },
  async getSwiperList(){
   let ret = await request({url:"/home/swiperdata"})
   this.setData({swiperList: ret.message})
  },
  async getCatesList(){
    let ret = await request({url: "/home/catitems"})
    this.setData({catesList: ret.message})
  },
  async getFloorList(){
    let ret = await request({url:"/home/floordata"})
    this.setData({floorList: ret.message})
  }
})

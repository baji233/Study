// pages/search/search.js
import { request } from '../../utils/request'

Page({

  /**
   * 页面的初始数据
   */
  data: {
    goods: [],
    inputValuse: ''
  },
  timekey: -1,  //定时器开关

  //搜索框输入
  inputHandle(e) {
    //获取输入值
    let {value} = e.detail
    clearTimeout(this.timekey)
    //定时器
    this.timekey = setTimeout(() => {
      //后台发请求
      this.qsearch(value)
    }, 1000);
  },
  //发送搜索请求
  async qsearch(query) {
    let ret = await request({url: '/goods/qsearch', data: {query}})
    console.log(ret);
    this.setData({goods: ret.message})
  },
  //取消按钮
  handleCancel() {
    this.setData({goods: [], inputValuse: ''})
  }
})
import { request } from '../../utils/request'

Page({
  data: {
    leftMenuList: [],
    rightContent: [],
    //当前选中类别
    curr: 0
  },
  // 接口的返回数据
  Cates: [],
  onLoad(options) {
    //获取本地缓存中的分类数据
    let cates = wx.getStorageSync('cates')
    if (cates) {
      if (Date.now - cates.time > 60 * 1000 * 5) {
        this.getCates()
      } else {
        let left = cates.data.map(v => v.cat_name)
        let right = cates.data[0].children
        this.setData({
          leftMenuList: left,
          rightContent: right,
          curr: 0
        })
      }
    } else {
      this.getCates()
    }
  },
  async getCates() {
    let ret = await request({ url: '/categories' })
    this.Cates = ret.message
    let left = this.Cates.map(v => v.cat_name)
    let right = this.Cates[0].children
    this.setData({
      leftMenuList: left,
      rightContent: right
    })
    // 存本地缓存 5分钟
    wx.setStorageSync('cates', { time: Date.now(), data: this.Cates })
  },
  //选择左边类别
  handleItem(e) {
    let { index } = e.currentTarget.dataset
    let right = this.Cates[index].children
    this.setData({
      curr: index,
      rightContent: right
    })
  }
})

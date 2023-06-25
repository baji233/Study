const base = 'https://api-hmugo-web.itheima.net/api/public/v1'
let time = 0

export let request = (params) => {
  time++
  //显示加载效果
  wx.showLoading({
    title: '正在加载..',
    mask: true
  })

  return new Promise((resolve, reject) => {
    wx.request({
      ...params,
      url: base + params.url,
      success: (ret) => {
        resolve(ret.data)
      },
      fail: () => {
        reject()
      },
      complete: () => {
        time--
        if (time == 0) {
          wx.hideLoading()
        }
        wx.hideLoading()
      }
    })
  })
}
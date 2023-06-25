// app.js
App({
  onLaunch() {
     console.log('小程序初始化....1');
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
  },
  onShow(){
    console.log('小程序显示....2');
  },
  onHide(){
    console.log('小程序后台隐藏....3');
  },
  onError(){
    console.log('小程序报错....4');
  },
  onPageNotFound(){
    console.log('小程序页面找不到....5');
  },
  globalData: {
    userInfo: null
  }
})

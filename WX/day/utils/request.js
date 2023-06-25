// 封装一个发请求的工具
const base = 'https://autumnfish.cn/api'
let times = 0;

export let request = (params)=>{
    //显示加载中 效果
    times++;
    wx.showLoading({
        title : "加载中",
        mask : true
    })
    return new Promise((resolve,reject)=>{
        wx.request({
          ...params,
          url: base + params.url ,
          success:(ret)=>{
            resolve(ret.data)
          },
          fail:()=>{
            reject()
          },
          complete:()=>{
              times--;
              if(times == 0){
                wx.hideLoading()
              }
            wx.hideLoading()
          }
        })
    });
}
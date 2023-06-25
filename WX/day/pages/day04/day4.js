// pages/day04/day4.js
import {request} from '../../utils/request'

Page({

    /**
     * 页面的初始数据
     */
    data: {
        list: [
            { id: 0, name: "首页", isActive: false},
            { id: 1, name: "原创", isActive: false},
            { id: 2, name: "分类", isActive: true},
            { id: 3, name: "关于", isActive: false}
          ],
        jokes: [],
        handle(e){
            let {index}=e.detail
            let {list}=this.data
            console.log('父...',index);
            list.forEach((v,i)=> i==index? v.isActive=true:v.isActive=false)
            //更新
            this.setData({list})
        },
        testsave(){
             // html 区别直接支持存储对象
            let sz=['1','2','3','4']
            wx.setStorageSync('lol', sz)
            wx.showToast({
              title: '存盘成功',
            })
        },
        testget() {
            let sz=wx.getStorageSync('lol')
            console.log(sz);
        },
        ajaxtest01() {
            let path='https://autumnfish.cn/api/joke/list'
            let that = this
            wx.reqest({
                url: path,
                data: {
                    num: 3
                },
                success(res) {
                    console.log(res.data);
                    that.setData({jokes: res.data.data})
                }
            })
        },
        async ajaxtest02() {
            let param = {
                url: '/joke/list',
                data: {
                    num: 10
                }
            }
            let ret = await request(param)
            this.setData({jokes: ret.data})

        }

    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad(options) {

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
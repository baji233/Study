// pages/categroy/categroy.js
import {request} from '../../utils/request'
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
        let cates =  wx.getStorageSync('cates')
        if(cates){
            //是否过期 5分钟 60*1000*5
            if( Date.now()- cates.time > 60*1000*5){
                this.getCates()   
            }else{    
                let left = cates.data.map( v=> v.cat_name )
                let right = cates.data[0].children
                this.setData({
                    leftMenuList: left,
                    rightContent: right,
                    curr: 0 
                })
            }
        }else{
            //不存在
            this.getCates()
        }
    },
    async getCates(){
        console.log('正在取分类数据.....');
        let ret = await request({url:'/categories'})
        console.log( ret );
        this.Cates = ret.message 
        let left = this.Cates.map( v=> v.cat_name )
        let right = this.Cates[0].children
        this.setData({
            leftMenuList: left,
            rightContent: right
        })
        // 存本地 5分钟
        wx.setStorageSync('cates', {time:Date.now(),data:this.Cates})
    },
    //选择左边类别
    handleItem(e){
        let {index} =  e.currentTarget.dataset
        let right = this.Cates[index].children
        console.log( '选中',index);
        this.setData({
            curr: index,
            rightContent: right
        })
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
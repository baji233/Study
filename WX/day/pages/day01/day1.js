// pages/day01/day1.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        info: '亲子鉴定多少钱?',
        price: '2000',
        do: true,
        age: '19',
        list1: [1,2,3,4,5],
        list2: [
            {id: 0, name: '炒饭1'},
            {id: 1, name: '炒饭2'},
            {id: 2, name: '炒饭3'},
            {id: 3, name: '炒饭4'}
        ],
        t1: '',
        t2: '',
        add: ''
    },
    test1( e ) {
        //获取参数: e.currentTarget.dataset
        let param = e.currentTarget.dataset
        console.log('测试01: ', param);

        //取出data区的变量
        let {price} = this.data
        console.log( price );
    },
    test2( e ) {
        //取出文本框的值
        var val = e.detail.value
        console.log('正在输入..', val);

        //修改data区的变量(双向绑定)
        this.setData({ price: val })
    },
    txt1(e) {
        let t = e.detail.value
        this.setData({ t1 : t})
    },
    txt2(e) {
        let t = e.detail.value
        this.setData({ t2 : t})
    },
    add() {
        this.data.add = this.data.t1 + this.data.t2
        console.log( this.data.add)
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
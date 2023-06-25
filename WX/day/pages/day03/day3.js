// pages/day03/day3.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        background: ['https://img13.360buyimg.com/pop/s590x470_jfs/t1/209882/30/34124/63118/6458e2c3Ff819f571/b83a44302dc40869.png.avif',
         'https://imgcps.jd.com/img-cubic/creative_server_cia_jdcloud/v2/2000366/100052327819/FocusFullshop/CkNqZnMvdDEvMTAyMjQ0LzIzLzM4NzM1LzMwODM1LzY0NWJlZGQ5RjlkMTFjMDk1LzlhZjZhZTUzMTEyY2EwODYucG5nEgkzLXR5XzBfNTQwAjjui3pCGgoWUUNZ6JOd54mZL-aXoOe6v-iAs-acuhABQg0KCei0rei_h-eYvhACQhAKDOeri-WNs-aKoui0rRAGQgoKBuS8mOi0qBAHWIu71dz0Ag/cr/s/q.jpg',
          'https://imgcps.jd.com/ling-cubic/ling4/lab/amZzL3QxLzE5NjQ2Mi8zNC8yNzQzLzEzNDQ4OC82MDljZDAxZEUzNGQ4MjNjZC84MGRhOTZkZDBlNzZiNDIzLnBuZw/5Lqs6YCJ5aW96LSn/5L2g5YC85b6X5oul5pyJ/1635188467440111618/cr/s/q.jpg'],
          
          myhtml: `<div class="lazyimg"><div>
          <p><span><strong><span>  如需了解具体成分请联系客服咨询，商品以实物为准</span></strong></span></p>
          <p><img data-src="//image.suning.cn/uimg/sop/commodity/144391318112221528421732_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/144391318112221528421732_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/926379906193716650075230_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/926379906193716650075230_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/609920095927142381856000_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/609920095927142381856000_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/138970591410051613249858_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/138970591410051613249858_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/173997991716994227556748_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/173997991716994227556748_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/194506346246409106964940_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/194506346246409106964940_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/835801205190047935027900_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/835801205190047935027900_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/156976381316304347065690_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/156976381316304347065690_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/119973052319108199011705_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/119973052319108199011705_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/309092698178635031275570_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/309092698178635031275570_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/830767103995768205383700_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/830767103995768205383700_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/627842013350642281102100_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/627842013350642281102100_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/313610607133945989126580_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/313610607133945989126580_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/860111581648725031870800_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/860111581648725031870800_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/102257310525611615473360_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/102257310525611615473360_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/329813238197061593430300_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/329813238197061593430300_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/730820219139747538140180_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/730820219139747538140180_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/182827904012246926564991_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/182827904012246926564991_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/711880362551568465306000_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/711880362551568465306000_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/130229933959676785594770_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/130229933959676785594770_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/329740607175115333478420_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/329740607175115333478420_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"><img data-src="//image.suning.cn/uimg/sop/commodity/607609702128202942449380_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/607609702128202942449380_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"></p>
          </div>
          <div>
          <p><img data-src="//image.suning.cn/uimg/sop/commodity/326997009152860027325930_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/326997009152860027325930_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"></p>
          </div>
          <div>
          <p><img data-src="//image.suning.cn/uimg/sop/commodity/258716766148558069888800_x.jpg?from=mobile&amp;format=80q.webp" alt="" src="//image.suning.cn/uimg/sop/commodity/258716766148558069888800_x.jpg?from=mobile&format=80q.webp" width="100%" height="auto"></p>
          </div></div>`
    },
    p: true,
    iconSize: [20, 30, 40, 50, 60, 70],
    iconColor: [
      'red', 'orange', 'yellow', 'green', 'rgb(0,255,255)', 'blue', 'purple'
    ],
    iconType: [
      'success', 'success_no_circle', 'info', 'warn', 'waiting', 'cancel', 'download', 'search', 'clear'
    ],
    items: [
        {value: 'USA', name: '美国'},
        {value: 'CHN', name: '中国', checked: 'true'},
        {value: 'BRA', name: '巴西'},
        {value: 'JPN', name: '日本'},
        {value: 'ENG', name: '英国'},
        {value: 'FRA', name: '法国'}
      ],
      //座位
      seats:[
         {r:1,w:1,price:10,sel:false},
         {r:1,w:2,price:20,sel:false},
         {r:1,w:3,price:20,sel:false},
         {r:1,w:4,price:10,sel:false},
      ],
      //单选
    radiochange(e) {
        let v =  e.detail.value
        console.log( v );
     },
     //多选
     checkchange(e) {
         let v =  e.detail.value
         let { items } = this.data 
         console.log( v );
         for(let i =0;i< items.length;i++){
             items[i].checked = false
             for(let j =0; j< v.length;j++){
                 if(v[j] == items[i].value ){
                     items[i].checked = true
                     break;
                 }
             }
         }
         this.setData({items})
         console.log( this.data.items);
     },
    jump01() {
        wx.switchTab({
          url: '/pages/day01/day1',
        })
    },
    jump02() {
        wx.navigateTo({
          url: '/pages/logs/logs',
        })
    },
    phone(e) {
        //获取手机号
        console.log(e.detail.code);
    },
    userInfo(e) {
        // (已过时)
        console.log(e.detail.userInfo);
    },
    userInfo02() {
        wx.getUserProfile({
          desc: '获取用户信息',
          success: (res) => {
              console.log(res)
              //保存用户信息
          }
        })
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
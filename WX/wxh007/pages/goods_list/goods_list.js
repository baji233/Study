import {request} from '../../utils/request'
Page({
    data: {
        //商品列表
        goodsList:[],
        tabs: [
            {id: 0,name: "综合", isActive: true },
            {id: 1,name: "销量", isActive: false},
            {id: 2,name: "价格",isActive: false}
        ],
        nullpic:'https://ts1.cn.mm.bing.net/th/id/R-C.9cd921799bb84c682ddd897a70149401?rik=0NRrAAue0GUQDQ&riu=http%3a%2f%2fwww.uugoi.com%2fassets%2fimg%2fnullpic.png&ehk=%2b6p64en%2bCMwb%2fIeRW4r%2bArqv%2fG5Yb49ztD8Nf%2fb0YTM%3d&risl=&pid=ImgRaw&r=0'

    },
    QueryParams:{
        query:"",
        cid:"",
        pagenum:1,
        pagesize:10
    },
    //总页数
    pages: 0,
    onLoad(options){
        let cid = options.cid;
        console.log( '类别',cid);
        this.QueryParams.cid = cid
        this.getGoodsList()
    },
    async getGoodsList(){
      let ret =await request({url:'/goods/search',data:this.QueryParams})
      // 总条数23 = 23/10 =2.3 =3页 
      let total = ret.message.total 
      this.pages = Math.ceil(total/this.QueryParams.pagesize)
      console.log( ret );
      let sz = [...this.data.goodsList,...ret.message.goods]
      this.setData({
        goodsList: sz
      })
    },
    //选项卡改变
    itemChange(e){
        let {index}= e.detail
        let {tabs} = this.data
        tabs.forEach( (v,i)=> i==index?v.isActive = true:v.isActive = false )
        this.setData({ tabs })
    },
    //到达底部后,加载下一页
    onReachBottom(){
        console.log('到达底部后');
        if(this.QueryParams.pagenum >= this.pages){
            wx.showToast({
              title: '到最后一页'
            })
            return;
        }
        this.QueryParams.pagenum++;
        this.getGoodsList()
    },
    //重新显示第一页
    onPullDownRefresh(){
        this.QueryParams.pagenum = 1
        this.setData({
            goodsList: []
        })
        //重新发请求
        this.getGoodsList()
    }
})
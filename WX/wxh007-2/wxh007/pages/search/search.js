import {request} from '../../utils/request'
Page({
    data: {
        goods:[],
        inpValue: ''
    },
    //定时器开关
    timekey: -1,
    //搜素框输入
    inputHandle(e){
        //获取你的输入
        let {value} =  e.detail
        clearTimeout( this.timekey )
        this.timekey = setTimeout( ()=>{
            //后台发请求
            console.log( value );
            this.qsearch(value);
        },1000)
    },
    async qsearch(query){
       let ret = await request({ url:"/goods/qsearch",data:{query}})
       this.setData({goods: ret.message})
       console.log('结果', ret );
    },
    //取消
    cancelHandle(){
        this.setData({
            goods: [],
            inpValue: ''
        })
    }
})
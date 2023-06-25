import {request} from '../../utils/request'
Page({

    /**
     * 页面的初始数据
     */
    data: {

    },
    onShow() { 
        this.getOrders()
    },
    async getOrders(){
        let type = 0
        const ret = await request({ url: "/my/orders/all", data: { type } });
        console.log( ret); 
    }
})
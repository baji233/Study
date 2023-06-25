// components/tabs/tabs.js
Component({
    /**
     * 组件的属性列表
     */
    properties: {
        list:{
            type: Array
        }
    },
    /**
     * 组件的初始数据
     */
    data: {

    },
    /**
     * 组件的方法列表
     */
    methods: {
        itemChange(e){
            let {index} = e.currentTarget.dataset
            console.log( index );
            //子传父 index
            this.triggerEvent('tabsItemChange',{index});
        }
    }
})

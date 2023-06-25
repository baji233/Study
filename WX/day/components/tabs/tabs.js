// components/tabs/tabs.js
Component({
    /**
     * 组件的属性列表
     */
    properties: {
        list: Array
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
        //子传父
        itemChange(e) {
            let {index} = e.currentTarget.dataset
            this.triggerEvent('tabsitemChange', {index})
        }
    }
})

<template>
    <div class="school">
        <h1>学校编号: {{sid}}</h1>
        <h1 ref="sname">学校名称: {{sname}}</h1>
        <!-- ref是用来给元素或子组件注册引用信息(id的替代者) -->
        <button ref="btu" @click="showDom">获取DOM对象</button>
        <input ref="text" type="text"/>
    </div>
</template>

<script>
    export default {
        name: 'SchoolView',
        data() {
            return {
                sid: '12',
                sname: '魔法学院'
            }
        },
        methods: {
            showDom() {
                //this.$refs.xxx和通过document.getElementById(“xxx”)的效果一样。
                console.log(this.$refs.sname);
                console.log(this.$refs.btu);
                this.$refs.text.value = this.$refs.sname
            }
        }
    }
</script>

<style>
    school {
        background-color: aquamarine;
    }
</style>
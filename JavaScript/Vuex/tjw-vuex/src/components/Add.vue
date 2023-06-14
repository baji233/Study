<template>
    <div style="background-color: aqua;">
        <h1>加法组件</h1>
        <h1>{{ this.$store.state.count }}</h1>
        <button @click="handle">加1</button>
        <button @click="handle2">加N</button>

        <button @click="getJokes">笑话</button>
    </div>
</template>

<script>
export default (await import('vue')).defineComponent({
    data() {
        return {

        }
    },
    methods: {
        handle() {
            this.$store.commit('add')
        },
        handle2() {
            //调用mutations的方法
            this.$store.commit('addN', 10)
        },
        getJokes() {
            //调用actions的方法
            this.$store.dispatch('joke')
        }
    }
})  
</script>

<style></style>
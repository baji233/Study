<template>
    <div>
        <h1>国服龙龟</h1>
        <h2>{{ info }}</h2>
        <img src="../assets/fish.jpg" width="200" >
        <button @click="test">测试</button>
    </div>
</template>
<script>
export default {
    data() {
        return {
            info: '美国为什么喜欢打仗?',
            classn: 'p1'
        }
    },
    methods: {
        test() {
            alert('ok')
        }
    }
}
</script>

<style scoped>
.bg {
    background-color: yellow;
}
.p1{ background-image: url(../assets/logo.png)}

.p2{ background-image: url(../assets/fish.jpg)}
</style>
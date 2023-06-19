<template>
    <div>
        <h1>游戏组件</h1>
        <h2>{{ list }}</h2>
        <h2>{{ age }}</h2>
    </div>
</template>

<script setup>
// 接收父组件的参数
const props = defineProps(['list', 'age'])

let name = '亚索'

function mounted() {

}

</script>

<style lang="scss" scoped>

</style>
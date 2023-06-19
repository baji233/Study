<template>
    <div class="box1">
        <h1>提供者</h1>
        <h3>message: {{ message }}</h3>
        <h3>num: {{ num }}</h3>
        <button @click="num++">加</button>

        <Provide></Provide>
    </div>
</template>

<script setup>
import Provide from './components/Provide.vue'
import { provide, ref, readonly  } from 'vue';

let num = ref(15)
let message = ref('Hello')
let str = ref('只读')

// 提供一个更改数据的方法
function updateMessage() {
    message.value = 'olleH'
}

// 提供共享的数据
provide('message', {message, updateMessage})
provide('num', num)
provide('str-ro', readonly(str))

</script>

<style scoped>
.box1 {
    background-color:cadetblue;
}
</style>
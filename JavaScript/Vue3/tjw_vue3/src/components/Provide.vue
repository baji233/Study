<template>
    <div class="box2">
        <h1>子组件</h1>
        <h3>{{ message }}</h3>
        <h3>{{ num }}</h3>
        <h3>{{ str }}</h3>
        <button @click="updateMessage">变</button>
    </div>
</template>

<script setup>
import { inject } from 'vue';

//注入共享的数据
let {message, updateMessage} = inject('message')
let num = inject('num')
let str = inject('str-ro')

</script>

<style scoped>
.box2    {
    background-color: aquamarine;
}
</style>
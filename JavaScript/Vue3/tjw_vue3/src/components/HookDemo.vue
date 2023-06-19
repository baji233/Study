<template>
    <div>
        <h2>当前求和为：{{sum}}</h2>
        <button @click="sum++">点我+1</button>
        <h2>{{point}}</h2>
    </div>
</template>

<script>
import {ref} from 'vue'
import usePoint from '../hook/usePoint'

export default {
    setup () {
        let sum = ref(0)
        // 引用公共hook函数
        let point = usePoint()
        return {
            sum,point
        }
    }
}
</script>

<style>

</style>
<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <h2>地址: {{ addr }}</h2>
  <h2>姓名: {{ name }}</h2>
  <h2>年龄: {{ age }}</h2>
  <h2>年数: {{ year }}</h2>
  <h2>对象: {{ city.name }} -- {{ city.salary }}</h2>
  <h2>数组: {{ arr }}</h2>


<button @click="handle">修改</button>
<button @click="handle2">修改2</button>

</template>

<script>
// 用ref()定义响应式变量, reactive定义响应式代理对象
import { reactive, ref } from 'vue'

export default {
  name: 'App',
  data() {
    return {
      addr: '湘潭'
    }
  },
  methods: {
    handle() {
      this.addr = '武汉'
      this.name = '剑圣'
    }
  },
  // vue3组合式API (是一个专门用于组合式 API 的特殊钩子函数)
  setup() {
    // 定义数据
    let name = '龙龟'
    let age = 18
    //定义响应式变量 RefImpl.value
    let year = ref('2023')
    //定义响应式代理对象 proxy(Object)
    let city = reactive({
      name: '上海',
      salary: '10k'
    })
    let arr = reactive([1,2,4,6])

    // 定义函数
    function handle2() {
      console.log('运行...');
      // 响应式消失, 但数据已修改
      name = '亚索'
      console.log('name:', name);

      // 修改响应式数据
      year.value = '2024'
      console.log('year', year);

      // 修改响应式代理对象
      city.name = '北京'
      console.log(city);

      // 修改数组
      // arr = [8,9,9,0]
      arr[0] = '123'
      console.log(arr);
    }

    // 暴露数据到模板
    return {
      name, age, city, year, arr,
      handle2
    }    
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

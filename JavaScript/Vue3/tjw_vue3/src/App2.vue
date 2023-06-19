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












<!-- <script setup>新写法 -->
<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <h2>地址: {{ addr }}</h2>
  <h2>姓名: {{ name }}</h2>
  <h2>年龄: {{ age }}</h2>
  <h2>年数: {{ year }}</h2>
  <h2>对象: {{ city.name }} -- {{ city.salary }}</h2>
  <h2>数组: {{ arr }}</h2>

  <button @click="handle1">修改</button>
  <button @click="handle2">修改2</button>
</template>

<script setup>
// 用ref()定义响应式变量, reactive定义响应式代理对象
import { reactive, ref } from 'vue'

// 定义数据
let addr = '湘潭'
let name = '亚索'
let age = 18
//定义响应式变量 RefImpl.value
let year = ref('2023')
//定义响应式代理对象 proxy(Object)
let city = reactive({
  name: '上海',
  salary: '10k'
})
let arr = reactive([1, 2, 4, 6])

function handle1() {
  this.addr = '武汉'
  this.name = '剑圣'
}
function handle2() {
  console.log('运行...');
  // 响应式消失, 但数据已修改
  name = '狐狸'
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

// !!无需暴露!!
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












<!-- vbase 模板 -->
<template>
  <div>

  </div>
</template>

<script setup>

</script>

<style lang="scss" scoped>

</style>













vue3计算属性
<template>
  <h1>{{ city.name }} -- {{ city.salary }}k</h1>
  <h1>阶级: {{ level }}</h1>
  <button @click="handle">修改</button>
</template>

<script setup>
import { reactive, computed } from 'vue';

let city = reactive({
  name: '长沙',
  salary: 5
})
const firstName = ref('John')
const lastName = ref('Doe')

function handle() {
  city.name = '北京'
  city.salary += 10
}

// Vue3计算属性(有缓存)
let level = computed(() => {
  // 从计算属性返回的值是派生状态(临时快照), 因为是只读的,所以可以同时提供 getter 和 setter 来操控计算属性
  return city.salary > 30 ? '中产' : '无产'
})
const fullName = computed({
  // getter
  get() {
    return firstName.value + ' ' + lastName.value
  },
  // setter
  set(newValue) {
    // 注意：我们这里使用的是解构赋值语法
    [firstName.value, lastName.value] = newValue.split(' ')
  }
})  
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








 
<template>
  <h1>Vue3组件传参</h1>
  <Game :list="arr" :age="age"></Game>
  
  <h2>{{ name }}</h2>
  <button>获取子组件的值</button>
  </template>
  
  <script setup>
  // 组件只需要导入,无需注册
  import { reactive, ref } from 'vue';
  import Game from './components/Game.vue'
  
  // 从 App.vue --> Game.vue 传参
  let arr = reactive([1,2,3,4,5,6])
  let age = ref(18)
  let name = ref('提莫')
  </script>
  
  <style scoped>
  </style>
  
  
  
  
  
  
  
  
  <template>
    <div>
      <h1>{{ sum }}</h1>
      <h1>{{ timo }}</h1>
      <button @click="sum++">改变</button>
      <button @click="timo = '龙龟'">修改</button>
      <h1>笑话</h1>
      <input type="" v-model="num"/>
      <p v-for="item in list.arr">{{ item }}</p>
  
    </div>
  </template>
  
  <script setup>
  import { reactive, ref, watch } from 'vue'
  import axios from 'axios'
  
  let sum = ref(0)
  let timo = ref('提莫')
  let num = ref(10)
  let joke = ref([])
  let list = reactive({
    arr: []
  })
  
  //侦听器(单个数据)
  watch(sum, (newv, oldv) => {
    console.log('新: ' newv, '旧: ', oldv);
  })
  
  //侦听器(多个数据)
  watch([sum, timo], (newv, oldv) => {
      console.log('新: ', newv, '旧: ', oldv);
  }, {immediate: true})
  
  //侦听器(执行异步请求)
  watch([num], async (newv, oldv) => {
    let ret = await axios.get('https://autumnfish.cn./api/joke/list', { params: { num: num.value } })
    // joke.value = ret.data.data
    
    list.arr = ret.data.data
  }, {immediate: true})
  
  </script>
  
  <style lang="scss" scoped>
  
  </style>


 





<template>
  <div class="box1">
    <h1>vue3生命周期</h1>
    <Demo v-if="life"></Demo>
    <button @click="life=!life">切换</button>
  </div>
</template>

<script setup>
import { ref, reactive, computed } from 'vue';
import Demo from './components/Demo.vue'

let life = ref(true)
</script>

<style scoped>
.box1 {
  background-color: aqua;
}
</style>




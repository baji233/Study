<template>
    <div style="background-color: thistle;">
        <h1>减法组件</h1>
        <h1>{{ count }}</h1>
        <button @click="handle">减1</button>
        <button @click="handle2">减N</button>

        <button @click="getJokes">笑话</button>
        <div>{{ jokes }}</div>
    </div>
</template>
  
<script>
// 导入映射State的mapState, mapMutations辅助函数
import { mapState, mapMutations, mapActions  } from 'vuex';

export default (await import('vue')).defineComponent({
    data() {
        return {

        }
    },
    methods: {
        //使用 mapMutations 辅助函数帮助我们生成方法sub(), subN()
        ...mapMutations(['sub', 'subN']),
        handle() {
            this.sub()
        },
        handle2() {
            this.subN(5)
        },
        ...mapActions(['joke']),
        getJokes() {
            this.joke()
        }
    },
    //使用 mapState 辅助函数帮助我们生成计算属性count
    computed: {
        ...mapState(['count', 'jokes'])
    }

})
</script>
  
<style></style>
<!-- <template>
    <div class="box2">
        <h1>我是子组件 {{ num }}</h1>
        <button @click="num++">更新</button>
    </div>
</template>

<script>
export default {
    setup() {
        console.log('setup');

    },
    beforeCreate() {
        console.log('创建前');

    },
    created() {
        console.log('创建后');
    }
    
}
</script>

<!-- <script setup>
//注册生命周期钩子
import { onBeforeUnmount, onUnmounted, ref, onBeforeMount, onBeforeUpdate, onMounted, onUpdated } from 'vue'
let num  = ref(0)

onBeforeMount(() => {
    console.log('挂载前');
})

onMounted(() => {
    console.log('挂载后');
})

onBeforeUpdate(() => {
    console.log('更新前');
})

onUpdated(() => {
    console.log('更新后');
})

onBeforeUnmount(() => {
    console.log('卸载前');
})

onUnmounted(() => {
    console.log('卸载后');
})
</script> -->

<style scoped>
.box2 {
    background-color: burlywood;
}
</style> -->
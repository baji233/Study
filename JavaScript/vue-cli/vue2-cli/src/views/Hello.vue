<template>
  <div class="main">
    <router-link to="/school">学校</router-link> | 
    <router-link to="/game">游戏</router-link> |
    <router-link to="/about">关于</router-link> |

    <h1>测试axios插件,less和less-locad,Element-UI依赖</h1>

    <el-button icon="el-icon-loading" @click="handle" type="danger">危险按钮</el-button>
    <i class="el-icon-delete-solid"></i>
    <el-tag type="success">标签三</el-tag>

    <h1>
        <div class="big">大盒子
            <div class="small">
                小盒子
            </div>
        </div>
    </h1>

    <h1>
        <el-button @click="axiosTest" type="primary" round>axios请求</el-button>
        <h3 v-for="(item,i) in list" :key="i">{{item}}</h3>
    </h1>
  </div>
</template>



<script>
import axios from 'axios'

export default {
    data() {
        return {
            list: []
        }
    },

    methods: {
        handle() {
            alert('危险!!')
        },
        async axiosTest() {
            let url = 'https://autumnfish.cn./api/joke/list'
            await axios.get(url, { params: { num: 5 } })
            .then((ret) => {
            console.log('结果', ret);
            this.list = ret.data.data;
            });
        }

    }
}
</script>

<style lang="less" scoped>
    .big {
        width: 200px;
        height: 200px;
        background-color: aqua;
    }

    .small {
        width: 100px;
        height: 100px;
        background-color: red;
    }
</style>>

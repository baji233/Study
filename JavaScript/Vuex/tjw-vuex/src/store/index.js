import Vue from 'vue'
import Vuex from 'vuex'
import asios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    //多个组件可共享的数据
    count: 0,
    jokes: ''
  },
  getters: {
  },
  mutations: {
    //vuex的方法区
    add(state) {
      state.count++
    },
    addN(state, step) {
      state.count += step
    },
    sub(state) {
      state.count--
    },
    subN(state, step) {
      state.count -= step
    },
    //不能直接调用这个异步函数,要使用actions调用
    async joke(state) {
      let ret = await asios.get('https://autumnfish.cn./api/joke/list', { params: { num: 5 } })
      console.log(ret);
      state.jokes = ret.data.data
    }
    
  },
  actions: {
    //可包含任意异步操作的mutations
     joke(context) {
      context.commit('joke')
    }
  },
  modules: {
  }
})

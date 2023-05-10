<template>
  <div class="about">
    <h1>This is an about page</h1>

    <h3 v-for="(item, i) in list" :key="i">{{ item }}</h3>
  </div>
</template>

<script>
export default {
  data() {
    return {
      list: [],
    };
  },
  //挂载后
  async mounted() {
    let url = "https://autumnfish.cn./api/joke/list";
    await this.http.get(url, { params: { num: 5 } }).then((ret) => {
      console.log("结果", ret);
      this.list = ret.data.data;
    });
  },
};
</script>

<style>
</style>

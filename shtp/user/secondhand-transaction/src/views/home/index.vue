<template>
  <div class="home-container">
    <div class="home-text">name: {{ name }}</div>
  </div>
</template>

<script lang="ts">
import {adminUserStore} from '@/store';

export default {
  name: 'Home',
  computed: {
    name(){
      return adminUserStore.user.username;
    }
  }
}
</script>

<style lang="scss" scoped>
.home {
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>

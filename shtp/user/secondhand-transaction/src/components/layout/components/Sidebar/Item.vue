<template>
  <el-icon>
    <component v-if="isUpperCaseLetter(icon)" :class="[icon, 'sub-el-icon']" :is="icon"/>
    <svg-icon :icon-class='icon' v-else />
  </el-icon>
  <span v-if="title">{{ title }}</span>
</template>

<script lang="ts">
import { isUpperCaseLetter } from '@/utils';
export default {
  name: 'MenuItem',
  props: {
    icon: {
      type: String,
      default: ''
    },
    title: {
      type: String,
      default: ''
    }
  },
  methods: {
    isUpperCaseLetter
  }
}
</script>

<style scoped lang="scss">
.el-icon {
  .svg-icon {
    margin-right: 12px !important;
  }
  .sub-el-icon {
    color: currentColor;
    width: 1em;
    height: 1em;
  }
}
</style>

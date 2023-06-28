<template>
  <el-breadcrumb class="app-breadcrumb" separator="/">
    <transition-group name="breadcrumb">
      <el-breadcrumb-item v-for="(item, index) in levelList" :key="item.path">
        <span v-if="item.redirect === 'noRedirect' || index == levelList.length - 1" class="no-redirect">{{ (item.meta || {}).title
        }}</span>
        <a v-else @click.prevent="handleLink(item)">{{ (item.meta || {}).title }}</a>
      </el-breadcrumb-item>
    </transition-group>
  </el-breadcrumb>
</template>

<script lang="ts" setup>
import {compile} from 'path-to-regexp'
import { ref, watch, } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import type {RouteRecordRaw} from 'vue-router'

const $route = useRoute();
const $router = useRouter();
const levelList = ref([] as RouteRecordRaw[]);
watch(
  () => $route,
  getBreadcrumb,
  { immediate: true, deep: true }
);

function getBreadcrumb() {
  let matched = $route.matched.filter(item => item.meta && item.meta.title) as RouteRecordRaw[];
  const first = matched[0]

  if (!isHome(first)) {
    const routeArr: RouteRecordRaw[] = [{ path: '/home', meta: { title: '首页' }, redirect: '/' }];
    
    matched = routeArr.concat(matched);
  }

  levelList.value = matched.filter(item => item.meta && item.meta.title && item.meta.breadcrumb !== false)
}
function isHome(route: RouteRecordRaw) {
  const name = (route && route.name) as string
  if (!name) {
    return false
  }
  return name.trim().toLocaleLowerCase() === 'home'.toLocaleLowerCase()
}
function pathCompile(path: string) {
  const { params } = $route
  var toPath = compile(path);
  return toPath(params)
}
function handleLink(item: RouteRecordRaw) {
  const { redirect, path } = item
  if (redirect) {
    $router.push(redirect as string)
    return
  }
  $router.push(pathCompile(path))
}
</script>

<style lang="scss" scoped>
.app-breadcrumb.el-breadcrumb {
  display: inline-block;
  font-size: 14px;
  line-height: 50px;
  margin-left: 8px;

  .no-redirect {
    color: #97a8be;
    cursor: text;
  }
}
</style>

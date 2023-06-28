<template>
  <div v-if="!(item.meta || {}).hidden">
    <template v-if="hasOneShowingChild(item.children, item as RouteRecordRaw) && (!onlyOneChild.children || (onlyOneChild.meta || {}).noShowingChildren) && !item.alwaysShow">
      <!-- <app-link v-if="onlyOneChild.meta" :to="resolvePath(onlyOneChild.path)">
        <el-menu-item :index="resolvePath(onlyOneChild.path)" :class="{ 'submenu-title-noDropdown': !isNest }">
          <item :icon="onlyOneChild.meta.icon || (item.meta && item.meta.icon)" :title="(onlyOneChild.meta.title as string)" />
        </el-menu-item>
      </app-link> -->
      <el-menu-item @click="to" v-if="onlyOneChild.meta" :index="resolvePath(onlyOneChild.path)" :class="{ 'submenu-title-noDropdown': !isNest }">
        <item :icon="onlyOneChild.meta.icon || (item.meta && item.meta.icon)" />
        <template #title v-if="onlyOneChild.meta.title">{{ onlyOneChild.meta.title }}</template>
      </el-menu-item>
    </template>

    <el-sub-menu v-else ref="subMenu" :index="resolvePath(item.path)">
      <template #title>
        <item v-if="item.meta" :icon="item.meta && item.meta.icon" :title="item.meta.title" />
      </template>
      <sidebar-item v-for="child in item.children" :key="child.path" :is-nest="true" :item="child"
        :base-path="resolvePath(child.path)" class="nest-menu" />
    </el-sub-menu>
  </div>
</template>

<script setup lang="ts">
import path from 'path-browserify'
import Item from './Item.vue'
// import AppLink from './Link.vue'
import type { RouteRecordRaw } from 'vue-router'
import { useRouter } from 'vue-router'
import { appStore } from "@/store"
import { onMounted, ref } from "vue"
import { isExternal } from '@/utils';

const $router = useRouter();
const subMenu = ref();
let onlyOneChild = {} as RouteRecordRaw;
const props = defineProps({
  item: {
    type: Object,
    required: true
  },
  isNest: {
    type: Boolean,
    default: false
  },
  basePath: {
    type: String,
    default: ''
  }
});

function hasOneShowingChild(children: RouteRecordRaw[] = [], parent: RouteRecordRaw) {
  const showingChildren = children.filter(item => {
    const meta = item.meta || {};
    if (meta.hidden) {
      return false
    } else {
      // Temp set(will be used if only has one showing child)
      onlyOneChild = item
      return true
    }
  })

  // When there is only one child router, the child router is displayed by default
  if (showingChildren.length === 1) {
    return true
  }

  // 如果没有要显示的子路由器，则显示父路由器
  if (showingChildren.length === 0) {
    const meta = {title: parent.meta!.title, noShowingChildren: true};
    onlyOneChild = { ...parent, path: '', meta };
    return true
  }

  return false
}
function resolvePath(routePath: string) {
  if (isExternal(routePath)) {
    return routePath
  }
  if (isExternal(props.basePath)) {
    return props.basePath
  }
  return path.resolve(props.basePath, routePath)
}
function to(){
  if (appStore.device === 'mobile') {
    appStore.closeSideBar(false);
  }
  $router.push(resolvePath(onlyOneChild.path));
}

onMounted(() => {
  if (subMenu.value) {
    const handleMouseleave = subMenu.value.handleMouseleave;
    subMenu.value.handleMouseleave = (e: any) => {
      if (appStore.device === 'mobile') {
        return
      }
      handleMouseleave(e)
    }
  }
});
</script>

<script lang="ts">
export default {
  name: 'SidebarItem',
}
</script>
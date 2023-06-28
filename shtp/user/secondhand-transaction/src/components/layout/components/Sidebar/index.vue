<template>
  <div :class="{ 'has-logo': settingsStore.showLogo }">
    <logo v-if="settingsStore.sidebarLogo" :collapse="isCollapse" />
    <el-scrollbar wrap-class="scrollbar-wrapper">
      <el-menu :default-active="activeMenu" :collapse="!isCollapse" :background-color="variables.menuBg"
        :text-color="variables.menuText" :unique-opened="false" :active-text-color="variables.menuActiveText"
        :collapse-transition="false" mode="vertical">
        <sidebar-item v-for="route in routes" :key="route.path" :item="route" :base-path="route.path" />
      </el-menu>
    </el-scrollbar>
  </div>
</template>

<script lang="ts" setup>
import Logo from './Logo.vue'
import SidebarItem from './SidebarItem.vue'
import variables from '@/styles/variables.module.scss'
import { computed } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { settingsStore, appStore } from '@/store'

const $route = useRoute();
const $router = useRouter();
const routes = computed(() => $router.options.routes);

const activeMenu = computed(() => {
  const { meta, path } = $route
  // 如果设置了路径，侧边栏将突出显示您设置的路径
  if (meta.activeMenu) {
    return meta.activeMenu
  }
  return path
});
const isCollapse = computed(() => appStore.sidebar.opened);
</script>

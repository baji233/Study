<template>
  <div class="sidebar-logo-container" :class="{ 'collapse': collapse }">
    <transition name="sidebarLogoFade">
      <a v-if="collapse" key="collapse" class="sidebar-logo-link" @click="to">
        <div v-if="logo" class="sidebar-logo">
          <img v-if="isImg(logo)" :src="logo">
          <el-icon v-else-if="isUpperCaseLetter(logo)">
            <component :is="logo" />
          </el-icon>
          <svg-icon v-else :icon-class="logo" />
        </div>
        <h1 class="sidebar-title">{{ title }} </h1>
      </a>
      <a v-else key="expand" class="sidebar-logo-link" @click="to">
        <div v-if="logo" class="sidebar-logo">
          <img v-if="isImg(logo)" :src="logo">
          <el-icon v-else-if="isUpperCaseLetter(logo)">
            <component :is="logo" />
          </el-icon>
          <svg-icon v-else :icon-class="logo" />
        </div>
      </a>
    </transition>
  </div>
</template>

<script setup lang="ts">
import { appStore } from '@/store';
import { isUpperCaseLetter, isImg } from '@/utils';
import { title, logo } from '@/utils/settings';
import { useRouter } from 'vue-router';

const $router = useRouter();
defineProps({
  collapse: {
    type: Boolean,
    required: true
  }
});

function to(){
  if (appStore.device === 'mobile') {
    appStore.closeSideBar(false);
  }
  $router.push('/');
}

</script>

<script lang="ts">
export default {
  name: 'SidebarLogo',
}
</script>

<style lang="scss" scoped>
.sidebarLogoFade-enter-active {
  transition: opacity 1.5s;
}

.sidebarLogoFade-enter,
.sidebarLogoFade-leave-to {
  opacity: 0;
}

.sidebar-logo-container {
  position: relative;
  width: 100%;
  height: 50px;
  line-height: 50px;
  background: #2b2f3a;
  text-align: center;
  overflow: hidden;

  & .sidebar-logo-link {
    height: 100%;
    width: 100%;
    display: flex !important;

    & .sidebar-logo {
      width: 32px;
      height: 100%;
      vertical-align: middle;
      margin: 0 12px;
      z-index: 2;

      img,
      svg {
        width: 100%;
        height: 100%;
      }
    }

    & .sidebar-title {
      flex: 2;
      margin: 0;
      color: #fff;
      font-weight: 600;
      line-height: 50px;
      font-size: 20px;
      font-family: Avenir, Helvetica Neue, Arial, Helvetica, sans-serif;
      vertical-align: middle;
      animation: show .25s linear;
    }

    @keyframes show {
      from {
        transform: translateX(-30px);
        z-index: -1;
      }
      to {
        z-index: 1;
        transform: translateX(0);
      }
    }
  }

  &.collapse {
    .sidebar-logo {
      margin-right: 0px;
    }
  }
}</style>

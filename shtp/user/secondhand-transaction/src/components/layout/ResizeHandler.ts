import { appStore } from '@/store'
import { useRoute } from 'vue-router'
import { watch, onBeforeMount, onBeforeUnmount, onMounted } from 'vue';

const { body } = document
const WIDTH = 992 // 参考 Bootstrap 的响应式设计
export default () => {
  const $route = useRoute();
  
  watch(() => $route, () => {
    if (appStore.device === 'mobile' && appStore.sidebar.opened) {
      appStore.closeSideBar(false);
    }
  });
  
  onBeforeMount(() => window.addEventListener('resize', $_resizeHandler));
  onBeforeUnmount(() => window.removeEventListener('resize', $_resizeHandler));
  onMounted(() => {
    const isMobile = $_isMobile()
    if (isMobile) {
      appStore.toggleDevice('mobile')
      appStore.closeSideBar(true);
    }
  });
}

function $_resizeHandler() {
  if (!document.hidden) {
    const isMobile = $_isMobile()
    appStore.toggleDevice(isMobile ? 'mobile' : 'desktop');

    if (isMobile) {
      appStore.closeSideBar(true);
    }
  }
}

function $_isMobile() {
  const rect = body.getBoundingClientRect()
  return rect.width - 1 < WIDTH
}
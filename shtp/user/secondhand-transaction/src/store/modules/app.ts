import Cookies from 'js-cookie'
import { defineStore } from 'pinia'

const sidebarStatus = 'sidebarStatus';
export default defineStore('app', {
  state() {
    const opened = Cookies.get(sidebarStatus) ? !!+Cookies.get(sidebarStatus) : true;
    return {
      sidebar: {
        opened,
        withoutAnimation: false,
      },
      device: 'desktop',
    }
  },
  actions: {
    toggleSideBar() {
      this.sidebar.opened = !this.sidebar.opened
      this.sidebar.withoutAnimation = false
      if (this.sidebar.opened) {
        Cookies.set(sidebarStatus, 1)
      } else {
        Cookies.set(sidebarStatus, 0)
      }
    },
    closeSideBar(withoutAnimation: boolean) {
      Cookies.set(sidebarStatus, 0)
      this.sidebar.opened = false
      this.sidebar.withoutAnimation = withoutAnimation
    },
    toggleDevice(device: string) {
      this.device = device;
    },
  },
});
import {isShowLogo, fixedHeader } from '@/utils/settings'
import { defineStore } from 'pinia'

interface State {
  fixedHeader: boolean,
  sidebarLogo: boolean,
  [key: string]: any
}

export default defineStore('settingsStore', {
  state() {
    return {
      fixedHeader,
      sidebarLogo: isShowLogo
    } as State
  },
  actions: {
    changeSetting({ key, value }: {key: string, value: boolean}) {
      // eslint 禁用下一行无原型内置
      if (this.hasOwnProperty(key)) {
        this[key] = value;
      }
    }
  }
});
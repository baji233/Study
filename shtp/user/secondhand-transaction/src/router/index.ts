import Nprogress from 'nprogress';
import 'nprogress/nprogress.css';
import { createRouter, createWebHashHistory } from "vue-router";
import routes from "./routes";
import { title } from "@/utils/settings";
import { getToken } from "@/utils/auth";
import { adminUserStore } from '@/store';

const routeConfig = {
  // 路由 hash 模式
  history: createWebHashHistory(),
  routes, 
  // 滚动行为
  scrollBehavior(){
    return {
      let: 0, top: 0
    }
  }
}
let router = createRouter(routeConfig);

router.beforeEach((to, from, next) => {
  Nprogress.start();
  if (getToken()) {
    if (to.path === '/login') {
      next(false);
    } else {
      if (adminUserStore.user.username) {
        next();
        Nprogress.done();
      } else {
        adminUserStore.getUserInfo().then(() => {
          next();
          Nprogress.done();
        }).catch(() => {
          next(from.fullPath); Nprogress.done();
        });
      }
    }
  } else {
    if (to.path === '/login') {
      next();
    } else {
      next(`/login?redirect=${to.path}`);
    }
    Nprogress.done();
  }
  document.title = to.meta.title + '  -  ' + (title || '二手物品交易后台系统');
});

export function resetRouter(){
  router = createRouter(routeConfig);
}

export default router;
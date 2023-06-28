import {RouteRecordRaw} from 'vue-router';
import Layout from '@/components/layout/index.vue';

// 路由路径
const asyncRoutes: RouteRecordRaw[] = [];

const constRoutes: RouteRecordRaw[] = [
  {
    path: '/',
    component: Layout,
    redirect: '/home',
    children: [
      {
        path: 'home',
        name: 'Home',
        component: () => import('@/views/home/index.vue'),
        meta: { title: '首页', icon: 'home' }
      },
    ]
  },
  {
    path: '/form',
    component: Layout,
    redirect: '/form/index',
    children: [
      {
        path: 'index',
        name: 'Form',
        component: () => import('@/views/form/index.vue'),
        meta: { title: '表单', icon: 'form' }
      },
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/login/index.vue'),
    meta: { title: '登录', hidden: true }
  },
  {
    path: '/*',
    name: 'NotFound',
    component: () => import('@/views/404.vue'),
    meta: { title: '404', hidden: true }
  }
];

export default asyncRoutes.concat(constRoutes);
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '首页', icon: 'dashboard' }
    }]
  },
  {
    path: '/xitongguanli',
    component: Layout,
    name: '/XiTongGuanLi',
    meta: { title: '系统管理', icon: 'el-icon-s-tools' },
    children: [
      {
        path: 'yuangongguanli',
        name: 'YuanGongGuanLi',
        component: () => import('@/views/xitongguanli/yuangongguanli'),
        meta: { title: '员工管理', icon: 'el-icon-user-solid' }
      },
      {
        path: 'jueseguanli',
        name: 'JueSeGuanLi',
        component: () => import('@/views/xitongguanli/jueseguanli'),
        meta: { title: '角色管理', icon: 'el-icon-s-finance' }
      },
    ]
  },

  {
    path: '/member-manage',
    component: Layout,
    redirect: '/member-manage/membership-card-type',
    meta: { title: '会员管理', icon: 'member-manage' },
    children: [
      {
        path: 'membership-card-type',
        component: () => import('@/views/member-manage/membership-card-type/index'),
        name: 'membership-card-type',
        meta: { title: '会员卡类型', icon: 'membership-card-type' }
      },
      {
        path: 'member-manage',
        component: () => import('@/views/member-manage/member-manage/index'),
        name: 'member-manage',
        meta: { title: '管理会员', icon: 'member-type' },
      },
      {
        path: 'my-recharge',
        component: () => import('@/views/member-manage/my-recharge/index'),
        name: 'my-recharge',
        meta: { title: '我的充值', icon: 'recharge' }
      }
    ]
  },

  {
    path: '/kechengguanli',
    component: Layout,
    name: '/keChengGuanLi',
    meta: { title: '课程管理', icon: 'el-icon-s-order' },
    children: [
      {
        path: 'kechengliebiao',
        name: 'keChengLieBiao',
        component: () => import('@/views/kechongguanli/kechengliebiao'),
        meta: { title: '课程列表', icon: 'el-icon-user-solid' }
      },
      {
        path: 'wodekecheng',
        name: 'woDeKeCheng',
        component: () => import('@/views/kechongguanli/wodekecheng'),
        meta: { title: '我的课程', icon: 'el-icon-s-finance' }
      },

    ]
  },
  {
    path: '/qicaiguanli',
    component: Layout,
    name: '/QiCaiGuanLi',
    meta: { title: '器材管理', icon: 'el-icon-user-solid' },
    children: [
      {
        path: 'qicaiguanli',
        name: 'QiCaiGuanLi',
        component: () => import('@/views/qicaiguanli/qicaiguanlifenlei'),
        meta: { title: '器材管理', icon: 'el-icon-user-solid' }
      },
    ]
  },
  {
    path: '/shangpinliebiao',
    component: Layout,
    name: '/shangPinLieBiao',
    meta: { title: '商品管理', icon: 'el-icon-sold-out' },
    children: [
      {
        path: 'shangpinliebiao',
        name: 'shangPinLieBiao',
        component: () => import('@/views/shangpinguanli/shangpinliebiao'),
        meta: { title: '商品列表', icon: 'el-icon-user-solid' }
      },
      {
        path: 'dingdanguanli',
        name: 'dingDanGuanLi',
        component: () => import('@/views/shangpinguanli/dingdanguanli'),
        meta: { title: '订单管理', icon: 'el-icon-s-finance' }
      },

    ]
  },

  {
    path: '/lost-found',
    redirect: '/lost-found/lost-list',
    component: Layout,
    meta: { title: '失物招领', icon: 'el-icon-sold-out' },
    children: [
      {
        path: '/child'
      },
      {
        path: 'lost-list',
        name: 'lost-list',
        component: () => import('@/views/lost-found/lost-list'),
        meta: { title: '失物列表', icon: 'el-icon-user-solid' }
      },
    ]
  },
  {
    path: '/feedback-manage',
    component: Layout,
    name: 'feedback-manage',
    meta: { title: '反馈管理', icon: 'el-icon-sold-out' },
    children: [
      { path: '/feedback' },
      {
        path: 'feedback-list',
        name: 'feedback-list',
        component: () => import('@/views/feedback-manage/feedback-list'),
        meta: { title: '反馈列表', icon: 'el-icon-position' }
      },

    ]
  },


  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service supportmanage
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router

import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import GameView from '../views/GameView.vue'
import SchoolView from '../views/SchoolView.vue'
import HelloView from '../views/Hello.vue'
import LoginView from '../views/Login.vue'
import Home from '../views/Home.vue'
//子组件
import Users from '../views/users/Users.vue'
import Rights from '../views/auth/Rights.vue'
import Roles from '../views/auth/Roles.vue'
import GoodsList from '../views/goods/GoodsList.vue'
import GoodsSorting from '../views/goods/GoodsSorting.vue'
import SortingParameter from '../views/goods/SortingParameter.vue'
import OrderList from '../views/orders/OrderList.vue'
import DataReport from '../views/report/DataReport.vue'


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/homev',
    name: 'homev',
    component: HomeView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView

  },
  {
    path: '/home',
    name: 'home',
    component: Home,
    children: [
      { path: '/users', component: Users},
      { path: '/rights', component: Rights},
      { path: '/roles', component: Roles},
      { path: '/goods', component: GoodsList},
      { path: '/categories', component: GoodsSorting},
      { path: '/params', component: SortingParameter},
      { path: '/orders', component: OrderList},
      { path: '/reports', component: DataReport},
    ]
  },
  {
    path: '/game',
    name: 'game',
    component: GameView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/school',
    name: 'school',
    component: SchoolView
  },
  {
    path: '/hello',
    name: 'hello',
    component: HelloView
  }
]

const router = new VueRouter({
  //打包的项目名
  base: 'taobao',

  routes
})

export default router

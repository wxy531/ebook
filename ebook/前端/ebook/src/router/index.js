import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/index',
      name: 'indexm',
      meta: {
        isLogin: true
      },
      component: (resolve) => require(['@/pages/indexm/indexm'], resolve)
    },
    {
      path: '/',
      name: 'demo',
      meta: {
        requireAuth: true // 判断是否需要登录
      },
      component: (resolve) => require(['@/pages/demo/demo'], resolve)
    },
    {
      path: '/detail',
      name: 'detail',
      meta: {
        requireAuth: false // 判断是否需要登录
      },
      component: (resolve) => require(['@/pages/detail/detail'], resolve)
    },
    {
      path: '/car',
      name: 'car',
      component: (resolve) => require(['@/pages/car/car'], resolve)
    },
    {
      path: '/myorder',
      name: 'myorder',
      component: (resolve) => require(['@/pages/orders/myorder'], resolve)
    },
    {
      path: '/order',
      name: 'order',
      component: (resolve) => require(['@/pages/orders/order'], resolve)
    },
    {
      path: '/mycar',
      name: 'mycar',
      component: (resolve) => require(['@/pages/car/mycar'], resolve)
    },
    {
      path: '/Table',
      name: 'Table',
      component: (resolve) => require(['@/pages/indexm/Table'], resolve)
    },
    {
      path: '/register',
      name: 'register',
      meta: {
        requireAuth: false // 判断是否需要登录
      },
      component: (resolve) => require(['@/pages/register/register'], resolve)
    },
    {
      path: '/registertable',
      name: 'registertable',
      component: (resolve) => require(['@/pages/register/registertable'], resolve)
    },
    {
      path: '/manager',
      name: 'manager',
      component: (resolve) => require(['@/pages/manager/manager'], resolve)
    },
    {
      path: '/',
      name: 'pic',
      component: (resolve) => require(['@/pages/pic/pic'], resolve)
    }
  ]
})

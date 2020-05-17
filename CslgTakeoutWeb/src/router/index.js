import Vue from 'vue'
import Router from 'vue-router'
import Home from "../components/home/Home";
import Order from "../components/order/Order";
import OrderNew from "../components/order/OrderNew";
import OrderWill from "../components/order/OrderWill";
import Data from "../components/data/Data";
import Help from "../components/help/Help";
import Store from "../components/store/Store";
import Finance from "../components/finance/Finance";
import Customer from "../components/customer/Customer";
import Goods from "../components/goods/Goods";
import OrderCancel from "../components/order/OrderCancel";
import StoreMessage from "../components/store/StoreMessage";
import StoreManager from "../components/store/StoreManager";
import Login from "../components/Login";
import QureyOrder from "../components/order/QureyOrder";
import SetOrder from "../components/order/SetOrder";
import SOmusic from "../components/order/SOmusic";
import SOwill from "../components/order/SOwill";
import SOout from "../components/order/SOout";
import Orderthrow from "../components/order/Orderthrow";
import Worklogin from "../components/Worklogin";
import Main from "../components/Appmian";
import Gevaluation from "../components/customer/Gevaluation";
Vue.use(Router)


const router= new Router({
  routes: [
    {
      path: '/',
      component: Worklogin
    }, {
      path: '/main',
      components: {
        default: Main,
        order: Worklogin
      },
      children: [
        {
          path: '/main/',
          components: {
            default: Home,
            order: Order
          }
        }, {
          path: '/main/Order',
          component: Order,
          children: [
            {
              path: '/main/Order',
              name: 'order',
              component: OrderNew
            }, {
              path: '/main/Order/Will',
              name: 'order',
              component: OrderWill
            }, {
              path: '/main/Order/Cancel',
              name: 'order',
              component: OrderCancel
            }, {
              path: '/main/Order/throw',
              name: 'order',
              component: Orderthrow
            }
          ]
        }, {
          path: '/main/QureyOrder',
          component: QureyOrder
        }, {
          path: '/main/SetOrder',
          component: SetOrder,
          children: [
            {
              path: '/',
              component: SOmusic
            }, {
              path: '/will',
              component: SOwill
            }, {
              path: 'out',
              component: SOout
            }
          ]
        }, {
          path: '/main/Goods',
          component: Goods
        }, {
          path: '/main/Customer',
          component: Customer
        }, {
          path: '/main/Finance',
          component: Finance
        }, {
          path: '/main/Store',
          component: StoreMessage
        }, {
          path: '/main/Data',
          component: Data
        }, {
          path: '/main/Help',
          component: Help
        }, {
          path: '/main/StoreManager',
          component: StoreManager
        },{
          path: '/main/Cgrade',
          component: Gevaluation
        }
      ]
    }
    ]
});
//路由守卫
// 使用 router.beforeEach 注册一个全局前置守卫，判断用户是否登陆
// router.beforeEach((to, from, next) => {
//   if (to.path === '/') {
//     next();
//   } else {
//     let token = sessionStorage.getItem('Authorization');
//     if (token ==null || token === '') {
//       window.alert("用户名或密码错误");
//       next('/');
//     } else {
//       next();
//     }
//   }
// });
export default router;

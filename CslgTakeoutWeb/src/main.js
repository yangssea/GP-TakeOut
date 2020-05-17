// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import App from './App'
import router from './router'
import Vue from 'vue';
import iView from 'iview';
import 'iview/dist/styles/iview.css';
//使用框架

Vue.use(iView);
Vue.config.productionTip = false;
//全局Url地址
/*Vue.prototype.url="http://10.18.47.88";*/

Vue.prototype.url="http://localhost:8090/"
Vue.prototype.img="http://localhost:8080/image/"
//全局商品id
Vue.prototype.storeid=1;
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})

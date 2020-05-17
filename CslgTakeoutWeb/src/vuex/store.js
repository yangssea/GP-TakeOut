import Vue from 'vue';
import Vuex from 'vuex';
//使用仓库
Vue.use(Vuex);
export default new Vuex.Store({
  state: {
    Authorization:sessionStorage.getItem('Authorization') ? sessionStorage.getItem('Authorization') : '',
    test:"test"
  },
  mutations: {
    changeLogin (state, token) {
      state.Authorization =token;
      sessionStorage.setItem('Authorization',token);
    }
  }
});

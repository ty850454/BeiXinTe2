import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/ant-design-vue.js'
import axios from 'axios'

Vue.config.productionTip = false
Vue.prototype.$ajax = axios
axios.defaults.baseURL='http://bxtsy.com/api/';
// axios.defaults.baseURL='http://127.0.0.1:9080/api/';
// axios.defaults.baseURL='http://120.27.215.26:9080/api/';


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
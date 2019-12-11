<template>
  <a-locale-provider :locale="zh_CN">
    <div id="app">
      <a-layout id="layout">
        <a-layout-header class="header">
          <div class="logo" />
          <a-menu
            theme="dark"
            mode="horizontal"
            :defaultSelectedKeys="['1']"
            :style="{ lineHeight: '64px' }"
          >
            <a-menu-item key="1">后台</a-menu-item>
            <a-menu-item key="2">前台</a-menu-item>
          </a-menu>
        </a-layout-header>
        <a-layout-content style="padding: 0 50px; height: 100%">
          <a-layout style="padding: 24px 0; background: #fff; margin: 16px 0; height: 100%">
            <a-layout-sider width="200" style="background: #fff">
              <a-menu
                mode="inline"
                style="height: 100%"
                :defaultSelectedKeys="defaultSelectedKeys"
              >
                <a-menu-item key="/product" to="/product">
                  <router-link to="/product">产品</router-link>
                </a-menu-item>
                <a-menu-item key="/typeSet">
                  <router-link to="/typeSet">产品分类</router-link>
                </a-menu-item>
                <a-menu-item key="3">其它设置</a-menu-item>
              </a-menu>
            </a-layout-sider>
            <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
              <router-view />
            </a-layout-content>
          </a-layout>
        </a-layout-content>
        <a-layout-footer style="text-align: center">Ant Design ©2018 Created by Ant UED</a-layout-footer>
      </a-layout>
    </div>
  </a-locale-provider>
</template>

<script>
import zh_CN from "ant-design-vue/lib/locale-provider/zh_CN";
import HelloWorld from "./components/HelloWorld.vue";

export default {
  name: "app",
  data() {
    return {
      zh_CN
    };
  },
  beforeCreate() {
      if (this.$route.path === "/") {
        this.$router.push("/product");
      }
      this.defaultSelectedKeys = [this.$route.path]
  },
  // beforeRouteEnter (to, from, next) {
  //   console.log(to);
  // },
  // beforeRouteUpdate(to, from, next) {
  //   console.log(to);
  // },
  // beforeRouteLeave (to, from, next) {
  //   console.log(to);
  // },console.log()
  mounted() {
    this.$nextTick(function() {
      // console.log(this.siderMenuSelect)
      // if (this.$route.path === "/") {
      //   this.$router.push("/product");
      // }
      // this.siderMenuSelect.length = 0
      // this.siderMenuSelect.push(this.$route.path)
    });
  },
  // watch: {
  //   '$route' (to, from) {
  //     console.log(to);
  //   }
  // },
  methods: {
    // siderMenuSelect(o) {
    // console.log(o);
    // }
  }
};
</script>

<style>
#app {
  height: 100%;
}
#layout {
  height: 100%;
}
#layout .logo {
  width: 120px;
  height: 31px;
  background-image: url("http://cdn.dreammakerteam.com/bxt/logo.png");
  background-size: contain;
  margin: 16px 24px 16px 0;
  float: left;
}
</style>

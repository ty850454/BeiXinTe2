<template>
  <a-locale-provider :locale="zh_CN">
    <a-layout id="layout">
      <!-- <a-affix> -->
      <a-layout-header>
        <div class="logo">
          <img src="http://cdn.dreammakerteam.com/bxt/logo.png" />
        </div>
        <div class="contact">
          <a-icon type="phone" class="phone" />
          <div>
            <div class="rx">全国客服热线</div>
            <div class="dh">0517-89881150</div>
          </div>
        </div>
        <a-menu theme="dark" mode="horizontal" :defaultSelectedKeys="['2']">
          <!-- <a-menu-item key="1">首页</a-menu-item> -->
          <a-menu-item key="2">产品中心</a-menu-item>
          <!-- <a-menu-item key="3">联系我们</a-menu-item> -->
        </a-menu>
      </a-layout-header>
      <!-- </a-affix> -->
      <a-layout-content>
        <router-view />
      </a-layout-content>
      <a-layout-footer>
        <div class="footer">
          <!-- <div style="width: 400px;">
            <h2>关于我们</h2>
            <div>可视化图文内容编辑模式让网站制作和维护成为一件轻松惬意的事。无论您是普通用户还是专业制作人员，都能使用起飞页设计出最具专业水准的网站。</div>
          </div> -->
          <div>
            <h2>联系方式</h2>
            <div>
              咨询电话 : 0517-89881150
              <!-- <br />商务合作 : abc@abcde.com -->
              <!-- <br />联系我们 : 0517-89881150 -->
            </div>
          </div>
        </div>
      </a-layout-footer>
    </a-layout>
  </a-locale-provider>
</template>

<script>
import zh_CN from "ant-design-vue/lib/locale-provider/zh_CN";

export default {
  name: "app",
  data() {
    return {
      zh_CN
    };
  }
};
</script>

<style>
#layout > .ant-layout-header {
  line-height: 90px;
  height: 90px;
  background: #ffffff none repeat center top;
  padding: 0 150px;
}

#layout > .ant-layout-header > .ant-menu {
  line-height: 90px;
  background: #ffffff none repeat center top;
}

#layout > .ant-layout-header > .ant-menu > .ant-menu-item {
  height: 90px;
  line-height: 90px;
  color: #666666;
  font-family: 微软雅黑, Helvetica, Arial, Verdana, sans-serif;
  font-size: 20px;
}

#layout
  > .ant-layout-header
  > .ant-menu
  > .ant-menu-item.ant-menu-item-selected {
  background-color: transparent;
  color: #0088cc;
}

#layout > .ant-layout-header > .logo {
  width: 200px;
  height: 60px;
  float: left;
  margin-right: 50px;
}

#layout > .ant-layout-header > .logo > img {
  width: auto;
  height: auto;
  max-width: 100%;
  max-height: 100%;
}

#layout > .ant-layout-header > .contact {
  width: 240px;
  height: 40px;
  float: right;
  margin-right: 20px;
}

#layout > .ant-layout-header > .contact > .phone {
  font-size: 60px;
  color: #0088cc;
  line-height: 90px;
  float: left;
}

#layout > .ant-layout-header > .contact > div {
  height: 90px;
  padding: 15px 0;
  margin-left: 70px;
  color: #0088cc;
  font-weight: bolder;
  font-size: 20px;
}

#layout > .ant-layout-header > .contact > div > .rx {
  height: 30px;
  line-height: 30px;
}

#layout > .ant-layout-header > .contact > div > .dh {
  height: 30px;
  line-height: 30px;
}

#layout > .ant-layout-content {
  padding: 0;
  min-height: 600px;
  background-color: #f0f0f0;
}

#layout .ant-layout-footer {
  background-color: #878787;
  color: #fff;
}

#layout .footer {
  display: flex;
  width: 800px;
  margin: 0 auto;
}

#layout .footer > div {
  margin-left: 20px;
}

#layout .footer > div > div {
  font-weight: 14;
  font-size: 12px;
}

#layout .footer h2 {
  color: #fff;
  font-weight: bold;
  font-size: 14px;
}
</style>

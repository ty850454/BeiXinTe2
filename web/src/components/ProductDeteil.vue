<template>
  <div id="product">
    <div class="info">
      <div style="height: 100%;display: flex;justify-content: center;align-items: center;min-height: 200px;"><img style="width: auto;height: auto;max-width: 100%;max-height: 100%;" :src="product.img"/></div>
      <div>
        <h1>{{product.name}}</h1>
        <a-divider />
        <a-rate v-model="rate" disabled style="line-height: 10px;" />
        <a-divider />
        <h3 style="color: #6a6a6a;margin-bottom: 15px;">参考价：<span style="color: red;font-size: 25px;">¥ ？</span></h3>
        <div style="line-height: 25px;margin-bottom: 15px;">{{product.content}}</div>
        <a-popover trigger="click">
          <template slot="content">
            请致电0517-89881150
          </template>
          <a-button type="primary" shape="round">立即咨询</a-button>
        </a-popover>
      </div>
    </div>
    <div class="deteil">
      <a-tabs type="card">
        <a-tab-pane tab="产品介绍" key="1">{{product.content}}</a-tab-pane>
        <a-tab-pane tab="产品型号" key="2">{{product.modelNumber}}</a-tab-pane>
      </a-tabs>
    </div>
  </div>
</template>

<script>
export default {
  name: "productDeteil",
  data() {
    return {
      rate: 4,
      product: {}
    }
  },
  mounted() {
    this.$nextTick(function() {
      this.getDate(this.$route.params.id)
    });
  },
  methods: {
    getDate(id) {
      let _this = this;
      this.$ajax.get("product/" + id + "?detail").then(function(resp) {
        _this.product = resp.data.data
      });
    },
  },
};
</script>

<style scoped>
#product {
  margin: 50px auto;
  width: 1190px;
  background-color: #fff;
  padding: 80px;
  border-top: solid 2px #0088cc;
}
.info {
  display: flex;
  justify-content: space-between;
}
.info > div {
  width: 47%;
}

.ant-divider {
  background: #93bfd5;
  margin: 15px 0;
}

.ant-rate {
  line-height: 10px;
  color: #0088cc;
}

#product >>> .ant-tabs-tab {
  color: #0088cc;
  font-size: 16px;
  font-weight: normal;
  background-color: #fff;
  border: none;
  border-radius: 8px 8px 0px 0px;
  padding-right: 20px;
  padding-left: 20px;
  width: 150px;
  text-align: center;
  height: 40px;
  border-bottom: 1px solid #0088cc;
}


#product >>> .ant-tabs-tab-active {
  background: #0088cc;
  color: #fff
}

#product >>> .ant-btn-primary {
  background-color: #0088cc;
  border-color: #0088cc;
}

#product >>> .ant-tabs-bar {
  border-bottom: 1px solid #0088cc;
}
</style>

<template>
  <div id="home">
    <div class="carousel">
      <a-carousel arrows>
        <div
          slot="prevArrow"
          slot-scope="props"
          class="custom-slick-arrow"
          style="left: 10px;zIndex: 1"
        >
          <a-icon type="left-circle" theme="filled" />
        </div>
        <div slot="nextArrow" slot-scope="props" class="custom-slick-arrow" style="right: 10px">
          <a-icon type="right-circle" theme="filled" />
        </div>
        <div>
          <div class="img">
            <img src="http://cdn.dreammakerteam.com/bxt/1575553114825" />
          </div>
          <div class="title">主推产品名称</div>
          <div class="desc">描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述描述</div>
        </div>
        <div>
          <h3>2</h3>
        </div>
        <div>
          <h3>3</h3>
        </div>
        <div>
          <h3>4</h3>
        </div>
      </a-carousel>
    </div>
    <div class="product-zone">
      <div class="product">
        <div class="title">
          <a-icon type="appstore" theme="filled" /> 产品中心 · Products
        </div>
        <div class="list">
          <div class="type" @click="toDetail(product.id)" v-for="product in products" v-bind:key="product.id">
            <div class="img"><img :src="product.img" /></div>
            <div class="name">{{product.name}}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      products: []
    }
  },
  methods: {
    toDetail(id) {
      console.log(id)
      this.$router.push(`/product/${id}`)
    },
    getDate(page) {
      let _this = this;
      this.$ajax.get(`product?page=${page}&size=200`).then(function(resp) {
        _this.products = resp.data.data
      });
    },
  },
  mounted() {
    this.$nextTick(function() {
      this.getDate(1)
    });
  }
};
</script>

<style scoped>
#home .carousel {
  padding: 0 100px;
}

#home .ant-carousel >>> .slick-slide {
  height: 260px;
  overflow: hidden;
}

#home .ant-carousel >>> .slick-slide .title {
  margin-top: 50px;
  margin-left: 100px;
  font-size: 25px;
  width: 800px;
}
#home .ant-carousel >>> .slick-slide .desc {
  margin-top: 20px;
  margin-left: 100px;
  font-size: 16px;
  width: 800px;
}

#home .ant-carousel >>> .slick-slide .img {
  float: right;
  width: 400px;
  margin: 30px 100px 30px 0;
  height: 200px;
  display: flex;
  justify-content: center;
  align-items: center;
}
#home .ant-carousel >>> .slick-slide .img > img {
  width: auto;
  height: auto;
  max-width: 100%;
  max-height: 100%;
}

#home .ant-carousel >>> .slick-dots li button {
  background: #777;
}

#home .ant-carousel >>> .custom-slick-arrow {
  width: 25px;
  height: 25px;
  font-size: 25px;
  color: #777;
  opacity: 0.8;
}
#home .ant-carousel >>> .custom-slick-arrow:before {
  display: none;
}
#home .ant-carousel >>> .custom-slick-arrow:hover {
  opacity: 1;
}

#home .product-zone {
  background-color: #fff;
}

#home .product {
  margin: 0 auto;
  width: 1120px;
  min-height: 500px;
  padding-top: 50px;
}

#home .product > .title {
  font-family: 微软雅黑;
  font-size: 20px;
  color: #333333;
}

#home .product > .list {
  margin-top: 30px;
  display: flex;
  flex-wrap: wrap;
}

#home .product > .list > .type {
  height: 285px;
  width: 264px;
  background-color: #f7f7f7;
  border: 1px solid #e8e8e8;
  margin-left: 15px;
  margin-bottom: 15px;
  transition: border 0.3s ease 0s;
  transition: background-color 0.3s ease 0s;
  cursor: pointer;
}

#home .product > .list > .type:hover {
  background-color: #d8d8d8;
  border: 1px solid #d8d8d8;
}

#home .product > .list > .type > .img {
  height: 235px;
  width: 264px;
  display: flex;
  justify-content: center;
  align-items: center;
}

#home .product > .list > .type > .img > img {
  width: auto;
  height: auto;
  max-width: 100%;
  max-height: 100%;
}

#home .product > .list > .type > .name {
  height: 50px;
  width: 264px;
  text-align: center;
  font-size: 16px;
  font-weight: bold;
  line-height: 50px;
}
</style>

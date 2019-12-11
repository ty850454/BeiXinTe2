<template>
  <div>
    <a-button
      type="primary"
      style="margin-bottom: 8px;margin-top: 4px;"
      icon="plus"
      @click="showModal"
    >新增</a-button>

    <a-list bordered :dataSource="types">
      <a-list-item slot="renderItem" slot-scope="item">
        <a href="javascript:void(0)" slot="actions" @click="showModal2(item.id, item.name)">编辑</a>
        {{item.name}}
      </a-list-item>
    </a-list>

    <a-modal
      :visible="modalVisible"
      title="新建产品类型"
      @cancel="closeModal"
      okText="新建"
      @ok="saveModal"
    >
      <a-form layout="vertical" :form="formCreate">
        <a-form-item label="产品类型名称">
          <a-input
            v-decorator="['name', {rules: [{ required: true, message: '请输入产品类型名称' }]}]"
            placeholder="请输入产品类型名称"
          />
        </a-form-item>
      </a-form>
    </a-modal>

    <a-modal
      :visible="modalVisible2"
      title="编辑产品类型"
      @cancel="closeModal2"
      okText="保存"
      @ok="saveModal2"
    >
      <a-form layout="vertical" :form="formUpdate">
        <a-form-item label="产品类型名称">
          <a-input
            v-decorator="['name', {rules: [{ required: true, message: '请输入产品类型名称' }]}]"
            placeholder="请输入产品类型名称"
          />
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script>
import { black } from "color-name";
export default {
  name: "typeSet",
  data() {
    return {
      types: [],
      modalVisible: false,
      modalVisible2: false,
      formCreate: this.$form.createForm(this),
      formUpdate: this.$form.createForm(this),
      updateId: 0
    };
  },
  mounted() {
    this.$nextTick(function() {
      this.getDate();
    });
  },
  methods: {
    getDate() {
      let _this = this;
      this.$ajax.get(`productType`).then(function(resp) {
        _this.types = resp.data.data;
      });
    },
    showModal() {
      this.modalVisible = true;
    },
    closeModal() {
      this.modalVisible = false;
    },
    showModal2(id, name) {
      this.modalVisible2 = true;
      this.updateId = id;
      setTimeout(() => {
        this.formUpdate.setFieldsValue({ name: name });
      }, 0);
    },
    closeModal2() {
      this.modalVisible2 = false;
    },
    saveModal() {
      let _this = this;
      this.$ajax
        .post("productType?name=" + this.formCreate.getFieldValue("name"))
        .then(function(resp) {
          _this.getDate();
          _this.modalVisible = false;
          _this.formCreate.resetFields();
        });
    },
    saveModal2() {
      let _this = this;
      this.$ajax
        .put(
          "productType/" +
            this.updateId +
            "?name=" +
            this.formUpdate.getFieldValue("name")
        )
        .then(function(resp) {
          _this.getDate();
          _this.modalVisible2 = false;
          _this.formUpdate.resetFields();
        });
    }
  }
};
</script>

<style>
</style>

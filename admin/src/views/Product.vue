<template>
  <div>
    <a-button
      type="primary"
      style="margin-bottom: 8px;margin-top: 4px;"
      icon="plus"
      @click="showModal"
    >新增</a-button>

    <a-table
      rowKey="id"
      :columns="columns"
      :dataSource="dataSource"
      bordered
      :pagination="pagination"
      @change="handleTableChange"
    >
      <span slot="id" slot-scope="id">
        <a href="javascript:;" @click="showDrawer(id)">编辑</a>
        <a-divider type="vertical" />
        <a-popconfirm title="确定删除么？" okText="确定" cancelText="取消">
          <a href="javascript:;">删除</a>
        </a-popconfirm>
      </span>
    </a-table>
    <a-drawer
      title="编辑产品"
      :closable="false"
      :visible="drawerVisible"
      :width="500"
      @close="closeDrawer"
    >
      <a-form :form="formD" layout="vertical" hideRequiredMark>
        <a-row :gutter="16">
          <a-col :span="16">
            <a-form-item label="产品名称">
              <a-input
                v-decorator="['name', {rules: [{ required: true, message: '请输入产品名称' }]}]"
                placeholder="请输入产品名称"
              />
            </a-form-item>
          </a-col>
          <a-col :span="8">
            <a-form-item label="产品类型">
              <a-select
                v-decorator="['type',{ rules: [{ message: '选择一个产品类型' , type: 'number' }]}]"
                placeholder="选择类型"
                :allowClear="true"
              >
                <a-select-option v-for="d in types" :key="d.id">{{d.name}}</a-select-option>
              </a-select>
            </a-form-item>
          </a-col>
        </a-row>

        <a-row :gutter="16">
          <a-col :span="24">
            <a-form-item label="产品图片">
              <a-upload
                listType="picture-card"
                class="avatar-uploader"
                :showUploadList="false"
                action="http://upload.qiniup.com"
                :data="getToken"
                :beforeUpload="calcToken"
                accept="image/*"
                @change="handleChange"
              >
                <input type="hidden" v-decorator="['img']" />
                <img v-if="imageUrl" :src="imageUrl" alt="avatar" />
                <div v-else>
                  <a-icon :type="loading ? 'loading' : 'plus'" />
                  <div class="ant-upload-text">上传</div>
                </div>
              </a-upload>
            </a-form-item>
          </a-col>
        </a-row>

        <a-row :gutter="16">
          <a-col :span="24">
            <a-form-item label="产品介绍">
              <a-textarea
                v-decorator="['content', {rules: [{ required: true, message: '请输入产品介绍' }]}]"
                placeholder="请输入产品介绍"
                :autosize="{ minRows: 8, maxRows: 20 }"
              />
            </a-form-item>
          </a-col>
        </a-row>

        <a-row :gutter="16">
          <a-col :span="24">
            <a-form-item label="主要产品">
              <a-textarea
                v-decorator="['majorProduct']"
                placeholder="请输入主要产品"
                :autosize="{ minRows: 8, maxRows: 20 }"
              />
            </a-form-item>
          </a-col>
        </a-row>

        <a-row :gutter="16">
          <a-col :span="24">
            <a-form-item label="产品型号">
              <a-textarea
                v-decorator="['modelNumber']"
                placeholder="请输入产品型号"
                :autosize="{ minRows: 8, maxRows: 20 }"
              />
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>
      <div
        :style="{
          position: 'absolute',
          left: 0,
          bottom: 0,
          width: '100%',
          borderTop: '1px solid #e9e9e9',
          padding: '10px 16px',
          background: '#fff',
          textAlign: 'right',
        }"
      >
        <a-button :style="{marginRight: '8px'}" @click="closeDrawer">取消</a-button>
        <a-button @click="saveDrawer" type="primary">保存</a-button>
      </div>
    </a-drawer>

    <a-modal :visible="modalVisible" title="新建产品" @cancel="closeModal" okText="新建" @ok="saveModal">
      <a-form layout="vertical" :form="formCreate">
        <a-form-item label="产品名称">
          <a-input
            v-decorator="['name', {rules: [{ required: true, message: '请输入产品名称' }]}]"
            placeholder="请输入产品名称"
          />
        </a-form-item>
        <a-form-item label="产品介绍">
          <a-textarea
            v-decorator="['content', {rules: [{ required: true, message: '请输入产品介绍' }]}]"
            placeholder="请输入产品介绍"
            :autosize="{ minRows: 8, maxRows: 8 }"
          />
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script>
import { gainsboro } from "color-name";
const columns = [
  {
    title: "类型",
    dataIndex: "type"
  },
  {
    title: "项目名",
    dataIndex: "name"
  },
  {
    title: "创建时间",
    dataIndex: "createTime"
  },
  {
    title: "更新时间",
    dataIndex: "updateTime"
  },
  {
    title: "操作",
    dataIndex: "id",
    scopedSlots: { customRender: "id" }
  }
];
export default {
  name: "project",
  data() {
    return {
      columns,
      dataSource: [],
      drawerVisible: true,
      modalVisible: false,
      formD: this.$form.createForm(this),
      formCreate: this.$form.createForm(this),
      pagination: { total: 0, current: 1, pageSize: 7 },
      types: [],
      updateId: 0,
      imageUrl: "",
      loading: false,
      uploadToken: ""
    };
  },
  mounted() {
    this.$nextTick(function() {
      this.drawerVisible = false;
      this.getDate(1);

      let _this = this;
      this.$ajax.get("productType").then(function(resp) {
        _this.types = resp.data.data;
      });
    });
  },
  methods: {
    handleChange(info) {
      if (info.file.status === "uploading") {
        this.loading = true;
        return;
      }
      if (info.file.status === "done") {
        this.imageUrl = info.file.response.date;
        this.formD.setFieldsValue({
          img: info.file.response.date
        });
        this.loading = false;
      }
    },
    async calcToken() {
      let _this = this;
      return this.$ajax.get("file/imgToken").then(function(resp) {
        _this.uploadToken = resp.data.data;
      });
    },
    getToken() {
      return {
        token: this.uploadToken,
        key: "bxt/" + new Date().getTime()
      };
    },
    handleTableChange(pagination, filters, sorter) {
      this.getDate(pagination.current);
    },
    getDate(page) {
      let _this = this;
      this.$ajax.get(`product?page=${page}&size=7`).then(function(resp) {
        _this.dataSource = resp.data.data;
        _this.pagination.total = resp.data.total;
        _this.pagination.current = page;
      });
    },
    showDrawer(id) {
      let _this = this;
      this.$ajax.get("product/" + id + "?detail").then(function(resp) {
        _this.formD.resetFields();
        _this.imageUrl = "";

        if (resp.data.data.typeId) {
          _this.formD.setFieldsValue({
            type: resp.data.data.typeId
          });
        }

        _this.formD.setFieldsValue({
          name: resp.data.data.name,
          content: resp.data.data.content,
          img: resp.data.data.img,
          majorProduct: resp.data.data.majorProduct,
          modelNumber: resp.data.data.modelNumber,
        });
        _this.imageUrl = resp.data.data.img;

        _this.drawerVisible = true;
        _this.updateId = id;
      });
    },
    closeDrawer() {
      this.drawerVisible = false;
    },
    saveDrawer() {
      let _this = this;

      this.$ajax.put("product/" + this.updateId, this.formD.getFieldsValue()).then(function(resp) {
        _this.getDate(_this.pagination.current);
        _this.drawerVisible = false;
      });
    },
    showModal() {
      this.modalVisible = true;
    },
    closeModal() {
      this.modalVisible = false;
    },
    saveModal() {
      let _this = this;
      this.$ajax
        .post("product", this.formCreate.getFieldsValue())
        .then(function(resp) {
          _this.getDate(_this.pagination.current);
          _this.modalVisible = false;
          _this.formCreate.resetFields();
        });
    }
  }
};
</script>

<style>
</style>

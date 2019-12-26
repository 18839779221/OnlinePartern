<template>
  <el-dialog title="登陆" :visible.sync="dialogVisible" :before-close="login" class="d-login">
    <el-form :model="user">
      <el-form-item label="用户名" :label-width="userLabelWidth">
        <el-input v-model="user.name" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="密码" :label-width="userLabelWidth">
        <el-input v-model="user.password" autocomplete="off"></el-input>
      </el-form-item>
    </el-form>
    <el-link class="l-toreg" type="primary" @click="toRegister">还没有账号? 点击注册</el-link>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
    </div>
  </el-dialog>
</template>

<script>
import http from "../http.js";

export default {
  name: "loginDialog",
  data() {
    return {
      dialogVisible: false,
      userLabelWidth: 100,
      user: {
        name: "abc",
        password: "password"
      },
      validImgUrl: ""
    };
  },
  methods: {
    login() {
      http
        .fetchPost("/user/login", {})
        .then(data => {
          console.log(data);
        })
        .catch(err => console.log(err));
    },
    toRegister() {
      this.$router.push("/register");
    },
    getValidCode() {
      var _this = this;
      http
        .fetchGet("/tool/getValidCode")
        .then(res => {
          return (
            "data:image/png;base64," +
            btoa(
              new Uint8Array(res.data).reduce(
                (data, byte) => data + String.fromCharCode(byte),
                ""
              )
            )
          );
        })
        .then(data => {
          _this.validImgUrl = data; //图片地址 <img src='data' />
        });
    }
  }
};
</script>

<style>
.l-toreg {
  margin-top: 10px;
}
</style>

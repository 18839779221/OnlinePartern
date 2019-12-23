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
        return{
            dialogVisible: false,
            userLabelWidth: 100,
            user: {
              name: "abc",
              password: "password",
            }
        }
    },
    methods: {
      login(){
        params = 
        http
        .fetchPost("/user/login",params)
        .then(data => {
          console.log(data);
        })
        .catch(err => console.log(err));
      },
    }
}
</script>

<style>

</style>

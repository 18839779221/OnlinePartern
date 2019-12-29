<template>
  <el-card class="e-main">
    <div class="d-login">
      <el-form class="e-form" :model="user" ref="user" :rules="rules">
        <p>
          <strong>登陆</strong>
        </p>
        <el-divider></el-divider>
        <el-form-item label="用户名 : " :label-width="userLabelWidth" prop="phone">
          <el-input v-model="user.phone"></el-input>
        </el-form-item>
        <el-form-item label="密码 : " :label-width="userLabelWidth" prop="password">
          <el-input v-model="user.password" show-password></el-input>
        </el-form-item>
        <el-link class="l-toreg" type="primary" @click="toRegister">还没有账号? 点击注册</el-link>
        <el-form-item class="dialog-footer">
          <el-button type="primary" @click="login">确 定</el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-card>
</template>

<script>
import http from "../http.js";
import validate from "@/utils/customerValidate";

export default {
  name: "login",
  data() {
    return {
      userLabelWidth: "100px",
      user: {
        phone: "",
        password: ""
      },
      rules: {
        phone: [
          { required: true, message: "请输入正确的手机号", trigger: "blur" },
          { validator: validate.isMobile, trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { validator: validate.isPasswd, trigger: "blur" }
        ]
      },
      validImgUrl: ""
    };
  },
  methods: {
    login() {
      http
        .fetchPost("/user/login", {
          phone: this.user.phone,
          password: this.encode(this.user.password)
        })
        .then(data => {
          console.log(data);
          this.parseData(data['data'])

        })
        .catch(err => console.log(err));
    },
    toRegister() {
      this.$router.push("/register");
    },
    parseData(data) {
      if (data["header"]["code"] == 203) {
        localStorage.setItem("user", JSON.stringify(data["body"]["data"]));
        console.log(localStorage.getItem("user"))
      } else {
        this.$message({
          type: "error",
          message: data["header"]["code"] + " : " + data["header"]["msg"]
        });
      }
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
    },
    encode(str) {
      return this.$md5(str);
    }
  }
};
</script>

<style>
.e-main {
  width: 400px;
  height: 350px;
  text-align: center;
  position: absolute;
  left: 50%;
  top: 50%;
  margin-left: -200px;
  margin-top: -150px;
}
.d-login {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.e-form {
  padding-left: 20px;
  align-self: flex-start;
}
.l-toreg {
  margin-top: 0;
}
.dialog-footer {
  margin-top: 20px;
}
</style>

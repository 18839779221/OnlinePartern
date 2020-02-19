<template>
  <div class="main">
    <el-card class="box-card" shadow="always">
      <div class="d-header" slot="header">
        <span>
          <font size="6">
            <strong>我的资料</strong>
          </font>
        </span>
      </div>
      <div class="d-content">
        <div class="d-con-top">
          <div>
            <el-avatar :size="80">{{user.nick}}</el-avatar>
          </div>
          <el-divider direction="vertical"></el-divider>
          <div class="d-basic-info">
            <p>
              昵称:
              <span>
                <strong>{{ user.nick }}</strong>
              </span>
            </p>
            <p>关注: {{user.count_concern}} &nbsp;&nbsp; 粉丝: {{user.count_fans}}</p>
            <div>
              <el-divider></el-divider>
              <p>电话:&nbsp;{{user.phone}}</p>
              <p>性别:&nbsp;{{parseSex(user.sex)}}</p>
              <p>年龄:&nbsp;{{user.age}}</p>
              <p>职业:&nbsp;{{user.prof}}</p>
              <p>收入:&nbsp;{{parseIncome(user.income)}}</p>
              <p>婚姻状况:&nbsp;{{parseMarrage(user.marrage)}}</p>
              <p>个人简介:&nbsp;{{user.note}}</p>
              <p></p>
              <p></p>
              <p></p>
              <!-- <el-button @click="getUserPhone()">测试</el-button> -->
            </div>
          </div>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import http from "../http.js";
import parseUser  from "@/utils/parseUser.js"

export default {
  name: "myinfo",
  data() {
    return {
      user: {
        nick: "",
        count_concern: "",
        count_fans: "",
        phone: "",
        sex: "",
        age: "",
        prof: "",
        income: "",
        note: "",
        marrage:"",
      }
    };
  },
  methods: {
    parseSex(){
      return parseUser.parseSex(this.user.sex);
    },
    parseIncome(){
      return parseUser.parseIncome(this.user.income);
    },
    parseMarrage(){
      return parseUser.parseMarrage(this.user.marrage);
    },
    getData() {
      http
        .fetchPost("/user/getUserById", { phone: this.getUserPhone() })
        .then(data => {
          this.parseData(data['data']);
        })
        .catch(err => console.log(err));
    },
    getUserPhone() {
      return localStorage.getItem("phone");
    },
    parseData(data) {
      console.log(data);
      if (data['header']['code'] == 101) {
        this.user = data['body']['data'];
      } else {
        this.$message({
          type: "error",
          message: data.header.code +" : "+ data.header.msg,
        });
      }
    }
  },
  mounted() {
    // 调用请求数据的方法
    this.getData();
  }
};
</script>

<style>
.main {
  margin-bottom: 30px;
}
.box-card{
  width: 100%;
  height: 100%;
}
.d-header {
  text-align: left;
  padding-left: 20px;
}
.d-content {
  text-align: left;
  padding-left: 40px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.d-con-top {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}
.d-basic-info {
  margin-left: 50px;
}
</style>

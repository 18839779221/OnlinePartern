<template>
  <div id="topbar">
    <!-- 首部菜单栏 -->
    <div class="d-menu">
      <el-menu
        :default-active="activeIndex"
        class="t-el-menu"
        mode="horizontal"
        @select="handleSelect"
        :route="true"
      >
        <el-menu-item index="/main">
          <!-- logo -->
          <img src="@/assets/logo.png" style="width:60px;height:100%;" />
        </el-menu-item>
        <el-menu-item index="/" @click="getUsers">首页</el-menu-item>
        <el-menu-item index="/my">我的</el-menu-item>
        <el-menu-item index="/userMain">搜索</el-menu-item>
        <el-menu-item index="/blinddate">相亲</el-menu-item>
      </el-menu>
    </div>

    <div class="d-search">
      <el-input
        placeholder="搜索好友"
        prefix-icon="el-icon-search"
        v-model="searchText"
        select-when-unmatched="true"
        @keyup.enter.native="search"
      ></el-input>
    </div>
    <!-- 登陆注册栏 -->
    <div class="d-lorr">
      <el-menu class="t-el-menu" mode="horizontal" @select="mySelect">
        <el-submenu index="0" v-if="user_nick!=null&&user_nick!=''" class="emi-user-img">
          <template slot="title">
            <el-badge is-dot class="item">
              <el-avatar :size="50">{{user_nick}}</el-avatar>
            </el-badge>
          </template>
          <el-menu-item index="/myPage">我的主页</el-menu-item>
          <el-menu-item index="/showLike">点赞通知</el-menu-item>
          <el-menu-item index="/logout">注销登陆</el-menu-item>
        </el-submenu>
        <el-menu-item index="1" @click="login()" v-else>登陆</el-menu-item>
        <el-menu-item index="2" @click="toRegister()">注册</el-menu-item>
      </el-menu>
    </div>
  </div>
</template>

<script>
import http from "../http.js";

export default {
  name: "top_bar",
  data() {
    return {
      activeIndex: "/",
      searchText: "",
      user_nick: ""
    };
  },
  methods: {
    getUsers() {
      http
        .fetchPost("/user/getUsers")
        .then(data => {
          console.log(data);
        })
        .catch(err => console.log(err));
    },
    handleSelect(index) {
      this.activeIndex = index;
      //当前地址栏url更改
      this.$router.push(index);
    },
    login() {
      this.$router.push("/login");
    },
    toRegister() {
      this.$router.push("/register");
    },
    //注销登陆
    logout(){
      localStorage.setItem("user",null);
      this.$router.go(0)
    },
    search() {
      console.log(this.searchText);
    },
    //我的信息下拉栏选择
    mySelect(index){
      switch(index){
        case "/myPage":
          break;
        case "/showLike":
          break;
        case "/logout":
          this.logout();
          break;
      }
    },
    init() {
      var user = JSON.parse(localStorage.getItem("user"));
      this.user_nick = user["nick"];
      console.log("nick=" + this.user_nick);
    }
  },
  mounted() {
    this.init();
  }
};
</script>

<style>
#topbar {
  display: flex;
  height: 60px;
  flex-direction: row;
  align-items: flex-end;
  justify-content: space-around;
  padding-left: 5%;
  padding-right: 5%;
}
.d-menu {
  order: 1;
  flex-grow: 6;
}
.d-search {
  order: 2;
  flex-grow: 3;
  margin-bottom: 10px;
}
.d-lorr {
  order: 3;
  flex-grow: 2;
}
.emi-user-img {
  margin: 5px;
}
</style>

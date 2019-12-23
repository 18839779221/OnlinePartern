<template>
  <div id="topbar">
    <!-- 首部菜单栏 -->
    <div id="d-menu">
      <el-menu
        :default-active="activeIndex"
        class="t-el-menu"
        mode="horizontal"
        @select="handleSelect"
      >
        <el-menu-item index="1" @click="getUsers">首页</el-menu-item>
        <el-menu-item index="2">我的</el-menu-item>
        <el-menu-item index="3">搜索</el-menu-item>
        <el-menu-item index="4">相亲</el-menu-item>
      </el-menu>
      <span>dsads</span>
    </div>

    <!-- 登陆注册栏 -->
    <div id="d-lorr">
      <el-menu class="t-el-menu" mode="horizontal">
        <el-menu-item index="1">登陆</el-menu-item>
        <el-menu-item index="2">注册</el-menu-item>
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
      activeIndex: "1"
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
    handleSelect() {}
  }
};
</script>

<style>
#topbar {
  margin-top: 0;
  padding: 0;
}
.d-menu {
  float: left;
  margin-right: 20%;
  margin-left: 10%;
}
.d-lorr {
  float: right;
}
.t-el-menu {
  background-color: "#545c64";
}
</style>

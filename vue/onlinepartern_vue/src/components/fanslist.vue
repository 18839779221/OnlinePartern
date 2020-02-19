<template>
  <div class="main">
    <el-card class="d-menu">
      <el-menu
        :default-active="activeIndex"
        class="t-el-menu"
        mode="vertical"
        background-color="transparent"
      >
        <el-menu-item
          class="d-user-list"
          v-for="(user,index) in userlist"
          :key="index"
          :index="index+''"
        >
          <div class="d-head-img">
            <el-avatar :size="50">{{user.nick==""?user.phone:user.nick}}</el-avatar>
          </div>
          <div class="d-nick">
            <p style="margin:0;">
              <strong>
                <font color="black">{{user.nick==""?user.phone:user.nick}}</font>
              </strong>
            </p>
          </div>
          <div class="d-state">
            <el-button type="danger" class="e-button-concern" @click="toChat(user)">私信</el-button>
            <el-button type="danger" class="e-button-concern">{{concernState(user.state)}}</el-button>
          </div>
        </el-menu-item>
      </el-menu>
    </el-card>
  </div>
</template>

<script>
import http from "../http.js";

export default {
  name: "fansList",
  data() {
    return {
      activeIndex: "0",
      userlist: [
        {
          phone: "18888888888",
          nick: "西瓜",
          state: 3
        },
        {
          phone: "18888888888",
          nick: "冬瓜",
          state: 0
        }
      ]
    };
  },
  methods: {
    concernState(state) {
      switch (state) {
        case 0:
          return "关注";
        case 1:
          return "关注";
        case 2:
          return "相互关注";
        case 3:
          return "已相互关注";
      }
    },
    toChat(user) {
      this.$emit("toChat",user)
    },
    
  }
};
</script>

<style>
.d-menu {
  padding: 0px;
  width: 100%;
  height: 100%;
}
.d-user-list {
  width: 100%;
  padding: 0px;
  display: flex;
  flex-direction: row;
  align-items: flex-end;
  justify-content: space-around;
}
.d-head-img {
  order: 1;
  flex-grow: 2;
}
.d-nick {
  order: 2;
  flex-grow: 10;
  text-align: start;
  margin-top: 0px;
}
.d-state {
  order: 3;
  flex-grow: 1;
  text-align: start;
  margin-top: 0px;
}
.e-button-concern {
  width: 110px;
}
</style>
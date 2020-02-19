<template>
  <div class="main">
    <div class="d-menu">
      <el-menu
        :default-active="activeIndex"
        class="t-el-menu"
        mode="vertical"
        @select="changeFriend"
        background-color="transparent"
      >
        <el-menu-item class="d-user-list" v-for="(user,index) in user_list" :key="index" :index="index+''">
          <div class="d-head-img">
            <el-avatar :size="50">{{user.nick}}</el-avatar>
          </div>
          <div class="d-nick">
            <p style="margin:0;">
              <strong><font color="black">{{user.nick}}</font></strong>
            </p>
          </div>
          <div class="d-time">
            <p style="margin:0;" color="black"><font color="black" size="1">{{user.lastChatTime}}</font></p>
          </div>
        </el-menu-item>
      </el-menu>
    </div>

  </div>
</template>

<script>
export default {
  name: "userList",
  data() {
    return {
      activeIndex: '0',
      user_list: [],
    };
  },
  methods: {
    changeFriend(index){
      if(this.activeIndex==index){return ;}
      this.activeIndex = index;
      this.$emit("updateMsgBox",this.user_list[index],index);
    },
  }
};
</script>

<style>

.d-menu{
  padding: 0px;
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
  flex-basis: 0%;
}
.d-nick {
  order: 2;
  flex-grow: 6;
  flex-basis: 0%;
  text-align: start;
  margin-left: 10px; 
  margin-top: 0px;
}
.d-time {
  order: 3;
  flex-grow: 4;
  flex-basis: 0%;
  overflow: hidden;
  text-align: start;
  margin-top: 0px;
  margin-right: 10px;
}
</style>
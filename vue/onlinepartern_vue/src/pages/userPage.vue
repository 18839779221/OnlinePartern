<template>
  <div id="main">
    <div id="user-body">
      <div class="left-navigate">
        <el-tabs style="height: 200px;" type="card" v-model="tabIndex">
          <el-tab-pane label="个人资料" name="myinfo">
            <myinfo />
          </el-tab-pane>
          <el-tab-pane label="我关注的人" name="myconcern">
            <fansList ref="concernRef" @toChat="toChat" />
          </el-tab-pane>
          <el-tab-pane label="我的粉丝" name="myfans">
            <fansList ref="fansRef" @toChat="toChat" />
          </el-tab-pane>
          <el-tab-pane label="私信" name="privatechat">
            <privateChat ref="chatRef"/>
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
  </div>
</template>

<script>
import myinfo from "@/components/myinfo";
import privateChat from "@/components/privatechat";
import fansList from "@/components/fanslist";
import http from "../http.js";

export default {
  name: "userPage",
  components: { myinfo, privateChat, fansList },
  data() {
    return {
      phone: "",
      tabIndex: "myinfo",
    };
  },
  methods: {
    getData() {
      this.getConcernAndFansList();
    },
    getConcernAndFansList() {
      http
        .fetchPost("/user/getFansAndConcernListById", { phone: this.phone })
        .then(data => {
          console.log(data);
          this.parseData(data.data);
        })
        .catch(err => console.log(err));
    },
    parseData(data) {
      if (data.header.code == 101) {
        var userList = data.body.data;
        this.$refs.fansRef.userlist = userList.filter(
          user => user.state == 2 || user.state == 3
        );
        this.$refs.concernRef.userlist = userList.filter(
          user => user.state == 1 || user.state == 3
        );
      } else {
        this.$message({
          type: "error",
          message: data.header.code + " : " + data.header.msg
        });
      }
    },
    getPhone() {
      return JSON.parse(localStorage.getItem("user")).phone;
    },
    toChat(user) {
      this.getChatMsg(user.phone);
    },
    getChatMsg(phone) {
      http
        .fetchPost("/user/getChatMsg", { id1: this.phone, id2: phone })
        .then(data => {
          console.log(data);
          this.parsePrivateMsg(data.data);
        })
        .catch(err => console.log(err));
    },
    parsePrivateMsg(data) {
      if (data.header.code == 101) {
        this.$refs.chatRef.updateUserList(data.body.data);
        this.tabIndex = "privatechat";
      } else {
        this.$message({
          type: "error",
          message: data.header.code + " : " + data.header.msg
        });
      }
    }
  },
  mounted() {
    this.phone = this.getPhone();
    this.getData();
  }
};
</script>

<style>
#user-body {
  margin-top: 50px;
  margin-left: 100px;
  margin-right: 100px;
  height: 100%;
}
</style>
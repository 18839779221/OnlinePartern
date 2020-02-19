<template>
  <el-card class="e-main" >
    <div class="main" v-if="user_list.length>0">
      <div class="left">
        <div class="d-left-title">
          <p>
            <font size="4">
              <strong>私人聊天</strong>
            </font>
          </p>
        </div>
        <div class="d-userlist">
          <div class="d-menu">
            <el-menu
              :default-active="activeIndex+''"
              class="t-el-menu"
              mode="vertical"
              @select="changeFriend"
              background-color="transparent"
            >
              <el-menu-item
                class="d-user-list"
                v-for="(user,index) in user_list"
                :key="index"
                :index="index+''"
              >
                <div class="d-head-img">
                  <el-avatar :size="50">{{user.nick}}</el-avatar>
                </div>
                <div class="d-nick">
                  <p style="margin:0;">
                    <strong>
                      <font color="black">{{user.nick}}</font>
                    </strong>
                  </p>
                </div>
                <div class="d-time">
                  <p style="margin:0;" color="black">
                    <font color="black" size="1">{{user.lastChatTime}}</font>
                  </p>
                </div>
              </el-menu-item>
            </el-menu>
          </div>
          <!-- <userList ref="userListRef" @updateMsgBox="updateMsgBox" v-if="user_list.length>0"/> -->
        </div>
      </div>
      <div class="right">
        <div class="d-right-title">
          <p>
            <font size="4">
              <strong>{{current_partern}}</strong>
            </font>
          </p>
        </div>
        <div class="d-msg-show">
          <div v-for="(item,index) in user_list[activeIndex].msg" :key="index" class="d-msg-box">
            <div v-if="item.type==1" class="msg-box-left">
              <p>
                <!-- <strong>{{item.nick}}</strong> -->
                {{item.time}}
              </p>
              <p>
                <font size="3">{{item.msg}}</font>
              </p>
            </div>
            <div v-else class="msg-box-right">
              <p>
                <!-- <strong>{{item.nick}}</strong> -->
                {{item.time}}
              </p>
              <p>
                <font size="3">{{item.msg}}</font>
              </p>
            </div>
          </div>
        </div>
        <div class="d-input-msg">
          <el-input
            class="e-input"
            v-model="input_msg"
            placeholder="说说你的心里话"
            @keyup.enter.native="sendMsg()"
          ></el-input>
          <el-button type="primary" :disabled="!canSendMsg" @click="sendMsg()">发送</el-button>
        </div>
      </div>
    </div>
  </el-card>
</template>

<script>
import userList from "@/components/userlist";

export default {
  name: "privateChat",
  components: { userList },
  data() {
    return {
      input_msg: "",
      current_partern: "",
      user_nick: "",
      canSendMsg: true,
      ws: null,
      activeIndex: -1,
      user_list: []
      // user_list: [{
      //   phone: "",
      //   nick: "",
      //   lastChatTime: "",
      //   msg: [{
      //     type: 1,
      //     time: "",
      //     msg: ""
      //   }]
      // }],
      //
    };
  },
  methods: {
    sendMsg() {
      if (this.input_msg.trim() == "") return;
      var current_msg = {
        type: "privatemsg",
        from: this.getPhone(),
        to: this.user_list[this.activeIndex].phone,
        time: new Date().Format("yyyy-MM-dd HH:mm:ss"),
        payload: {
          nick: this.user_nick,
          msg: this.input_msg
        }
      };
      this.showLocalMsg(current_msg);
      //this.msg_list.push(current_msg);
      this.sendToServer(JSON.stringify(current_msg));
      this.input_msg = "";
    },
    showLocalMsg(msg) {
      var current_user = this.user_list[this.activeIndex];
      current_user.lastChatTime = msg.time;
      current_user.msg.push({
        type: 2,
        time: msg.time,
        msg: msg.payload.msg
      });
    },
    showRemoteMsg(msg) {
      if (msg.type != "privatemsg") return;
      var type = 0;
      var target = null;
      if (msg.from == this.getPhone()) {
        target = msg.to;
        type = 2;
      } else if (msg.to == this.getPhone()) {
        target = msg.from;
        type = 1;
      } else {
        return;
      }
      var current_user = this.user_list.find(user => user.phone == target);
      current_user.lastChatTime = msg.time;
      current_user.msg.push({
        type: type,
        time: msg.time,
        msg: msg.payload.msg
      });
    },
    //消息发送到服务器
    sendToServer(current_msg) {
      this.ws.send(current_msg);
    },
    //更新右边消息框
    updateMsgBox(user, index) {
      this.current_partern = user.nick;
      this.activeIndex = index;
    },
    //更新左边用户列表
    updateUserList(user) {
      //判断当前用户是否已在用户列表中
      var exist = false;
      this.user_list.forEach(u => {
        if (u.phone == user.phone) exist = true;
      });
      if (!exist) {
        this.user_list.unshift(user);
        this.current_partern = user.nick == "" ? user.phone : user.nick;
        this.activeIndex = 0;
        this.input_msg = "";
      }
      // this.$refs.userListRef.user_list = this.user_list;
      // this.$refs.userListRef.activeIndex = this.activeIndex + "";
    },
    initChatRoom() {
      var user = JSON.parse(localStorage.getItem("user"));
      this.user_phone = user["phone"];
      if (user != null) {
        this.canSendMsg = true;
        this.chat_title = "私信";
        if (this.$websocket == null) {
          this.$websocket = new WebSocket(
            this.$websocketPath + "?" + user.phone
          );
        }
        this.ws = this.$websocket;
      }
      if (user.nick == "") {
        this.user_nick = user["phone"];
      }
      this.user_nick = user["nick"];
    },
    receiveMessage(event) {
      console.log(" Receive Message Is :" + event.data);
      var msg = JSON.parse(event.data);
      this.showRemoteMsg(msg);
    },
    receiveServiceMsg() {
      this.ws.onmessage = this.receiveMessage;
      this.ws.onopen = function(event) {
        console.log("Connection create!");
      };
      this.ws.onclose = function(event) {
        console.log("Connection close!");
      };
    },
    getPhone() {
      return JSON.parse(localStorage.getItem("user")).phone;
    },
    changeFriend(index) {
      if (this.activeIndex == index) {
        return;
      }
      this.activeIndex = index;
      this.updateMsgBox(this.user_list[index], index);
    },
    scrollToBottom() {
      console.log("0---");
      this.$nextTick(() => {
        var container = this.$el.querySelector(".d-msg-show");
        container.scrollTop = container.scrollHeight;
      });
    }
  },
  mounted() {
    this.initChatRoom();
    this.receiveServiceMsg();
  },
  updated() {
    this.scrollToBottom();
  }
};
</script>

<style>
.e-main {
  height: 550px;
  margin-left: 100px;
  margin-right: 100px;
  background-color: antiquewhite;
  margin-bottom: 50px;
}
.main {
  display: flex;
  flex-direction: row;
  align-items: stretch;
  justify-content: space-around;
  widows: 100%;
  height: 100%;
}
.left {
  order: 1;
  flex-grow: 1;
  flex-basis: 0%;
  box-shadow: 0 0 1px 1px #ccc;
  padding-top: 0px;
}
.right {
  order: 2;
  flex-grow: 3;
  flex-basis: 0%;
  box-shadow: 0 0 1px 1px #ccc;
}
.d-left-title {
  box-shadow: 0 0 0px 0px #ccc;
}
.d-msg-show {
  height: 400px;
  flex-direction: column;
  align-items: flex-start;
  box-shadow: inset 0 0 2px 2px #ccc;
  overflow: auto;
}
.d-msg-box {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.d-input-msg {
  display: flex;
  flex-direction: row;
  align-items: stretch;
  justify-content: space-around;
  padding: 2px;
}
.e-input {
  margin-right: 8px;
}
.msg-box-left {
  text-align: left;
  align-self: flex-start;
  padding-left: 20px;
}
.msg-box-right {
  text-align: right;
  align-self: flex-end;
  padding-right: 20px;
}
.d-userlist {
  text-align: start;
}
.d-menu {
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
<template>
  <div id="main">
    <div id="user-body">
      <div class="left-navigate">
        <el-tabs style="height: 200px;" type="card">
          <el-tab-pane label="个人资料"><myinfo/></el-tab-pane>
          <el-tab-pane label="我关注的人">我关注的</el-tab-pane>
          <el-tab-pane label="我的粉丝">我的粉</el-tab-pane>
        </el-tabs>
      </div>
    </div>
  </div>
</template>

<script>
import topbar from "@/components/topbar";
import myinfo from "@/components/myinfo";

export default {
  name: "userPage",
  components: { topbar,myinfo }
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
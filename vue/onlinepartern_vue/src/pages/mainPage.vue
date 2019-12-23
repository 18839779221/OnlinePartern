<template>
  <div id="main_page">
    <el-container>
      <el-header>
        <topbar />
      </el-header>
      <el-main>Main</el-main>
      <el-footer>Footer</el-footer>
    </el-container>
  </div>
</template>

<script>
import topbar from '@/components/topbar'

export default {
  name: 'mainPage',
  components: { topbar }
}
</script>

<style>
#main_page {
  margin-top: 0;
  padding: 0;
}
.el-header,
.el-footer {
  background-color: #b3c0d1;
  color: #333;
  text-align: center;
}
.el-main {
  background-color: #e9eef3;
  color: #333;
  text-align: center;
  line-height: 160px;
}
</style>

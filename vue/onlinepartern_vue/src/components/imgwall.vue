<template>
  <div>
    <el-row v-for="(imgUrls,index) in imgUrlss" :key="index">
      <el-col :span="24/wallWSize" v-for="(imgUrl,index) in imgUrls" :key="index">
        <div class="img-col">
          <img :src="imgUrl" style="width:100px;height:100%;"/>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "imgWall",
  data() {
    return {
      wallWSize: 6,
      imgUrlss: [["https://img0.sc115.com/uploads3/sc/jpgs/1908/bpic12885_sc115.com.jpg", "@/assets/logo.png", "@/assets/logo.png","@/assets/logo.png","@/assets/logo.png","@/assets/logo.png"],]
    };
  }
};
</script>
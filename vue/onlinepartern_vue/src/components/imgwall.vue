<template>
  <div>
    <el-row v-for="(imgs,index) in imgss" :key="index">
      <el-col :span="24/wallWSize" v-for="(img,index) in imgs" :key="index">
        <div class="img-col">
          <!-- <img :src="img" style="width:100px;height:100%;"/> -->
          <el-card :body-style="{ padding: '0px' }" style="height:300px;" @click="toUserMain(img)">
            <el-image :src="img.img" fit="fill" style="width:100%;height:180px;"/>
            <div style="padding: 14px;">
              <!-- <span>好吃的汉堡</span> -->
              <div class="bottom clearfix">
                <p class="font-desc">{{img.desc}}</p>
              </div>
            </div>
          </el-card>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import http from "../http.js";

export default {
  name: "imgWall",
  data() {
    return {
      wallWSize: 6,
      imgss: [
        [
          // {
          //   img:"",
          //   desc:"",
          // },
        ],
        [],[],[]
      ]
    };
  },
  methods: {
    getData() {
      http
        .fetchPost("/user/getRecommendUser")
        .then(data => {
          console.log(data);
          this.parseData(data.data);
        })
        .catch(err => console.log(err));
    },
    parseData(data) {
      if (data.header.code == 101) {
        var validData = data.body.data;
        var ri = 0;
        var index = 0;
        while (ri * this.wallWSize < validData.length) {
          for (var i = 0; i < this.wallWSize; i++) {
            this.imgss[ri].push({
              img: validData[index]["img"],
              desc: validData[index++]["note"]
            });
          }
          ri++;
        }
      } else {
        this.$message({
          type: "error",
          message: data.header.code + " : " + data.header.msg
        });
      }
    },
    toUserMain(user){
      
    }
  },
  mounted() {
    this.getData();
  }
};
</script>

<style>
.img-col {
  margin: 10px;
}
.font-desc {
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  overflow: hidden;
}
</style>
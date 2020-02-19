<template>
  <div class="main">
    <div class="body">
      <!-- <div class="big-img">
        <el-image src="http://www.obzhi.com/wp-content/uploads/2020/01/WechatIMG170.jpeg" fit="cover" style="width:100%;height:100%"/>
      </div>
      <div class="smail-img-list">
        <div class="smail-img">
          <el-image src="http://www.obzhi.com/wp-content/uploads/2020/01/WechatIMG170.jpeg" fit="cover" style="width:100%;height:100%"/>
        </div>
      </div>-->
      <v-gallery :images="list"></v-gallery>
    </div>
    <div></div>
  </div>
</template>

<script>

export default {
  name: "photoAlbum",
  data() {
    return {
      list: [
        {title:'Image1',url:'http://www.obzhi.com/wp-content/uploads/2020/01/rock.jpg'},
        {title:'Image2',url:'http://www.obzhi.com/wp-content/uploads/2020/01/xiangyun.png'},
        {title:'Image3',url:'http://www.obzhi.com/wp-content/uploads/2020/01/xueguolieche2.jpg'},
        {title:'Image4',url:'http://www.obzhi.com/wp-content/uploads/2020/01/WechatIMG170.jpeg'},
      ],
      // images: [
      //   "http://www.obzhi.com/wp-content/uploads/2020/01/rock.jpg",
      //   "http://www.obzhi.com/wp-content/uploads/2020/01/xiangyun.png",
      //   "http://www.obzhi.com/wp-content/uploads/2020/01/xueguolieche2.jpg",
      //   "http://www.obzhi.com/wp-content/uploads/2020/01/WechatIMG170.jpeg"
      // ],
      index: null
    };
  }
};
</script>

<style scoped>
.main {
  text-align: center;

  padding: 0;
  margin: 0;
}
.body {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-around;
  padding-top: 50px;
  margin-left: 100px;
  margin-right: 100px;
}
.big-img {
  height: 600px;
  border: 10px outset white;
  border-radius: 1em;
}
.smail-img-list {
}
.image {
  float: left;
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
  border: 1px solid #ebebeb;
  margin: 5px;
}
</style>
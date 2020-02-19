<template>
  <div>
    <div class="v-first">
      <div class="left-imagewall">
        <photoAlbum/>
      </div>
      <div class="right-info">
        <p><font size="6"><strong>Hello</strong></font></p>
        <p>交友宣言:~~~~~~</p>
        <label>喜欢</label>
      </div>
    </div>
    <div class="v-second">

    </div>
  </div>
</template>

<script>
import photoAlbum from "@/components/photoalbum"

export default {
  name: "userMain",
  data() {

  },
  method:{

  },
  mounted(){

  }
}
</script>

<style scoped>
.v-first{
  display: flex;
  flex-direction: row;
  align-items: stretch;
  justify-content: space-around;
}
</style>
<template>
  <div id="body">
    <viewPager class="view-pager" />
    <imgWall class="img-wall" />
    <chatRoom class="chat-room" />
  </div>
</template>

<script>
import viewPager from "@/components/viewPager";
import imgWall from "@/components/imgwall";
import chatRoom from "@/components/chatroom";

export default {
  name: "mainBody",
  components: { imgWall, viewPager, chatRoom }
};
</script>

<style>
#main {
  display: flex;
  flex-direction: column;
  align-items: stretch;
  justify-content: space-between;
}
.view-pager {
  order: 1;
  margin-bottom: 20px;
}
.img-wall {
  order: 2;
  margin-bottom: 20px;
}
.chat-room {
  order: 3;
}
</style>

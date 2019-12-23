<template>
  <div id="body">
    <viewPager class="view-pager"/>
    <imgWall class="img-wall"/>
  </div>
</template>

<script>
import viewPager from "@/components/viewPager";
import imgWall from "@/components/imgwall";

export default {
  name: "mainBody",
  components: { imgWall, viewPager }
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
  margin-bottom:20px; 
}
.img-wall {
  order: 2;
}
</style>

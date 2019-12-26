<template>
  <div id="app">
    <mainPage />
  </div>
</template>

<script>
import mainPage from "@/pages/mainPage";
export default {
  name: "App",
  components: { mainPage }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>

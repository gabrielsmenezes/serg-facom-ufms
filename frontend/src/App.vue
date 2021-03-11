<template>
  <div id="app">
    <nav-bar class="mb-5"/>
    <b-container class="mb-5" fluid>
      <router-view/>
    </b-container>
    <footer-customized/>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar"
import FooterCustomized from "@/components/Footer";

export default {
  components: {
    NavBar,
    FooterCustomized
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
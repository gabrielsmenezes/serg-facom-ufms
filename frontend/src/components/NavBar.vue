<template>
  <div id="nav-bar">

    <!--    <b-navbar sticky fixed="top" v-if="isMediumOrBigger">-->
    <!--      <b-navbar-brand to="/" class="mr-auto">{{brandTitle}}</b-navbar-brand>-->
    <!--      <b-navbar-nav>-->
    <!--        <b-nav-item v-bind:to="route.path" v-for="route in routes">{{ route.name }}</b-nav-item>-->
    <!--      </b-navbar-nav>-->
    <!--    </b-navbar>-->

    <b-navbar toggleable variant="secondary" class="text-white">
      <b-navbar-brand to="/" class="mr-auto text-white">{{ brandTitle }}</b-navbar-brand>

      <b-navbar-toggle target="navbar-toggle-collapse">
        <template #default="{ expanded }">
          <b-icon v-if="expanded" icon="chevron-compact-up" style="color: white !important"></b-icon>
          <b-icon v-else icon="chevron-compact-down" style="color: white !important"></b-icon>
        </template>
      </b-navbar-toggle>

      <b-collapse id="navbar-toggle-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item v-bind:to="route.path" v-for="route in routes">
            <span style="color: white">
            {{route.name}}
            </span>
          </b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>

  </div>
</template>

<script>
export default {
  name: "NavBar",
  computed: {
    screenSize() {
      return window.innerWidth
    },
    isMediumOrBigger() {
      return this.screenSize >= 768
    }
  },
  data() {
    return {
      routes: [
        {
          name: "Home",
          path: "/"
        },
        {
          name: "News",
          path: "/news"
        },
        {
          name: "Professors",
          path: "/professors"
        },
        {
          name: "Students",
          path: "/students"
        },
        {
          name: "Publications",
          path: "/publications"
        },
        {
          name: "Vacancies",
          path: "/vacancies"
        },
        {
          name: "Research Lines",
          path: "/research-lines"
        },
        {
          name: "Softwares and Databases",
          path: "/softwares-and-databases"
        },
        {
          name: "Classes",
          path: "/classes"
        },
        {
          name: "Projects",
          path: "/projects"
        },
      ],
      brandTitle: "Software Engineering Group"
    }
  }
}
</script>

<style scoped>

</style>
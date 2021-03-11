<template>
<div id="projects">
  <b-container>
    <h1>Projects</h1>
    <projects-group v-bind:projects="projects"></projects-group>
  </b-container>
</div>
</template>

<script>
import database from "@/database"
import ProjectsGroup from "@/views/Projects/ProjectsGroup";
export default {
  name: "Projetcs",
  components: {
      ProjectsGroup
  },
  computed: {
    projects() {
      return database.getProjects()
    }
  }
}
</script>

<style scoped>

</style>
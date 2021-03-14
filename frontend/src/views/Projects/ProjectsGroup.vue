<template>
  <div id="projects-group">
    <b-card v-for="project in projects" v-bind:title="project.name"
            v-bind:sub-title="`Powered by: ${project.fundingOrganization} | Coordinator: Bruno Cafeo`">
      {{ `${project.description ? project.description : ""}` }}
    </b-card>
  </div>
</template>

<script>
export default {
  name: "ProjectsGroup",
  props: {
    projects: Array
  }
}
</script>

<style scoped>

</style>
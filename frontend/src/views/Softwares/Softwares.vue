<template>
  <div id="softwares">
    <b-container>
      <h1>Softwares and Databases</h1>
      <h2 v-if="softwares.length">Softwares</h2>
      <b-list-group v-for="software in softwares">
        <b-list-group-item>
          <a v-bind:href="software.link" target="_blank">{{software.name}}</a>: {{software.description}}
        </b-list-group-item>
      </b-list-group>

      <h2 v-if="datasets.length">Datasets</h2>
      <b-list-group v-for="dataset in datasets">
        <b-list-group-item>
          <a v-bind:href="dataset.link" target="_blank">{{dataset.name}}</a>: {{dataset.description}}
        </b-list-group-item>
      </b-list-group>
    </b-container>
  </div>
</template>

<script>
import database from "@/database"

export default {
  name: "Softwares",
  computed: {
    softwares() {
      return database.getSoftwares()
    },

    datasets() {
      return database.getDatasets()
    }
  }
}
</script>

<style scoped>

</style>
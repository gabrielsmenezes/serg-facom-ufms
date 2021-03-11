<template>
  <div id="professors">
    <b-container>
      <h1>Professors</h1>
      <person-card-list
          v-bind:people="this.professors"
          v-on:click="clickHandler($event)"
      />
    </b-container>
  </div>
</template>

<script>
import PersonCardList from "@/components/PersonCardList"
import database from "@/database"

export default {
  components: {
    PersonCardList
  },

  mounted() {
    database.getProfessors()
  },

  data() {
    return {
      professors: []
    }
  },

  methods: {
    clickHandler(id) {
      this.$router.push({name: 'Professor', params: {id: id}})
    }
  }
}
</script>

<style scoped>
</style>
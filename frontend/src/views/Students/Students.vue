<template>
  <div id="students">
    <b-container>
      <h1>Students</h1>
      <person-card-list
          v-bind:people="students"
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
  computed: {
      students() {
        return database.getStudents()
      }
  },

  methods: {
    clickHandler(id) {
      this.$router.push({name: "Student", params: {id: id}})
    }
  }
}
</script>

<style scoped>

</style>
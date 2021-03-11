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
import api from "@/api/backend-api"

export default {
  components: {
    PersonCardList
  },

  mounted() {
    api.getStudents().then(response => {this.students = response.data}).catch(reason => console.log(reason))
  },

  methods: {
    clickHandler(id) {
      this.$router.push({name: "Student", params: {id: id}})
    }
  },
  data() {
    return {
      students: []
    }
  }
}
</script>

<style scoped>

</style>
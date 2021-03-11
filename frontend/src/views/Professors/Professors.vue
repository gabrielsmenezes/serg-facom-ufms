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
import api from "@/api/backend-api"

export default {
  components: {
    PersonCardList
  },

  mounted() {
    api.getProfessors().then(response => {
      this.professors = response.data
    }).catch(error => {
      console.log(error)
    })
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
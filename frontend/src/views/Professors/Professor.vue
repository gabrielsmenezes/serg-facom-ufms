<template>
  <div id="professor">
    <b-container>
      <person-perfil
          v-bind:person="this.professor"
          v-on:click="clickHandler($event)"
      />
    </b-container>
  </div>
</template>

<script>
import PersonPerfil from "@/components/PersonPerfil"
import api from "@/api/backend-api"
export default {
  components: {
    PersonPerfil
  },

  mounted() {
    api.getProfessorById(this.$route.params.id).then(response => this.professor = response.data).catch(reason => console.log(reason))
  },

  data() {
    return {
      professor: {}
    }
  },

  methods: {
    clickHandler(id) {
      this.$router.push({name: 'Student', params: {id: id}})
    }
  }
}
</script>

<style scoped>

</style>

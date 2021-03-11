<template>
  <div id="student">
    <b-container>
      <person-perfil
          v-bind:person="this.getStudentById"
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
    api.getStudentById(this.$route.params.id).then(response => this.student = response.data).catch(reason => console.log(reason))
  },

  data() {
    return {
      student: {}
    }
  }
}
</script>

<style scoped>

</style>
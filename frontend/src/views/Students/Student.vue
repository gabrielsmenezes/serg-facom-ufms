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
import database from "@/database"

export default {
  components: {
    PersonPerfil
  },

  computed: {
    getStudentById() {
      return database.getStudentById(this.$route.params.id)
    }
  }
}
</script>

<style scoped>

</style>
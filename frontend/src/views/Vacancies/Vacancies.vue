<template>
  <div id="vacancies">
    <b-container>
      <h1>Vacancies</h1>
      <p>The Software Engineering Research Group @ FACOM - UFMS has the following vacancies:</p>
      <h2>For doctoral students</h2>
      <b-list-group>
        <b-list-group-item v-for="vacancy in doctoral">{{ vacancy }}</b-list-group-item>
      </b-list-group>
      <h2>For master students</h2>
      <b-list-group>
        <b-list-group-item v-for="vacancy in master">{{ vacancy }}</b-list-group-item>
      </b-list-group>
      <h2>For bachelor students</h2>
      <b-list-group-item v-for="vacancy in bachelor">{{ vacancy }}</b-list-group-item>

    </b-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      doctoral: [
        "Vaga 1",
        "Vaga 2"
      ],
      master: [
        "Vaga 3",
        "Vaga 4"
      ],
      bachelor: [
        "Vaga 5",
        "Vaga 6"
      ]
    }
  }
}
</script>

<style scoped>

</style>
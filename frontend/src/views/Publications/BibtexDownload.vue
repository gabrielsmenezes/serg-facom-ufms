<template>
<div id="bibtex-download">
  <b-container>
    <b-card>
      {{getPublicationById}}
    </b-card>
  </b-container>
</div>
</template>

<script>
import database from "@/database";

export default {
  name: "BibtexDownload",

  computed: {
    getPublicationById() {
      return database.getPublicationById(this.$route.params.id).bibtex_non_parsed
    }
  },
}
</script>

<style scoped>

</style>
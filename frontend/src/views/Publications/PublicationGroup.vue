<template>
  <div id="publication-group">
      <publication-item v-for="publication in this.publications"
                        v-bind:publication="publication"
      />
  </div>
</template>

<script>
import PublicationItem from "@/views/Publications/PublicationItem";

export default {
  name: "PublicationGroup",

  components: {
    PublicationItem
  },

  props: {
    publications: Array
  },

}
</script>

<style scoped>

</style>
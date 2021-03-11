<template>
  <div id="research-lines-group">
    <b-card v-for="researchLine in researchLines" v-bind:title="researchLine.name">{{ researchLine.description }}</b-card>
  </div>
</template>

<script>
export default {
  name: "ResearchLinesGroup",
  props: {
    researchLines: Array
  }
}
</script>

<style scoped>

</style>
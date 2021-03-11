<template>
  <div id="card-list">
    <b-row cols="1" cols-sm="2" cols-md="4" cols-lg="6" align-h="center">
      <b-card
          v-bind:title="person.name"
          v-bind:img-src="person.imageSource"
          v-bind:img-alt="person.name"
          img-top
          v-for="person in people"
          v-bind:key="person.id"
          v-on:click="$emit('click', person.id)"
          class="m-3"
      >
      </b-card>
    </b-row>
  </div>

</template>

<script>
export default {
  name: "PersonCardList",
  props: {
    people: Array
  }
}
</script>

<style scoped>

</style>
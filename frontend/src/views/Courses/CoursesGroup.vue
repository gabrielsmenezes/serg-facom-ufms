<template>
<div id="courses-group">
  <b-card v-for="course in courses">{{course.name}}</b-card>
</div>
</template>

<script>
export default {
  name: "CoursesGroup",
  props: {
    courses: Array
  }
}
</script>

<style scoped>

</style>
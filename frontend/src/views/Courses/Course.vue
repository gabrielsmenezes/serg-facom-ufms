<template>
  <div id="classes">
    <b-container>
      <h1>Classes</h1>
      <courses-group v-bind:courses="courses"></courses-group>
    </b-container>
  </div>
</template>

<script>
import database from "@/database"
import CoursesGroup from "@/views/Courses/CoursesGroup";

export default {
  name: "Courses",
  components: {
    CoursesGroup
  },
  computed: {
    courses() {
      return database.getClasses()
    }
  }
}
</script>

<style scoped>

</style>
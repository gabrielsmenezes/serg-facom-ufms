<template>
  <div id="person-perfil">
    <h3>{{ person.name }}</h3>
    <b-img
        v-bind:src="person.imageSource"
        fluid
        alt=""
        height="200px"
        width="200px"
    />

    <div v-if="person.titulation">
      <h3>Degree</h3>
      <p>{{ person.titulation }}</p>
      <p v-if="person.egressed">{{ person.egressed }}</p>
    </div>

    <div v-if="person.interestAreas">
      <h3>Interest Areas</h3>
      <b-card v-for="interestArea in person.interestAreas" >{{ interestArea.name }}</b-card>
    </div>

    <div v-if="person.description">
      <h3>Description</h3>
      <p>{{ person.description }}</p>
    </div>

    <div v-if="person.publications">
      <h3>Publications</h3>
      <publication-group v-bind:publications="person.publications" v-if="person.publications"/>
    </div>

    <div v-if="person.students">
      <h3>Students</h3>
      <person-card-list v-bind:people="person.students" v-on:click="$emit('click', $event)"/>
    </div>

    <div v-if="person.courses">
      <h3>Courses</h3>
      <classes-group v-bind:courses="person.courses"></classes-group>
    </div>

    <div v-if="person.projects">
      <h3>Projects</h3>
      <projects-group v-bind:projects="person.projects"></projects-group>
    </div>

  </div>
</template>

<script>
import PublicationGroup from "@/views/Publications/PublicationGroup"
import PersonCardList from "@/components/PersonCardList"
import ClassesGroup from "@/views/Courses/CoursesGroup"
import ProjectsGroup from "@/views/Projects/ProjectsGroup";
import ResearchLinesGroup from "@/views/ResearchLines/ResearchLinesGroup";

export default {
  //TODO refatorar, colocar cada topico em um Component?
  name: "PersonPerfil",

  components: {
    PersonCardList,
    PublicationGroup,
    ClassesGroup,
    ProjectsGroup,
    ResearchLinesGroup
  },

  props: {
    person: Object
  }
}
</script>

<style scoped>

</style>

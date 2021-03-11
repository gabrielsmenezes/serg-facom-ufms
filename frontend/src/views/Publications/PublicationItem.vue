<template>
  <div id="publication-item">
    <b-card img-left body-class="card-publication">
      {{ `${authors} (${year}). ${title}, In ${conference}` }}
      <b-card-footer footer-bg-variant="white" v-bind:footer-class="classSelection">

        <b-button class="button-publication" v-on:click="downloadBibtex()">
          <b-icon icon="download" aria-hidden="true"></b-icon>
          Bibtex
        </b-button>

        <b-button class="button-publication" v-on:click="copyBibtex()">
          <b-icon icon="clipboard" aria-hidden="true"></b-icon>
          Bibtex
        </b-button>

        <b-button class="button-publication" v-bind:href=link target="_blank">
          <b-icon icon="link" aria-hidden="true"></b-icon>
          Page
        </b-button>


      </b-card-footer>
    </b-card>
  </div>
</template>

<script>
import bibtexParse from "@orcid/bibtex-parse-js"

export default {
  name: "PublicationItem",

  props: {
    publication: Object
  },

  mounted() {
    let publicationParsed = bibtexParse.toJSON(this.publication.bibtex)[0]
    this.authors = publicationParsed.entryTags.author
    this.year = publicationParsed.entryTags.year
    this.title = publicationParsed.entryTags.title
    this.conference = publicationParsed.entryTags.booktitle
    this.link = this.publication.link
  },

  computed: {
    screenSize() {
      return window.innerWidth;
    },

    classSelection: function () {
      return {
        'card-publication-footer': true,
        'card-publication-footer-mobile': this.screenSize <= 768,
        'card-publication-footer-desktop': !this.screenSize <= 768
      }
    }
  },

  data() {
    return {
      authors: "",
      year: "",
      title: "",
      conference: "",
      link: ""
    }
  },

  methods: {
    downloadBibtex() {
      this.$router.push({name: 'BibtexDownload', params: {id: this.publication.id}})
    },

    copyBibtex() {
      this.$clipboard(this.publication.bibtex_non_parsed)
      this.showMessage()
    },

    showMessage() {
      this.$bvToast.toast(`The bibtex was successfully copied`, {
        title: 'Copied successfully',
        autoHideDelay: 5000,
        appendToast: true
      })
    }
  }
}
</script>

<style scoped>

.card-publication {
  display: flex;
}

.card-publication-footer {
  padding: 0 0 0 .75rem !important;
  border-color: white;
  display: flex;
  justify-content: space-between;
}

.card-publication-footer-mobile {
  flex-direction: column;
}

.card-publication-footer-desktop {
  justify-content: space-between;
}

.button-publication {
  font-size: 60%;
  margin: 2%;
}

</style>
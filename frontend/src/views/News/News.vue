<template>
  <div id="news">
    <b-container>
      <h1>News</h1>

        <b-card
            img-left
            img-width="20%"
            title="Processo seletivo para professor Substituto"
            sub-title="20/01/2021"
            class="mb-3"
        >As Comissões Especiais dos Processos Seletivos para Professor Substituto da Facom tornam públicas os Editais de
          Resultado Final, conforme disponibilizadas […]
        </b-card>

      <b-card
          img-src="https://www.facom.ufms.br/wp-content/uploads/2020/12/prof-substituto.png"
          img-left
          img-width="20%"
          title="Processo seletivo para professor Substituto"
          sub-title="20/01/2021"
          class="mb-3"
      >As Comissões Especiais dos Processos Seletivos para Professor Substituto da Facom tornam públicas os Editais de
        Resultado Final, conforme disponibilizadas […]
      </b-card>

      <b-card
          img-src="https://www.facom.ufms.br/wp-content/uploads/2020/12/prof-substituto.png"
          img-left
          img-width="20%"
          title="Processo seletivo para professor Substituto"
          sub-title="20/01/2021"
      >As Comissões Especiais dos Processos Seletivos para Professor Substituto da Facom tornam públicas os Editais de
        Resultado Final, conforme disponibilizadas […]
      </b-card>
      <scroll-loader :loader-method="getImageList" :loader-disable="disable">
      </scroll-loader>

    </b-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      disable: false,
      page: 1,
      pageSize: 30,
      images: [],
    }
  },
  methods: {
    //TODO Criar um metodo no state que vai buscar e armazenar a lista de notícias
    getImageList() {
      axios.get('https://api.example.com/', {
        params: {
          page: this.page++,
          pageSize: this.pageSize,
        }
      })
          .then(res => {
            this.images = [...this.images, ...res.data]

            // Stop scroll loading...
            this.disable = res.data.length < this.pageSize
          })
          .catch(error => {
            console.log(error);
          })
    }
  }
}
</script>

<style scoped>

</style>
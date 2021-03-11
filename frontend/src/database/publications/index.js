import bibtexParse from "@orcid/bibtex-parse-js"

let _publications = ["001_Menezes_2019_Framework.json"]

export default new class PublicationDatabase {
    publications = []

    constructor() {
        _publications.forEach(publication => {
            let pub = require("./" + publication)
            let bibtex = bibtexParse.toJSON(pub.bibtex)
            pub.bibtex_non_parsed = pub.bibtex
            pub.bibtex = bibtex[0]
            this.publications.push(pub)
        })
    }

    getPublications() {
        return this.publications
    }

    getPublicationById(id){
        return this.publications.find(publication => publication.id == id)
    }
    // TODO ta errado, esta comparando o id do professor ocm o id da publication
    getPublicationsByProfessorId(id) {
        return this.publications.filter(publication => publication.id == id)
    }
    // TODO ta errado, esta comparando o id do student ocm o id da publication
    getPublicationsByStudentId(id) {
        return this.publications.filter(publication => publication.id == id)
    }
}

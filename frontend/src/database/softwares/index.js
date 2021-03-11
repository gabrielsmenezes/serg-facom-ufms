let _softwares = ["001_Nome_2019.json", "002_Nome_2019.json", "003_Nome_2019.json"]

export default new class SoftwareDatabase {
    softwares = []

    constructor() {
        _softwares.forEach(software => {
            this.softwares.push(require("./"+software))
        })
    }

    getSoftwares() {
        return this.softwares.filter(software => software.type === "SOFTWARE")
    }

    getDatasets() {
        return this.softwares.filter(software => software.type === "DATASET")
    }

}
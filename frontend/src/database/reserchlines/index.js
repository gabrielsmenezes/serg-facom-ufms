let _lines = ["001_Research_Line_Name.json", "002_Research_Line_Name.json"]

export default new class ResearchLinesDatabase {
    lines = []

    constructor() {
        _lines.forEach(line => {
            this.lines.push(require("./"+line))
        })
    }

    getResearchLines() {
        return this.lines
    }

    getResearchLinesByIds(ids){
        return this.lines.filter(line => ids.includes(line.id))
    }

}
let _classes = [
    "001_Introduction_Software_Engineering.json",
    "002_Database.json",
    "003_Software_Testing_Verification_Validation.json"
]

export default new class ClassesDatabase {

    classes = []

    constructor() {
        _classes.forEach(_class => this.classes.push(require("./" + _class)))
    }

    getClasses() {
        return this.classes
    }

    getClassesById(ids){
        return this.classes.filter(cls => ids.includes(cls.id))
    }
}
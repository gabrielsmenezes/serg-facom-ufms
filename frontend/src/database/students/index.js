import publications from "@/database/publications"
import projects from "@/database/projects"

let _students = ["001_Gabriel_Menezes.json"]

export default new class StudentDatabase {
    students = []

    constructor() {
        _students.forEach(student => this.students.push(require("./" + student)))

        this._setPublications()
        this._setProjects()
    }

    _setPublications() {
        this.students.map(student => student.publications = publications.getPublicationsByStudentId(student.id))
    }

    _setProjects() {
        this.students.map(student => student.projects = projects.getProjetcsByStudentId(student.id))
    }

    getStudents() {
        return this.students
    }

    getStudentByProfessorId(id) {
        return this.students.filter(student => student.advisor_id == id)
    }

    getStudentById(id) {
        return this.students.find(student => student.id == id)
    }
}


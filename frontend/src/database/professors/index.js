let API = "/professors"
import axios from "axios";

export default {

    async getProfessors() {
        return await axios.get("http://localhost:8080/professors").then(value => value.data)
    },

    getProfessorById(id) {
        return this.professors.find(professor => professor.id == id)
    }
}
import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `/api`,
  timeout: 1000
});


export default {
    getPerson(id){
        return AXIOS.get(`/people/${id}`)
    },
    getProfessors(){
        return AXIOS.get(`/people?role=professor`)
    },
    getProfessorById(id){
        return this.getPerson(id)
    },
    getStudents(){
        return AXIOS.get(`/people?role=student`)
    },
    getStudentById(id){
        return this.getPerson(id)
    },
    hello() {
        return AXIOS.get(`/hello`);
    },
    getUser(userId) {
        return AXIOS.get(`/user/` + userId);
    },
    createUser(firstName, lastName) {
        return AXIOS.post(`/user/` + firstName + '/' + lastName);
    },
    getSecured(user, password) {
        return AXIOS.get(`/secured/`,{
            auth: {
                username: user,
                password: password
            }});
    }
}



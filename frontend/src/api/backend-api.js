import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `/api`,
  timeout: 1000
});


export default {
    getProfessors(){
        return AXIOS.get(`/professors`)
    },
    getProfessorById(id){
        return AXIOS.get(`/professors/${id}`)
    },
    getStudents(){
        return AXIOS.get(`/students`)
    },
    getStudentById(id){
        return AXIOS.get(`/students/${id}`)
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



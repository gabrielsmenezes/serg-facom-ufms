import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/professors',
        name: 'Professors',
        component: () => import(/* webpackChunkName: "Professors" */ '../views/Professors/Professors.vue')
    },
    {
        path: '/professors/:id',
        name: 'Professor',
        component: () => import(/* webpackChunkName: "Professor" */ '../views/Professors/Professor.vue')
    },
    {
        path: '/students',
        name: 'Students',
        component: () => import(/* webpackChunkName: "Students" */ '../views/Students/Students.vue')
    },
    {
        path: '/students/:id',
        name: 'Student',
        component: () => import(/* webpackChunkName: "Student" */ '../views/Students/Student.vue')
    },
    {
        path: '/news',
        name: 'News',
        component: () => import(/* webpackChunkName: "News" */ '../views/News/News.vue')
    },
    {
        path: '/publications',
        name: 'Publications',
        component: () => import(/* webpackChunkName: "Publications" */ '../views/Publications/Publications.vue')
    },
    {
        path: '/vacancies',
        name: 'Vacancies',
        component: () => import(/* webpackChunkName: "Vacancies" */ '../views/Vacancies/Vacancies.vue')
    },
    {
        path: '/research-lines',
        name: 'ResearchLines',
        component: () => import(/* webpackChunkName: "ResearchLines" */ '../views/ResearchLines/ResearchLines.vue')
    },
    {
        path: '/softwares-and-databases',
        name: 'SoftwaresAndDatabases',
        component: () => import(/* webpackChunkName: "SoftwaresAndDatabases" */ '@/views/Softwares/Softwares.vue')
    },
    {
        path: '/bibtex-download/:id',
        name: 'BibtexDownload',
        component: () => import(/* webpackChunkName: "BibtexDownload" */ '@/views/Publications/BibtexDownload.vue'),
    },
    {
        path: '/classes',
        name: 'Classes',
        component: () => import(/* webpackChunkName: "Classes" */ '@/views/Courses/Course.vue')
    },
    {
        path: '/projects',
        name: 'Projects',
        component: () => import(/* webpackChunkName: "Projects" */ '@/views/Projects/Projetcs.vue')
    },
]

const router = new VueRouter({
    routes
})

export default router

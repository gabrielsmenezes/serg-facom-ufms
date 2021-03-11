package com.example.sergfacomufms.domain.professor;

import com.example.sergfacomufms.domain.person.Role;
import com.example.sergfacomufms.domain.project.Project;
import com.example.sergfacomufms.domain.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends Role {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private List<Course> courses;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "advisor")
    private List<Student> students;

    @OneToMany(mappedBy = "coordinator")
    private List<Project> coordenateProjects;

}
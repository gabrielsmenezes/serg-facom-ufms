package com.example.sergfacomufms.domain.student;

import com.example.sergfacomufms.domain.person.Role;
import com.example.sergfacomufms.domain.person.Titulation;
import com.example.sergfacomufms.domain.professor.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Role {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor advisor;

    private Titulation titulationExpected;
}

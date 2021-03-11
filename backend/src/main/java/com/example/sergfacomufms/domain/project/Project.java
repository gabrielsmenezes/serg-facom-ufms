package com.example.sergfacomufms.domain.project;

import com.example.sergfacomufms.domain.base.BaseEntity;
import com.example.sergfacomufms.domain.person.Person;
import com.example.sergfacomufms.domain.professor.Professor;
import com.example.sergfacomufms.domain.researchline.ResearchLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity {

    private String name;

    @Lob
    private String description;

    private String fundingOrganization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor coordinator;

    private Date startDate;

    private Date endDate;

    @ManyToMany(mappedBy = "projects")
    private List<ResearchLine> researchLine;

    @ManyToMany(mappedBy = "projects")
    private List<Person> people;
}

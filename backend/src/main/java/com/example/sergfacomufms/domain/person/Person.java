package com.example.sergfacomufms.domain.person;

import com.example.sergfacomufms.domain.base.BaseEntity;
import com.example.sergfacomufms.domain.interestarea.InterestArea;
import com.example.sergfacomufms.domain.project.Project;
import com.example.sergfacomufms.domain.publication.Publication;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Person extends BaseEntity {

    private String name;

    @Lob
    private String imageSource;

    @Lob
    private String description;

    private Titulation titulation;

    @ManyToMany
    @JoinTable(name = "PERSON_INTEREST_AREA", joinColumns = {@JoinColumn(name = "PERSON_ID")}, inverseJoinColumns = {@JoinColumn(name = "INTEREST_AREA_ID")})
    private List<InterestArea> interestAreas;

    @ManyToMany
    @JoinTable(name = "PERSON_PUBLICATION", joinColumns = {@JoinColumn(name = "PERSON_ID")}, inverseJoinColumns = {@JoinColumn(name = "PUBLICATION_ID")})
    private List<Publication> publications;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Role> roles = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "PERSON_PROJECT", joinColumns = {@JoinColumn(name = "PERSON_ID")}, inverseJoinColumns = {@JoinColumn(name = "PROJECT_ID")})
    private List<Project> projects;
}

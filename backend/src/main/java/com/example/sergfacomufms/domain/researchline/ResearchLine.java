package com.example.sergfacomufms.domain.researchline;

import com.example.sergfacomufms.domain.base.BaseEntity;
import com.example.sergfacomufms.domain.project.Project;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ResearchLine extends BaseEntity {

    @NonNull
    private String name;

    @NonNull
    @Lob
    private String description;

    @ManyToMany
    @JoinTable(name = "RESEARCH_LINE_PROJECT", joinColumns = {@JoinColumn(name = "RESEARCH_LINE_ID")}, inverseJoinColumns = {@JoinColumn(name = "PROJECT_ID")})
    private List<Project> projects;
}

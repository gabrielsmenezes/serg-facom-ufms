package com.example.sergfacomufms.domain.professor.usecases.getprofessordetailsbyid;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class ProfessorDTO implements Serializable {
    private Long id;
    private String imageSource;
    private String name;
    private String description;
    private String titulation;
    private List<InterestAreaDTO> interestAreas;
    private List<PublicationDTO> publications;
    private List<ProjectDTO> projects;
}

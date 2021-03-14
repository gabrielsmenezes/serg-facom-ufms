package com.example.sergfacomufms.domain.person.usecases.getpersondetailsbyid;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PersonDTO {
    private Long id;
    private String imageSource;
    private String name;
    private String description;
    private String titulation;
    private List<InterestAreaDTO> interestAreas;
    private List<PublicationDTO> publications;
    private List<ProjectDTO> projects;
    private List<StudentDTO> students;
    private List<CourseDTO> courses;
}
package com.example.sergfacomufms.domain.student.usecases.getstudentdetailsbyid;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class StudentDTO implements Serializable {
    private Long id;
    private String imageSource;
    private String name;
    private String descritpion;
    private String titulation;
    private List<InterestAreaDTO> interestAreas;
    private List<PublicationDTO> publications;
    private List<ProjectDTO> projects;
}

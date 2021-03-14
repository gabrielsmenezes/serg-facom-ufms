package com.example.sergfacomufms.domain.professor.usecases.getprofessordetailsbyid;

import com.example.sergfacomufms.domain.publication.Publication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

package com.example.sergfacomufms.domain.professor.usecases.getprofessorsnamesandimages;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessorDTO {
    private Long id;
    private String name;
    private String imageSource;
}

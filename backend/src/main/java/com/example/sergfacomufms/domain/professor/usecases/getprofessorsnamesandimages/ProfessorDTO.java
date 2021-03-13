package com.example.sergfacomufms.domain.professor.usecases.getprofessorsnamesandimages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfessorDTO {
    private Long id;
    private String name;
    private String imageSource;
}

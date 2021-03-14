package com.example.sergfacomufms.domain.professor.usecases.getprofessordetailsbyid;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class PublicationDTO implements Serializable {
    private Long id;
    private String bibtex;
}

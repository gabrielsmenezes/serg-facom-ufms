package com.example.sergfacomufms.domain.professor.usecases.getprofessordetailsbyid;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class InterestAreaDTO implements Serializable {
    private Long id;
    private String name;
}

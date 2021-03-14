package com.example.sergfacomufms.domain.professor.usecases.getprofessordetailsbyid;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
public class InterestAreaDTO implements Serializable {
    private Long id;
    private String name;
}

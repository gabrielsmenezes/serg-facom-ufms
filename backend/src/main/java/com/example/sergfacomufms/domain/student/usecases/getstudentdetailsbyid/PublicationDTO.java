package com.example.sergfacomufms.domain.student.usecases.getstudentdetailsbyid;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PublicationDTO implements Serializable {
    private Long id;
    private String bibtex;
}

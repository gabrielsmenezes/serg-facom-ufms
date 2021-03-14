package com.example.sergfacomufms.domain.student.usecases.getstudentsnamesandimages;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private String imageSource;
}

package com.example.sergfacomufms.domain.person.usecases.getpersondetailsbyid;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDTO {
    private Long id;
    private String name;
    private String imageSource;
}

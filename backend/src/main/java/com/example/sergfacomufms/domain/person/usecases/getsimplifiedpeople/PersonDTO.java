package com.example.sergfacomufms.domain.person.usecases.getsimplifiedpeople;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDTO {
    private Long id;
    private String name;
    private String imageSource;
}

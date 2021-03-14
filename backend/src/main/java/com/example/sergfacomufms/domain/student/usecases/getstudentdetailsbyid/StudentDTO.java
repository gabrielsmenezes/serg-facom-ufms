package com.example.sergfacomufms.domain.student.usecases.getstudentdetailsbyid;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
@Setter
public class StudentDTO implements Serializable {
    private Long id;
}

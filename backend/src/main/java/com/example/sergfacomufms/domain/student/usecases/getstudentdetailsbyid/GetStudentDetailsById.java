package com.example.sergfacomufms.domain.student.usecases.getstudentdetailsbyid;

import com.example.sergfacomufms.domain.student.Student;

public interface GetStudentDetailsById {
    StudentDTO execute(Long id);
}

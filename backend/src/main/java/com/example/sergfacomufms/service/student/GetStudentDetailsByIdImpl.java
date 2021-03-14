package com.example.sergfacomufms.service.student;

import com.example.sergfacomufms.domain.student.usecases.getstudentdetailsbyid.GetStudentDetailsById;
import com.example.sergfacomufms.domain.student.usecases.getstudentdetailsbyid.StudentDTO;
import com.example.sergfacomufms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetStudentDetailsByIdImpl implements GetStudentDetailsById {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO execute(Long id) {
        return studentRepository.findById(id).map(student -> StudentDTO.builder().id(student.getId()).build()).get();
    }
}

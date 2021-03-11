package com.example.sergfacomufms.controller.student;

import com.example.sergfacomufms.domain.student.usecases.GetStudentsNamesAndImages;
import com.example.sergfacomufms.domain.student.usecases.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    GetStudentsNamesAndImages getStudentsNamesAndImages;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll() {
        return ResponseEntity.ok(getStudentsNamesAndImages.execute());
    }
}

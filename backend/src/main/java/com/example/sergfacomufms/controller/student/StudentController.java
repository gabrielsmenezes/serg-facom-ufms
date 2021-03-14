package com.example.sergfacomufms.controller.student;

import com.example.sergfacomufms.domain.student.usecases.getstudentdetailsbyid.GetStudentDetailsById;
import com.example.sergfacomufms.domain.student.usecases.getstudentsnamesandimages.GetStudentsNamesAndImages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    GetStudentsNamesAndImages getStudentsNamesAndImages;

    @Autowired
    GetStudentDetailsById getStudentDetailsById;

    @GetMapping
    public ResponseEntity<List<com.example.sergfacomufms.domain.student.usecases.getstudentsnamesandimages.StudentDTO>> getAll() {
        return ResponseEntity.ok(getStudentsNamesAndImages.execute());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<com.example.sergfacomufms.domain.student.usecases.getstudentdetailsbyid.StudentDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getStudentDetailsById.execute(id));
    }
}

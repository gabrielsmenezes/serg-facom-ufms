package com.example.sergfacomufms.service.student;

import com.example.sergfacomufms.domain.student.usecases.GetStudentsNamesAndImages;
import com.example.sergfacomufms.domain.student.usecases.StudentDTO;
import com.example.sergfacomufms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetStudentsNamesAndImagesImpl implements GetStudentsNamesAndImages {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDTO> execute() {
        return studentRepository.findAll().stream().map(student ->
                StudentDTO.
                        builder().
                        name(student.getOwner().getName()).
                        imageSource(student.getOwner().getImageSource()).build()).collect(Collectors.toList());
    }
}

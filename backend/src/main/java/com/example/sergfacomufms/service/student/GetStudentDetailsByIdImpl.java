package com.example.sergfacomufms.service.student;

import com.example.sergfacomufms.domain.student.usecases.getstudentdetailsbyid.*;
import com.example.sergfacomufms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GetStudentDetailsByIdImpl implements GetStudentDetailsById {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO execute(Long id) {
        return studentRepository.findById(id).map(student ->
                StudentDTO.builder().
                        id(student.getId()).
                        imageSource(student.getOwner().getImageSource()).
                        description(student.getOwner().getDescription()).
                        titulation(student.getOwner().getTitulation().getName()).
                        interestAreas(student.getOwner().getInterestAreas().stream().map(interestArea -> InterestAreaDTO.builder().id(interestArea.getId()).name(interestArea.getName()).build()).collect(Collectors.toList())).
                        publications(student.getOwner().getPublications().stream().map(publication -> PublicationDTO.builder().id(publication.getId()).bibtex(publication.getBibtex()).build()).collect(Collectors.toList())).
                        projects(student.getOwner().getProjects().stream().map(project -> ProjectDTO.builder().id(project.getId()).name(project.getName()).fundingOrganization(project.getFundingOrganization()).build()).collect(Collectors.toList())).
                        build())
                .get();
    }
}

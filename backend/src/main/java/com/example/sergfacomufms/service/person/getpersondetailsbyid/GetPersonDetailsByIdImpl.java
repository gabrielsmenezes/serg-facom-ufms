package com.example.sergfacomufms.service.person.getpersondetailsbyid;

import com.example.sergfacomufms.domain.person.Person;
import com.example.sergfacomufms.domain.person.Role;
import com.example.sergfacomufms.domain.person.usecases.getpersondetailsbyid.*;
import com.example.sergfacomufms.domain.professor.Professor;
import com.example.sergfacomufms.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetPersonDetailsByIdImpl implements GetPersonDetailsById {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public PersonDTO execute(Long id) {


        return personRepository.findById(id).map(person ->
                PersonDTO.builder().
                        id(person.getId()).
                        name(person.getName()).
                        imageSource(person.getImageSource()).
                        description(person.getDescription()).
                        titulation(person.getTitulation().getName()).
                        interestAreas(getInterestAreas(person)).
                        publications(getPublications(person)).
                        projects(getProjects(person)).
                        students(getStudents(person)).
                        courses(getCourses(person)).
                        build())
                .get();
    }

    private List<CourseDTO> getCourses(Person person) {
        try {
            return ((Professor) person.getRoles().get(person.getRoles().size() - 1)).getCourses().stream().map(course -> CourseDTO.builder().id(course.getId()).name(course.getName()).build()).collect(Collectors.toList());
        } catch (ClassCastException e) {
            return null;
        }
    }

    private List<InterestAreaDTO> getInterestAreas(Person person) {
        return person.getInterestAreas().stream().map(interestArea -> InterestAreaDTO.builder().id(interestArea.getId()).name(interestArea.getName()).build()).collect(Collectors.toList());
    }

    private List<PublicationDTO> getPublications(Person person) {
        return person.getPublications().stream().map(publication -> PublicationDTO.builder().id(publication.getId()).bibtex(publication.getBibtex()).build()).collect(Collectors.toList());
    }

    private List<ProjectDTO> getProjects(Person person) {
        return person.getProjects().stream().map(project -> ProjectDTO.builder().id(project.getId()).name(project.getName()).fundingOrganization(project.getFundingOrganization()).build()).collect(Collectors.toList());
    }

    private List<StudentDTO> getStudents(Person person) {
        try {
            return ((Professor) person.getRoles().get(person.getRoles().size() - 1)).getStudents().stream().map(student -> StudentDTO.builder().id(student.getOwner().getId()).name(student.getOwner().getName()).imageSource(student.getOwner().getImageSource()).build()).collect(Collectors.toList());
        } catch (ClassCastException e) {
            return null;
        }
    }
}

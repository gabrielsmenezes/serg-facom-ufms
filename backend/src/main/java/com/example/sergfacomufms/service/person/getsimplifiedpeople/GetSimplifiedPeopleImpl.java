package com.example.sergfacomufms.service.person.getsimplifiedpeople;

import com.example.sergfacomufms.domain.person.usecases.getsimplifiedpeople.GetSimplifiedPeople;
import com.example.sergfacomufms.domain.person.usecases.getsimplifiedpeople.PersonDTO;
import com.example.sergfacomufms.domain.professor.Professor;
import com.example.sergfacomufms.domain.student.Student;
import com.example.sergfacomufms.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetSimplifiedPeopleImpl implements GetSimplifiedPeople {

    @Autowired
    private PersonRepository personRepository;

    private List<PersonDTO> executeForProfessors() {
        return personRepository.findAll().stream().filter(
                person -> person.getRoles().get(person.getRoles().size() - 1) instanceof Professor).map(person -> PersonDTO.builder().id(person.getId()).name(person.getName()).imageSource(person.getImageSource()).build()).collect(Collectors.toList());
    }

    private List<PersonDTO> executeForStudents() {
        return personRepository.findAll().stream().filter(
                person -> person.getRoles().get(person.getRoles().size() - 1) instanceof Student).map(person -> PersonDTO.builder().id(person.getId()).name(person.getName()).imageSource(person.getImageSource()).build()).collect(Collectors.toList());
    }

    @Override
    public List<PersonDTO> execute(String role) {
        List<PersonDTO> people = Collections.emptyList();
        switch (role){
            case "professor":
                people = executeForProfessors();
                break;
            case "student":
                people = executeForStudents();
                break;
        }
        return people;
    }
}

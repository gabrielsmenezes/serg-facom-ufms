package com.example.sergfacomufms.service.person.getpersondetailsbyid;

import com.example.sergfacomufms.domain.person.usecases.getpersondetailsbyid.*;
import com.example.sergfacomufms.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                        imageSource(person.getImageSource()).
                        description(person.getDescription()).
                        titulation(person.getTitulation().getName()).
                        interestAreas(person.getInterestAreas().stream().map(interestArea -> InterestAreaDTO.builder().id(interestArea.getId()).name(interestArea.getName()).build()).collect(Collectors.toList())).
                        publications(person.getPublications().stream().map(publication -> PublicationDTO.builder().id(publication.getId()).bibtex(publication.getBibtex()).build()).collect(Collectors.toList())).
                        projects(person.getProjects().stream().map(project -> ProjectDTO.builder().id(project.getId()).name(project.getName()).fundingOrganization(project.getFundingOrganization()).build()).collect(Collectors.toList())).
                        build())
                .get();
    }
}

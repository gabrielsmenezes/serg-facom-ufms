package com.example.sergfacomufms.service.professor;

import com.example.sergfacomufms.domain.professor.usecases.getprofessordetailsbyid.*;
import com.example.sergfacomufms.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetProfessorDetailsByIdImpl implements GetProfessorDetailsById {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public ProfessorDTO execute(Long id) {
        return professorRepository.findById(id).map(professor ->
                ProfessorDTO.builder().
                        id(professor.getId()).
                        imageSource(professor.getOwner().getImageSource()).
                        name(professor.getOwner().getName()).
                        description(professor.getOwner().getDescription()).
                        titulation(professor.getOwner().getTitulation().getName()).
                        interestAreas(getInterestAreas(professor)).
                        publications(getPublications(professor)).
                        projects(getProjects(professor)).build()
        ).get();
    }

    private List<ProjectDTO> getProjects(com.example.sergfacomufms.domain.professor.Professor professor) {
        return professor.getOwner().getProjects().stream().map(project -> ProjectDTO.builder().id(project.getId()).name(project.getName()).fundingOrganization(project.getFundingOrganization()).build()).collect(Collectors.toList());
    }

    private List<PublicationDTO> getPublications(com.example.sergfacomufms.domain.professor.Professor professor) {
        return professor.getOwner().getPublications().stream().map(publication -> PublicationDTO.builder().id(publication.getId()).bibtex(publication.getBibtex()).build()).collect(Collectors.toList());
    }

    private List<InterestAreaDTO> getInterestAreas(com.example.sergfacomufms.domain.professor.Professor professor) {
        return professor.getOwner().getInterestAreas().stream().map(interestArea -> InterestAreaDTO.builder().id(interestArea.getId()).name(interestArea.getName()).build()).collect(Collectors.toList());
    }
}

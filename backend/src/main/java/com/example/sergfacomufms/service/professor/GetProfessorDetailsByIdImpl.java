package com.example.sergfacomufms.service.professor;

import com.example.sergfacomufms.domain.professor.usecases.getprofessordetailsbyid.*;
import com.example.sergfacomufms.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class GetProfessorDetailsByIdImpl implements GetProfessorDetailsById {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public ProfessorDTO execute(Long id) {
        return professorRepository.findById(id).map(professor ->
                ProfessorDTO.builder().
                        imageSource(professor.getOwner().getImageSource()).
                        name(professor.getOwner().getName()).
                        description(professor.getOwner().getDescription()).
                        titulation(professor.getOwner().getTitulation().getName()).
                        interestAreas(Arrays.asList(new InterestAreaDTO())).
                        publications(Arrays.asList(new PublicationDTO())).
                        projects(Arrays.asList(new ProjectDTO())).build()
        ).get();
    }
}

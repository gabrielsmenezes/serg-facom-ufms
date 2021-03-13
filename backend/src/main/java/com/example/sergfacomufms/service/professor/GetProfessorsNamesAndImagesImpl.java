package com.example.sergfacomufms.service.professor;

import com.example.sergfacomufms.domain.professor.usecases.getprofessorsnamesandimages.GetProfessorsNamesAndImages;
import com.example.sergfacomufms.domain.professor.usecases.getprofessorsnamesandimages.ProfessorDTO;
import com.example.sergfacomufms.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetProfessorsNamesAndImagesImpl implements GetProfessorsNamesAndImages {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public List<ProfessorDTO> execute() {
        return professorRepository.findAll().stream().map(professor ->
                ProfessorDTO.
                        builder().
                        id(professor.getId()).
                        name(professor.getOwner().getName()).
                        imageSource(professor.getOwner().getImageSource()).build()).collect(Collectors.toList());
    }
}

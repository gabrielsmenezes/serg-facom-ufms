package com.example.sergfacomufms.controller.professor;


import com.example.sergfacomufms.domain.professor.usecases.getprofessordetailsbyid.GetProfessorDetailsById;
import com.example.sergfacomufms.domain.professor.usecases.getprofessorsnamesandimages.GetProfessorsNamesAndImages;
import com.example.sergfacomufms.domain.professor.usecases.getprofessorsnamesandimages.ProfessorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    @Autowired
    private GetProfessorsNamesAndImages getProfessorsNamesAndImages;

    @Autowired
    private GetProfessorDetailsById getProfessorDetailsById;

//    @PostMapping
//    public ResponseEntity<Professor> save(@RequestBody Professor professor) {
//        professorService.save(professor);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(professor.getId()).toUri();
//        return ResponseEntity.created(uri).body(professor);
//    }

    @GetMapping
    public ResponseEntity<List<com.example.sergfacomufms.domain.professor.usecases.getprofessorsnamesandimages.ProfessorDTO>> getAll() {
        return ResponseEntity.ok(getProfessorsNamesAndImages.execute());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<com.example.sergfacomufms.domain.professor.usecases.getprofessordetailsbyid.ProfessorDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getProfessorDetailsById.execute(id));
    }
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Professor> getById(@PathVariable String id) {
//        return ResponseEntity.ok(professorService.findById(Long.valueOf(id)));
//    }

}
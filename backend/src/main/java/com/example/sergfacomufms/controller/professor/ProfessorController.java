package com.example.sergfacomufms.controller.professor;


import com.example.sergfacomufms.domain.professor.usecases.GetProfessorsNamesAndImages;
import com.example.sergfacomufms.domain.professor.usecases.ProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    @Autowired
    GetProfessorsNamesAndImages getProfessorsNamesAndImages;

//    @PostMapping
//    public ResponseEntity<Professor> save(@RequestBody Professor professor) {
//        professorService.save(professor);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(professor.getId()).toUri();
//        return ResponseEntity.created(uri).body(professor);
//    }

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> getAll() {
        return ResponseEntity.ok(getProfessorsNamesAndImages.execute());
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Professor> getById(@PathVariable String id) {
//        return ResponseEntity.ok(professorService.findById(Long.valueOf(id)));
//    }

}
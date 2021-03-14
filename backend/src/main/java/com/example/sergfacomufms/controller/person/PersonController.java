package com.example.sergfacomufms.controller.person;

import com.example.sergfacomufms.domain.person.usecases.getpersondetailsbyid.GetPersonDetailsById;
import com.example.sergfacomufms.domain.person.usecases.getpersondetailsbyid.PersonDTO;
import com.example.sergfacomufms.domain.person.usecases.getsimplifiedpeople.GetSimplifiedPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonController {

    @Autowired
    private GetPersonDetailsById getPersonDetailsById;

    @Autowired
    private GetSimplifiedPeople getSimplifiedPeople;

    @GetMapping
    public ResponseEntity getAll(@RequestParam String role){
        return ResponseEntity.ok(getSimplifiedPeople.execute(role));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getPersonDetailsById.execute(id));
    }
}

package com.example.sergfacomufms.domain.person.usecases.getsimplifiedpeople;

import java.util.List;

public interface GetSimplifiedPeople {
    List<PersonDTO> execute(String role);
}

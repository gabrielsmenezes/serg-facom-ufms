package com.example.sergfacomufms.domain.interestarea;

import com.example.sergfacomufms.domain.base.BaseEntity;
import com.example.sergfacomufms.domain.person.Person;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class InterestArea extends BaseEntity {

    @NonNull
    private String name;

    @ManyToMany(mappedBy = "interestAreas")
    private List<Person> people;
}

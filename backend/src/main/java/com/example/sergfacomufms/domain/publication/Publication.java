package com.example.sergfacomufms.domain.publication;

import com.example.sergfacomufms.domain.base.BaseEntity;
import com.example.sergfacomufms.domain.person.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publication extends BaseEntity {

    @Lob
    private String bibtex;

    private Boolean selected = Boolean.FALSE;

    private String archiveLink;

    private String officialLink;

    @ManyToMany(mappedBy = "publications")
    private List<Person> authors;

    private Byte[] file;
}

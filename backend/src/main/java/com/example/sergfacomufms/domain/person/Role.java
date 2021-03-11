package com.example.sergfacomufms.domain.person;

import com.example.sergfacomufms.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {

    private Boolean egressed = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person owner;
}

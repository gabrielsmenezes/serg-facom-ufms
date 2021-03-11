package com.example.sergfacomufms.domain.professor;

import com.example.sergfacomufms.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Course extends BaseEntity {

    @NonNull
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "courses")
    private List<Professor> professors;
}

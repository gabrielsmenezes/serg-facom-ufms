package com.example.sergfacomufms.domain.base;


import lombok.*;

import javax.persistence.*;


@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
}

package com.example.sergfacomufms.domain.product;

import com.example.sergfacomufms.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    private String name;

    private String link;

    @Lob
    private String description;

    private ProductType productType;
}

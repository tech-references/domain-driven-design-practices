package me.bigfanoftim.domaindriven.catalog.domain.category;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CategoryId implements Serializable {

    @Column(name = "category_id")
    private String id;
}

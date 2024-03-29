package me.bigfanoftim.domaindriven.catalog.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Category {

    @EmbeddedId
    @AttributeOverride(name = "category_id", column = @Column(name = "id"))
    private CategoryId categoryId;

    @Column(nullable = false)
    private String name;
}

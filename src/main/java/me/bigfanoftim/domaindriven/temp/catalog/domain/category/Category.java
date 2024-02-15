package me.bigfanoftim.domaindriven.temp.catalog.domain.category;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Category {

    @EmbeddedId
    @AttributeOverride(name = "category_id", column = @Column(name = "id"))
    private CategoryId categoryId;
}

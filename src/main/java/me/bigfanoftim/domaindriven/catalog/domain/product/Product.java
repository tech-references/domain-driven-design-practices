package me.bigfanoftim.domaindriven.catalog.domain.product;

import jakarta.persistence.*;
import me.bigfanoftim.domaindriven.catalog.domain.category.CategoryId;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @EmbeddedId
    @AttributeOverride(name = "product_id", column = @Column(name = "id"))
    private ProductId id;

    @ElementCollection
    @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"))
    private Set<CategoryId> categoryIds;
}

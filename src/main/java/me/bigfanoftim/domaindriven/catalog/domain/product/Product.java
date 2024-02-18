package me.bigfanoftim.domaindriven.catalog.domain.product;

import jakarta.persistence.*;
import me.bigfanoftim.domaindriven.catalog.domain.category.CategoryId;
import me.bigfanoftim.domaindriven.common.jpa.MoneyConverter;
import me.bigfanoftim.domaindriven.common.model.Money;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @EmbeddedId
    @AttributeOverride(name = "id", column = @Column(name = "id"))
    private ProductId id;

    @Column(nullable = false)
    private String name;

    @Convert(converter = MoneyConverter.class)
    @Column(nullable = false)
    private Money price;

    @ElementCollection
    @CollectionTable(name = "product_category", joinColumns = @JoinColumn(name = "id"))
    private Set<CategoryId> categoryIds = new HashSet<>();

    protected Product() {
    }

    private Product(ProductId id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static Product createProduct(String name, Money price) {
        return new Product(ProductId.createUniqueId(), name, price);
    }

    public void addCategory(CategoryId categoryId) {
        categoryIds.add(categoryId);
    }
}

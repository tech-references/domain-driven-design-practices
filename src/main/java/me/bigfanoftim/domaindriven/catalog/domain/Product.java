package me.bigfanoftim.domaindriven.catalog.domain;

import jakarta.persistence.*;
import me.bigfanoftim.domaindriven.common.jpa.MoneyConverter;
import me.bigfanoftim.domaindriven.common.model.Money;

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
}

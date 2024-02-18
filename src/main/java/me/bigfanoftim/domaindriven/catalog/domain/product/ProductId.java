package me.bigfanoftim.domaindriven.catalog.domain.product;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class ProductId implements Serializable {

    @Column(name = "product_id")
    private String id;

    public ProductId() {
    }

    public ProductId(String id) {
        this.id = id;
    }

    public static ProductId createUniqueId() {
        return new ProductId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(id, productId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

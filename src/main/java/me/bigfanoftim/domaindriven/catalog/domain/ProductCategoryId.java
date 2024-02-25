package me.bigfanoftim.domaindriven.catalog.domain;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductCategoryId implements Serializable {

    private ProductId productId;
    private CategoryId categoryId;

    protected ProductCategoryId() {
    }

    public ProductCategoryId(ProductId productId, CategoryId categoryId) {
        this.productId = productId;
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryId that = (ProductCategoryId) o;
        return Objects.equals(productId, that.productId) && Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, categoryId);
    }
}

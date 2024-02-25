package me.bigfanoftim.domaindriven.catalog.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import me.bigfanoftim.domaindriven.common.audit.BaseEntity;

@Entity
public class ProductCategory extends BaseEntity {

    @EmbeddedId
    private ProductCategoryId id;

    protected ProductCategory() {
    }

    public ProductCategory(ProductId productId, CategoryId categoryId) {
        this.id = new ProductCategoryId(productId, categoryId);
    }

    public ProductCategoryId getId() {
        return id;
    }
}

package me.bigfanoftim.domaindriven.catalog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class CategoryId implements Serializable {

    @Column(name = "category_id")
    private String id;

    protected CategoryId() {
    }

    public CategoryId(String id) {
        this.id = id;
    }

    public static CategoryId createUniqueId() {
        return new CategoryId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryId that = (CategoryId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

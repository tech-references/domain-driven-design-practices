package me.bigfanoftim.domaindriven.catalog.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, ProductCategoryId> {
}

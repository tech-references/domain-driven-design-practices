package me.bigfanoftim.domaindriven.catalog.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.bigfanoftim.domaindriven.config.JpaAuditingConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@Import({JpaAuditingConfig.class})
@DataJpaTest
public class ProductCategoryTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void pass() throws Exception {
        ProductId productId = ProductId.createUniqueId();
        CategoryId categoryId = CategoryId.createUniqueId();

        ProductCategory productCategory = new ProductCategory(productId, categoryId);
        productCategoryRepository.save(productCategory);

        entityManager.flush();
        entityManager.clear();

        ProductCategoryId productCategoryId = new ProductCategoryId(productId, categoryId);
        ProductCategory foundProductCategory = productCategoryRepository.findById(productCategoryId).get();

        assertThat(foundProductCategory.getId()).isEqualTo(productCategory.getId());
    }
}

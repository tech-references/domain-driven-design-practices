package me.bigfanoftim.domaindriven.catalog.domain.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import me.bigfanoftim.domaindriven.catalog.domain.category.CategoryId;
import me.bigfanoftim.domaindriven.catalog.domain.category.CategoryRepository;
import me.bigfanoftim.domaindriven.common.model.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
@DisplayName("Product Aggregate Tests")
public class ProductAggregateTest {

    @PersistenceContext EntityManager entityManager;

    @Autowired CategoryRepository categoryRepository;

    @Autowired ProductRepository productRepository;

    @Nested
    @DisplayName("addCategory() method test")
    class AddCategoryMethod {

        private Product product;

        @BeforeEach
        void setUp() {
            Money money = new Money(30000);
            product = Product.createProduct("productA", money);
            productRepository.save(product);
        }

        @Test
        @DisplayName("")
        public void should() throws Exception {
            CategoryId categoryId = CategoryId.createUniqueId();
            product.addCategory(categoryId);
            product.addCategory(categoryId);

            entityManager.flush();
            entityManager.clear();
        }
    }
}

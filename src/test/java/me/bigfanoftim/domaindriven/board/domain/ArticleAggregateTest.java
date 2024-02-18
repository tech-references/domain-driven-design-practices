package me.bigfanoftim.domaindriven.board.domain;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@DisplayName("Article Aggregate Tests")
public class ArticleAggregateTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ArticleRepository articleRepository;

    @Nested
    @DisplayName("updateContentType() method test")
    class UpdateContentTypeMethod {

        @Nested
        @DisplayName("content가 존재하면")
        class WithContent {

            private Article article;
            private String newContentType;

            @BeforeEach
            void setUp() {
                ArticleContent articleContent = new ArticleContent("content", "contentType");
                article = new Article("title", articleContent);
                articleRepository.save(article);

                newContentType = "newContentType";
            }

            @Test
            @DisplayName("새로운 ContentType으로 업데이트된다.")
            public void shouldUpdate() throws Exception {
                article.updateContentType(newContentType);

                entityManager.flush();
                entityManager.clear();

                Article foundArticle = articleRepository.findById(article.getId()).get();
                assertThat(foundArticle.getContent().getContentType()).isEqualTo(newContentType);
            }
        }

        @Nested
        @DisplayName("content가 없으면")
        class WithoutContent {

            private Article article;
            private String newContentType;

            @BeforeEach
            void setUp() {
                article = new Article("title", null);
                articleRepository.save(article);

                newContentType = "newContentType";
            }

            @Test
            @DisplayName("IllegalStateException을 던진다.")
            public void shouldUpdate() throws Exception {
                entityManager.flush();
                entityManager.clear();

                Article foundArticle = articleRepository.findById(article.getId()).get();
                assertThatThrownBy(() -> foundArticle.updateContentType(newContentType))
                        .isInstanceOf(IllegalStateException.class)
                        .hasMessage("ArticleContent cannot be null when trying to update.");
            }
        }
    }
}

package me.bigfanoftim.domaindriven.board.domain;

import jakarta.persistence.*;

/**
 * 이렇게 @SecondaryTable을 이용하면 Article 조회 시 article_content 테이블도 조인해서 데이터를 읽기 때문에
 * 원하는 결과가 아닐 수 있다.
 * 그렇다고 ArticleContent를 엔티티로 처리하는 것은 좋은 방법이 아니다. 이건 조회 전용 쿼리로 해결하자.
 */
@Entity
@Table(name = "article")
@SecondaryTable(
        name = "article_content",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "content",
                    column = @Column(table = "article_content", name = "content")
            ),
            @AttributeOverride(
                    name = "contentType",
                    column = @Column(table = "article_content", name = "content_type")
            )
    })
    private ArticleContent content;
}

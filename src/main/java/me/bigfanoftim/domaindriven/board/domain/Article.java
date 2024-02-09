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
        /**
         * 이렇게 설정하면 article의 id, article_content의 id가 연결되는 것
         * article_content의 pk이자 fk가 id라는 컬럼이 되어서 다소 헷갈릴 것 같음
         * 이러면 joinColumn과 같은 속성을 통해 처리해야 하는데 @SecondaryTable로는 불가능
         * 따라서 조금 더 세밀한 조절이 필요한 경우 ArticleContent를 밸류가 아닌 엔티티로 처리해야 한다.
         */
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
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

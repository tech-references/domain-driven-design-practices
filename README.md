# domain-driven-design-practices

[도메인 주도 개발 시작하기](https://www.yes24.com/Product/Goods/108431347)를 공부하며 떠오르는 개인적인 생각을 기록하는 저장소입니다.
책에서 전달하고자 하는 바를 최대한 이해하고 내것으로 만드는 과정을 통해 작성되어 책의 내용과 다를 수 있습니다.

# 엔티티와 밸류, 어떻게 구분해야 할까?
```java
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
```

위 코드에서 `Article` 엔티티는 애그리거트의 루트 엔티티, 그리고 `ArticleContent`는 밸류 객체이다.
책에서는 여기서 `ArticleContent`는 밸류가 아니라 엔티티로 관리하는 것은 좋은 방법이 아니라 한다. 아직 도메인 개념에 대한 이해가 부족한 것인지
한 번에 와닿지 않아 조금 생각을 정리한 후에 기록을 남기려고 한다.

우선 엔티티, 밸류 객체가 어떤 차이가 있는지 파악하는 것이 우선이라고 생각한다.

- 엔티티는 식별자를 통해 구별되는 객체이다. 시간에 따라 속성이 변할 수 있지만 동일한 식별자를 유지한다. 사용자 계정, 주문 등
- 밸류 객체는 식별자로 구별되지 않는 (엄밀히 얘기하면 고유 식별자로 구별될 필요가 없는) 객체이다. 도메인 무결성 유지, 안전한 재사용을 위해 불변 객체로
  다루는 것이 권장된다.

위와 같은 차이를 고려해 보았을 때 `ArticleContent`는 고유 식별자를 가질 필요없이(식별성 부재) 그저 `Article`에 속하는 데이터를 표현한 데 적합한 밸류 타입이라고
볼 수 있다. 

이렇듯 밸류 객체를 사용하면 이러한 설계만으로 도메인 모델이 더 명확해지고, 의도를 더 잘 표현할 수 있다. `ArticleContent`를 밸류 객체로 모델링함으로써
단순 데이터의 집합이 아닌 `Article` 루트 엔티티의 도메인 로직과 밀접한 연관이 있는 도메인 개념임을 명확히 할 수 있는 것이다.

## 루트 엔티티 외에 다른 엔티티가 있다면?

애그리거트를 구성하다보면 분명 루트 엔티티외에 다른 엔티티가 있을 수 있다. 이때 정말 이것이 엔티티가 맞는지 의심할 필요가 있다.

- 별도의 테이블로 데이터를 저장한다고 해서 엔티티는 아니다.
- 애그리거트에서 루트 엔티티를 뺀 나머지 구성요소는 대부분 밸류 객체이다.
- 독자적인 라이프 사이클을 갖는다면 다른 애그리거트일 가능성이 높다.

# 코드 응집성
로직이 이곳저곳 분산되어있는 기능을 이해하려고 하면 굉장히 머리가 아프다. 그래서 나는 개인적으로 도메인 영역과 응용 영역을 정확히 분리하여 개발하는 것이
좋다고 생각한다. 만약 기능 개발 시 도메인 로직을 응용 서비스, 도메인 영역 등 다양한 곳에 분산해서 작성하게 되면 누군가 이 기능을 이해하려고 할 때
여러 영역에 걸쳐 코드를 분석해야 한다. 무엇보다 패키지가 복잡해지고 파일이 많아지면 더욱 어지럽다.

또 다른 문제는 동일한 도메인 로직이 여러 응용 서비스에 반복해서 작성된다는 것이다. 이렇게 영역을 정확하게 구분하지 않고 마음가는대로 개발하게 되면
어디를 어떻게 고쳐야 할지, 어떤 코드를 리팩토링해야 할지 고민하는 것에 시간을 쏟는 등 정작 중요한 일에 집중하지 못하게 된다.

따라서 도메인 로직을 도메인 영역에서만 관리할 수 있도록 하고, 응용 영역에서는 필요한 도메인 기능을 가져다 사용하기만 하는 형태로 만드는 것이 좋다.

# 참고
- [도메인 주도 개발 시작하기 - 최범균](https://www.yes24.com/Product/Goods/108431347)
package me.bigfanoftim.domaindriven.board.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class ArticleContent {

    private String content;
    private String contentType;

    protected ArticleContent() {
    }

    public ArticleContent(String content, String contentType) {
        this.content = content;
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public String getContentType() {
        return contentType;
    }
}

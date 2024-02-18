create table article
(
    id    bigint      not null auto_increment comment 'article pk',
    title varchar(50) not null comment 'article 타이틀'
);


create table article_content
(
    id           bigint      not null primary key comment 'article pk 참조',
    content      text        not null comment 'article 내용',
    content_type VARCHAR(20) not null comment 'article content의 타입'
);

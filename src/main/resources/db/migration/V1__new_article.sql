create table article
(
    id bigint not null auto_increment,
    title varchar(50) not null
);

create table article_content
(
    id           bigint      not null primary key comment 'article의 id',
    content      text        null,
    content_type varchar(20) null
);



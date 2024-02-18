create table category
(
    id   varchar(255) not null primary key comment 'category id (uuid)',
    name varchar(30)  not null comment 'category 이름'
);

create table product
(
    id    varchar(255)   not null primary key comment 'product id (uuid)',
    name  varchar(100)   not null comment 'product 이름',
    price decimal(19, 2) not null comment 'product 가격'
);

create table product_category
(
    category_id varchar(255) not null comment 'category id',
    product_id  varchar(255) not null comment 'product id',
    primary key (category_id, product_id)
);

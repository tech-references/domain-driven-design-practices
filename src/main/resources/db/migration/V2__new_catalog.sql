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
    product_id  varchar(255) not null comment 'product id',
    category_id varchar(255) not null comment 'category id',
    created_at  datetime(6)  not null comment '데이터 생성 시점',
    updated_at  datetime(6)  not null comment '데이터 업데이트 시점, 처음 데이터 생성 시 기록됨',
    deleted_at  datetime(6)  null comment '데이터 삭제 시점',
    primary key (product_id, category_id)
);

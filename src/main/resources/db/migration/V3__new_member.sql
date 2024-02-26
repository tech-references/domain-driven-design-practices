create table member
(
    id         varchar(255) not null primary key comment 'member 고유 ID',
    name       varchar(255) not null comment 'member 이름',
    email      varchar(255) not null comment 'member 이메일',
    password   varchar(255) not null comment '비밀번호',
    is_active  tinyint      not null default 1 comment '활성화 여부',
    created_at datetime(6)  not null comment '데이터 생성 시점',
    updated_at datetime(6)  not null comment '데이터 업데이트 시점, 처음 데이터 생성 시 기록됨',
    deleted_at datetime(6)  null comment '데이터 삭제 시점'
);

create table member_deactivation_history
(
    id             bigint       not null auto_increment primary key,
    member_id      varchar(255) not null comment 'member 고유 id',
    deactivated_at datetime(6)  not null comment '비활성화 시점'
);

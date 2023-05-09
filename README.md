# DB 스키마
- patient
create table patient
(
    id           bigint                 not null comment '환자ID'
        primary key,
    hospital_id  bigint                 not null comment '병원ID',
    name         varchar(45) default '' not null comment '환자명',
    patient_code varchar(13) default '' not null comment '환자등록코드',
    sex_code     varchar(10) default '' not null comment '성별코드',
    birth        varchar(10) default '' not null comment '생년월일',
    phone        varchar(20) default '' not null comment '휴대전화번호'
);

- hospital
create table hospital
(
    id          bigint                 not null comment '병원ID'
        primary key,
    name        varchar(45) default '' not null comment '병원명',
    code        varchar(20) default '' not null comment '요양기관번호',
    doctor_name varchar(10) default '' not null comment '병원장명'
);

- visit
create table visit
(
    id          bigint                                not null comment '환자방문ID'
        primary key,
    hospital_id bigint                                not null comment '병원ID',
    patient_id  bigint                                not null comment '환자ID',
    create_time datetime    default CURRENT_TIMESTAMP not null comment '접수일시',
    status_code varchar(10) default ''                not null comment '방문상태코드'
);

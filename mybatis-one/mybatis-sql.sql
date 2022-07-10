create database mybatis;


create table mybatis_test
(
    id       int auto_increment primary key,
    username varchar(32) null comment '用户名',
    password varchar(64) null comment '密码'
)

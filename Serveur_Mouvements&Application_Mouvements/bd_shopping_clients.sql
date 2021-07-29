create table clients
(
    idClient int auto_increment
        primary key,
    username varchar(255) not null,
    password varchar(255) not null
)
    charset = utf8;


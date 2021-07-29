create table panier
(
    idPanier int auto_increment
        primary key,
    idClient int                  not null,
    articles text                 not null,
    done     tinyint(1) default 0 not null,
    constraint panier_ibfk_1
        foreign key (idClient) references clients (idClient)
            on update cascade on delete cascade
)
    charset = utf8;

create index idClient
    on panier (idClient);


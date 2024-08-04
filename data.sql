create table account
(
    id       integer not null
        constraint account_pk
            primary key,
    name     varchar not null,
    username varchar not null,
    password varchar not null
);

alter table account
    owner to postgres;

create unique index account_id_uindex
    on account (id);
create table if not exists public.accounts
(
    id   serial
        constraint accounts_pk
            primary key,
    name varchar not null
);

alter table public.accounts
    owner to postgres;
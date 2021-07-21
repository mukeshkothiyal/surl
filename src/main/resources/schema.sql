create table if not exists impl_url
(
    id        integer not null,
    url       varchar not null,
    small_url varchar not null,
    primary key (id)
);
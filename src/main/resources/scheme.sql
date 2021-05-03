create table col_blacklist_ip
(
    id         bigserial not null
        constraint col_blacklist_ip_pkey
            primary key,
    created_at timestamp,
    enabled    boolean,
    is_deleted boolean,
    updated_at timestamp,
    ip_address varchar(255)
);

alter table col_blacklist_ip
    owner to postgres;



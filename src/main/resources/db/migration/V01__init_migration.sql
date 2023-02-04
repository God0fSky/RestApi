create schema if not exists store;

create table if not exists store.order
(
    id              serial,
    date            date not null,
    cost            numeric not null,
    primary key(id)
);

create table if not exists store.product
(
    id              serial,
    fk_order_id     integer constraint fk_product_id_fkey references store.order,
    name            text not null,
    cost            numeric not null,
    primary key(id)
);
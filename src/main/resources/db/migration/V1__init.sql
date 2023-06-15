create table if not exists products
(
    id
    bigserial
    primary
    key,
    title
    varchar
(
    255
), price int);

insert into products (title, price)
values ('milk', 100),
       ('bread', 80),
       ('water', 90);

create table if not exists customers
(
    id   int primary key auto_increment,
    name varchar2 not null
);

create table if not exists products
(
    id   int primary key auto_increment,
    title varchar2 not null unique,
    price double not null
);

create table if not exists orders
(
    id   int primary key auto_increment,
    date date not null,
    customer_id int not null,
    foreign key (customer_id) references customers (id)
);

create table if not exists orders_products
(
    product_id int not null,
    order_id int not null,
    foreign key (product_id) references products (id),
    foreign key (order_id) references orders (id)
);
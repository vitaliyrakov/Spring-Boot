
insert into PRODUCTS (title, price)
VALUES  ('Гречка', 10),
        ('Хлеб', 20),
        ('Рис', 30);

insert into CUSTOMERS (name)
VALUES  ('Иван'),
        ('Петр'),
        ('Семен');

insert into ORDERS (date, customer_id )
VALUES  ('2021-07-01', 1),
        ('2021-07-01', 2),
        ('2021-07-01', 3);

insert into ORDERS_PRODUCTS (product_id, order_id )
VALUES  (1,1),
        (2,1),
        (3,2),
        (3,3);



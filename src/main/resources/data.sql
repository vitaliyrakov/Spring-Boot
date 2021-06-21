
insert into PRICE (cost, dateP)
VALUES  (50, '2021-07-01'),
        (60, '2021-07-01'),
        (70, '2021-07-01');

insert into PRODUCTS (title, price_id)
VALUES  ('Гречка', 1),
        ('Хлеб', 2),
        ('Рис', 3);

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



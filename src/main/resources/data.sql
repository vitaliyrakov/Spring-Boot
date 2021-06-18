
insert into PRICE (cost, dateP) VALUES (50, '2021-07-01');
insert into PRICE (cost, dateP) VALUES (60, '2021-07-01');
insert into PRICE (cost, dateP) VALUES (70, '2021-07-01');

insert into PRODUCTS (title, price_id) VALUES ('Гречка', 1);
insert into PRODUCTS (title, price_id) VALUES ('Хлеб', 2);
insert into PRODUCTS (title, price_id) VALUES ('Рис', 3);

insert into CUSTOMERS (name) VALUES ('Иван');
insert into CUSTOMERS (name) VALUES ('Петр');
insert into CUSTOMERS (name) VALUES ('Семен');

insert into ORDERS (date, customer_id ) VALUES ('2021-07-01', 1);
insert into ORDERS (date, customer_id ) VALUES ('2021-07-01', 2);
insert into ORDERS (date, customer_id ) VALUES ('2021-07-01', 3);

insert into ORDERS_PRODUCTS (product_id, order_id ) VALUES (1,1);
insert into ORDERS_PRODUCTS (product_id, order_id ) VALUES (2,1);
insert into ORDERS_PRODUCTS (product_id, order_id ) VALUES (3,2);
insert into ORDERS_PRODUCTS (product_id, order_id ) VALUES (3,3);



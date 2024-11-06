CREATE TABLE IF NOT EXISTS orders
(
    id serial PRIMARY KEY NOT NULL
);

CREATE TABLE IF NOT EXISTS orders_line_items
(
    id serial PRIMARY KEY NOT NULL,
    product INT NOT NULL,
    quantity INT NOT NULL,
    orders INT REFERENCES orders(id)
);
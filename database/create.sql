-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-06-15 09:48:26.44

-- tables
-- Table: order_lines
CREATE TABLE order_lines
(
    id          serial NOT NULL,
    quantity    int    NOT NULL,
    orders_id   int    NOT NULL,
    products_id int    NOT NULL,
    CONSTRAINT order_lines_pk PRIMARY KEY (id)
);

-- Table: orders
CREATE TABLE orders
(
    id              serial NOT NULL,
    submission_date date   NOT NULL,
    user_id         int    NOT NULL,
    CONSTRAINT orders_pk PRIMARY KEY (id)
);

-- Table: products
CREATE TABLE products
(
    id         serial         NOT NULL,
    name       varchar(255)   NOT NULL,
    sku_code   varchar(255)   NOT NULL,
    unit_price decimal(10, 2) NOT NULL,
    CONSTRAINT products_pk PRIMARY KEY (id)
);

-- Table: users
CREATE TABLE users
(
    id                serial       NOT NULL,
    registration_code varchar(255) NOT NULL,
    full_name         varchar(255) NOT NULL,
    email             varchar(255) NOT NULL,
    telephone         varchar(255) NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Order_user (table: orders)
ALTER TABLE orders
    ADD CONSTRAINT Order_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: order_lines_orders (table: order_lines)
ALTER TABLE order_lines
    ADD CONSTRAINT order_lines_orders
        FOREIGN KEY (orders_id)
            REFERENCES orders (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: order_lines_products (table: order_lines)
ALTER TABLE order_lines
    ADD CONSTRAINT order_lines_products
        FOREIGN KEY (products_id)
            REFERENCES products (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.
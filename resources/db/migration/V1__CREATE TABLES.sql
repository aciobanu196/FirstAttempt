CREATE TABLE IF NOT EXISTS USERS(
user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR(25) NOT NULL,
user_email VARCHAR(25) NOT NULL,
user_bankId BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS BANK(
bank_id BIGINT PRIMARY KEY,
bank_ballance INT NOT NULL
);

CREATE TABLE IF NOT EXISTS PRODUCTS(
product_id BIGINT PRIMARY KEY,
product_name VARCHAR(30) NOT NULL,
product_price INT NOT NULL,
product_type INT,
product_quantity INT
);

CREATE TABLE IF NOT EXISTS TYPES(
type_id BIGINT PRIMARY KEY,
type_name VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS CART(
cart_id BIGINT PRIMARY KEY,
cart_productId BIGINT NOT NULL,
cart_quantity INT NOT NULL,
cart_productStatus VARCHAR(15) NOT NULL,
cart_total INT NOT NULL
);

CREATE TABLE IF NOT EXISTS ORDERED(
order_id BIGINT PRIMARY KEY,
order_userID BIGINT NOT NULL,
order_status VARCHAR(12) NOT NULL
);


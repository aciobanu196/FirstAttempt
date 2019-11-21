CREATE TABLE IF NOT EXISTS USERS(
USER_ID INT AUTO_INCREMENT PRIMARY KEY,
USER_NAME VARCHAR(50) NOT NULL,
USER_EMAIL VARCHAR(50) NOT NULL,
USER_BALANCE FLOAT
);
CREATE TABLE IF NOT EXISTS PRODUCTS(
PRODUCT_ID INT PRIMARY KEY,
PRODUCT_NAME VARCHAR(50) NOT NULL,
PRODUCT_PRICE FLOAT NOT NULL,
PRODUCT_TYPE VARCHAR(50),
PRODUCT_QUANTITY INT,
IS_DELETED BIT
);

CREATE TABLE IF NOT EXISTS CART(
CART_ID INT AUTO_INCREMENT PRIMARY KEY,
CART_PRODUCT_QUANTITY INT NOT NULL,
CART_PRODUCT_STATUS VARCHAR(50) NOT NULL,
CART_USER_ID INT REFERENCES USERS(USER_ID),
CART_TOTAL FLOAT NOT NULL,
CART_PRODUCT_ID VARCHAR(1000)
);

CREATE TABLE IF NOT EXISTS ORDERED(
ORDER_ID INT PRIMARY KEY,
ORDER_STATUS VARCHAR(12) NOT NULL,
ORDER_CART_ID INT REFERENCES CART(CART_ID),
CONSTRAINT CART_ORDER_FK UNIQUE (ORDER_CART_ID),
ORDER_USER_ID INT REFERENCES USERS(USER_ID)
);

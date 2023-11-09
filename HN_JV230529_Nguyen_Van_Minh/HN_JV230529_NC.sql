# Bài 1: Tạo CSDL[20 điểm]:
-- DROP DATABASE IF EXISTS QUANLYBANHANG2;
CREATE DATABASE QUANLYBANHANG2;
USE QUANLYBANHANG2;
CREATE TABLE CUSTOMERS
(
    customer_id VARCHAR(4)   NOT NULL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    email       VARCHAR(100) NOT NULL,
    phone       VARCHAR(25)  NOT NULL,
    address     VARCHAR(255) NOT NULL
);
CREATE TABLE ORDERS
(
    order_id     VARCHAR(4) NOT NULL PRIMARY KEY,
    customer_id  VARCHAR(4) NOT NULL,
    total_amount DOUBLE     NOT NULL,
    order_date   DATE       NOT NULL
);
ALTER TABLE ORDERS
    ADD CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES CUSTOMERS (customer_id);
CREATE TABLE PRODUCTS
(
    product_id  VARCHAR(4)   NOT NULL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    price       DOUBLE       NOT NULL,
    status      BIT(1)
);
CREATE TABLE ORDER_DETAIL
(
    order_id   VARCHAR(4) NOT NULL,
    product_id VARCHAR(4) NOT NULL,
    price      DOUBLE     NOT NULL,
    quantity   INT        NOT NULL
);
ALTER TABLE ORDER_DETAIL
    ADD CONSTRAINT pk_com PRIMARY KEY (order_id, product_id);
ALTER TABLE ORDER_DETAIL
    ADD CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES ORDERS (order_id);
ALTER TABLE ORDER_DETAIL
    ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES PRODUCTS (product_id);
-- Bài 2: Thêm dữ liệu [20 điểm]:
INSERT INTO CUSTOMERS
VALUES ('C001', 'Nguyễn Trung Mạnh', 'manhnt@gmail.com', '984756322', 'Cầu Giấy, Hà Nội'),
       ('C002', 'Hồ Hải Nam', 'namhh@gmail.com', '984875926', 'Ba Vì, Hà Nội'),
       ('C003', 'Tô Ngọc Vũ', 'vutn@gmail.com', '904725784', 'Mộc Châu, Sơn La'),
       ('C004', 'Phạm Ngọc Anh', 'anhpn@gmail.com', '984635365', 'Vinh, Nghệ An'),
       ('C005', 'Trương Minh Cường', 'cuongtm@gmail.com', '989735624', 'Hai Bà Trưng, Hà Nội');;
INSERT INTO ORDERS
VALUES ('H001', 'C001', 52999997, '2023/02/22'),
       ('H002', 'C001', 80999997, '2023/03/11'),
       ('H003', 'C002', 54359998, '2023/01/22'),
       ('H004', 'C003', 102999995, '2023/03/14'),
       ('H005', 'C003', 80999997, '2022/03/12'),
       ('H006', 'C003', 110449994, '2023/02/01'),
       ('H007', 'C004', 79999996, '2023/03/29'),
       ('H008', 'C004', 29999998, '2023/02/14'),
       ('H009', 'C005', 29999999, '2023/01/10'),
       ('H010', 'C005', 149999994, '2023/04/01');
INSERT INTO PRODUCTS
VALUES ('P001', 'Iphone 13 ProMax', 'Bản 512 GB, xanh lá', 22999999, 1),
       ('P002', 'Dell Vostro V3510', 'Core i5, RAM 8GB', 14999999, 1),
       ('P003', 'Macbook Pro M2', '8CPU 10GPU 8GB 256GB', 28999999, 1),
       ('P004', 'Apple Watch Ultra', 'Titanium Alpine Loop Small', 18999999, 1),
       ('P005', 'Airpods 2 2022', 'Spatial Audio', 4090000, 1);
INSERT INTO ORDER_DETAIL
VALUES ('H001', 'P002', 14999999, 1),
       ('H001', 'P004', 18999999, 2),
       ('H002', 'P001', 22999999, 1),
       ('H002', 'P003', 28999999, 2),
       ('H003', 'P004', 18999999, 2),
       ('H003', 'P005', 4090000, 4),
       ('H004', 'P002', 14999999, 3),
       ('H004', 'P003', 28999999, 2),
       ('H005', 'P001', 22999999, 1),
       ('H005', 'P003', 28999999, 2),
       ('H006', 'P005', 4090000, 5),
       ('H006', 'P002', 14999999, 6),
       ('H007', 'P004', 18999999, 3),
       ('H007', 'P001', 22999999, 1),
       ('H008', 'P002', 14999999, 2),
       ('H009', 'P003', 28999999, 1),
       ('H010', 'P003', 28999999, 2),
       ('H010', 'P001', 22999999, 4);

-- Bài 3: Truy vấn dữ liệu [30 điểm]:
-- 1
SELECT name, email, phone, address
FROM CUSTOMERS;
-- 2
SELECT name, phone, address
FROM CUSTOMERS AS c
         JOIN ORDERS AS o ON c.customer_id = o.customer_id
WHERE MONTH(order_date) = 3
GROUP BY c.customer_id;
-- 3
SELECT DATE_FORMAT(order_date, '%Y/%m') AS tháng, SUM(total_amount) AS 'Tổng doanh thu'
FROM ORDERS
GROUP BY tháng;
-- 4
SELECT name, address, email, phone
FROM CUSTOMERS
WHERE customer_id NOT IN (SELECT DISTINCT c.customer_id
                          FROM CUSTOMERS c
                                   INNER JOIN ORDERS o ON c.customer_id = o.customer_id
                          WHERE YEAR(o.order_date) = 2023
                            AND MONTH(o.order_date) = 2);
-- 5
SELECT p.product_id, p.name, SUM(od.quantity) AS 'Tổng số lượng bán ra'
FROM ORDERS
         JOIN ORDER_DETAIL OD on ORDERS.order_id = OD.order_id
         JOIN PRODUCTS P on OD.product_id = P.product_id
WHERE DATE_FORMAT(order_date, '%Y/%m') LIKE '2023/03%'
GROUP BY p.product_id;
-- 6
SELECT c.customer_id, c.name, SUM(o.total_amount) AS 'tổng chi tiêu'
FROM CUSTOMERS AS c
         JOIN ORDERS AS o on c.customer_id = o.customer_id
GROUP BY c.customer_id
ORDER BY `tổng chi tiêu` DESC;
-- 7
SELECT name, o.total_amount, o.order_id, o.order_date, SUM(od.quantity) as total
FROM CUSTOMERS AS c
         JOIN ORDERS O on c.customer_id = O.customer_id
         JOIN ORDER_DETAIL OD on o.order_id = OD.order_id
GROUP BY o.order_id
HAVING total >= 5;
-- Bài 4: Tạo View, Procedure [30 điểm]:
-- 1
CREATE VIEW VIEW_ORDER_INFO AS
SELECT c.name, c.phone, c.address, o.total_amount, o.order_date
FROM CUSTOMERS AS c
         JOIN ORDERS O on c.customer_id = O.customer_id
         JOIN ORDER_DETAIL OD on o.order_id = OD.order_id
GROUP BY o.order_id;
SELECT *
FROM VIEW_ORDER_INFO;
-- 2
CREATE VIEW VIEW_CUSTOMER_INFO AS
SELECT c.name, c.address, c.phone, COUNT(o.order_id) AS 'Số đơn hàng'
FROM CUSTOMERS AS c
         JOIN ORDERS O on c.customer_id = O.customer_id
GROUP BY c.customer_id;
SELECT *
FROM VIEW_CUSTOMER_INFO;
-- 3
CREATE VIEW VIEW_PRODUCT_DETAIL AS
SELECT p.name,
       p.description,
       p.price,
       SUM(od.quantity)           AS 'đã bán',
       SUM(p.price * od.quantity) AS 'tổng tiền thu được'
FROM PRODUCTS as p
         JOIN ORDER_DETAIL OD on p.product_id = OD.product_id
GROUP BY p.product_id;
SELECT *
FROM VIEW_PRODUCT_DETAIL;
DROP VIEW VIEW_PRODUCT_DETAIL;
-- 4
CREATE UNIQUE INDEX i_email ON CUSTOMERS (email);
CREATE UNIQUE INDEX i_phone ON CUSTOMERS (phone);
-- 5
DELIMITER &&
CREATE PROCEDURE GET_USER_BY_ID(IN id VARCHAR(4))
BEGIN
    SELECT * FROM CUSTOMERS WHERE customer_id = id;
END && DELIMITER ;
CAll GET_USER_BY_ID('C001');
-- 6
DELIMITER &&
CREATE PROCEDURE GET_PRODUCT_BY_ID(IN id VARCHAR(4))
BEGIN
    SELECT * FROM PRODUCTS WHERE product_id = id;
END && DELIMITER ;
CAll GET_PRODUCT_BY_ID('P001');
-- 7
DELIMITER &&
CREATE PROCEDURE GET_ORDER_BY_UID(IN id VARCHAR(4))
BEGIN
    SELECT * FROM ORDERS WHERE customer_id = id;
END && DELIMITER ;
CAll GET_ORDER_BY_UID('C001');
-- 8
DELIMITER &&
CREATE PROCEDURE INSERT_ORDER(IN cId VARCHAR(4), IN total DOUBLE, IN d DATE)
BEGIN
    DECLARE oId VARCHAR(4);
    DECLARE c INT;
    SELECT COUNT(1) a INTO c FROM ORDERS;
    IF c < 10
    THEN
        SET oid = CONCAT('H00', c + 1);
    ELSEIF c < 100 THEN
        SET oid = CONCAT('H0', c + 1);
    ELSE
        SET oid = CONCAT('H', c + 1);

    END IF;
    #     SET oId = (IF(c < 10, CONCAT('H00', c + 1), CONCAT('H0', c + 1)));
    INSERT INTO ORDERS(order_id, customer_id, total_amount, order_date) VALUE (oId,cid,total,d);
    select oid;
END && DELIMITER ;
CALL INSERT_ORDER('c001', 2000000, CURDATE());

-- 9
DELIMITER &&
CREATE PROCEDURE statistical_by_dateRange(IN startD DATE, IN endD DATE)
BEGIN
    SELECT p.product_id, p.name, SUM(od.quantity) AS 'Tổng số lượng bán ra'
    FROM ORDERS
             JOIN ORDER_DETAIL OD ON ORDERS.order_id = OD.order_id
             JOIN PRODUCTS P ON OD.product_id = P.product_id
    WHERE order_date BETWEEN startD AND endD
    GROUP BY p.product_id;
END && DELIMITER ;
-- 10
DELIMITER &&
CREATE PROCEDURE statistical_by_Ym(IN m INT(2), IN y INT(4))
BEGIN
    SELECT p.product_id, p.name, SUM(od.quantity) AS 'Tổng số lượng bán ra'
    FROM ORDERS
             JOIN ORDER_DETAIL OD ON ORDERS.order_id = OD.order_id
             JOIN PRODUCTS P ON OD.product_id = P.product_id
    WHERE YEAR(order_date) = y
      AND MONTH(order_date) = m
    GROUP BY p.product_id
    ORDER BY `Tổng số lượng bán ra` DESC;

END && DELIMITER ;
CALL statistical_by_Ym(2, 2023);
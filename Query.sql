CREATE DATABASE IF NOT EXISTS `storedb`;
USE storedb;

-- Chèn dữ liệu vào bảng Employee
INSERT INTO `employee` (full_name, dob, email, phone, address, status)
VALUES
    ('Nguyen Truong Tuan Kiet', '2002-10-27', 'kiet@gmail.com', '123456789', '123 Main St', 1),
    ('Pham Thi Ngoc Huong', '2002-05-24', 'huong@gmail.com', '987654321', '456 Elm St', 1);

-- Chèn dữ liệu vào bảng Product
INSERT INTO product (name, description, unit, manufacturer_name, status)
VALUES
    ('Iphone 12', 'Điện thoại di động', '128gb', 'Apple', 1),
    ('Iphone 13', 'Điện thoại di động', '128gb', 'Apple', 1),
   ('Iphone 11', 'Điện thoại di động', '128gb', 'Apple', 1),
    ('Iphone 14', 'Điện thoại di động', '256gb', 'Apple', 1),
    ('Iphone 15', 'Điện thoại di động', '256gb', 'Apple',0),
    ('Sam sung Note 22', 'Điện thoại di động', '128gb', 'SamSung', 0),
    ('Sam sung Note 23', 'Điện thoại di động', '128gb', 'SamSung', 1),
    ('Sam sung Note 24', 'Điện thoại di động', '128gb', 'SamSung', 1),
    ('Sam sung Note 21', 'Điện thoại di động', '256gb', 'SamSung', 1),
    ('Sam sung Note 20', 'Điện thoại di động', '256gb', 'SamSung', 1);
-- Chèn dữ liệu vào bảng Customer
INSERT INTO customer (cust_name, email, phone, address)
VALUES
    ('Nguyen Tien', 'tien@gmail.com', '111222333', '789 Oak St'),
    ('Nguyen Thu', 'thu@gmail.com', '444555666', '987 Pine St');

-- Chèn dữ liệu vào bảng Product_Image
INSERT INTO product_image (product_id, path, alternative)
VALUES
   (1, 'images/sp1.jpg', 'Hình ảnh 1 cho Iphone 12'),
(2, 'images/sp2.jpg', 'Hình ảnh 1 cho Iphone 13'),
(3, 'images/sp3.jpg', 'Hình ảnh 1 cho Iphone 11'),
(4, 'images/sp4.jpg', 'Hình ảnh 1 cho Iphone 14'),
(5, 'images/sp5.jpg', 'Hình ảnh 1 cho Iphone 15'),
(6, 'images/sp6.jpg', 'Hình ảnh 1 cho Sam sung Note 22'), 
(7, 'images/sp7.jpg', 'Hình ảnh 1 cho Sam sung Note 23'),
(8, 'images/sp8.jpg', 'Hình ảnh 1 cho Sam sung Note 24'),
(9, 'images/sp9.jpg', 'Hình ảnh 1 cho Sam sung Note 21'),
(10, 'images/sp10.jpg', 'Hình ảnh 1 cho Sam sung Note 20');



-- Chèn dữ liệu vào bảng Order
INSERT INTO `orders` (order_date, emp_id, cust_id)
VALUES
    ('2023-09-20', 1, 1),
    ('2023-09-21', 2, 2),
    ('2023-09-22', 1, 2);

-- Chèn dữ liệu vào bảng Order_Detail
INSERT INTO order_detail (order_id, product_id, quantity, price, note)
VALUES
   (2, 3, 4, 8.99, 'Ghi chú cho Đơn hàng 2, Sản phẩm 3'),
    (2, 5, 2, 7.99, 'Ghi chú cho Đơn hàng 2, Sản phẩm 5'),
    (3, 1, 1, 10.99, 'Ghi chú cho Đơn hàng 3, Sản phẩm 1'),
    (3, 4, 5, 6.99, 'Ghi chú cho Đơn hàng 3, Sản phẩm 4');


INSERT INTO product_price (product_id, price_date_time, price, note)
VALUES
(1, '2023-09-20 12:00:00', 10.99, 'Giá ban đầu cho Iphone 12'),
    (2, '2023-09-20 12:00:00', 15.99, 'Giá ban đầu cho Iphone 13'),
    (3, '2023-09-22 12:00:00', 9.99, 'Giá mới cho Iphone 11'),
    (4, '2023-09-25 12:00:00', 7.49, 'Giá mới cho Iphone 14'),
    (5, '2023-09-20 12:00:00', 9.49, 'Giá ban đầu cho Iphone 15'),
    (6, '2023-09-20 12:00:00', 6.99, 'Giá ban đầu cho Sam sung Note 22'),
    (7, '2023-09-20 12:00:00', 8.99, 'Giá ban đầu cho Sam sung Note 23'),
    (8, '2023-09-20 12:00:00', 12.99, 'Giá ban đầu cho am sung Note 24'),
    (9, '2023-09-20 12:00:00', 11.99, 'Giá ban đầu cho am sung Note 21'),
    (10, '2023-09-20 12:00:00', 14.99, 'Giá ban đầu cho am sung Note 20');

    


INSERT INTO user_role (id, role)
SELECT 1, 'Customer'
WHERE NOT EXISTS (SELECT * FROM user_role WHERE id = 1);

INSERT INTO user_role (id, role)
SELECT 3, 'Vendor'
WHERE NOT EXISTS (SELECT * FROM user_role WHERE id = 3);

-- Insert new customers into user table if they don't already exist

INSERT INTO user (id, email, fname, lname, password, registered_at, status, user_role_id)
SELECT * FROM (SELECT 1 as id, 'johndoe@gmail.com', 'John', 'Doe', '12345', NOW(), 1 as status, 1 as user_role_id) AS tmp
WHERE NOT EXISTS (
    SELECT email FROM user WHERE email = 'johndoe@gmail.com'
) LIMIT 1;

INSERT INTO user (id, email, fname, lname, password, registered_at, status, user_role_id)
SELECT * FROM (SELECT 2 as id, 'janedoe@gmail.com', 'Jane', 'Doe', '12345', NOW(), 1 as status, 1 as user_role_id) AS tmp
WHERE NOT EXISTS (
    SELECT email FROM user WHERE email = 'janedoe@gmail.com'
) LIMIT 1;

INSERT INTO user (id, email, fname, lname, password, registered_at, status, user_role_id)
SELECT * FROM (SELECT 3 as id,'bobsmith@gmail.com', 'Bob', 'Smith', '12345', NOW(), 1 as status, 1 as user_role_id) AS tmp
WHERE NOT EXISTS (
    SELECT email FROM user WHERE email = 'bobsmith@gmail.com'
) LIMIT 1;

-- Insert new vendors into user table if they don't already exist

INSERT INTO user (id, email, fname, lname, password, registered_at, status, user_role_id)
SELECT * FROM (SELECT 4 as id, 'alicejohnson@gmail.com', 'Alice', 'Johnson', '12345', NOW(), 1 as status, 3 as user_role_id) AS tmp
WHERE NOT EXISTS (
    SELECT email FROM user WHERE email = 'alicejohnson@gmail.com'
) LIMIT 1;

INSERT INTO user (id, email, fname, lname, password, registered_at, status, user_role_id)
SELECT * FROM (SELECT 5 as id,'bobwilliams@gmail.com', 'Bob', 'Williams', '12345', NOW(), 1 as status, 3 as user_role_id) AS tmp
WHERE NOT EXISTS (
    SELECT email FROM user WHERE email = 'bobwilliams@gmail.com'
) LIMIT 1;

-- Insert corresponding vendors into vendor table
INSERT INTO vendor (id, address, contact, user_id, vendor_name)
SELECT * FROM (SELECT 1 as id, '123 Main St', '0115551234', 4, 'Johnson Co.') AS tmp
WHERE NOT EXISTS (
    SELECT id FROM vendor WHERE id = 1
) LIMIT 1;

INSERT INTO vendor (id, address, contact, user_id, vendor_name)
SELECT * FROM (SELECT 2 as id,'456 Elm St', '0775555678', 5, 'Williams Inc.') AS tmp
WHERE NOT EXISTS (
    SELECT id FROM vendor WHERE id = 2
) LIMIT 1;

-- Insert new products into product table if they don't already exist

INSERT INTO product (description, image, price, registered_at, status, title, vendor_id)
SELECT * FROM (SELECT 'A classic white t-shirt made from 100% cotton.', 'https://example.com/images/white-tshirt.jpg', 19.99, NOW(), 1 as status, 'White T-Shirt', 1 as vendor_id) AS tmp
WHERE NOT EXISTS (
    SELECT title FROM product WHERE title = 'White T-Shirt'
) LIMIT 1;

INSERT INTO product (description, image, price, registered_at, status, title, vendor_id)
SELECT * FROM (SELECT 'A comfortable pair of blue jeans with a slim fit.', 'https://example.com/images/blue-jeans.jpg', 49.99, NOW(), 1 as status, 'Blue Jeans', 2 as vendor_id) AS tmp
WHERE NOT EXISTS (
    SELECT title FROM product WHERE title = 'Blue Jeans'
) LIMIT 1;

INSERT INTO product (description, image, price, registered_at, status, title, vendor_id)
SELECT * FROM (SELECT 'A warm and cozy knit sweater in a neutral beige color.', 'https://example.com/images/beige-sweater.jpg', 59.99, NOW(), 1 as status, 'Beige Sweater', 1 as vendor_id) AS tmp
WHERE NOT EXISTS (
    SELECT title FROM product WHERE title = 'Beige Sweater'
) LIMIT 1;

INSERT INTO product (description, image, price, registered_at, status, title, vendor_id)
SELECT * FROM (SELECT 'A stylish leather jacket with a classic design.', 'https://example.com/images/leather-jacket.jpg', 199.99, NOW(), 1 as status,'Leather Jacket', 2 as vendor_id) AS tmp
WHERE NOT EXISTS (
    SELECT title FROM product WHERE title = 'Leather Jacket'
) LIMIT 1;

INSERT INTO product (description, image, price, registered_at, status, title, vendor_id)
SELECT * FROM (SELECT 'A pair of comfortable and durable running shoes.', 'https://example.com/images/running-shoes.jpg', 89.99, NOW(), 1 as status,'Running Shoes', 1 as vendor_id) AS tmp
WHERE NOT EXISTS (
    SELECT title FROM product WHERE title = 'Running Shoes'
) LIMIT 1;

INSERT INTO product (description, image, price, registered_at, status, title, vendor_id)
SELECT * FROM (SELECT 'A versatile and spacious backpack for everyday use.', 'https://example.com/images/backpack.jpg', 69.99, NOW(), 1 as status,'Backpack', 2 as vendor_id) AS tmp
WHERE NOT EXISTS (
    SELECT title FROM product WHERE title = 'Backpack'
) LIMIT 1;

INSERT INTO product (description, image, price, registered_at, status, title, vendor_id)
SELECT * FROM (SELECT 'A warm and waterproof winter coat with a hood.', 'https://example.com/images/winter-coat.jpg', 129.99, NOW(), 1 as status,'Winter Coat', 1 as vendor_id) AS tmp
WHERE NOT EXISTS (
    SELECT title FROM product WHERE title = 'Winter Coat'
) LIMIT 1;

INSERT INTO product (description, image, price, registered_at, status, title, vendor_id)
SELECT * FROM (SELECT 'A soft and comfortable fleece pullover in a bright color.', 'https://example.com/images/fleece-pullover.jpg', 39.99, NOW(), 1 as status,'Fleece Pullover', 2 as vendor_id) AS tmp
WHERE NOT EXISTS (
    SELECT title FROM product WHERE title = 'Fleece Pullover'
) LIMIT 1;

INSERT INTO product (description, image, price, registered_at, status, title, vendor_id)
SELECT * FROM (SELECT 'A pair of stylish and comfortable ankle boots with a low heel.', 'https://example.com/images/ankle-boots.jpg', 99.99, NOW(), 1 as status,'Ankle Boots', 1 as vendor_id) AS tmp
WHERE NOT EXISTS (
    SELECT title FROM product WHERE title = 'Ankle Boots'
) LIMIT 1;

INSERT INTO product (description, image, price, registered_at, status, title, vendor_id)
SELECT * FROM (SELECT 'A comfortable and supportive sports bra for high-impact activities.', 'https://example.com/images/sports-bra.jpg', 34.99, NOW(), 1 as status,'Sports Bra', 2 as vendor_id) AS tmp
WHERE NOT EXISTS (
    SELECT title FROM product WHERE title = 'Sports Bra'
) LIMIT 1;

-- Insert new order types into order_types table if they don't already exist

INSERT INTO order_types (id, type)
SELECT * FROM (SELECT 1 as id, 'full') AS tmp
WHERE NOT EXISTS (
    SELECT id FROM order_types WHERE id = 1
) LIMIT 1;

INSERT INTO order_types (id, type)
SELECT * FROM (SELECT 2 as id,'installment') AS tmp
WHERE NOT EXISTS (
    SELECT id FROM order_types WHERE id = 2
) LIMIT 1;


-- Insert new orders into orders and order details tables is not exists

INSERT INTO orders (id, order_date, order_type_id, price, product_id, status, user_id)
SELECT * FROM ( SELECT 1 as id, NOW() as order_date, 1 as order_type_id, 19.99 as price, 1 as product_id, 1 as status, 1 as user_id) AS tmp
WHERE NOT EXISTS ( SELECT id FROM orders WHERE id = 1 ) LIMIT 1;

INSERT INTO order_installments (id, due_date, order_id, price, paied_date)
SELECT * FROM (SELECT 1 as id, NOW(), 1, 19.99, NOW() as paied_date) AS tmp
WHERE NOT EXISTS ( SELECT id FROM order_installments WHERE id = 1 ) LIMIT 1;

INSERT INTO orders (id, order_date, order_type_id, price, product_id, status, user_id)
SELECT * FROM ( SELECT 2 as id, NOW() as order_date, 2 as order_type_id, 49.9 as price, 2 as product_id, 1 as status, 1 as user_id ) AS tmp
WHERE NOT EXISTS ( SELECT id FROM orders WHERE id = 2 ) LIMIT 1;

INSERT INTO order_installments (id, due_date, order_id, price, paied_date)
SELECT * FROM (SELECT 2 as id, NOW(), 2, 16.63, NOW() as paied_date) AS tmp
WHERE NOT EXISTS ( SELECT id FROM order_installments WHERE id = 2 ) LIMIT 1;

INSERT INTO order_installments (id, due_date, order_id, price)
SELECT * FROM (SELECT 3 as id, DATE_ADD(NOW(), INTERVAL 1 MONTH), 2, 16.63) AS tmp
WHERE NOT EXISTS ( SELECT id FROM order_installments WHERE id = 3 ) LIMIT 1;

INSERT INTO order_installments (id, due_date, order_id, price)
SELECT * FROM (SELECT 4 as id, DATE_ADD(NOW(), INTERVAL 2 MONTH), 2, 16.63) AS tmp
WHERE NOT EXISTS ( SELECT id FROM order_installments WHERE id = 4 ) LIMIT 1;

INSERT INTO orders (id, order_date, order_type_id, price, product_id, status, user_id)
SELECT * FROM ( SELECT 3 as id, NOW() as order_date, 2 as order_type_id, 59.99 as price, 2 as product_id, 1 as status, 2 as user_id ) AS tmp
WHERE NOT EXISTS ( SELECT id FROM orders WHERE id = 3 ) LIMIT 1;

INSERT INTO order_installments (id, due_date, order_id, price, paied_date)
SELECT * FROM (SELECT 5 as id, NOW(), 3, 19.99, NOW() as paied_date) AS tmp
WHERE NOT EXISTS ( SELECT id FROM order_installments WHERE id = 5 ) LIMIT 1;

INSERT INTO order_installments (id, due_date, order_id, price)
SELECT * FROM (SELECT 6 as id, DATE_ADD(NOW(), INTERVAL 1 MONTH), 3, 19.99) AS tmp
WHERE NOT EXISTS ( SELECT id FROM order_installments WHERE id = 6 ) LIMIT 1;

INSERT INTO order_installments (id, due_date, order_id, price)
SELECT * FROM (SELECT 7 as id, DATE_ADD(NOW(), INTERVAL 2 MONTH), 3, 19.99) AS tmp
WHERE NOT EXISTS ( SELECT id FROM order_installments WHERE id = 7 ) LIMIT 1;

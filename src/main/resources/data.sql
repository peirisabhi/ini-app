INSERT INTO user_role (id, role)
SELECT 1, 'Customer'
WHERE NOT EXISTS (SELECT * FROM user_role WHERE id = 1);

INSERT INTO user_role (id, role)
SELECT 3, 'Vendor'
WHERE NOT EXISTS (SELECT * FROM user_role WHERE id = 3);
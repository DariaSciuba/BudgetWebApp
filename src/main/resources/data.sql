INSERT INTO categories(name, type) VALUES ('Food', 'expense');
INSERT INTO categories(name, type) VALUES ('Work', 'income');
INSERT INTO categories(name, type) VALUES ('Home', 'expense');
INSERT INTO categories(name, type) VALUES ('Savings', 'expense');
INSERT INTO categories(name, type) VALUES ('Others', 'expense');

INSERT INTO subcategories(name, category_id) VALUES('Food in work',1);
INSERT INTO subcategories(name, category_id) VALUES('Restuarant',1);
INSERT INTO subcategories(name, category_id) VALUES('Furniture',3);
INSERT INTO subcategories(name, category_id) VALUES('Travel',5);

INSERT INTO expenses(date, subcategory_id, amount, note) VALUES (current_date,2,20.20,'sushi restaurant');
INSERT INTO expenses(date, subcategory_id, amount, note) VALUES (current_date,3,150.00,'wood desk');
INSERT INTO expenses(date, subcategory_id, amount, note) VALUES (current_date,3,50.375,'lamp');


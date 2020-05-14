INSERT INTO categories(name, type) VALUES ('Food', 'expense');
INSERT INTO categories(name, type) VALUES ('Work', 'income');
INSERT INTO categories(name, type) VALUES ('Home', 'expense');
INSERT INTO categories(name, type) VALUES ('Savings', 'expense');
INSERT INTO categories(name, type) VALUES ('Others', 'expense');
INSERT INTO categories(name, type) VALUES ('Bank', 'income');
INSERT INTO categories(name, type) VALUES ('Bonus', 'income');

INSERT INTO subcategories(name, category_id) VALUES('Food in work',1);
INSERT INTO subcategories(name, category_id) VALUES('Restuarant',1);
INSERT INTO subcategories(name, category_id) VALUES('Cococococo',1);
INSERT INTO subcategories(name, category_id) VALUES('Furniture',3);
INSERT INTO subcategories(name, category_id) VALUES('Travel',5);
INSERT INTO subcategories(name, category_id) VALUES('Work full time',2);
INSERT INTO subcategories(name, category_id) VALUES('Bank interest',6);
INSERT INTO subcategories(name, category_id) VALUES('Bonus',7);

INSERT INTO expenses(date, subcategory_id, amount, note) VALUES (current_date,3,20.20,'sushi restaurant');
INSERT INTO expenses(date, subcategory_id, amount, note) VALUES (current_date,4,150.00,'wood desk');
INSERT INTO expenses(date, subcategory_id, amount, note) VALUES (current_date,4,50.375,'lamp');

INSERT INTO incomes(date, subcategory_id, amount, note) VALUES ('2020-01-15',6,2000.00,'salary');
INSERT INTO incomes(date, subcategory_id, amount, note) VALUES ('2020-02-15',6,1000.00,'salary');
INSERT INTO incomes(date, subcategory_id, amount, note) VALUES ('2020-03-15',6,1500.75,null);

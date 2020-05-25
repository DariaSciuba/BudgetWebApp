INSERT INTO accounts(number, type, bank_name, currency, balance) VALUES ('24116000065542393625484713', 'debit', 'Millennium S.A.', 'PLN',2000.00);

INSERT INTO income_sources(company_name, company_address) VALUES ('Others', null);
INSERT INTO income_sources(company_name, company_address) VALUES ('Budimex', null);
INSERT INTO income_sources(company_name, company_address) VALUES ('Panattoni', 'Pl. Europejski 1, Warsaw');

INSERT INTO categories(name, type) VALUES ('Food', 'expense');
INSERT INTO categories(name, type) VALUES ('Work', 'income');
INSERT INTO categories(name, type) VALUES ('Home', 'expense');
INSERT INTO categories(name, type) VALUES ('Savings', 'expense');
INSERT INTO categories(name, type) VALUES ('Others', 'expense');
INSERT INTO categories(name, type) VALUES ('Bank', 'income');
INSERT INTO categories(name, type) VALUES ('Bonus', 'income');

INSERT INTO subcategories(name, category_id) VALUES('Food in work',1);
INSERT INTO subcategories(name, category_id) VALUES('Restaurant',1);
INSERT INTO subcategories(name, category_id) VALUES('Work bonus',7);
INSERT INTO subcategories(name, category_id) VALUES('Furniture',3);
INSERT INTO subcategories(name, category_id) VALUES('Travel',5);
INSERT INTO subcategories(name, category_id) VALUES('Work full time',2);
INSERT INTO subcategories(name, category_id) VALUES('Bank interest',6);

INSERT INTO expenses(date, subcategory_id, amount, note, account_id) VALUES ('2020-02-23',2,20.20,'sushi restaurant',1);
INSERT INTO expenses(date, subcategory_id, amount, note, account_id) VALUES ('2020-05-01',4,150.00,'wood desk',1);
INSERT INTO expenses(date, subcategory_id, amount, note, account_id) VALUES ('2020-05-01',5,1500.00,'plane tickets',1);
INSERT INTO expenses(date, subcategory_id, amount, note, account_id) VALUES ('2020-05-01',4,100.00,'IKEA',1);
INSERT INTO expenses(date, subcategory_id, amount, note, account_id) VALUES ('2020-05-01',4,25.00,'decoration',1);
INSERT INTO expenses(date, subcategory_id, amount, note, account_id) VALUES ('2020-03-06',4,50.37,'lamp',1);
INSERT INTO expenses(date, subcategory_id, amount, note, account_id) VALUES ('2020-04-27',5,125.22, null,1);
INSERT INTO expenses(date, subcategory_id, amount, note, account_id) VALUES ('2020-04-25',5,5.55,null,1);
INSERT INTO expenses(date, subcategory_id, amount, note, account_id) VALUES ('2020-03-28',1,21.37,'dinner',1);

INSERT INTO incomes(date, subcategory_id, amount, note, account_id, income_source_id) VALUES ('2020-01-15',6,2000.00,'salary',1,2);
INSERT INTO incomes(date, subcategory_id, amount, note, account_id, income_source_id) VALUES ('2020-02-15',6,1000.00,'salary',1,2);
INSERT INTO incomes(date, subcategory_id, amount, note, account_id, income_source_id) VALUES ('2020-03-15',6,1500.75,'salary',1,3);
INSERT INTO incomes(date, subcategory_id, amount, note, account_id, income_source_id) VALUES ('2020-01-30',7,15.50,null,1,1);
INSERT INTO incomes(date, subcategory_id, amount, note, account_id, income_source_id) VALUES ('2020-02-04',3,1000.00,'January bonus',1,3);
INSERT INTO incomes(date, subcategory_id, amount, note, account_id, income_source_id) VALUES ('2020-03-05',3,1500.75,'February bonus',1,3);
INSERT INTO incomes(date, subcategory_id, amount, note, account_id, income_source_id) VALUES ('2020-02-28',7,20.20,null,1,1);
INSERT INTO incomes(date, subcategory_id, amount, note, account_id, income_source_id) VALUES ('2020-01-15',7,100.00,'bonus1',1,2);
INSERT INTO incomes(date, subcategory_id, amount, note, account_id, income_source_id) VALUES ('2020-01-15',7,200.00,'bonus2',1,2);
INSERT INTO incomes(date, subcategory_id, amount, note, account_id, income_source_id) VALUES ('2020-01-15',7,300.00,'bonus3',1,2);


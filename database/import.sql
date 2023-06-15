-- users --------------------------------------------------------
INSERT INTO users (registration_code, full_name, email, telephone)
VALUES ('7217507960', 'Wordesworth', 'hwordesworth0@cisco.com', '178-230-7303'),
       ('0125637314', 'Vaughten', 'mvaughten1@bloglovin.com', '673-467-9568'),
       ('7922129637', 'Spolton', 'gspolton2@sogou.com', '702-392-8443'),
       ('5670465105', 'Fake', 'tfake3@si.edu', '681-576-0716'),
       ('0623037912', 'Rate', 'grate4@rambler.ru', '298-334-7691'),
       ('8994544445', 'Beagles', 'abeagles5@wunderground.com', '637-438-9201'),
       ('9925337313', 'Kuscha', 'wkuscha6@flavors.me', '491-419-5163'),
       ('1515590798', 'Weblin', 'wweblin7@newsvine.com', '862-723-1856'),
       ('0049998005', 'Henkmann', 'chenkmann8@yale.edu', '891-837-2340'),
       ('7708056780', 'Gonsalo', 'tgonsalo9@ezinearticles.com', '621-968-2978');


-- products -----------------------------------------------------
INSERT INTO products (name, sku_code, unit_price)
VALUES ('Truffle Cups Green', '3056584191', 0.05),
       ('Water - Aquafina Vitamin', '7463054756', 1.54),
       ('Coconut - Whole', '3724985835', 5.03),
       ('Chestnuts - Whole,canned', '1811855512', 7.77),
       ('Straw - Regular', '0115929045', 8.45),
       ('Shrimp - Black Tiger 13/15', '4609716844', 7.41),
       ('Compound - Strawberry', '5919300388', 9.40),
       ('Appetizer - Spring Roll, Veg', '2017249297', 2.18),
       ('Cake - Cheese Cake 9 Inch', '6262514511', 1.17),
       ('Bar Mix - Pina Colada, 355 Ml', '3201014729', 4.91),
       ('Wine - Beaujolais Villages', '4458386514', 6.78),
       ('Oil - Macadamia', '4234142115', 9.98),
       ('Scallops - 20/30', '1416664637', 7.79),
       ('Beef - Bones, Marrow', '0286458438', 2.36),
       ('Mahi Mahi', '8223956152', 1.39),
       ('Tea - Herbal Sweet Dreams', '6742655690', 7.67),
       ('Sultanas', '7788814091', 2.57),
       ('Artichoke - Hearts, Canned', '3562877161', 5.67),
       ('Dooleys Toffee', '3490178157', 1.28),
       ('Lime Cordial - Roses', '0975536516', 0.90);


-- orders -------------------------------------------------------
INSERT INTO public.orders (id, submission_date, user_id)
VALUES (1, '2023-06-15', 1),
       (2, '2023-06-11', 3),
       (3, '2023-06-05', 3),
       (4, '2023-05-15', 7),
       (5, '2023-06-12', 4),
       (6, '2023-06-12', 2),
       (7, '2023-06-14', 9);

-- order_lines --------------------------------------------------
INSERT INTO public.order_lines (id, quantity, orders_id, products_id)
VALUES (1, 10, 1, 1),
       (2, 11, 1, 10),
       (3, 65, 2, 13),
       (4, 47, 3, 9),
       (5, 76, 4, 6),
       (6, 90, 4, 17),
       (7, 12, 4, 4),
       (8, 1, 5, 1),
       (9, 4, 5, 4),
       (10, 53, 5, 3),
       (11, 25, 5, 2),
       (12, 76, 6, 17),
       (13, 86, 7, 10),
       (14, 47, 7, 4);



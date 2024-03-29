INSERT INTO db_blog.categories(name)VALUES('antipasto');
INSERT INTO db_blog.categories(name)VALUES('primo piatto');
INSERT INTO db_blog.categories(name)VALUES('secondo piatto');
INSERT INTO db_blog.categories(name)VALUES('contorno');
INSERT INTO db_blog.categories(name)VALUES('dessert');



INSERT INTO db_blog.recipes(description, ingredient, photo_url, portion, prep_time_in_minutes, title, category_id, created_at)VALUES('Versare la pasta in acqua bollente, dopo il tempo di cottura necessario scolare. Nel frattempo soffriggere la cipolla, poi aggiungere la passata e far cuocere 10/15 minuti con olio e sale a piacere', '150g di pasta, 500g passata di pomodoro, 1 cipolla, olio q.b., sale q.b.', 'https://www.giallozafferano.it/images/221-22163/Spaghetti-al-pomodoro_650x433_wm.jpg', 2, 20, 'Pasta con sugo di pomodoro',2,'2024-01-08');
INSERT INTO db_blog.recipes(description, ingredient, photo_url, portion, prep_time_in_minutes, title, category_id, created_at)VALUES('Versare la pasta in acqua bollente, dopo il tempo di cottura necessario scolare. Nel frattempo soffriggere preparare il sugo con aglio panna e funghi', '250g di pasta, 500g funghi, 250ml panna, 1 spicchio di aglio, pepe q.b. olio q.b., sale q.b.', 'https://images.fidhouse.com/fidelitynews/wp-content/uploads/sites/6/2016/10/1477575375_ed2f886f6e6ba03493d4d6659066a7d4295405ff-708385388.jpg?width=1280&height=720&quality=80', 3, 25, 'Pasta con funghi',2,'2024-01-09');
INSERT INTO db_blog.recipes(description, ingredient, photo_url, portion, prep_time_in_minutes, title, category_id, created_at)VALUES('Bollire in un pentolino acqua zucchero e limone. Mettere in freezer', '500ml succo di limone, 500ml acqua, 250g zucchero', 'https://www.giallozafferano.it/images/20-2033/Granita-al-limone-senza-gelatiera_780x520_wm.jpg', 2, 10, 'Granita al limone',5,'2024-01-11');
INSERT INTO db_blog.recipes(description, ingredient, photo_url, portion, prep_time_in_minutes, title, category_id, created_at)VALUES('impastare e infornare', '400g farina 00, 250g farina, 20g olio, 5g sale fino, 300g acqua a temperatura ambiente, 4g lievito di birra fresco ', 'https://www.giallozafferano.it/images/168-16876/Focaccia_650x433_wm.jpg', 6, 50, 'Focaccia',1,'2024-01-12');

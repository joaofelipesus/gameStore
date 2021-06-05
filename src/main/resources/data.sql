-- CONSOLES

insert into console (name) values ('Play Station 4');
insert into console (name) values ('XBox ONe');
insert into console (name) values ('Nintendo Switch');

-- CATEGORIES

insert into category (name) values ('Shooter');
insert into category (name) values ('Puzzle');
insert into category (name) values ('Survival Horror');

-- GAMES

insert into game (title, price, category_id, console_id) values ('Resudent Evil 2 Remake', 299.90, 3, 1);
insert into game (title, price, category_id, console_id) values ('God of war', 299.90, 2, 1);
insert into game (title, price, category_id, console_id) values ('Alan wake', 299.90, 1, 1);
insert into game (title, price, category_id, console_id) values ('Gears of war', 299.90, 3, 1);
insert into game (title, price, category_id, console_id) values ('Zelda', 399.90, 2, 3);
insert into game (title, price, category_id, console_id) values ('Mario World', 199.90, 2, 3);
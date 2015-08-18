insert into library (id, lib_name) values (1, 'Biblioteka Kongresu');
insert into library (id, lib_name) values (2, 'Ossolineum');
insert into library (id, lib_name) values (3, 'Biblioteka Miejska w Erywaniu');
insert into library (id, lib_name) values (4, 'Antykwariat');

insert into book (id, title, lib_id) values (1, 'Roundhouse Kick', 1);
insert into book (id, title, lib_id) values (2, 'Me, Myself and I', 3);
insert into book (id, title, lib_id) values (3, 'Camino de Muerte', 2);
insert into book (id, title, lib_id) values (4, 'Korek', 4);
insert into book (id, title, lib_id) values (5, 'Berzdej party', 2);
insert into book (id, title, lib_id) values (6, 'Ewrybady pomarancze', 2);
insert into book (id, title, lib_id) values (7, 'Jak zrazac do siebie ludzi', 4);
insert into book (id, title, lib_id) values (8, 'OK puta lets go', 2);
insert into book (id, title, lib_id) values (9, 'Katapulty i kotlety', 4);
insert into book (id, title, lib_id) values (10, 'Sermaci', 2);
insert into book (id, title, lib_id) values (11, 'Man With Silver', 3);


insert into author (id, first_name, last_name) values (1, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (2, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (3, 'Prym', 'Babinski');
insert into author (id, first_name, last_name) values (4, 'Apoloniusz', 'Matula');
insert into author (id, first_name, last_name) values (5, 'Gvozden', 'Sholokhov');
insert into author (id, first_name, last_name) values (6, 'Sobieslaw', 'Chaykovskiy');
insert into author (id, first_name, last_name) values (7, 'Mislav', 'Gospod');
insert into author (id, first_name, last_name) values (8, 'Karol', 'Kuzio');
insert into author (id, first_name, last_name) values (9, 'Janusz', 'Jankowski');
insert into author (id, first_name, last_name) values (10, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (11, 'Zbigniew', 'Nowak');


insert into book_author(book_id, author_id) values (1, 7);
insert into book_author(book_id, author_id) values (2, 8);
insert into book_author(book_id, author_id) values (3, 9);
insert into book_author(book_id, author_id) values (4, 10);
insert into book_author(book_id, author_id) values (5, 11);
insert into book_author(book_id, author_id) values (6, 1);
insert into book_author(book_id, author_id) values (7, 2);
insert into book_author(book_id, author_id) values (8, 3);
insert into book_author(book_id, author_id) values (9, 4);
insert into book_author(book_id, author_id) values (10, 5);
insert into book_author(book_id, author_id) values (11, 6);



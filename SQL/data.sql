INSERT INTO USER
    (username, password, first_name, last_name, street, city, state, zipcode, email,phone)
VALUES
       ('user1', '333','Daisy','Saulsberry','7769 Windfall St.','Cartersville', 'GA', '30120','kspiteri@verizon.net','(875)283-6533'),
       ('user2', '333','Tasia','Uhrig','433 Jones Court', 'Youngstown', 'OH', '44512','syrinx@me.com','(714)449-6291'),
       ('user3', '333', 'Albert','Blaschke','91 Hill Field Avenue', 'Cincinnati', 'OH', '45211','solomon@yahoo.ca','(970)156-4910'),
       ('user4', '333', 'Marquis','Reinhold','392 Yukon Dr.', 'Murfreesboro', 'TN', '37128','quantaman@comcast.net','(185) 782-9454');


INSERT INTO MPAA_RATING (mpaa_id, mpaa_name)
VALUES
(1, "G"),
(2, "PG"),
(3, "PG-13"),
(4, "R"),
(5, "NC-17");

INSERT INTO GENRE (genre_id, genre_name)
VALUES
(1, "Action"),
(2, "Adventure"),
(3, "Comedy"),
(4, "Crime"),
(5, "Drama"),
(6, "Fantacy"),
(7, "Historical"),
(8, "Historical Fiction"),
(9, "Horror"),
(10, "Mystery"),
(11, "Political"),
(12, "Romance"),
(13, "Science Fiction"),
(14, "Triller"),
(15, "Western");

INSERT INTO `MOVIE` VALUES (1,'Kids for Cash',
  'Curabitur at ipsum ac tellus semper interdum. Mauris ullamcorper purus sit amet nulla.
  Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.',
  'https://www.youtube.com/embed/Nx46GJLT-Xs','https://image.ibb.co/b0qB8c/32.jpg','2018-01-06',3,'PG-13',114,5.0,7.3,'Gaumount Film Company','Iran',1),
(2,'Heartbreaker (L\'Arnacoeur)','Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam,
  sollicitudin vitae, consectetuer eget, rutrum at, lorem.',
  'https://www.youtube.com/embed/eAKrgwCnkGM','https://image.ibb.co/b6nf1x/13.jpg','2018-01-05',3,'PG-13',146,5.0,8.1,'Nordisk Film','United Kingdom',1),
(3,'Apt Pupil','Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in,
 leo. Maecenas pulvinar lobortis est.','https://www.youtube.com/embed/zR6kV-s2Qn0','https://image.ibb.co/bSmvZH/30.jpg','2018-03-02',4,'R',94,5.0,8.1,'Gaumount Film Company','United States',1),
(4,'Age of the Medici, The (L\'età di Cosimo de Medici)','Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.',
  'https://www.youtube.com/embed/kUBowkexpkE','https://image.ibb.co/bwHDMx/62.jpg','2018-05-13',3,'PG-13',94,5.0,5.6,'20th Century Fox','Bangladesh',1),
(5,'Redemption: The Stan Tookie Williams Story','Phasellus in felis. Donec semper sapien a libero. Nam dui.',
  'https://www.youtube.com/embed/tBgIEX2P07g','https://image.ibb.co/c8VYMx/40.jpg','2018-04-12',1,'G',102,5.0,7.5,'Paramount Pictures','Nepal',1),
(6,'Railway Man, The','In congue. Etiam justo. Etiam pretium iaculis justo.','https://www.youtube.com/embed/LAT1lf8iViw',
  'https://image.ibb.co/cjCkZH/2.jpg','2018-03-31',3,'PG-13',96,5.0,3.8,'Columbia Pictures','China',1),
(7,'Road to Rio','Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue.
 Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra,
 magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi. Integer ac neque.',
 'https://www.youtube.com/embed/rAUOdcvkGnY','https://image.ibb.co/cKrvZH/60.jpg','2018-03-04',1,'G',141,5.0,9.1,'Warner Bros. Pictures','United States',1),
(8,'Dance Flick','Aliquam quis turpis eget elit sodales scelerisque. Mauris sit amet eros. Suspendisse accumsan tortor quis turpis.',
  'https://www.youtube.com/embed/D9joM600LKA','https://image.ibb.co/cmu4Tc/9.jpg','2018-02-13',1,'G',118,5.0,8.3,'Paramount Pictures','Korea',1),
(9,'Navy Seals','In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis,
 lectus.','https://www.youtube.com/embed/KhKpA7LQlUA','https://image.ibb.co/crmjTc/37.jpg','2018-05-04',2,'PG',106,5.0,3.8,'STXfilms','Pakistan',1),
(10,'Memphis Belle: A Story of a Flying Fortress, The','Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.',
  'https://www.youtube.com/embed/5WWC0GTP08w','https://image.ibb.co/cY3ngx/16.jpg','2018-01-14',1,'G',115,5.0,4.7,'Gaumount Film Company','Iran',1);

insert into MOVIE_CHARACTER (movie_id, character_name) values (1, 'Beauregard Teal');
insert into MOVIE_CHARACTER (movie_id, character_name) values (2, 'Harmonia Storck');
insert into MOVIE_CHARACTER (movie_id, character_name) values (2, 'Persis Wilman');
insert into MOVIE_CHARACTER (movie_id, character_name) values (3, 'Thorpe Edgeley');
insert into MOVIE_CHARACTER (movie_id, character_name) values (4, 'Dave Drezzer');
insert into MOVIE_CHARACTER (movie_id, character_name) values (3, 'Antone Pershouse');
insert into MOVIE_CHARACTER (movie_id, character_name) values (3, 'Sabra Le Franc');
insert into MOVIE_CHARACTER (movie_id, character_name) values (3, 'Elias Costellow');
insert into MOVIE_CHARACTER (movie_id, character_name) values (3, 'Arlana D''Ambrosi');
insert into MOVIE_CHARACTER (movie_id, character_name) values (3, 'Web Balham');
insert into MOVIE_CHARACTER (movie_id, character_name) values (2, 'Deeanne Parsonson');
insert into MOVIE_CHARACTER (movie_id, character_name) values (1, 'Lionello Lemon');
insert into MOVIE_CHARACTER (movie_id, character_name) values (1, 'Harwell Keohane');
insert into MOVIE_CHARACTER (movie_id, character_name) values (1, 'Falkner Swanborough');
insert into MOVIE_CHARACTER (movie_id, character_name) values (1, 'Rozalie Reinbach');
insert into MOVIE_CHARACTER (movie_id, character_name) values (1, 'Melinda Tomsen');
insert into MOVIE_CHARACTER (movie_id, character_name) values (7, 'Kristi Gores');
insert into MOVIE_CHARACTER (movie_id, character_name) values (7, 'Sula Johanning');

insert into MOVIE_GENRE (movie_id, genre_id) values (1, 10);
insert into MOVIE_GENRE (movie_id, genre_id) values (1, 13);
insert into MOVIE_GENRE (movie_id, genre_id) values (1, 3);
insert into MOVIE_GENRE (movie_id, genre_id) values (1, 7);
insert into MOVIE_GENRE (movie_id, genre_id) values (1, 9);
insert into MOVIE_GENRE (movie_id, genre_id) values (10, 2);
insert into MOVIE_GENRE (movie_id, genre_id) values (10, 3);
insert into MOVIE_GENRE (movie_id, genre_id) values (10, 5);

  
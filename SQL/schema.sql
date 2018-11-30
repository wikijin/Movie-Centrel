DROP DATABASE IF EXISTS dos;
CREATE DATABASE dos;
USE dos;


CREATE TABLE USER
(
  user_id     INT PRIMARY KEY AUTO_INCREMENT,
  username    VARCHAR(20) UNIQUE NOT NULL,
  password    VARCHAR(100) NOT NULL,
  first_name  VARCHAR(30),
  last_name   VARCHAR(30),
  street      VARCHAR(100),
  city        VARCHAR(30),
  state       CHAR(2),
  zipcode     CHAR(5),
  phone       CHAR(15),
  email       VARCHAR(50) NOT NULL,
  image_url   VARCHAR(100),
  role        INTEGER NOT NULL DEFAULT 1,
  card_num    VARCHAR(20),
  card_cvv    VARCHAR(4),
  card_expire DATE
);

CREATE TABLE GENRE
(
  genre_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  genre_name VARCHAR(30)
);

CREATE TABLE MPAA_RATING
(
  mpaa_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  mpaa_name VARCHAR(10)
);

CREATE TABLE MOVIE
(
  movie_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  movie_title VARCHAR(100) NOT NULL,
  movie_desc VARCHAR(500),
  trailer_url VARCHAR(200),
  cover_image_url VARCHAR(200),
  release_date DATE,
  mpaa_id INTEGER,
  mpaa_rating VARCHAR(10),
  length INTEGER,
  stars DECIMAL(2,1) DEFAULT 5.0,
  movie_price DECIMAL(2,1),
  studio VARCHAR(20),
  country VARCHAR(20),
  FOREIGN KEY (mpaa_id) REFERENCES MPAA_RATING(mpaa_id)
);

CREATE TABLE MOVIE_IMAGE
(
  image_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  movie_id INTEGER,
  image_title VARCHAR(50),
  image_desc VARCHAR(500),
  image_url VARCHAR(200),
  FOREIGN KEY (movie_id) REFERENCES MOVIE(movie_id)
);

CREATE TABLE MOVIE_CHARACTER
(
  character_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  movie_id INTEGER,
  character_name VARCHAR(50),
  FOREIGN KEY (movie_id) REFERENCES MOVIE(movie_id)
);

CREATE TABLE MOVIE_DIRECTOR
(
  director_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  movie_id INTEGER,
  director_name VARCHAR(50),
  FOREIGN KEY (movie_id) REFERENCES MOVIE(movie_id)
);

CREATE TABLE MOVIE_GENRE
(
  movie_genre_id INTEGER PRIMARY KEY AUTO_INCREMENT,
  movie_id INTEGER,
  genre_id INTEGER,
  FOREIGN KEY (genre_id) REFERENCES GENRE(genre_id),
  FOREIGN KEY (movie_id) REFERENCES MOVIE(movie_id),
  UNIQUE movie_genre_uniq (genre_id, movie_id)
);


CREATE TABLE MOVIE_REVIEW
(
    review_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    movie_id INTEGER,
    user_id INTEGER,
    review_title VARCHAR(100),
    stars INTEGER,
    comment VARCHAR(10000),
    post_date DATE,
    FOREIGN KEY (user_id) REFERENCES USER(user_id),
    FOREIGN KEY (movie_id) REFERENCES MOVIE(movie_id)

);







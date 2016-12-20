
CREATE TABLE USERS(
   USER_ID  SERIAL NOT NULL PRIMARY KEY,
   FIRSTNAME      VARCHAR(30) NOT NULL,
   LASTNAME       VARCHAR(30) NOT NULL,
   EMAIL          VARCHAR(50) UNIQUE,
   PASSWORD       VARCHAR(50)
);
CREATE TABLE USERROLE (
  ROLE_ID SERIAL NOT NULL PRIMARY KEY,
  USER_ID INTEGER REFERENCES USERS (USER_ID),
  ROLE varchar(45) NOT NULL,
  UNIQUE (ROLE,USER_ID)
);

CREATE TABLE READERPASSPORTSSTATE(
  STATE_ID  SERIAL NOT NULL PRIMARY KEY,
  NAME VARCHAR(50),
  DESCRIPTION TEXT
);

CREATE TABLE READERPASSPORT(
   PASSPORT_ID  SERIAL NOT NULL PRIMARY KEY,
   USER_ID INTEGER     REFERENCES USERS (USER_ID),
   STATE INTEGER REFERENCES READERPASSPORTSSTATE (STATE_ID)
 );

CREATE TABLE BOOKCATEGORY(
  CATEGORY_ID  SERIAL NOT NULL PRIMARY KEY,
  NAME VARCHAR(50),
  DESCRIPTION TEXT
);

CREATE TABLE BOOK(
   BOOK_ID  SERIAL NOT NULL PRIMARY KEY,
   TITLE      VARCHAR(50)      NOT NULL,
   AUTHOR       VARCHAR(50)       NOT NULL,
   CATEGORY INTEGER REFERENCES BOOKCATEGORY (CATEGORY_ID)
);

CREATE TABLE LIBRARY(
  ID  SERIAL NOT NULL PRIMARY KEY,
  PASSPORT_ID INTEGER     REFERENCES READERPASSPORT (PASSPORT_ID),
  BOOK_ID INTEGER REFERENCES BOOK (BOOK_ID),
  STATE INTEGER NOT NULL DEFAULT 0
);

INSERT INTO USERS(FIRSTNAME, LASTNAME, EMAIL, PASSWORD)
VALUES
    ('Mike', 'Lomakin', 'whitelamer@mail.ru', '123456');
INSERT INTO USERS(FIRSTNAME, LASTNAME, EMAIL, PASSWORD)
VALUES
    ('Babulka', 'Zlaya', 'library@mail.ru', '111111');
INSERT INTO READERPASSPORTSSTATE(NAME,  DESCRIPTION)
VALUES
('opened','opened');

INSERT INTO READERPASSPORTSSTATE(NAME,  DESCRIPTION)
VALUES
('closed','closed');

INSERT INTO READERPASSPORTSSTATE(NAME,  DESCRIPTION)
VALUES
('paused','paused before returning book');

INSERT INTO READERPASSPORT(USER_ID, STATE)
VALUES
    (5, 0);
INSERT INTO READERPASSPORT(USER_ID, STATE)
VALUES
    (6, 0);

INSERT INTO USERROLE(USER_ID, ROLE)
VALUES
    (5, 'USER');
INSERT INTO USERROLE(USER_ID, ROLE)
VALUES
    (6, 'ADMIN');

INSERT INTO public.bookcategory(
  name, description)
VALUES ('Science fiction', ' '),
  ('Satire', ' '),
  ('Drama', ' '),
  ('Action and Adventure', ' '),
  ('Romance', ' '),
  ('Mystery', ' '),
  ('Horror', ' '),
  ('Self help', ' '),
  ('Health', ' '),
  ('Guide', ' '),
  ('Travel', ' '),
  ('Children', ' '),
  ('Religion, Spirituality & New Age', ' '),
  ('Science', ' '),
  ('History', ' '),
  ('Math', ' '),
  ('Anthology', ' '),
  ('Poetry', ' '),
  ('Encyclopedias', ' '),
  ('Dictionaries', ' '),
  ('Comics', ' '),
  ('Art', ' '),
  ('Cookbooks', ' '),
  ('Diaries', ' '),
  ('Journals', ' '),
  ('Prayer books', ' '),
  ('Series', ' '),
  ('Trilogy', ' '),
  ('Biographies', ' '),
  ('Autobiographies', ' '),
  ('Fantasy', ' ');

 select * from USERS u join READERPASSPORTS p on u.id = p.user_id where u.EMAIL='library@mail.ru'
--------------------------------------------------------
--  File created - вторник-декабря-12-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence BOOK_CATALOG_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##DENIS"."BOOK_CATALOG_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence INVENTORY_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "C##DENIS"."INVENTORY_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence LOANS_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "C##DENIS"."LOANS_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence PENALTIES_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##DENIS"."PENALTIES_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 13 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "C##DENIS"."USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 45 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table AUTHORS
--------------------------------------------------------

  CREATE TABLE "C##DENIS"."AUTHORS" 
   (	"AUTHOR_NAME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BOOK_CATALOG
--------------------------------------------------------

  CREATE TABLE "C##DENIS"."BOOK_CATALOG" 
   (	"BOOK_ID" NUMBER, 
	"TITLE" VARCHAR2(255 BYTE), 
	"YEAR_PUBLISHED" NUMBER, 
	"AUTHOR_NAME" VARCHAR2(255 BYTE), 
	"GENRE_NAME" VARCHAR2(255 BYTE), 
	"PUBLISHER_NAME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table BOOK_INVENTORY
--------------------------------------------------------

  CREATE TABLE "C##DENIS"."BOOK_INVENTORY" 
   (	"INVENTORY_ID" NUMBER DEFAULT "C##DENIS"."INVENTORY_SEQUENCE"."NEXTVAL", 
	"BOOK_ID" NUMBER, 
	"LOCATION" VARCHAR2(100 BYTE), 
	"STATUS" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table GENRES
--------------------------------------------------------

  CREATE TABLE "C##DENIS"."GENRES" 
   (	"GENRE_NAME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table LOANS
--------------------------------------------------------

  CREATE TABLE "C##DENIS"."LOANS" 
   (	"LOAN_ID" NUMBER DEFAULT "C##DENIS"."LOANS_SEQUENCE"."NEXTVAL", 
	"INVENTORY_ID" NUMBER, 
	"READER_ID" NUMBER, 
	"LOAN_DATE" DATE, 
	"DUE_DATE" DATE, 
	"RETURN_DATE" DATE, 
	"STATUS" VARCHAR2(20 BYTE), 
	"LIBRARIAN_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PENALTIES
--------------------------------------------------------

  CREATE TABLE "C##DENIS"."PENALTIES" 
   (	"PENALTY_ID" NUMBER DEFAULT "C##DENIS"."PENALTIES_SEQ"."NEXTVAL", 
	"READER_ID" NUMBER, 
	"VALIDITY" NUMBER, 
	"REASON" VARCHAR2(255 BYTE), 
	"PENALTY_DATE" DATE, 
	"EXPIRATION_DATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PUBLISHERS
--------------------------------------------------------

  CREATE TABLE "C##DENIS"."PUBLISHERS" 
   (	"PUBLISHER_NAME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "C##DENIS"."USERS" 
   (	"ID" NUMBER DEFAULT "C##DENIS"."USERS_SEQ"."NEXTVAL", 
	"TYPE" VARCHAR2(50 BYTE), 
	"LOGIN" VARCHAR2(50 BYTE), 
	"PASSWORD" VARCHAR2(50 BYTE), 
	"STATUS" VARCHAR2(50 BYTE), 
	"NAME" VARCHAR2(200 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into C##DENIS.AUTHORS
SET DEFINE OFF;
Insert into C##DENIS.AUTHORS (AUTHOR_NAME) values ('Агата Кристи');
Insert into C##DENIS.AUTHORS (AUTHOR_NAME) values ('Александр Пушкин');
Insert into C##DENIS.AUTHORS (AUTHOR_NAME) values ('Габриэль Гарсиа Маркес');
Insert into C##DENIS.AUTHORS (AUTHOR_NAME) values ('Джейн Остин');
Insert into C##DENIS.AUTHORS (AUTHOR_NAME) values ('Джордж Оруэлл');
Insert into C##DENIS.AUTHORS (AUTHOR_NAME) values ('Иван Тургенев');
Insert into C##DENIS.AUTHORS (AUTHOR_NAME) values ('Лев Толстой');
Insert into C##DENIS.AUTHORS (AUTHOR_NAME) values ('Маргарет Митчелл');
Insert into C##DENIS.AUTHORS (AUTHOR_NAME) values ('Федор Достоевский');
Insert into C##DENIS.AUTHORS (AUTHOR_NAME) values ('Эрих Мария Ремарк');
REM INSERTING into C##DENIS.BOOK_CATALOG
SET DEFINE OFF;
Insert into C##DENIS.BOOK_CATALOG (BOOK_ID,TITLE,YEAR_PUBLISHED,AUTHOR_NAME,GENRE_NAME,PUBLISHER_NAME) values ('1','Евгений Онегин','1833','Александр Пушкин','Роман','Издательство АСТ');
Insert into C##DENIS.BOOK_CATALOG (BOOK_ID,TITLE,YEAR_PUBLISHED,AUTHOR_NAME,GENRE_NAME,PUBLISHER_NAME) values ('2','Война и мир','1869','Лев Толстой','Исторический роман','Эксмо');
Insert into C##DENIS.BOOK_CATALOG (BOOK_ID,TITLE,YEAR_PUBLISHED,AUTHOR_NAME,GENRE_NAME,PUBLISHER_NAME) values ('3','Преступление и наказание','1866','Федор Достоевский','Детектив','ACT');
Insert into C##DENIS.BOOK_CATALOG (BOOK_ID,TITLE,YEAR_PUBLISHED,AUTHOR_NAME,GENRE_NAME,PUBLISHER_NAME) values ('5','1984','1949','Джордж Оруэлл','Научная литература','Манн, Иванов и Фербер');
Insert into C##DENIS.BOOK_CATALOG (BOOK_ID,TITLE,YEAR_PUBLISHED,AUTHOR_NAME,GENRE_NAME,PUBLISHER_NAME) values ('6','Гордость и предубеждение','1813','Джейн Остин','Роман','Попурри');
Insert into C##DENIS.BOOK_CATALOG (BOOK_ID,TITLE,YEAR_PUBLISHED,AUTHOR_NAME,GENRE_NAME,PUBLISHER_NAME) values ('9','Анна Каренина','1877','Лев Толстой','Роман','Московский рабочий');
REM INSERTING into C##DENIS.BOOK_INVENTORY
SET DEFINE OFF;
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('1','1','Стеллаж А','AVAILABLE');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('2','2','Стеллаж Б','AVAILABLE');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('3','3','Стеллаж В','ON_REPAIR');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('5','5','Стеллаж Д','AVAILABLE');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('6','6','Стеллаж Е','LOST');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('9','9','Стеллаж И','AVAILABLE');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('11','1','Стеллаж А','AVAILABLE');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('12','2','Стеллаж Б','AVAILABLE');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('13','3','Стеллаж В','ON_REPAIR');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('15','5','Стеллаж Д','AVAILABLE');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('16','6','Стеллаж Е','LOST');
Insert into C##DENIS.BOOK_INVENTORY (INVENTORY_ID,BOOK_ID,LOCATION,STATUS) values ('19','9','Стеллаж И','AVAILABLE');
REM INSERTING into C##DENIS.GENRES
SET DEFINE OFF;
Insert into C##DENIS.GENRES (GENRE_NAME) values ('Детектив');
Insert into C##DENIS.GENRES (GENRE_NAME) values ('Исторический роман');
Insert into C##DENIS.GENRES (GENRE_NAME) values ('Классика');
Insert into C##DENIS.GENRES (GENRE_NAME) values ('Научная литература');
Insert into C##DENIS.GENRES (GENRE_NAME) values ('Поэзия');
Insert into C##DENIS.GENRES (GENRE_NAME) values ('Приключения');
Insert into C##DENIS.GENRES (GENRE_NAME) values ('Психология');
Insert into C##DENIS.GENRES (GENRE_NAME) values ('Роман');
Insert into C##DENIS.GENRES (GENRE_NAME) values ('Фантастика');
Insert into C##DENIS.GENRES (GENRE_NAME) values ('Фэнтези');
REM INSERTING into C##DENIS.LOANS
SET DEFINE OFF;
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('1','1','3',to_date('05.01.23','DD.MM.RR'),to_date('15.01.23','DD.MM.RR'),null,'ISSUED','2');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('2','2','1',to_date('10.02.23','DD.MM.RR'),to_date('20.02.23','DD.MM.RR'),null,'RETURNED','2');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('3','3','2',to_date('15.03.23','DD.MM.RR'),to_date('25.03.23','DD.MM.RR'),null,'ISSUED','1');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('5','5','5',to_date('05.05.23','DD.MM.RR'),to_date('15.05.23','DD.MM.RR'),null,'ISSUED','4');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('6','6','7',to_date('10.06.23','DD.MM.RR'),to_date('20.06.23','DD.MM.RR'),null,'ISSUED','6');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('9','9','9',to_date('25.09.23','DD.MM.RR'),to_date('05.10.23','DD.MM.RR'),null,'ISSUED','9');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('11','1','3',to_date('05.01.23','DD.MM.RR'),to_date('15.01.23','DD.MM.RR'),null,'ISSUED','2');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('12','2','1',to_date('10.02.23','DD.MM.RR'),to_date('20.02.23','DD.MM.RR'),null,'RETURNED','2');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('13','3','2',to_date('15.03.23','DD.MM.RR'),to_date('25.03.23','DD.MM.RR'),null,'ISSUED','1');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('15','5','5',to_date('05.05.23','DD.MM.RR'),to_date('15.05.23','DD.MM.RR'),null,'ISSUED','4');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('16','6','7',to_date('10.06.23','DD.MM.RR'),to_date('20.06.23','DD.MM.RR'),null,'ISSUED','6');
Insert into C##DENIS.LOANS (LOAN_ID,INVENTORY_ID,READER_ID,LOAN_DATE,DUE_DATE,RETURN_DATE,STATUS,LIBRARIAN_ID) values ('19','9','9',to_date('25.09.23','DD.MM.RR'),to_date('05.10.23','DD.MM.RR'),null,'ISSUED','9');
REM INSERTING into C##DENIS.PENALTIES
SET DEFINE OFF;
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('1','1','5','Просрочка',to_date('25.02.23','DD.MM.RR'),to_date('25.03.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('2','2','3','Повреждение книги',to_date('10.04.23','DD.MM.RR'),to_date('20.04.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('3','3','7','Утеря книги',to_date('20.06.23','DD.MM.RR'),to_date('20.07.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('4','4','4','Повреждение обложки',to_date('05.08.23','DD.MM.RR'),to_date('09.08.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('5','5','6','Просрочка',to_date('15.10.23','DD.MM.RR'),to_date('21.10.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('6','6','2','Повреждение страниц',to_date('30.11.23','DD.MM.RR'),to_date('02.12.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('7','1','5','Просрочка',to_date('25.02.23','DD.MM.RR'),to_date('25.03.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('8','2','3','Повреждение книги',to_date('10.04.23','DD.MM.RR'),to_date('20.04.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('9','3','7','Утеря книги',to_date('20.06.23','DD.MM.RR'),to_date('20.07.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('10','4','4','Повреждение обложки',to_date('05.08.23','DD.MM.RR'),to_date('09.08.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('11','5','6','Просрочка',to_date('15.10.23','DD.MM.RR'),to_date('21.10.23','DD.MM.RR'));
Insert into C##DENIS.PENALTIES (PENALTY_ID,READER_ID,VALIDITY,REASON,PENALTY_DATE,EXPIRATION_DATE) values ('12','6','2','Повреждение страниц',to_date('30.11.23','DD.MM.RR'),to_date('02.12.23','DD.MM.RR'));
REM INSERTING into C##DENIS.PUBLISHERS
SET DEFINE OFF;
Insert into C##DENIS.PUBLISHERS (PUBLISHER_NAME) values ('ACT');
Insert into C##DENIS.PUBLISHERS (PUBLISHER_NAME) values ('Альпина Паблишер');
Insert into C##DENIS.PUBLISHERS (PUBLISHER_NAME) values ('Издательство АСТ');
Insert into C##DENIS.PUBLISHERS (PUBLISHER_NAME) values ('КоЛибри');
Insert into C##DENIS.PUBLISHERS (PUBLISHER_NAME) values ('Манн, Иванов и Фербер');
Insert into C##DENIS.PUBLISHERS (PUBLISHER_NAME) values ('Московский рабочий');
Insert into C##DENIS.PUBLISHERS (PUBLISHER_NAME) values ('Попурри');
Insert into C##DENIS.PUBLISHERS (PUBLISHER_NAME) values ('Просвещение');
Insert into C##DENIS.PUBLISHERS (PUBLISHER_NAME) values ('Рипол Классик');
Insert into C##DENIS.PUBLISHERS (PUBLISHER_NAME) values ('Эксмо');
REM INSERTING into C##DENIS.USERS
SET DEFINE OFF;
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('1','ADMIN','админ1','пароль123','ACTIVE','Администратор Алексей');
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('2','LIBRARIAN','библиотекарь1','lib456','ACTIVE','Елена Библиотекарева');
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('3','READER','читатель99','pass321','ACTIVE','Иван Читательский');
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('4','READER','любознательная_анна','anna2023','ACTIVE','Анна Семенова');
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('5','ADMIN','admin_kate','kateadmin','ACTIVE','Катя Админова');
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('6','LIBRARIAN','lib_ivanov','lib2023','ACTIVE','Иван Иванов');
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('7','READER','bookworm23','librarypass','ACTIVE','Александра Книжная');
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('8','READER','readingjoe','joe2023','ACTIVE','Джо Ридер');
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('9','ADMIN','администратор_петр','adminpetr','ACTIVE','Петр Петров');
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('10','LIBRARIAN','lib_maria','maria_library','ACTIVE','Мария Либрари');
Insert into C##DENIS.USERS (ID,TYPE,LOGIN,PASSWORD,STATUS,NAME) values ('11','READER','booklover','read2023','ACTIVE','Ольга Читалкина');
--------------------------------------------------------
--  DDL for Index PK_AUTHORS
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##DENIS"."PK_AUTHORS" ON "C##DENIS"."AUTHORS" ("AUTHOR_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_BOOK_CATALOG
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##DENIS"."PK_BOOK_CATALOG" ON "C##DENIS"."BOOK_CATALOG" ("BOOK_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_GENRES
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##DENIS"."PK_GENRES" ON "C##DENIS"."GENRES" ("GENRE_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_LOANS
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##DENIS"."PK_LOANS" ON "C##DENIS"."LOANS" ("LOAN_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PENALTIES
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##DENIS"."PK_PENALTIES" ON "C##DENIS"."PENALTIES" ("PENALTY_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PUBLISHERS
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##DENIS"."PK_PUBLISHERS" ON "C##DENIS"."PUBLISHERS" ("PUBLISHER_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table GENRES
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."GENRES" MODIFY ("GENRE_NAME" NOT NULL ENABLE);
  ALTER TABLE "C##DENIS"."GENRES" ADD CONSTRAINT "PK_GENRES" PRIMARY KEY ("GENRE_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table AUTHORS
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."AUTHORS" MODIFY ("AUTHOR_NAME" NOT NULL ENABLE);
  ALTER TABLE "C##DENIS"."AUTHORS" ADD CONSTRAINT "PK_AUTHORS" PRIMARY KEY ("AUTHOR_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table LOANS
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."LOANS" MODIFY ("LOAN_ID" NOT NULL ENABLE);
  ALTER TABLE "C##DENIS"."LOANS" ADD CONSTRAINT "CHECK_LOAN_STATUS" CHECK (STATUS IN ('RESERVED', 'ISSUED', 'RETURNED')) ENABLE;
  ALTER TABLE "C##DENIS"."LOANS" ADD CONSTRAINT "CHK_LOANS_DATES" CHECK (LOAN_DATE <= DUE_DATE AND (RETURN_DATE IS NULL OR RETURN_DATE <= DUE_DATE)) ENABLE;
  ALTER TABLE "C##DENIS"."LOANS" ADD CONSTRAINT "PK_LOANS" PRIMARY KEY ("LOAN_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."USERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "C##DENIS"."USERS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "C##DENIS"."USERS" ADD CONSTRAINT "CHECK_USER_TYPE" CHECK (TYPE IN ('LIBRARIAN', 'ADMIN', 'READER')) ENABLE;
  ALTER TABLE "C##DENIS"."USERS" ADD CONSTRAINT "CHECK_USER_STATUS" CHECK (STATUS IN ('ACTIVE', 'SUSPENDED')) ENABLE;
  ALTER TABLE "C##DENIS"."USERS" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PUBLISHERS
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."PUBLISHERS" MODIFY ("PUBLISHER_NAME" NOT NULL ENABLE);
  ALTER TABLE "C##DENIS"."PUBLISHERS" ADD CONSTRAINT "PK_PUBLISHERS" PRIMARY KEY ("PUBLISHER_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table BOOK_INVENTORY
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."BOOK_INVENTORY" MODIFY ("INVENTORY_ID" NOT NULL ENABLE);
  ALTER TABLE "C##DENIS"."BOOK_INVENTORY" ADD CONSTRAINT "CHECK_BOOK_STATUS" CHECK (STATUS IN ('LOST', 'AVAILABLE', 'ON_REPAIR', 'SCRAPPED', 'RESERVED')) ENABLE;
  ALTER TABLE "C##DENIS"."BOOK_INVENTORY" ADD PRIMARY KEY ("INVENTORY_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PENALTIES
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."PENALTIES" MODIFY ("PENALTY_ID" NOT NULL ENABLE);
  ALTER TABLE "C##DENIS"."PENALTIES" ADD CONSTRAINT "CHK_PENALTIES_AMOUNT" CHECK (VALIDITY >= 0) ENABLE;
  ALTER TABLE "C##DENIS"."PENALTIES" ADD CONSTRAINT "PK_PENALTIES" PRIMARY KEY ("PENALTY_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table BOOK_CATALOG
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."BOOK_CATALOG" MODIFY ("BOOK_ID" NOT NULL ENABLE);
  ALTER TABLE "C##DENIS"."BOOK_CATALOG" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "C##DENIS"."BOOK_CATALOG" ADD CONSTRAINT "CHK_BOOK_CATALOG_YEAR_PUBLISHED" CHECK (YEAR_PUBLISHED IS NULL OR YEAR_PUBLISHED >= 0) ENABLE;
  ALTER TABLE "C##DENIS"."BOOK_CATALOG" ADD CONSTRAINT "PK_BOOK_CATALOG" PRIMARY KEY ("BOOK_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOOK_CATALOG
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."BOOK_CATALOG" ADD CONSTRAINT "CHK_BOOK_CATALOG_AUTHOR" FOREIGN KEY ("AUTHOR_NAME")
	  REFERENCES "C##DENIS"."AUTHORS" ("AUTHOR_NAME") ENABLE;
  ALTER TABLE "C##DENIS"."BOOK_CATALOG" ADD CONSTRAINT "CHK_BOOK_CATALOG_GENRE" FOREIGN KEY ("GENRE_NAME")
	  REFERENCES "C##DENIS"."GENRES" ("GENRE_NAME") ENABLE;
  ALTER TABLE "C##DENIS"."BOOK_CATALOG" ADD CONSTRAINT "CHK_BOOK_CATALOG_PUBLISHER" FOREIGN KEY ("PUBLISHER_NAME")
	  REFERENCES "C##DENIS"."PUBLISHERS" ("PUBLISHER_NAME") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table BOOK_INVENTORY
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."BOOK_INVENTORY" ADD FOREIGN KEY ("BOOK_ID")
	  REFERENCES "C##DENIS"."BOOK_CATALOG" ("BOOK_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LOANS
--------------------------------------------------------

  ALTER TABLE "C##DENIS"."LOANS" ADD FOREIGN KEY ("INVENTORY_ID")
	  REFERENCES "C##DENIS"."BOOK_INVENTORY" ("INVENTORY_ID") ENABLE;

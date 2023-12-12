create table USERS
(
    ID       NUMBER default "C##DENIS"."USERS_SEQ"."NEXTVAL" not null
        primary key,
    TYPE     VARCHAR2(50)
        constraint CHECK_USER_TYPE
            check (TYPE IN ('LIBRARIAN', 'ADMIN', 'READER')),
    LOGIN    VARCHAR2(50),
    PASSWORD VARCHAR2(50),
    STATUS   VARCHAR2(50)                                    not null
        constraint CHECK_USER_STATUS
            check (STATUS IN ('ACTIVE', 'SUSPENDED')),
    NAME     VARCHAR2(200)
)
/

create table AUTHORS
(
    AUTHOR_NAME VARCHAR2(255) not null
        constraint PK_AUTHORS
            primary key
)
/
create table GENRES
(
    GENRE_NAME VARCHAR2(255) not null
        constraint PK_GENRES
            primary key
)
/
create table PUBLISHERS
(
    PUBLISHER_NAME VARCHAR2(255) not null
        constraint PK_PUBLISHERS
            primary key
)
/
create table BOOK_CATALOG
(
    BOOK_ID        NUMBER        not null
        constraint PK_BOOK_CATALOG
            primary key,
    TITLE          VARCHAR2(255) not null,
    YEAR_PUBLISHED NUMBER
        constraint CHK_BOOK_CATALOG_YEAR_PUBLISHED
            check (YEAR_PUBLISHED IS NULL OR YEAR_PUBLISHED >= 0),
    AUTHOR_NAME    VARCHAR2(255)
        constraint CHK_BOOK_CATALOG_AUTHOR
            references AUTHORS,
    GENRE_NAME     VARCHAR2(255)
        constraint CHK_BOOK_CATALOG_GENRE
            references GENRES,
    PUBLISHER_NAME VARCHAR2(255)
        constraint CHK_BOOK_CATALOG_PUBLISHER
            references PUBLISHERS
)
/
create table BOOK_INVENTORY
(
    INVENTORY_ID NUMBER default "C##DENIS"."INVENTORY_SEQUENCE"."NEXTVAL" not null
        primary key,
    BOOK_ID      NUMBER
        references BOOK_CATALOG,
    LOCATION     VARCHAR2(100),
    STATUS       VARCHAR2(20)
        constraint CHECK_BOOK_STATUS
            check (STATUS IN ('LOST', 'AVAILABLE', 'ON_REPAIR', 'SCRAPPED', 'RESERVED'))
)
/
create table LOANS
(
    LOAN_ID      NUMBER default "C##DENIS"."LOANS_SEQUENCE"."NEXTVAL" not null
        constraint PK_LOANS
            primary key,
    INVENTORY_ID NUMBER
        references BOOK_INVENTORY,
    READER_ID    NUMBER
        constraint "LOANS_USERS_ID_fk"
            references USERS,
    LOAN_DATE    DATE,
    DUE_DATE     DATE,
    RETURN_DATE  DATE,
    STATUS       VARCHAR2(20)
        constraint CHECK_LOAN_STATUS
            check (STATUS IN ('RESERVED', 'ISSUED', 'RETURNED', 'CANCELED')),
    constraint CHK_LOANS_DATES
        check (LOAN_DATE <= DUE_DATE AND (RETURN_DATE IS NULL OR RETURN_DATE <= DUE_DATE))
)
/
create table PENALTIES
(
    PENALTY_ID      NUMBER default "C##DENIS"."PENALTIES_SEQ"."NEXTVAL" not null
        constraint PK_PENALTIES
            primary key,
    READER_ID       NUMBER
        constraint "PENALTIES_USERS_ID_fk2"
            references USERS,
    VALIDITY        NUMBER
        constraint CHK_PENALTIES_AMOUNT
            check (VALIDITY >= 0),
    REASON          VARCHAR2(255),
    PENALTY_DATE    DATE,
    EXPIRATION_DATE DATE,
    LIBRARIAN_ID    NUMBER
        constraint "PENALTIES_USERS_ID_fk"
            references USERS
)
/
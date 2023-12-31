-- Данные для таблицы USERS
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('ADMIN', 'админ1', 'пароль123', 'ACTIVE', 'Администратор Алексей');
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('LIBRARIAN', 'библиотекарь1', 'lib456', 'ACTIVE', 'Елена Библиотекарева');
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('READER', 'читатель99', 'pass321', 'ACTIVE', 'Иван Читательский');
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('READER', 'любознательная_анна', 'anna2023', 'ACTIVE', 'Анна Семенова');
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('ADMIN', 'admin_kate', 'kateadmin', 'ACTIVE', 'Катя Админова');
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('LIBRARIAN', 'lib_ivanov', 'lib2023', 'ACTIVE', 'Иван Иванов');
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('READER', 'bookworm23', 'librarypass', 'ACTIVE', 'Александра Книжная');
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('READER', 'readingjoe', 'joe2023', 'ACTIVE', 'Джо Ридер');
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('ADMIN', 'администратор_петр', 'adminpetr', 'ACTIVE', 'Петр Петров');
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('LIBRARIAN', 'lib_maria', 'maria_library', 'ACTIVE', 'Мария Либрари');
insert into USERS (TYPE, LOGIN, PASSWORD, STATUS, NAME) values ('READER', 'booklover', 'read2023', 'ACTIVE', 'Ольга Читалкина');

-- Данные для таблицы AUTHORS
insert into AUTHORS (AUTHOR_NAME) values ('Александр Пушкин');
insert into AUTHORS (AUTHOR_NAME) values ('Лев Толстой');
insert into AUTHORS (AUTHOR_NAME) values ('Агата Кристи');
insert into AUTHORS (AUTHOR_NAME) values ('Иван Тургенев');
insert into AUTHORS (AUTHOR_NAME) values ('Федор Достоевский');
insert into AUTHORS (AUTHOR_NAME) values ('Эрих Мария Ремарк');
insert into AUTHORS (AUTHOR_NAME) values ('Джейн Остин');
insert into AUTHORS (AUTHOR_NAME) values ('Джордж Оруэлл');
insert into AUTHORS (AUTHOR_NAME) values ('Маргарет Митчелл');
insert into AUTHORS (AUTHOR_NAME) values ('Габриэль Гарсиа Маркес');

-- Данные для таблицы GENRES
insert into GENRES (GENRE_NAME) values ('Роман');
insert into GENRES (GENRE_NAME) values ('Фантастика');
insert into GENRES (GENRE_NAME) values ('Детектив');
insert into GENRES (GENRE_NAME) values ('Поэзия');
insert into GENRES (GENRE_NAME) values ('Фэнтези');
insert into GENRES (GENRE_NAME) values ('Научная литература');
insert into GENRES (GENRE_NAME) values ('Исторический роман');
insert into GENRES (GENRE_NAME) values ('Психология');
insert into GENRES (GENRE_NAME) values ('Классика');
insert into GENRES (GENRE_NAME) values ('Приключения');

-- Данные для таблицы PUBLISHERS
insert into PUBLISHERS (PUBLISHER_NAME) values ('Издательство АСТ');
insert into PUBLISHERS (PUBLISHER_NAME) values ('Эксмо');
insert into PUBLISHERS (PUBLISHER_NAME) values ('ACT');
insert into PUBLISHERS (PUBLISHER_NAME) values ('Просвещение');
insert into PUBLISHERS (PUBLISHER_NAME) values ('Рипол Классик');
insert into PUBLISHERS (PUBLISHER_NAME) values ('Манн, Иванов и Фербер');
insert into PUBLISHERS (PUBLISHER_NAME) values ('Попурри');
insert into PUBLISHERS (PUBLISHER_NAME) values ('КоЛибри');
insert into PUBLISHERS (PUBLISHER_NAME) values ('Альпина Паблишер');
insert into PUBLISHERS (PUBLISHER_NAME) values ('Московский рабочий');

-- Данные для таблицы BOOK_CATALOG
insert into BOOK_CATALOG (BOOK_ID, TITLE, YEAR_PUBLISHED, AUTHOR_NAME, GENRE_NAME, PUBLISHER_NAME) values (1, 'Евгений Онегин', 1833, 'Александр Пушкин', 'Роман', 'Издательство АСТ');
insert into BOOK_CATALOG (BOOK_ID, TITLE, YEAR_PUBLISHED, AUTHOR_NAME, GENRE_NAME, PUBLISHER_NAME) values (2, 'Война и мир', 1869, 'Лев Толстой', 'Исторический роман', 'Эксмо');
insert into BOOK_CATALOG (BOOK_ID, TITLE, YEAR_PUBLISHED, AUTHOR_NAME, GENRE_NAME, PUBLISHER_NAME) values (3, 'Преступление и наказание', 1866, 'Федор Достоевский', 'Детектив', 'ACT');
insert into BOOK_CATALOG (BOOK_ID, TITLE, YEAR_PUBLISHED, AUTHOR_NAME, GENRE_NAME, PUBLISHER_NAME) values (4, 'Мастер и Маргарита', 1967, 'Михаил Булгаков', 'Фэнтези', 'Рипол Классик');
insert into BOOK_CATALOG (BOOK_ID, TITLE, YEAR_PUBLISHED, AUTHOR_NAME, GENRE_NAME, PUBLISHER_NAME) values (5, '1984', 1949, 'Джордж Оруэлл', 'Научная литература', 'Манн, Иванов и Фербер');
insert into BOOK_CATALOG (BOOK_ID, TITLE, YEAR_PUBLISHED, AUTHOR_NAME, GENRE_NAME, PUBLISHER_NAME) values (6, 'Гордость и предубеждение', 1813, 'Джейн Остин', 'Роман', 'Попурри');
insert into BOOK_CATALOG (BOOK_ID, TITLE, YEAR_PUBLISHED, AUTHOR_NAME, GENRE_NAME, PUBLISHER_NAME) values (7, 'Метро 2033', 2005, 'Дмитрий Глуховский', 'Фантастика', 'КоЛибри');
insert into BOOK_CATALOG (BOOK_ID, TITLE, YEAR_PUBLISHED, AUTHOR_NAME, GENRE_NAME, PUBLISHER_NAME) values (8, 'Мастер и Маргарита', 1967, 'Михаил Булгаков', 'Фэнтези', 'Альпина Паблишер');
insert into BOOK_CATALOG (BOOK_ID, TITLE, YEAR_PUBLISHED, AUTHOR_NAME, GENRE_NAME, PUBLISHER_NAME) values (9, 'Анна Каренина', 1877, 'Лев Толстой', 'Роман', 'Московский рабочий');
insert into BOOK_CATALOG (BOOK_ID, TITLE, YEAR_PUBLISHED, AUTHOR_NAME, GENRE_NAME, PUBLISHER_NAME) values (10, 'Маленький принц', 1943, 'Антуан де Сент-Экзюпери', 'Поэзия', 'Издательство АСТ');

-- Данные для таблицы BOOK_INVENTORY
insert into BOOK_INVENTORY (BOOK_ID, LOCATION, STATUS) values (1, 'Стеллаж А', 'AVAILABLE');
insert into BOOK_INVENTORY (BOOK_ID, LOCATION, STATUS) values (2, 'Стеллаж Б', 'AVAILABLE');
insert into BOOK_INVENTORY (BOOK_ID, LOCATION, STATUS) values (3, 'Стеллаж В', 'ON_REPAIR');
insert into BOOK_INVENTORY (BOOK_ID, LOCATION, STATUS) values (4, 'Стеллаж Г', 'SCRAPPED');
insert into BOOK_INVENTORY (BOOK_ID, LOCATION, STATUS) values (5, 'Стеллаж Д', 'AVAILABLE');
insert into BOOK_INVENTORY (BOOK_ID, LOCATION, STATUS) values (6, 'Стеллаж Е', 'LOST');
insert into BOOK_INVENTORY (BOOK_ID, LOCATION, STATUS) values (7, 'Стеллаж Ж', 'AVAILABLE');
insert into BOOK_INVENTORY (BOOK_ID, LOCATION, STATUS) values (8, 'Стеллаж З', 'ON_REPAIR');
insert into BOOK_INVENTORY (BOOK_ID, LOCATION, STATUS) values (9, 'Стеллаж И', 'AVAILABLE');
insert into BOOK_INVENTORY (BOOK_ID, LOCATION, STATUS) values (10, 'Стеллаж К', 'AVAILABLE');

-- Данные для таблицы LOANS
insert into LOANS (INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS) values (1, 3, TO_DATE('2023-01-05', 'YYYY-MM-DD'), TO_DATE('2023-01-15', 'YYYY-MM-DD'), 'ISSUED');
insert into LOANS (INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS) values (2, 1, TO_DATE('2023-02-10', 'YYYY-MM-DD'), TO_DATE('2023-02-20', 'YYYY-MM-DD'), 'RETURNED');
insert into LOANS (INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS) values (3, 2, TO_DATE('2023-03-15', 'YYYY-MM-DD'), TO_DATE('2023-03-25', 'YYYY-MM-DD'), 'ISSUED');
insert into LOANS (INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS) values (4, 4, TO_DATE('2023-04-20', 'YYYY-MM-DD'), TO_DATE('2023-05-01', 'YYYY-MM-DD'), 'RESERVED');
insert into LOANS (INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS) values (5, 5, TO_DATE('2023-05-05', 'YYYY-MM-DD'), TO_DATE('2023-05-15', 'YYYY-MM-DD'), 'ISSUED');
insert into LOANS (INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS) values (6, 7, TO_DATE('2023-06-10', 'YYYY-MM-DD'), TO_DATE('2023-06-20', 'YYYY-MM-DD'), 'ISSUED');
insert into LOANS (INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS) values (7, 6, TO_DATE('2023-07-15', 'YYYY-MM-DD'), TO_DATE('2023-07-25', 'YYYY-MM-DD'), 'RETURNED');
insert into LOANS (INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS) values (8, 8, TO_DATE('2023-08-20', 'YYYY-MM-DD'), TO_DATE('2023-08-30', 'YYYY-MM-DD'), 'RESERVED');
insert into LOANS (INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS) values (9, 9, TO_DATE('2023-09-25', 'YYYY-MM-DD'), TO_DATE('2023-10-05', 'YYYY-MM-DD'), 'ISSUED');
insert into LOANS (INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS,) values (10, 10, TO_DATE('2023-10-10', 'YYYY-MM-DD'), TO_DATE('2023-10-20', 'YYYY-MM-DD'), 'ISSUED');

-- Данные для таблицы PENALTIES
insert into PENALTIES (READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID) values (1, 5, 'Просрочка', TO_DATE('2023-02-25', 'YYYY-MM-DD'), TO_DATE('2023-03-25', 'YYYY-MM-DD'), 101);
insert into PENALTIES (READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID) values (2, 3, 'Повреждение книги', TO_DATE('2023-04-10', 'YYYY-MM-DD'), TO_DATE('2023-04-20', 'YYYY-MM-DD'), 102);
insert into PENALTIES (READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID) values (3, 7, 'Утеря книги', TO_DATE('2023-06-20', 'YYYY-MM-DD'), TO_DATE('2023-07-20', 'YYYY-MM-DD'), 103);
insert into PENALTIES (READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID) values (4, 4, 'Повреждение обложки', TO_DATE('2023-08-05', 'YYYY-MM-DD'), TO_DATE('2023-08-09', 'YYYY-MM-DD'), 104);
insert into PENALTIES (READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID) values (5, 6, 'Просрочка', TO_DATE('2023-10-15', 'YYYY-MM-DD'), TO_DATE('2023-10-21', 'YYYY-MM-DD'), 105);
insert into PENALTIES (READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID) values (6, 2, 'Повреждение страниц', TO_DATE('2023-11-30', 'YYYY-MM-DD'), TO_DATE('2023-12-02', 'YYYY-MM-DD'), 106);
insert into PENALTIES (READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID) values (7, 8, 'Утеря книги', TO_DATE('2023-12-10', 'YYYY-MM-DD'), TO_DATE('2023-12-18', 'YYYY-MM-DD'), 107);
insert into PENALTIES (READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID) values (8, 3, 'Просрочка', TO_DATE('2024-01-05', 'YYYY-MM-DD'), TO_DATE('2024-01-08', 'YYYY-MM-DD'), 108);
insert into PENALTIES (READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID) values (9, 5, 'Повреждение обложки', TO_DATE('2024-02-15', 'YYYY-MM-DD'), TO_DATE('2024-02-20', 'YYYY-MM-DD'), 109);
insert into PENALTIES (READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID) values (10, 4, 'Просрочка', TO_DATE('2024-03-20', 'YYYY-MM-DD'), TO_DATE('2024-03-24', 'YYYY-MM-DD'), 110);

-- Создание записи о книге в инвентаре
INSERT INTO BOOK_INVENTORY (INVENTORY_ID, BOOK_ID, LOCATION, STATUS)
VALUES (C##DENIS.INVENTORY_SEQUENCE.NEXTVAL, ?, ?, ?);

-- Получение информации о книге в инвентаре по ID
SELECT * FROM BOOK_INVENTORY WHERE INVENTORY_ID = ?;

-- Обновление информации о книге в инвентаре
UPDATE BOOK_INVENTORY
SET BOOK_ID = ?, LOCATION = ?, STATUS = ?
WHERE INVENTORY_ID = ?;

-- Удаление информации о книге из инвентаря по ID
DELETE FROM BOOK_INVENTORY WHERE INVENTORY_ID = ?;

-- Получение списка всех книг с определенным статусом
SELECT * FROM BOOK_INVENTORY WHERE STATUS = ?;

-- Получение списка всех книг для определенной книги из каталога
SELECT * FROM BOOK_INVENTORY WHERE BOOK_ID = ?;

-- Получение списка всех доступных книг
SELECT * FROM BOOK_INVENTORY WHERE STATUS = 'AVAILABLE';

-- Получение списка всех книг, находящихся на ремонте
SELECT * FROM BOOK_INVENTORY WHERE STATUS = 'ON_REPAIR';

-- Получение списка всех утерянных книг
SELECT * FROM BOOK_INVENTORY WHERE STATUS = 'LOST';

-- Получение списка всех зарезервированных книг
SELECT * FROM BOOK_INVENTORY WHERE STATUS = 'RESERVED';

--Обновление статуса книги
UPDATE BOOK_INVENTORY
SET STATUS = ?
WHERE INVENTORY_ID = ?;

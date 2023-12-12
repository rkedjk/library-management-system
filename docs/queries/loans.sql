
BEGIN
    -- Создание записи о займе книги
    INSERT INTO LOANS (LOAN_ID, INVENTORY_ID, READER_ID, LOAN_DATE, DUE_DATE, STATUS, LIBRARIAN_ID)
    VALUES (C##DENIS.LOANS_SEQUENCE.NEXTVAL, ?, ?, ?, ?, ?, ?);

    -- Обновление статуса книги в BOOK_INVENTORY
    UPDATE BOOK_INVENTORY
    SET STATUS = 'ISSUED'
    WHERE INVENTORY_ID = ?;

    COMMIT; -- Фиксация транзакции, если оба запроса выполнены успешно
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK; -- Откат изменений в случае возникновения ошибки
END;

-- Получение информации о займе книги по ID
SELECT * FROM LOANS WHERE LOAN_ID = ?;

-- Обновление информации о займе книги
UPDATE LOANS
SET INVENTORY_ID = ?, READER_ID = ?, LOAN_DATE = ?, DUE_DATE = ?, STATUS = ?, RETURN_DATE = ?
WHERE LOAN_ID = ?;

-- Получение списка всех займов для определенного читателя
SELECT * FROM LOANS WHERE READER_ID = ?;

-- Получение списка всех займов, находящихся в определенном статусе
SELECT * FROM LOANS WHERE STATUS = ?;

-- Получение списка всех займов, просроченных на определенную дату
SELECT * FROM LOANS WHERE DUE_DATE < ?;

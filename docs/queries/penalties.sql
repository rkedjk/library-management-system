-- Вставка новой записи о штрафе для читателя с заданным READER_ID
INSERT INTO PENALTIES (PENALTY_ID, READER_ID, VALIDITY, REASON, PENALTY_DATE, EXPIRATION_DATE, LIBRARIAN_ID)
VALUES (C##DENIS.PENALTIES_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?);

-- Обновление данных о штрафе по его ID для конкретного читателя
UPDATE PENALTIES
SET VALIDITY = ?, REASON = ?, PENALTY_DATE = ?, EXPIRATION_DATE = ?, LIBRARIAN_ID = ?
WHERE PENALTY_ID = ? AND READER_ID = ?;

-- Удаление штрафа по его ID для определенного читателя
DELETE FROM PENALTIES
WHERE PENALTY_ID = ? AND READER_ID = ?;

-- Выборка всех штрафов для конкретного читателя
SELECT * FROM PENALTIES
WHERE READER_ID = ?;

-- Выборка штрафов, которые истекают к определенной дате
SELECT * FROM PENALTIES
WHERE EXPIRATION_DATE <= ?;

-- Выборка штрафов, наложенных конкретным библиотекарем
SELECT * FROM PENALTIES
WHERE LIBRARIAN_ID = ?;

-- Обновление поля VALIDITY и EXPIRATION_DATE для штрафа с определенным PENALTY_ID
UPDATE PENALTIES
SET VALIDITY = ?, EXPIRATION_DATE = ?
WHERE PENALTY_ID = ?

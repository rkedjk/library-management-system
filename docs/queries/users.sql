-- Создание пользователя
INSERT INTO USERS (ID, TYPE, LOGIN, PASSWORD, STATUS, NAME)
VALUES (C##DENIS.USERS_SEQ.NEXTVAL, ?, ?, ?, ?, ?);

-- Получение пользователя по ID
SELECT * FROM USERS WHERE ID = ?;

-- Обновление информации о пользователе
UPDATE USERS
SET TYPE = ?, LOGIN = ?, PASSWORD = ?, STATUS = ?, NAME = ?
WHERE ID = ?;

-- Удаление пользователя по ID
DELETE FROM USERS WHERE ID = ?;

-- Получение списка всех пользователей определенного типа
SELECT * FROM USERS WHERE TYPE = ?;

-- Получение списка всех активных пользователей
SELECT * FROM USERS WHERE STATUS = ?;

-- Поиск пользователя по имени
SELECT * FROM USERS WHERE NAME = ?;

-- Получение списка всех пользователей определенного типа и статуса
SELECT * FROM USERS WHERE TYPE = ? AND STATUS = ?;

-- Получение списка пользователей определенного типа
SELECT * FROM USERS WHERE TYPE = ?;

-- Получение списка пользователей с определенным статусом
SELECT * FROM USERS WHERE STATUS = ?;

-- Получение списка пользователей по типу и статусу
SELECT * FROM USERS WHERE TYPE = ? AND STATUS = ?;

-- Создание пользователя (от пользователя и библиотекаря)
INSERT INTO USERS (ID, TYPE, LOGIN, PASSWORD, STATUS, NAME)
VALUES (C##DENIS.USERS_SEQ.NEXTVAL, ?, 'READER', ?, ?, ?);


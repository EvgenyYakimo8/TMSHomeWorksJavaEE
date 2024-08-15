package by.tms.l32_35;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
import org.flywaydb.core.api.MigrationInfoService;
import org.flywaydb.core.api.configuration.FluentConfiguration;

import java.util.Arrays;
import java.util.List;

/**
 * Запрос многие ко многим: SELECT * FROM accounts a JOIN accounts_telephones at ON a.id = at.account_id JOIN telephones ON at.telephone_id=telephones.id;
 * запрос с использованием лимита со смещением (показать первые 5 записей начиная с 11): SELECT * FROM accounts LIMIT 5 OFFSET 10;
 * запрос показать все между двумя значениями (включительно): SELECT * FROM accounts a WHERE id BETWEEN 19 AND 21;
 * запрос суммы ID аккаунтов: SELECT SUM(a.id) FROM accounts a;
 * запрос количества аккаунтов: SELECT count(*) FROM accounts a;
 * запрос вхождения имени в список: SELECT * FROM accounts WHERE name IN ('test','test2'); для отрицания нужно написать NOT IN вместо IN
 * запрос найти все имена с (% все символы(остальное множество), _ один символ): SELECT * FROM accounts a WHERE name LIKE 'tes%';
 *---------------------------------------------------------------
 * Базовые запросы (примеры) ->
 *
 * INSERT INTO "user" VALUES ('tes','tes1','tes2');
 *
 * UPDATE "user" SET username = 'new_name', email ='123', password = '8' WHERE password = 'tes6';
 *
 * DELETE FROM "user" WHERE password = 'tes4';
 *
 * SELECT * FROM "user" WHERE email = '123';
 *
 * INSERT INTO account VALUES ('3','testN','testUN','testp');
 *
 * SELECT * FROM account WHERE username ='testUN';
 *
 * DELETE FROM "account" WHERE name = 'testU';
 *---------------------------------------------------------------
 * Пример функции в базе данных->
 * CREATE OR REPLACE FUNCTION getAccountCount()
 *     RETURNS int
 *     LANGUAGE plpgsql
 * AS
 * $$
 * DECLARE
 *     count int;
 * BEGIN
 *     SELECT COUNT()
 *     INTO count
 *     FROM accounts;
 *     RETURN count;
 * END;
 * $$
 *
 * Вызов функции ->
 * SELECT getaccountcount()
 *---------------------------------------------------------------
 * Пример процедуры в базе данных ->
 *create procedure updateaccountname(IN id integer, IN name character varying)
 *     language plpgsql
 * as
 * $$
 * BEGIN
 *     UPDATE accounts
 *     SET username = name
 *     WHERE accounts.id = updateaccountname.id;
 *
 * END;
 * $$;
 *
 * Вызов процедуры ->
 * CALL  updateaccountname(1, 'test3')
 * ---------------------------------------------------------------
 * Пример триггера ->
 * CREATE TRIGGER check_ob_update
 *     BEFORE UPDATE
 *     ON accounts
 *     FOR EACH ROW
 * EXECUTE FUNCTION getaccountcount() (при вызове функций могут быть ошибки, например должен быть типо возвращаемого значения "trigger" - тут надо гуглить)
 * Обычно (чаще всего) триггеры используются для обновления временной отметки в колонке записи при обновении строки.
 *
 * ПОДКЛЮЧЕНА БИБЛИОТЕКА FLYWAY 8.0.0 для выполнения миграций базы данных.
 * */
public class Main {
    public static void main(String[] args) {
        FluentConfiguration configure = Flyway.configure();
        configure.schemas("public");
        Flyway flyway = configure.dataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "bigbase").load();
        flyway.migrate();

    }
}
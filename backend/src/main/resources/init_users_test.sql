INSERT INTO address(address_id, address_line, city, country, voivodeship, zip_code)
VALUES ( '1', 'Test', 'Test', 'Test', 'Test', '12345');
INSERT INTO users (user_id, birthdate, citytype, code, education, name, personalidnumber, profession, sex, surname, address_id)
VALUES ( '69e279ad-f5c7-44cb-bce9-9164a67839ab', '1999-01-01', 'OVER500THOUSAND', '123456789', 'VOCATIONAL', 'Test', '123456789', 'STUDENT', 0, 'Test', '1');
INSERT INTO accounts (account_id, email, hasvoted, isaccountactive, password, role, user_id) VALUES (1, 'test@mail.com', false, true, 'password', 'USER', '69e279ad-f5c7-44cb-bce9-9164a67839ab');
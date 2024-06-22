INSERT INTO address(address_id, address_line, city, country, voivodeship, zip_code)
VALUES ( '1', 'Test', 'Test', 'Test', 'Test', '12345');
INSERT INTO users (user_id, birthdate, citytype, code, education, name, personalidnumber, profession, sex, surname, address_id)
VALUES ( '69e279ad-f5c7-44cb-bce9-9164a67839ab', '1999-01-01', 'OVER500THOUSAND', '123456789', 'VOCATIONAL', 'Test', '123456789', 'STUDENT', 0, 'Test', '1');
INSERT INTO accounts (account_id, email, hasvoted, isaccountactive, password, role, user_id) VALUES (5, 'test@mail.com', false, true, 'password123', 'USER', '69e279ad-f5c7-44cb-bce9-9164a67839ab');


INSERT INTO address(address_id, address_line, city, country, voivodeship, zip_code)
VALUES ( '2', 'Test', 'Test', 'Test', 'Test', '12345');
INSERT INTO users (user_id, birthdate, citytype, code, education, name, personalidnumber, profession, sex, surname, address_id)
VALUES ( 'c1bdd935-8c9e-4b0e-8134-fc40e11d2f2d', '1999-01-01', 'OVER500THOUSAND', '123456789', 'VOCATIONAL', 'Test', '123456789', 'STUDENT', 0, 'Test', '2');
INSERT INTO accounts (account_id, email, hasvoted, isaccountactive, password, role, user_id) VALUES (6, 'test2@mail.com', true, true, 'password1234', 'USER', 'c1bdd935-8c9e-4b0e-8134-fc40e11d2f2d');

INSERT INTO address(address_id, address_line, city, country, voivodeship, zip_code)
VALUES ( '3', 'Test', 'Test', 'Test', 'Test', '12345');
INSERT INTO users (user_id, birthdate, citytype, code, education, name, personalidnumber, profession, sex, surname, address_id)
VALUES ( '3c3e34ca-3809-4a22-aaad-011b11540375', '1999-01-01', 'OVER500THOUSAND', '123456789', 'VOCATIONAL', 'Test', '123456789', 'STUDENT', 0, 'Test', '3');
INSERT INTO accounts (account_id, email, hasvoted, isaccountactive, password, role, user_id) VALUES (7, 'test3@mail.com', false, true, 'password12345', 'USER', '3c3e34ca-3809-4a22-aaad-011b11540375');



INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc', 1, 'Parliamentary' , 1);

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('2ef5a787-fcc3-4f07-93e4-5e91ee051b9a', 2, 'Senate' , 2);
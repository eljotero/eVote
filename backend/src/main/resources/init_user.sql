
INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (1,'Gowno', 'Brzeziny', 'Polska', 'Łódzkie', '12-000');

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (2,'Gowno', 'Brzeziny', 'Polska', 'Łódzkie', '12-000');

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (3,'Gowno', 'Brzeziny', 'Polska', 'Łódzkie', '12-000');


INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id, user_id)
VALUES('7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc', 6, 1 , 1, '369c4ca5-66a5-45d2-b624-bfe9ade55560');

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id, user_id)
VALUES('5c6ca58c-e19d-48ba-a6bb-57331ee91cf3', 9, 3, 2 ,'369c4ca5-66a5-45d2-b624-bfe9ade55560');

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id, user_id)
VALUES('ddd3cd12-35fd-4c71-aac5-98927cfbc2f0', 23, 4, 3 ,'369c4ca5-66a5-45d2-b624-bfe9ade55560');

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc', 'Łódzkie');
INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('5c6ca58c-e19d-48ba-a6bb-57331ee91cf3', 'Brzeziny');
INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('5c6ca58c-e19d-48ba-a6bb-57331ee91cf3', 'Łódź');
INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('ddd3cd12-35fd-4c71-aac5-98927cfbc2f0', 'Łódź');
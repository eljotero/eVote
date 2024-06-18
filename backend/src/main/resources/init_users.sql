
INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (1,'', 'Wrocław', 'Polska', 'Dolnośląskie', '45-573')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (2,'', 'Bydgoszcz', 'Polska', 'Kujawsko-Pomorskie', '12-000')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (3,'', 'Lublin', 'Polska', 'Lubelskie', '20-000')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (4,'', 'Gorzów Wielkopolski', 'Polska', 'Lubuskie', '66-400')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (5, '', 'Łódź', 'Polska', 'Łódzkie', '90-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (6, '', 'Kraków', 'Polska', 'Małopolskie', '30-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (7, '', 'Warszawa', 'Polska', 'Mazowieckie', '00-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (8, '', 'Opole', 'Polska', 'Opolskie', '45-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (9, '', 'Rzeszów', 'Polska', 'Podkarpackie', '35-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (10, '', 'Białystok', 'Polska', 'Podlaskie', '15-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (11, '', 'Gdańsk', 'Polska', 'Pomorskie', '80-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (12, '', 'Katowice', 'Polska', 'Śląskie', '40-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (13, '', 'Kielce', 'Polska', 'Świętokrzyskie', '25-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (14, '', 'Olsztyn', 'Polska', 'Warmińsko-Mazurskie', '10-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (15, '', 'Poznań', 'Polska', 'Wielkopolskie', '60-001')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, voivodeship, zip_code)
VALUES (16, '', 'Szczecin', 'Polska', 'Zachodniopomorskie', '70-001')
    ON CONFLICT (address_id) DO NOTHING;

--sejm
INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc', 1, 3 , 1)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('2ef5a787-fcc3-4f07-93e4-5e91ee051b9a', 2, 3 , 1)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('77bd481c-abd3-4f2a-a9ed-6b7cc6af5678', 3, 3 , 1)
    ON CONFLICT (precinct_uuid) DO NOTHING;


INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('5c6ca58c-e19d-48ba-a6bb-57331ee91cf3', 4, 3, 2 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('4c7509bd-e9da-4d49-ac83-7ad1503b2bbe', 5, 3, 2 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('8d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 6, 3, 3 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('9d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 7, 3, 3 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('60e87cd2-a46b-4fb8-8e72-0d0e9e63d8b0', 8, 3, 4 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('0c2cdf82-08e1-410c-bc41-55ae53171391', 9, 3, 5 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('8df0ef8d-38a7-42f9-b618-6915f78e08d3', 10, 3, 5 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('f13020af-f4d8-43e9-a00c-089442db4729', 11, 3, 5 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('ff51e390-70e4-4fdc-8f32-d68c8dd83482', 12, 3, 6 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('de81eba0-a8f7-48a6-bdb6-71ebb52bed8e', 13, 3, 6 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('bca10d4e-8f17-4995-9efb-69e69e1393d5', 14, 3, 6 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('cd887a30-cfbd-466a-acd4-5ce4a26568b2', 15, 3, 6 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('17680e70-46b8-4c7f-b23d-4af75f5b50f3', 16, 3, 7 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('675b586e-a54d-46ab-9304-6d266997314b', 17, 3, 7 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('e9b8ffa6-cd4a-4625-b65f-e6e25d3fa946', 18, 3, 7 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('eb7aaa86-4d89-42e2-835c-5d423b7067b1', 19, 3, 7 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('0bd6f193-e8e1-4a5f-bd81-ecaee4bda9ec', 20, 3, 7 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('1b6e832e-481f-48e1-a20a-0e323c34321e', 21, 3, 8 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('b7f832dc-f3eb-4fd8-9a2b-5a74d6b4ac3a', 22, 3, 9 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('6a054862-015e-4e10-8c24-4215beec5d3e', 23, 3, 9 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('5944cb14-ca9a-426b-ae94-95cd99334d2f', 24, 3, 10 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('681d5c6d-3830-4d33-9bd9-1b2e0165dda0', 25, 3, 11 )
    ON CONFLICT (precinct_uuid) DO NOTHING;


--senat
INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('ec4144e5-5df2-40de-9a01-c39b60d98764', 3, 4 , 1)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype, address_id)
VALUES('174857a5-cb83-413c-bfe6-f652e66c4923', 23, 4, 5)

    ON CONFLICT (precinct_uuid) DO NOTHING;


ALTER TABLE usersprecinct_availablecities
DROP CONSTRAINT IF EXISTS unique_usersprecinct_availablecities;

ALTER TABLE usersprecinct_availablecities
    ADD CONSTRAINT unique_usersprecinct_availablecities UNIQUE (usersprecinct_precinct_uuid, availableCities);

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc', 'Leginica')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc', 'Jelenia Góra')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('2ef5a787-fcc3-4f07-93e4-5e91ee051b9a', 'Wałbrzych')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('77bd481c-abd3-4f2a-a9ed-6b7cc6af5678', 'Wrocław')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('5c6ca58c-e19d-48ba-a6bb-57331ee91cf3', 'Bydgoszcz')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('4c7509bd-e9da-4d49-ac83-7ad1503b2bbe', 'Toruń')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('8d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 'Lublin')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('9d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 'Chełm')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('9d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 'Zamość')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('9d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 'Biała Podlaska')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('60e87cd2-a46b-4fb8-8e72-0d0e9e63d8b0', 'Zielona Góra')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('0c2cdf82-08e1-410c-bc41-55ae53171391', 'Łódź')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('0c2cdf82-08e1-410c-bc41-55ae53171391', 'Brzeziny')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('8df0ef8d-38a7-42f9-b618-6915f78e08d3', 'Piotrków Trybunalski')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('8df0ef8d-38a7-42f9-b618-6915f78e08d3', 'Skiernewice')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('f13020af-f4d8-43e9-a00c-089442db4729', 'Sieradz')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('ff51e390-70e4-4fdc-8f32-d68c8dd83482', 'Chrzanów')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('de81eba0-a8f7-48a6-bdb6-71ebb52bed8e', 'Kraków')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('bca10d4e-8f17-4995-9efb-69e69e1393d5', 'Nowy Sącz')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('cd887a30-cfbd-466a-acd4-5ce4a26568b2', 'Tarnów')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('17680e70-46b8-4c7f-b23d-4af75f5b50f3', 'Płock')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('675b586e-a54d-46ab-9304-6d266997314b', 'Radom')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('e9b8ffa6-cd4a-4625-b65f-e6e25d3fa946', 'Siedlce')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('e9b8ffa6-cd4a-4625-b65f-e6e25d3fa946', 'Ostrołęka')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('eb7aaa86-4d89-42e2-835c-5d423b7067b1', 'Warszawa')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('0bd6f193-e8e1-4a5f-bd81-ecaee4bda9ec', 'Pruszków')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('1b6e832e-481f-48e1-a20a-0e323c34321e', 'Opole')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('b7f832dc-f3eb-4fd8-9a2b-5a74d6b4ac3a', 'Krosno')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('b7f832dc-f3eb-4fd8-9a2b-5a74d6b4ac3a', 'Przemyśl')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('6a054862-015e-4e10-8c24-4215beec5d3e', 'Rzeszów')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('6a054862-015e-4e10-8c24-4215beec5d3e', 'Tarnobrzeg')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('5944cb14-ca9a-426b-ae94-95cd99334d2f', 'Białystok')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('681d5c6d-3830-4d33-9bd9-1b2e0165dda0', 'Gdańsk')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('681d5c6d-3830-4d33-9bd9-1b2e0165dda0', 'Sopot')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('681d5c6d-3830-4d33-9bd9-1b2e0165dda0', 'Gdynia')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;

--senat
INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('ec4144e5-5df2-40de-9a01-c39b60d98764', 'Leginica')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;


INSERT INTO usersprecinct_availablecities (usersprecinct_precinct_uuid, availableCities) VALUES ('174857a5-cb83-413c-bfe6-f652e66c4923', 'Łódź')
    ON CONFLICT (usersprecinct_precinct_uuid, availableCities) DO NOTHING;


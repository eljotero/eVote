INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (1, 'Nowogrodzka 84/86', 'Warszawa', 'Polska', '02-018')
ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (2, 'Wiejska 12a', 'Warszawa', 'Polska', '00-490')
ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (3, 'Piękna 24/26A', 'Warszawa', 'Polska', '00-549')
ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (4, 'Złota 9', 'Warszawa', 'Polska', '00-019')
ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (5, 'Marii Konopnickiej 6', 'Warszawa', 'Polska', '00-491')
ON CONFLICT (address_id) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (1, 'Wybory parlamentarne - sejm','2024-06-26','2024-06-25', 3)
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (2, 'Wybory parlamentarne - senat','2024-06-26','2024-06-25', 4)
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (3, 'Wybory prezydenckie','2024-09-26','2024-09-25', 2)
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (4, 'Wybory samorządowe - gimna','2025-09-26','2025-09-25', 1)
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (5, 'Wybory samorządowe - powiat','2025-09-26','2025-09-25', 1)
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (6, 'Wybory samorządowe - województwo','2025-09-26','2025-09-25', 1)
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (1,'Prawo i Sprawiedliwość', 1)
ON CONFLICT (politicalpartyid) DO NOTHING;

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (2,'Koalicja Obywatelska', 2)
ON CONFLICT (politicalpartyid) DO NOTHING;

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (3,'Konfederacja', 3)
ON CONFLICT (politicalpartyid) DO NOTHING;

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (4,'Nowa Lewica', 4)
ON CONFLICT (politicalpartyid) DO NOTHING;

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (5,'Trzecia Droga', 5)
ON CONFLICT (politicalpartyid) DO NOTHING;

--sejm
INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc', 1, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('2ef5a787-fcc3-4f07-93e4-5e91ee051b9a', 2, 3 )
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('77bd481c-abd3-4f2a-a9ed-6b7cc6af5678', 3, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;


INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('5c6ca58c-e19d-48ba-a6bb-57331ee91cf3', 4, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('4c7509bd-e9da-4d49-ac83-7ad1503b2bbe', 5, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('8d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 6, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('9d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 7, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('60e87cd2-a46b-4fb8-8e72-0d0e9e63d8b0', 8, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('0c2cdf82-08e1-410c-bc41-55ae53171391', 9, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('8df0ef8d-38a7-42f9-b618-6915f78e08d3', 10, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('f13020af-f4d8-43e9-a00c-089442db4729', 11, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('ff51e390-70e4-4fdc-8f32-d68c8dd83482', 12, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('de81eba0-a8f7-48a6-bdb6-71ebb52bed8e', 13, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('bca10d4e-8f17-4995-9efb-69e69e1393d5', 14, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('cd887a30-cfbd-466a-acd4-5ce4a26568b2', 15, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('17680e70-46b8-4c7f-b23d-4af75f5b50f3', 16, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('675b586e-a54d-46ab-9304-6d266997314b', 17, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('e9b8ffa6-cd4a-4625-b65f-e6e25d3fa946', 18, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('eb7aaa86-4d89-42e2-835c-5d423b7067b1', 19, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('0bd6f193-e8e1-4a5f-bd81-ecaee4bda9ec', 20, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('1b6e832e-481f-48e1-a20a-0e323c34321e', 21, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('b7f832dc-f3eb-4fd8-9a2b-5a74d6b4ac3a', 22, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('6a054862-015e-4e10-8c24-4215beec5d3e', 23, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('5944cb14-ca9a-426b-ae94-95cd99334d2f', 24, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('681d5c6d-3830-4d33-9bd9-1b2e0165dda0', 25, 3)
ON CONFLICT (precinct_uuid) DO NOTHING;


--senat
INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('ec4144e5-5df2-40de-9a01-c39b60d98764', 3, 4)
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('174857a5-cb83-413c-bfe6-f652e66c4923', 23, 4)
ON CONFLICT (precinct_uuid) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           1,
           '1988-04-20',
           'inżynier informatyki',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-11_211139026.png',
           'Cos tam cos tam.',
           'Michał',
           'Kot',
           'Szefunio',
           1,
           1,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           2,
           '1980-03-25',
           'doktor nauk prawnych',
           'https://storage.googleapis.com/evote_c/kan1.png',
           'Zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. Walka z nierównościami społecznymi poprzez wprowadzenie programów pomocy socjalnej i podniesienie płacy minimalnej.',
           'Andrzej',
           'Piaseczny',
           'Prawnik',
           1,
           1,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;



INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           3,
           '1988-04-20',
           'inżynier informatyki',
           'https://storage.googleapis.com/evote_c/obraz_2024-05-22_085300374.png',
           'Mój plan wyborczy zakłada wzmocnienie gospodarki przez obniżenie podatków dla małych i średnich przedsiębiorstw oraz inwestycje w nowoczesne technologie i infrastrukturę.',
           'Anna',
           'Małomówna',
           'Administrator baz danych',
           1,
           2,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           4,
           '1960-01-22',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_025042065.png',
           'Oczywiście Polska tylko dla Polaków. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Krzysztof',
           'Waligóra',
           'doradca podatkowy',
           1,
           2,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           5,
           '1989-06-22',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_025451889.png',
           'Dodatki socjalne dla rodzin z dziećmi, zwiększenie dostępu do opieki medycznej oraz walka z korupcją w administracji publicznej.',
           'Maria',
           'Laskowska',
           'profesor prawa',
           1,
           3,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           6,
           '1974-04-21',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_030253175.png',
           'Zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. ',
           'Piotr',
           'Guzek',
           'rolnik',
           1,
           3,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           7,
           '1984-04-21',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031428363.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Michał',
           'Klimaczak',
           'prawnik',
           1,
           4,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           7,
           '1984-04-21',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031428363.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. ',
           'Michał',
           'Klimaczak',
           'prawnik',
           1,
           4,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           8,
           '1980-07-11',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031806775.png',
           'Wolna i suwerenna Polska. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Wojciech',
           'Kaczmarek',
           'programista Java',
           1,
           4,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           9,
           '1970-02-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_032105345.png',
           'Stop korupcji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Aleksander',
           'Maruda',
           'komornik sądowy',
           1,
           5,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           10,
           '1960-11-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_032345581.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Elżbieta',
           'Kotek',
           'nauczycielka',
           1,
           5,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           11,
           '1977-11-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_033522952.png',
           'Wszystko dla Polski. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Michał',
           'Kotecki',
           'nauczyciel',
           1,
           1,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           12,
           '1979-01-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_033752771.png',
           'Podatki tylko dla bogatych. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Szymon',
           'Kołecki',
           'sportowiec',
           1,
           1,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           13,
           '1989-01-24',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034045514.png',
           'Ograniczenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo.',
           'Michalina',
           'Piotrowska',
           'prawniczka',
           1,
           2,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           14,
           '1982-06-24',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034305890.png',
           'Polska powinna wystąpić z Unii Europejskiej. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Piotr',
           'Nowak',
           'programista',
           1,
           2,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           15,
           '1972-06-24',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034631231.png',
           'Głosuj na mnie a Polska będzie silna. Bóg, Honor, Ojczyzna.',
           'Jakub',
           'Kowalski',
           'przedstawiciel handlowy',
           1,
           3,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           16,
           '1988-09-24',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034840978.png',
           'Podać Polskę w ręce młodych. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Anna',
           'Kowalska',
           'naukowiec',
           1,
           3,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           17,
           '1982-03-21',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_035135548.png',
           'Ta Polska to nasza Polska. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Piotr',
           'Myślak',
           'przedsiębiorca',
           1,
           4,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           18,
           '1987-07-04',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_035445767.png',
           'Jeszcze Polska nie zginęła. Unia Europejska to zło. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Krzysztof',
           'Piątek',
           'sportowiec',
           1,
           4,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           19,
           '1985-09-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_035842525.png',
           'Już czas na zmiany. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Anita',
           'Piąteczek',
           'sprzedawca',
           1,
           5,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           20,
           '1990-09-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_040705009.png',
           'Polska dla Polaków. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Piotr',
           'Kowalski',
           'programista',
           1,
           5,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           21,
           '1962-03-19',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_041232980.png',
           'Zakaz handlu w niedziele. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Adam',
           'Kaczmarek',
           'przedsiębiorca',
           2,
           1,
           'ec4144e5-5df2-40de-9a01-c39b60d98764'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           22,
           '1972-03-19',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_041526081.png',
           'Nowe miejsca pracy. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Karolina',
           'Wójcik',
           'nauczycielka',
           2,
           2,
           'ec4144e5-5df2-40de-9a01-c39b60d98764'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           23,
           '1982-03-19',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_041838954.png',
           'Nie dla Unii Europejskiej. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Mikołaj',
           'Michalski',
           'programista',
           2,
           3,
           'ec4144e5-5df2-40de-9a01-c39b60d98764'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           24,
           '1982-05-19',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_041838954.png',
           'Nie dla Unii Europejskiej. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Piotr',
           'Kołeczek',
           'rolnik',
           2,
           1,
           '174857a5-cb83-413c-bfe6-f652e66c4923'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           25,
           '1989-05-19',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_043828059.png',
           'Podatki tylko dla bogatych. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Marta',
           'Kwiecień',
           'nauczycielka',
           2,
           2,
           '174857a5-cb83-413c-bfe6-f652e66c4923'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           26,
           '1979-09-29',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_044124541.png',
           'Uniwersalne 500+ dla wszystkich. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Krzysztof',
           'Piotrowski',
           'przedsiębiorca',
           2,
           3,
           '174857a5-cb83-413c-bfe6-f652e66c4923'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (1,true, '10:34:56', '2024-06-015', 0, 'Polska', 'wyższe', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (2,true, '10:34:56', '2024-06-015', 2, 'Polska', 'średnie', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (3,true, '10:34:56', '2024-06-015', 2, 'Polska', 'podstawowe', 3)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (4,true, '10:34:56', '2024-06-015', 2, 'Polska', 'wyższe', 4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (5, false, '08:25:47', '1988-02-28', 1, 'Polska', 'średnie', 5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (6, true, '16:05:38', '1995-07-17', 2, 'Polska', 'podstawowe', 6)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (7, false, '12:30:22', '1982-09-30', 3, 'Polska', 'wyższe', 7)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (8, true, '15:12:18', '1991-05-10', 3, 'Polska', 'średnie', 8)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (9, false, '10:45:50', '1984-08-25', 1, 'Polska', 'podstawowe', 9)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (10, true, '11:55:33', '1976-04-14', 2, 'Polska', 'wyższe', 10)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (11, false, '09:05:12', '1980-01-06', 3, 'Polska', 'średnie', 11)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (12, true, '14:30:45', '1993-03-18', 0, 'Polska', 'podstawowe', 12)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (13, false, '16:40:27', '1987-10-21', 1, 'Polska', 'wyższe', 13)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (14, true, '12:15:36', '1975-07-12', 2, 'Polska', 'średnie', 14)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (15, false, '08:50:48', '1994-06-03', 3, 'Polska', 'podstawowe', 15)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (16, true, '17:20:59', '1989-02-11', 0, 'Polska', 'wyższe', 16)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (17, false, '11:05:12', '1977-05-29', 1, 'Polska', 'średnie', 17)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (18, true, '13:40:23', '1986-09-18', 2, 'Polska', 'podstawowe', 18)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (19, false, '10:15:48', '1992-11-14', 3, 'Polska', 'wyższe', 19)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (20, true, '14:10:36', '1983-08-09', 3, 'Polska', 'średnie', 20)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (21, false, '09:25:17', '1979-04-23', 1, 'Polska', 'podstawowe', 21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (22, true, '15:30:29', '1990-07-06', 2, 'Polska', 'wyższe', 22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (23, false, '12:45:38', '1996-12-17', 3, 'Polska', 'średnie', 23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (24, true, '08:05:42', '1981-01-19', 1, 'Polska', 'podstawowe', 24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (25, false, '13:20:13', '1985-06-25', 1, 'Polska', 'wyższe', 25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (26, true, '16:50:31', '1993-10-08', 2, 'Polska', 'średnie', 26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (27, true, '16:50:31', '1993-10-08', 1, 'Polska', 'wyższe', 25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (28, true, '16:50:31', '1993-10-08', 1, 'Polska', 'podstawowe', 22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (29, true, '16:50:31', '1993-10-08', 0, 'Polska', 'wyższe', 23)
ON CONFLICT (voteid) DO NOTHING;


INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (30, false, '16:50:31', '1953-10-08', 2, 'Niemcy', 'podstawowe', 23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (31, false, '16:50:31', '1956-10-08', 2, 'Irlandia', 'wyższe', 22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (32, false, '16:50:31', '1996-10-08', 3, 'Niemcy', 'wyższe', 26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (33, true, '16:50:31', '1996-10-08', 1, 'Irlandia', 'średnie', 25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (33, true, '16:50:31', '1996-10-08', 1, 'Irlandia', 'średnie', 24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (34, true, '16:50:31', '1956-10-08', 1, 'Irlandia', 'średnie', 4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (35, false, '16:50:31', '1956-10-08', 3, 'Niemcy', 'średnie', 5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (36, false, '16:50:31', '2000-10-08', 2, 'Irlandia', 'podstawowe', 2)
ON CONFLICT (voteid) DO NOTHING;


INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (37, false, '16:50:31', '2000-10-08', 2, 'Polska', 'podstawowe', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (38, true, '16:50:31', '2000-10-08', 2, 'Polska', 'podstawowe', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (39, true, '16:50:31', '2001-10-08', 2, 'Polska', 'podstawowe', 2)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (40, true, '16:50:31', '1951-10-08', 2, 'Niemcy', 'podstawowe', 3)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (41, true, '16:50:31', '1971-10-08', 2, 'Irlandia', 'wyższe', 5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (42, true, '16:50:31', '2000-10-08', 2, 'Irlandia', 'wyższe', 4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (43, true, '16:50:31', '1952-10-08', 2, 'Polska', 'wyższe', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (44, true, '16:50:31', '1952-10-08', 0, 'Polska', 'wyższe', 2)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (45, true, '16:50:31', '1952-10-08', 0, 'Polska', 'wyższe', 3)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (46, true, '16:50:31', '1952-10-08', 3, 'Polska', 'wyższe', 4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (47, true, '16:50:31', '1952-10-08', 3, 'Polska', 'wyższe', 4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (48, true, '16:50:31', '1952-10-08', 3, 'Polska', 'wyższe', 5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (49, true, '16:50:31', '1952-10-08', 3, 'Irlandia', 'wyższe', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (50, true, '16:50:31', '1952-10-08', 3, 'Niemcy', 'wyższe', 2)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (51, true, '16:50:31', '1968-10-08', 3, 'Polska', 'podstawowe', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (52, false, '16:50:31', '1968-10-08', 3, 'Irlandia', 'wyższe', 2)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (53, true, '16:50:31', '1968-10-08', 3, 'Polska', 'wyższe', 3)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (54, false, '16:50:31', '1968-10-08', 2, 'Polska', 'wyższe', 3)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (55, false, '16:50:31', '1968-10-08', 0, 'Polska', 'podstawowe',4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (56, false, '16:50:31', '1968-10-08', 0, 'Irlandia', 'średnie',5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (57, false, '16:50:31', '1978-10-08', 2, 'Polska', 'średnie',4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (58, false, '16:50:31', '1978-10-08', 2, 'Niemcy', 'średnie',4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (59, false, '16:50:31', '1978-10-08', 3, 'Irlandia', 'wyższe',5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (60, false, '16:50:31', '1978-10-08', 3, 'Polska', 'podstawowe',1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (61, false, '16:50:31', '1978-10-08', 3, 'Polska', 'średnie',3)
ON CONFLICT (voteid) DO NOTHING;


INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (62, false, '16:50:31', '1978-10-08', 3, 'Polska', 'średnie',4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (63, false, '16:50:31', '2000-10-08', 3, 'Polska', 'średnie',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (64, true, '16:50:31', '2000-10-08', 0, 'Irlandia', 'średnie',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (65, true, '16:50:31', '2000-10-08', 1, 'Polska', 'wyższe',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (66, true, '16:50:31', '2000-10-08', 2, 'Polska', 'wyższe',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (67, true, '16:50:31', '2001-10-08', 3, 'Niemcy', 'średnie',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (68, true, '16:50:31', '2001-10-08', 3, 'Niemcy', 'średnie',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (69, true, '16:50:31', '1950-10-08', 0, 'Polska', 'wyższe',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (70, true, '16:50:31', '1955-10-08', 1, 'Polska', 'podstawowe',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (71, true, '16:50:31', '1955-10-08', 2, 'Niemcy', 'średnie',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (72, true, '16:50:31', '1955-10-08', 3, 'Polska', 'wyższe',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (73, false, '16:50:31', '1955-10-08', 0, 'Polska', 'średnie',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (74, false, '16:50:31', '1958-10-08', 1, 'Polska', 'podstawowe',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (75, false, '16:50:31', '1958-10-08', 2, 'Polska', 'podstawowe',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (76, false, '16:50:31', '1958-10-08', 3, 'Niemcy', 'wyższe',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (77, true, '16:50:31', '1958-10-08', 1, 'Irlandia', 'wyższe',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (78, true, '16:50:31', '1989-10-08', 0, 'Irlandia', 'wyższe',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (79, false, '16:50:31', '1989-10-08', 1, 'Polska', 'podstawowe',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (80, false, '16:50:31', '1989-10-08', 2, 'Polska', 'średnie',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (81, true, '16:50:31', '1989-10-08', 3, 'Polska', 'wyższe',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (82, false, '16:50:31', '1989-10-08', 3, 'Polska', 'wyższe',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (83, true, '16:50:31', '1989-10-08', 0, 'Polska', 'podstawowe',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (84, true, '16:50:31', '1989-10-08', 1, 'Irlandia', 'wyższe',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (85, true, '16:50:31', '1989-10-08', 0, 'Polska', 'wyższe',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (86, true, '16:50:31', '1989-10-08', 0, 'Niemcy', 'średnie',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (87, true, '16:50:31', '1989-10-08', 0, 'Polska', 'wyższe',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (88, false, '16:50:31', '1989-10-08', 0, 'Polska', 'wyższe',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (89, true, '16:50:31', '1989-10-08', 2, 'Polska', 'wyższe',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (90, true, '16:50:31', '1989-10-08', 3, 'Polska', 'podstawowe',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (91, false, '16:50:31', '1989-10-08', 0, 'Polska', 'wyższe',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (92, true, '16:50:31', '1989-10-08', 1, 'Polska', 'podstawowe',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (93, true, '16:50:31', '1989-10-08', 2, 'Irlandia', 'wyższe',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (94, true, '16:50:31', '1989-10-08', 3, 'Polska', 'wyższe',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (95, true, '16:50:31', '1989-10-08', 1, 'Niemcy', 'podstawowe',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (96, true, '16:50:31', '1979-10-08', 2, 'Polska', 'podstawowe',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (97, true, '16:50:31', '1979-10-08', 3, 'Polska', 'wyższe',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (98, false, '16:50:31', '1979-10-08', 0, 'Polska', 'wyższe',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (99, false, '16:50:31', '1979-10-08', 1, 'Polska', 'średnie',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (100, false, '16:50:31', '1979-10-08', 2, 'Polska', 'wyższe',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (101, false, '16:50:31', '1979-10-08', 3, 'Polska', 'wyższe',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (102, true, '16:50:31', '1979-10-08', 0, 'Polska', 'wyższe',15)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (103, true, '16:50:31', '1950-10-08', 1, 'Niemcy', 'podstawowe',16)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (104, false, '16:50:31', '1950-10-08', 2, 'Polska', 'podstawowe',17)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (105, false, '16:50:31', '1950-10-08', 3, 'Polska', 'podstawowe',18)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (106, true, '16:50:31', '1950-10-08', 3, 'Polska', 'podstawowe',18)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (107, true, '16:50:31', '1950-10-08', 3, 'Polska', 'podstawowe',19)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (108, true, '16:50:31', '1950-10-08', 0, 'Polska', 'wyższe',20)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (109, true, '16:50:31', '1950-10-08', 1, 'Polska', 'średnie',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (110, true, '16:50:31', '2000-10-08', 1, 'Polska', 'wyższe',7)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (111, false, '16:50:31', '2000-10-08', 2, 'Polska', 'wyższe',8)
ON CONFLICT (voteid) DO NOTHING;
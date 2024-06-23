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
VALUES (1, 'Wybory parlamentarne - sejm','2024-06-24','2024-06-24', 'Parliamentary')
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (2, 'Wybory parlamentarne - senat','2024-06-24','2024-06-24', 'Senate')
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (3, 'Wybory prezydenckie','2024-09-26','2024-09-25', 'Presidential')
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (4, 'Wybory samorządowe - gimna','2025-09-26','2025-09-25', 'LocalGovernment')
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (5, 'Wybory samorządowe - powiat','2025-09-26','2025-09-25', 'LocalGovernment')
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (6, 'Wybory samorządowe - województwo','2025-09-26','2025-09-25', 'LocalGovernment')
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (7, 'Wybory parlamentarne - sejm','2020-09-26','2020-09-25', 'Parliamentary')
ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (8, 'Wybory parlamentarne - sejm','2016-09-26','2016-09-25', 'Parliamentary')
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

--sejm1
INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc', 1, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('2ef5a787-fcc3-4f07-93e4-5e91ee051b9a', 2, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('77bd481c-abd3-4f2a-a9ed-6b7cc6af5678', 3, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;


INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('5c6ca58c-e19d-48ba-a6bb-57331ee91cf3', 4, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('4c7509bd-e9da-4d49-ac83-7ad1503b2bbe', 5, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('8d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 6, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('9d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 7, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('60e87cd2-a46b-4fb8-8e72-0d0e9e63d8b0', 8, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('0c2cdf82-08e1-410c-bc41-55ae53171391', 9, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('8df0ef8d-38a7-42f9-b618-6915f78e08d3', 10, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('f13020af-f4d8-43e9-a00c-089442db4729', 11, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('ff51e390-70e4-4fdc-8f32-d68c8dd83482', 12, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('de81eba0-a8f7-48a6-bdb6-71ebb52bed8e', 13, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('bca10d4e-8f17-4995-9efb-69e69e1393d5', 14, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('cd887a30-cfbd-466a-acd4-5ce4a26568b2', 15, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('17680e70-46b8-4c7f-b23d-4af75f5b50f3', 16, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('675b586e-a54d-46ab-9304-6d266997314b', 17, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('e9b8ffa6-cd4a-4625-b65f-e6e25d3fa946', 18, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('eb7aaa86-4d89-42e2-835c-5d423b7067b1', 19, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('0bd6f193-e8e1-4a5f-bd81-ecaee4bda9ec', 20, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('1b6e832e-481f-48e1-a20a-0e323c34321e', 21, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('b7f832dc-f3eb-4fd8-9a2b-5a74d6b4ac3a', 22, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('6a054862-015e-4e10-8c24-4215beec5d3e', 23, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('5944cb14-ca9a-426b-ae94-95cd99334d2f', 24, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('681d5c6d-3830-4d33-9bd9-1b2e0165dda0', 25, 'Parliamentary')
ON CONFLICT (precinct_uuid) DO NOTHING;


--senat1
INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('ec4144e5-5df2-40de-9a01-c39b60d98764', 3, 'Senate')
ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('174857a5-cb83-413c-bfe6-f652e66c4923', 23, 'Senate')
ON CONFLICT (precinct_uuid) DO NOTHING;

--sejm1kandydaci
INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           1,
           '1988-04-20',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-23_095148412.png',
           'Głosuj na mnie a Polska będzie silna. Bóg, Honor, Ojczyzna.',
           'Michał',
           'Kot',
           'administrator baz danych',
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
           'inżynier budownictwa',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'średnie',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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

--senat1kandydaci

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           21,
           '1962-03-19',
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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
           'wyższe',
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

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           27,
           '1988-04-20',
           'inżynier informatyki',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-11_211139026.png',
           'Cos tam cos tam.',
           'Michał',
           'Kot',
           'Szefunio',
           7,
           1,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           28,
           '1980-03-25',
           'doktor nauk prawnych',
           'https://storage.googleapis.com/evote_c/kan1.png',
           'Zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. Walka z nierównościami społecznymi poprzez wprowadzenie programów pomocy socjalnej i podniesienie płacy minimalnej.',
           'Andrzej',
           'Piaseczny',
           'Prawnik',
           7,
           1,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

--sejm2kandydaci

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           29,
           '1988-04-20',
           'inżynier informatyki',
           'https://storage.googleapis.com/evote_c/obraz_2024-05-22_085300374.png',
           'Mój plan wyborczy zakłada wzmocnienie gospodarki przez obniżenie podatków dla małych i średnich przedsiębiorstw oraz inwestycje w nowoczesne technologie i infrastrukturę.',
           'Anna',
           'Małomówna',
           'Administrator baz danych',
           7,
           2,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           30,
           '1960-01-22',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_025042065.png',
           'Oczywiście Polska tylko dla Polaków. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Krzysztof',
           'Waligóra',
           'doradca podatkowy',
           7,
           2,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           31,
           '1989-06-22',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_025451889.png',
           'Dodatki socjalne dla rodzin z dziećmi, zwiększenie dostępu do opieki medycznej oraz walka z korupcją w administracji publicznej.',
           'Maria',
           'Laskowska',
           'profesor prawa',
           7,
           3,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           31,
           '1974-04-21',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_030253175.png',
           'Zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. ',
           'Piotr',
           'Guzek',
           'rolnik',
           7,
           3,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           32,
           '1984-04-21',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031428363.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Michał',
           'Klimaczak',
           'prawnik',
           7,
           4,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           33,
           '1984-04-21',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031428363.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. ',
           'Michał',
           'Klimaczak',
           'prawnik',
           7,
           4,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           34,
           '1980-07-11',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031806775.png',
           'Wolna i suwerenna Polska. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Wojciech',
           'Kaczmarek',
           'programista Java',
           7,
           4,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           35,
           '1970-02-14',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_032105345.png',
           'Stop korupcji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Aleksander',
           'Maruda',
           'komornik sądowy',
           7,
           5,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           36,
           '1960-11-14',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_032345581.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Elżbieta',
           'Kotek',
           'nauczycielka',
           7,
           5,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           37,
           '1977-11-14',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_033522952.png',
           'Wszystko dla Polski. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Michał',
           'Kotecki',
           'nauczyciel',
           7,
           1,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           38,
           '1979-01-14',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_033752771.png',
           'Podatki tylko dla bogatych. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Szymon',
           'Kołecki',
           'sportowiec',
           7,
           1,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           39,
           '1989-01-24',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034045514.png',
           'Ograniczenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo.',
           'Michalina',
           'Piotrowska',
           'prawniczka',
           7,
           2,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           40,
           '1982-06-24',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034305890.png',
           'Polska powinna wystąpić z Unii Europejskiej. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Piotr',
           'Nowak',
           'programista',
           7,
           2,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           41,
           '1972-06-24',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034631231.png',
           'Głosuj na mnie a Polska będzie silna. Bóg, Honor, Ojczyzna.',
           'Jakub',
           'Kowalski',
           'przedstawiciel handlowy',
           7,
           3,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           42,
           '1988-09-24',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034840978.png',
           'Podać Polskę w ręce młodych. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Anna',
           'Kowalska',
           'naukowiec',
           7,
           3,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           43,
           '1982-03-21',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_035135548.png',
           'Ta Polska to nasza Polska. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Piotr',
           'Myślak',
           'przedsiębiorca',
           7,
           4,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           44,
           '1987-07-04',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_035445767.png',
           'Jeszcze Polska nie zginęła. Unia Europejska to zło. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Krzysztof',
           'Piątek',
           'sportowiec',
           7,
           4,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           45,
           '1985-09-14',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_035842525.png',
           'Już czas na zmiany. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Anita',
           'Piąteczek',
           'sprzedawca',
           7,
           5,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           46,
           '1990-09-14',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_040705009.png',
           'Polska dla Polaków. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Piotr',
           'Kowalski',
           'programista',
           7,
           5,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

---sejm3kandydaci
INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           47,
           '1988-04-20',
           'inżynier informatyki',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-11_211139026.png',
           'Cos tam cos tam.',
           'Michał',
           'Kot',
           'Szefunio',
           8,
           1,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           48,
           '1980-03-25',
           'doktor nauk prawnych',
           'https://storage.googleapis.com/evote_c/kan1.png',
           'Zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. Walka z nierównościami społecznymi poprzez wprowadzenie programów pomocy socjalnej i podniesienie płacy minimalnej.',
           'Andrzej',
           'Piaseczny',
           'Prawnik',
           8,
           1,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;



INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           49,
           '1988-04-20',
           'inżynier informatyki',
           'https://storage.googleapis.com/evote_c/obraz_2024-05-22_085300374.png',
           'Mój plan wyborczy zakłada wzmocnienie gospodarki przez obniżenie podatków dla małych i średnich przedsiębiorstw oraz inwestycje w nowoczesne technologie i infrastrukturę.',
           'Anna',
           'Małomówna',
           'Administrator baz danych',
           8,
           2,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           50,
           '1960-01-22',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_025042065.png',
           'Oczywiście Polska tylko dla Polaków. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Krzysztof',
           'Waligóra',
           'doradca podatkowy',
           8,
           2,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           51,
           '1989-06-22',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_025451889.png',
           'Dodatki socjalne dla rodzin z dziećmi, zwiększenie dostępu do opieki medycznej oraz walka z korupcją w administracji publicznej.',
           'Maria',
           'Laskowska',
           'profesor prawa',
           8,
           3,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           52,
           '1974-04-21',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_030253175.png',
           'Zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. ',
           'Piotr',
           'Guzek',
           'rolnik',
           8,
           3,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           53,
           '1984-04-21',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031428363.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Michał',
           'Klimaczak',
           'prawnik',
           8,
           4,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           54,
           '1984-04-21',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031428363.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. ',
           'Michał',
           'Klimaczak',
           'prawnik',
           8,
           4,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           55,
           '1980-07-11',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031806775.png',
           'Wolna i suwerenna Polska. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Wojciech',
           'Kaczmarek',
           'programista Java',
           8,
           4,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           56,
           '1970-02-14',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_032105345.png',
           'Stop korupcji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Aleksander',
           'Maruda',
           'komornik sądowy',
           8,
           5,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           57,
           '1960-11-14',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_032345581.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Elżbieta',
           'Kotek',
           'nauczycielka',
           8,
           5,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           58,
           '1977-11-14',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_033522952.png',
           'Wszystko dla Polski. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Michał',
           'Kotecki',
           'nauczyciel',
           8,
           1,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           59,
           '1979-01-14',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_033752771.png',
           'Podatki tylko dla bogatych. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Szymon',
           'Kołecki',
           'sportowiec',
           8,
           1,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           60,
           '1989-01-24',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034045514.png',
           'Ograniczenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo.',
           'Michalina',
           'Piotrowska',
           'prawniczka',
           8,
           2,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           61,
           '1982-06-24',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034305890.png',
           'Polska powinna wystąpić z Unii Europejskiej. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Piotr',
           'Nowak',
           'programista',
           8,
           2,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           62,
           '1972-06-24',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034631231.png',
           'Głosuj na mnie a Polska będzie silna. Bóg, Honor, Ojczyzna.',
           'Jakub',
           'Kowalski',
           'przedstawiciel handlowy',
           8,
           3,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;


INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           63,
           '1988-09-24',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034840978.png',
           'Podać Polskę w ręce młodych. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Anna',
           'Kowalska',
           'naukowiec',
           8,
           3,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

INSERT INTO candidate (candidate_id, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           64,
           '1982-03-21',
           'wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_035135548.png',
           'Ta Polska to nasza Polska. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Piotr',
           'Myślak',
           'przedsiębiorca',
           8,
           4,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
ON CONFLICT (candidate_id) DO NOTHING;

--sejmsenatglosy

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (1,true, '10:34:56', '2024-06-015', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (2,true, '10:34:56', '2024-06-015', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (3,true, '10:34:56', '2024-06-015', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 3)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (4,true, '10:34:56', '2024-06-015', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (5, false, '08:25:47', '1988-02-28', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY', 5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (6, true, '16:05:38', '1995-07-17', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 6)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (7, false, '12:30:22', '1982-09-30', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 7)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (8, true, '15:12:18', '1991-05-10', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 8)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (9, false, '10:45:50', '1984-08-25', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 9)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (10, true, '11:55:33', '1976-04-14', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 10)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (11, false, '09:05:12', '1980-01-06', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 11)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (12, true, '14:30:45', '1993-03-18', 'OVER500THOUSAND', 'Polska', 'PRIMARY', 12)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (13, false, '16:40:27', '1987-10-21', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY', 13)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (14, true, '12:15:36', '1975-07-12', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY', 14)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (15, false, '08:50:48', '1994-06-03', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY', 15)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (16, true, '17:20:59', '1989-02-11', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 16)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (17, false, '11:05:12', '1977-05-29', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY', 17)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (18, true, '13:40:23', '1986-09-18', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 18)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (19, false, '10:15:48', '1992-11-14', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 19)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (20, true, '14:10:36', '1983-08-09', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 20)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (21, false, '09:25:17', '1979-04-23', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (22, true, '15:30:29', '1990-07-06', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (23, false, '12:45:38', '1996-12-17', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (24, true, '08:05:42', '1981-01-19', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (25, false, '13:20:13', '1985-06-25', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY', 25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (26, true, '16:50:31', '1993-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY', 26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (27, true, '16:50:31', '1993-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY', 25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (28, true, '16:50:31', '1993-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (29, true, '16:50:31', '1993-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 23)
ON CONFLICT (voteid) DO NOTHING;


INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (30, false, '16:50:31', '1953-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'PRIMARY', 23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (31, false, '16:50:31', '1956-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY', 22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (32, false, '16:50:31', '1996-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'POST_SECONDARY', 26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (33, true, '16:50:31', '1996-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'SECONDARY', 25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (33, true, '16:50:31', '1996-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'SECONDARY', 24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (34, true, '16:50:31', '1956-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'SECONDARY', 4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (35, false, '16:50:31', '1956-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'SECONDARY', 5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (36, false, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'PRIMARY', 2)
ON CONFLICT (voteid) DO NOTHING;


INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (37, false, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (38, true, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (39, true, '16:50:31', '2001-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 2)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (40, true, '16:50:31', '1951-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'PRIMARY', 3)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (41, true, '16:50:31', '1971-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY', 5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (42, true, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY', 4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (43, true, '16:50:31', '1952-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (44, true, '16:50:31', '1952-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 2)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (45, true, '16:50:31', '1952-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 3)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (46, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (47, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (48, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (49, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Irlandia', 'POST_SECONDARY', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (50, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'POST_SECONDARY', 2)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (51, true, '16:50:31', '1968-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY', 1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (52, false, '16:50:31', '1968-10-08', 'BELOWFIFTYTHOUSAND', 'Irlandia', 'POST_SECONDARY', 2)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (53, true, '16:50:31', '1968-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 3)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (54, false, '16:50:31', '1968-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 3)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (55, false, '16:50:31', '1968-10-08', 'OVER500THOUSAND', 'Polska', 'PRIMARY',4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (56, false, '16:50:31', '1968-10-08', 'OVER500THOUSAND', 'Irlandia', 'SECONDARY',5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (57, false, '16:50:31', '1978-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY',4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (58, false, '16:50:31', '1978-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'SECONDARY',4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (59, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Irlandia', 'POST_SECONDARY',5)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (60, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',1)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (61, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY',3)
ON CONFLICT (voteid) DO NOTHING;


INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (62, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY',4)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (63, false, '16:50:31', '2000-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (64, true, '16:50:31', '2000-10-08', 'OVER500THOUSAND', 'Irlandia', 'SECONDARY',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (65, true, '16:50:31', '2000-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (66, true, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (67, true, '16:50:31', '2001-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'SECONDARY',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (68, true, '16:50:31', '2001-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'SECONDARY',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (69, true, '16:50:31', '1950-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (70, true, '16:50:31', '1955-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (71, true, '16:50:31', '1955-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'SECONDARY',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (72, true, '16:50:31', '1955-10-08',  'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (73, false, '16:50:31', '1955-10-08', 'OVER500THOUSAND', 'Polska', 'SECONDARY',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (74, false, '16:50:31', '1958-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (75, false, '16:50:31', '1958-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (76, false, '16:50:31', '1958-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'POST_SECONDARY',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (77, true, '16:50:31', '1958-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'POST_SECONDARY',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (78, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Irlandia', 'POST_SECONDARY',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (79, false, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (80, false, '16:50:31', '1989-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (81, true, '16:50:31', '1989-10-08',  'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (82, false, '16:50:31', '1989-10-08',  'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (83, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'PRIMARY',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (84, true, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'POST_SECONDARY',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (85, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (86, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Niemcy', 'SECONDARY',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (87, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (88, false, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (89, true, '16:50:31', '1989-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (90, true, '16:50:31', '1989-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (91, false, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (92, true, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (93, true, '16:50:31', '1989-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (94, true, '16:50:31', '1989-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (95, true, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Niemcy', 'PRIMARY',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (96, true, '16:50:31', '1979-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (97, true, '16:50:31', '1979-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',22)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (98, false, '16:50:31', '1979-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',23)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (99, false, '16:50:31', '1979-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY',24)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (100, false, '16:50:31', '1979-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',25)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (101, false, '16:50:31', '1979-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',26)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (102, true, '16:50:31', '1979-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',15)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (103, true, '16:50:31', '1950-10-08', 'TWOHUNDREDTO500THOUSAND', 'Niemcy', 'PRIMARY',16)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (104, false, '16:50:31', '1950-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY',17)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (105, false, '16:50:31', '1950-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',18)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (106, true, '16:50:31', '1950-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',18)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (107, true, '16:50:31', '1950-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',19)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (108, true, '16:50:31', '1950-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',20)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (109, true, '16:50:31', '1950-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY',21)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (110, true, '16:50:31', '2000-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY',7)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (111, false, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',8)
ON CONFLICT (voteid) DO NOTHING;

--sejm2glosy

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (112,true, '10:34:56', '2024-06-015', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 44)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (113,true, '10:34:56', '2024-06-015', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY', 29)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (114,true, '10:34:56', '2024-06-015', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 35)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (115,true, '10:34:56', '2024-06-015', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 41)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (116, false, '08:25:47', '1988-02-28', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY', 44)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (117, true, '16:05:38', '1995-07-17', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY',44 )
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (118, false, '12:30:22', '1982-09-30', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 39)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (119, true, '15:12:18', '1991-05-10', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 37)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (120, false, '10:45:50', '1984-08-25', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 44)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (121, true, '11:55:33', '1976-04-14', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 32)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (122, false, '09:05:12', '1980-01-06', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 33)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (123, true, '14:30:45', '1993-03-18', 'OVER500THOUSAND', 'Polska', 'PRIMARY', 46)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (124, false, '16:40:27', '1987-10-21',  'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY', 35)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (125, true, '12:15:36', '1975-07-12', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY', 29)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (126, false, '08:50:48', '1994-06-03', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY', 34)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (127, true, '17:20:59', '1989-02-11', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 42)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (128, false, '11:05:12', '1977-05-29',  'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY', 37)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (129, true, '13:40:23', '1986-09-18', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 42)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (130, false, '10:15:48', '1992-11-14', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 42)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (131, true, '14:10:36', '1983-08-09', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (132, false, '09:25:17', '1979-04-23', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 31)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (133, true, '15:30:29', '1990-07-06', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 42)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (134, false, '12:45:38', '1996-12-17', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 32)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (135, true, '08:05:42', '1981-01-19', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 42)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (136, false, '13:20:13', '1985-06-25', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY', 42)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (137, true, '16:50:31', '1993-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY', 43)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (138, true, '16:50:31', '1993-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY', 35)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (139, true, '16:50:31', '1993-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 31)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (140, true, '16:50:31', '1993-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 37)
ON CONFLICT (voteid) DO NOTHING;


INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (141, false, '16:50:31', '1953-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'PRIMARY', 34)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (142, false, '16:50:31', '1956-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY', 37)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (143, false, '16:50:31', '1996-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'POST_SECONDARY', 34)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (144, true, '16:50:31', '1996-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'SECONDARY', 36)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (145, true, '16:50:31', '1996-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'SECONDARY', 30)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (146, true, '16:50:31', '1956-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'SECONDARY', 44)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (147, false, '16:50:31', '1956-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'SECONDARY', 45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (148, false, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'PRIMARY', 33)
ON CONFLICT (voteid) DO NOTHING;


INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (149, false, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 44)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (150, true, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (151, true, '16:50:31', '2001-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 31)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (152, true, '16:50:31', '1951-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'PRIMARY', 30)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (153, true, '16:50:31', '1971-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY', 33)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (154, true, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY', 41)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (155, true, '16:50:31', '1952-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 33)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (156, true, '16:50:31', '1952-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 42)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (157, true, '16:50:31', '1952-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 32)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (158, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 40)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (159, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 29)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (160, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 34)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (161, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Irlandia', 'POST_SECONDARY', 29)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (162, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'POST_SECONDARY', 30)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (163, true, '16:50:31', '1968-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY', 43)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (164, false, '16:50:31', '1968-10-08', 'BELOWFIFTYTHOUSAND', 'Irlandia', 'POST_SECONDARY', 39)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (165, true, '16:50:31', '1968-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 41)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (166, false, '16:50:31', '1968-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 41)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (167, false, '16:50:31', '1968-10-08', 'OVER500THOUSAND', 'Polska', 'PRIMARY', 34)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (168, false, '16:50:31', '1968-10-08', 'OVER500THOUSAND', 'Irlandia', 'SECONDARY',31)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (169, false, '16:50:31', '1978-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY',35)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (170, false, '16:50:31', '1978-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'SECONDARY',31)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (171, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Irlandia', 'POST_SECONDARY',39)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (172, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',42)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (173, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY',46)
ON CONFLICT (voteid) DO NOTHING;


INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (174, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY',38)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (175, false, '16:50:31', '2000-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY',39)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (176, true, '16:50:31', '2000-10-08', 'OVER500THOUSAND', 'Irlandia', 'SECONDARY',43)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (177, true, '16:50:31', '2000-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY',42)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (178, true, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (179, true, '16:50:31', '2001-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'SECONDARY',30)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (180, true, '16:50:31', '2001-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'SECONDARY',32)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (181, true, '16:50:31', '1950-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',29)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (182, true, '16:50:31', '1955-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',42)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (183, true, '16:50:31', '1955-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'SECONDARY',30)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (184, true, '16:50:31', '1955-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',32)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (185, false, '16:50:31', '1955-10-08', 'OVER500THOUSAND', 'Polska', 'SECONDARY',44)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (186, false, '16:50:31', '1958-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (187, false, '16:50:31', '1958-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY',37)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (188, false, '16:50:31', '1958-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'POST_SECONDARY',45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (189, true, '16:50:31', '1958-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'POST_SECONDARY',38)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (190, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Irlandia', 'POST_SECONDARY',31)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (191, false, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',41)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (192, false, '16:50:31', '1989-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY',44)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (193, true, '16:50:31', '1989-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',34)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (194, false, '16:50:31', '1989-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',41)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (195, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'PRIMARY',33)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (196, true, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'POST_SECONDARY',45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (197, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',36)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (198, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Niemcy', 'SECONDARY',45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (199, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',38)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (200, false, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',30)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (201, true, '16:50:31', '1989-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',38)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (202, true, '16:50:31', '1989-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',39)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (203, false, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',30)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (204, true, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',38)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (205, true, '16:50:31', '1989-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY',30)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (206, true, '16:50:31', '1989-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (207, true, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Niemcy', 'PRIMARY',39)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (208, true, '16:50:31', '1979-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY',39)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (209, true, '16:50:31', '1979-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (210, false, '16:50:31', '1979-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',33)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (211, false, '16:50:31', '1979-10-08',  'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY',32)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (212, false, '16:50:31', '1979-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',36)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (213, false, '16:50:31', '1979-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',34)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (214, true, '16:50:31', '1979-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',33)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (215, true, '16:50:31', '1950-10-08', 'TWOHUNDREDTO500THOUSAND', 'Niemcy', 'PRIMARY',45)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (216, false, '16:50:31', '1950-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY',34)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (217, false, '16:50:31', '1950-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',34)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (218, true, '16:50:31', '1950-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',44)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (219, true, '16:50:31', '1950-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',38)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (220, true, '16:50:31', '1950-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',40)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (221, true, '16:50:31', '1950-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY',44)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (222, true, '16:50:31', '2000-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY',32)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (223, false, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',41)
ON CONFLICT (voteid) DO NOTHING;

--sejm3glosy

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (224,true, '10:34:56', '2024-06-015', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 47)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (225,true, '10:34:56', '2024-06-015', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY', 55)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (226,true, '10:34:56', '2024-06-015', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 54)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (227,true, '10:34:56', '2024-06-015', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 52)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (228, false, '08:25:47', '1988-02-28', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY', 47)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (229, true, '16:05:38', '1995-07-17', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 64)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (230, false, '12:30:22', '1982-09-30', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 53)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (231, true, '15:12:18', '1991-05-10', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 58)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (232, false, '10:45:50', '1984-08-25', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 52)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (233, true, '11:55:33', '1976-04-14', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 55)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (234, false, '09:05:12', '1980-01-06', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 60)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (235, true, '14:30:45', '1993-03-18', 'OVER500THOUSAND', 'Polska', 'PRIMARY', 47)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (236, false, '16:40:27', '1987-10-21', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY', 57)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (237, true, '12:15:36', '1975-07-12', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY', 64)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (238, false, '08:50:48', '1994-06-03', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY', 64)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (239, true, '17:20:59', '1989-02-11', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 55)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (240, false, '11:05:12', '1977-05-29', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY', 53)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (241, true, '13:40:23', '1986-09-18', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 63)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (242, false, '10:15:48', '1992-11-14', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 57)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (245, true, '14:10:36', '1983-08-09', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 51)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (246, false, '09:25:17', '1979-04-23', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 49)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (247, true, '15:30:29', '1990-07-06', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 58)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (248, false, '12:45:38', '1996-12-17', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY', 62)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (249, true, '08:05:42', '1981-01-19', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 56)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (250, false, '13:20:13', '1985-06-25', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY', 47)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (251, true, '16:50:31', '1993-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY', 47)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (252, true, '16:50:31', '1993-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY', 47)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (253, true, '16:50:31', '1993-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY', 57)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (254, true, '16:50:31', '1993-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 62)
ON CONFLICT (voteid) DO NOTHING;


INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (255, false, '16:50:31', '1953-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'PRIMARY', 63)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (256, false, '16:50:31', '1956-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY', 60)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (257, false, '16:50:31', '1996-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'POST_SECONDARY', 50)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (258, true, '16:50:31', '1996-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'SECONDARY', 53)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (259, true, '16:50:31', '1996-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'SECONDARY', 57)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (260, true, '16:50:31', '1956-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'SECONDARY', 56)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (261, false, '16:50:31', '1956-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'SECONDARY', 59)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (262, false, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'PRIMARY', 50)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (263, false, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 50)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (264, true, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 61)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (265, true, '16:50:31', '2001-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY', 47)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (266, true, '16:50:31', '1951-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'PRIMARY', 61)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (267, true, '16:50:31', '1971-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY', 47)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (268, true, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY', 58)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (269, true, '16:50:31', '1952-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 55)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (270, true, '16:50:31', '1952-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 58)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (271, true, '16:50:31', '1952-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY', 60)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (272, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 53)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (273, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 58)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (274, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 59)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (275, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Irlandia', 'POST_SECONDARY', 51)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (276, true, '16:50:31', '1952-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'POST_SECONDARY', 56)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (277, true, '16:50:31', '1968-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY', 52)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (278, false, '16:50:31', '1968-10-08', 'BELOWFIFTYTHOUSAND', 'Irlandia', 'POST_SECONDARY', 50)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (279, true, '16:50:31', '1968-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY', 56)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (280, false, '16:50:31', '1968-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY', 55)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (281, false, '16:50:31', '1968-10-08', 'OVER500THOUSAND', 'Polska', 'PRIMARY',55)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (282, false, '16:50:31', '1968-10-08', 'OVER500THOUSAND', 'Irlandia', 'SECONDARY',55)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (283, false, '16:50:31', '1978-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY',58)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (284, false, '16:50:31', '1978-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'SECONDARY',63)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (285, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Irlandia', 'POST_SECONDARY',57)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (286, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',49)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (287, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY',62)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (288, false, '16:50:31', '1978-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY',64)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (289, false, '16:50:31', '2000-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'SECONDARY',48)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (290, true, '16:50:31', '2000-10-08', 'OVER500THOUSAND', 'Irlandia', 'SECONDARY',53)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (291, true, '16:50:31', '2000-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY',62)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (292, true, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',48)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (293, true, '16:50:31', '2001-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'SECONDARY',54)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (294, true, '16:50:31', '2001-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'SECONDARY',63)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (295, true, '16:50:31', '1950-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',59)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (296, true, '16:50:31', '1955-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',54)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (297, true, '16:50:31', '1955-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Niemcy', 'SECONDARY',48)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (298, true, '16:50:31', '1955-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',50)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (299, false, '16:50:31', '1955-10-08', 'OVER500THOUSAND', 'Polska', 'SECONDARY',56)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (300, false, '16:50:31', '1958-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',56)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (301, false, '16:50:31', '1958-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY',59)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (302, false, '16:50:31', '1958-10-08', 'BELOWFIFTYTHOUSAND', 'Niemcy', 'POST_SECONDARY',56)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (303, true, '16:50:31', '1958-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'POST_SECONDARY',48)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (304, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Irlandia', 'POST_SECONDARY',52)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (305, false, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',60)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (306, false, '16:50:31', '1989-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'SECONDARY',50)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (307, true, '16:50:31', '1989-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',64)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (308, false, '16:50:31', '1989-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',62)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (309, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'PRIMARY',60)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (310, true, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Irlandia', 'POST_SECONDARY',55)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (311, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',54)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (312, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Niemcy', 'SECONDARY',49)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (313, true, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',62)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (314, false, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',61)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (315, true, '16:50:31', '1989-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',63)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (316, true, '16:50:31', '1989-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',58)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (317, false, '16:50:31', '1989-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',53)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (318, true, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'PRIMARY',47)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (319, true, '16:50:31', '1989-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Irlandia', 'POST_SECONDARY',53)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (320, true, '16:50:31', '1989-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',51)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (321, true, '16:50:31', '1989-10-08', 'TWOHUNDREDTO500THOUSAND', 'Niemcy', 'PRIMARY',55)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (322, true, '16:50:31', '1979-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY',57)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (323, true, '16:50:31', '1979-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',58)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (324, false, '16:50:31', '1979-10-08', 'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',47)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (325, false, '16:50:31', '1979-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY',50)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (326, false, '16:50:31', '1979-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',64)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (327, false, '16:50:31', '1979-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'POST_SECONDARY',59)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (328, true, '16:50:31', '1979-10-08',  'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',48)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (329, true, '16:50:31', '1950-10-08', 'TWOHUNDREDTO500THOUSAND', 'Niemcy', 'PRIMARY',63)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (330, false, '16:50:31', '1950-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'PRIMARY',58)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (331, false, '16:50:31', '1950-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',59)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (332, true, '16:50:31', '1950-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',52)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (333, true, '16:50:31', '1950-10-08', 'BELOWFIFTYTHOUSAND', 'Polska', 'PRIMARY',61)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (334, true, '16:50:31', '1950-10-08',  'OVER500THOUSAND', 'Polska', 'POST_SECONDARY',51)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (335, true, '16:50:31', '1950-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'SECONDARY',53)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (336, true, '16:50:31', '2000-10-08', 'TWOHUNDREDTO500THOUSAND', 'Polska', 'POST_SECONDARY',57)
ON CONFLICT (voteid) DO NOTHING;

INSERT INTO vote (voteid, sex, votetime, voterbirthdate, votercitytype, votercountry, votereducation, candidate_id)
VALUES (337, false, '16:50:31', '2000-10-08', 'FIFTYTOTWOHUNDREDTHOUSAND', 'Polska', 'POST_SECONDARY',51)
ON CONFLICT (voteid) DO NOTHING;
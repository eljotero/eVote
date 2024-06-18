INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (10, 'Nowogrodzka 84/86', 'Warszawa', 'Polska', '02-018')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (20, 'Wiejska 12a', 'Warszawa', 'Polska', '00-490')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (30, 'Piękna 24/26A', 'Warszawa', 'Polska', '00-549')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (40, 'Złota 9', 'Warszawa', 'Polska', '00-019')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (50, 'Marii Konopnickiej 6', 'Warszawa', 'Polska', '00-491')
    ON CONFLICT (address_id) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (10, 'Wybory parlamentarne - sejm','2024-06-26','2024-06-25', 3)
    ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (20, 'Wybory parlamentarne - senat','2024-06-26','2024-06-25', 4)
    ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (3, 'Wybory prezydenckie','2024-09-26','2024-09-25', 2)
    ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (40, 'Wybory samorządowe - gimna','2025-09-26','2025-09-25', 1)
    ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (50, 'Wybory samorządowe - powiat','2025-09-26','2025-09-25', 1)
    ON CONFLICT (electionid) DO NOTHING;

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (60, 'Wybory samorządowe - województwo','2025-09-26','2025-09-25', 1)
    ON CONFLICT (electionid) DO NOTHING;

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (10,'Prawo i Sprawiedliwość', 10)
    ON CONFLICT (politicalpartyid) DO NOTHING;

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (20,'Koalicja Obywatelska', 20)
    ON CONFLICT (politicalpartyid) DO NOTHING;

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (30,'Konfederacja', 30)
    ON CONFLICT (politicalpartyid) DO NOTHING;

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (40,'Nowa Lewica', 40)
    ON CONFLICT (politicalpartyid) DO NOTHING;

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (50,'Trzecia Droga', 50)
    ON CONFLICT (politicalpartyid) DO NOTHING;

--sejm
INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc', 10, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('2ef5a787-fcc3-4f07-93e4-5e91ee051b9a', 20, 3 )
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('77bd481c-abd3-4f2a-a9ed-6b7cc6af5678', 30, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;


INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('5c6ca58c-e19d-48ba-a6bb-57331ee91cf3', 40, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('4c7509bd-e9da-4d49-ac83-7ad1503b2bbe', 50, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('8d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 60, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('9d7ee2bf-0aa3-4152-8003-e8602c0fbffb', 70, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('60e87cd2-a46b-4fb8-8e72-0d0e9e63d8b0', 80, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('0c2cdf82-08e1-410c-bc41-55ae53171391', 90, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('8df0ef8d-38a7-42f9-b618-6915f78e08d3', 100, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('f13020af-f4d8-43e9-a00c-089442db4729', 110, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('ff51e390-70e4-4fdc-8f32-d68c8dd83482', 120, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('de81eba0-a8f7-48a6-bdb6-71ebb52bed8e', 130, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('bca10d4e-8f17-4995-9efb-69e69e1393d5', 140, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('cd887a30-cfbd-466a-acd4-5ce4a26568b2', 150, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('17680e70-46b8-4c7f-b23d-4af75f5b50f3', 160, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('675b586e-a54d-46ab-9304-6d266997314b', 170, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('e9b8ffa6-cd4a-4625-b65f-e6e25d3fa946', 180, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('eb7aaa86-4d89-42e2-835c-5d423b7067b1', 190, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('0bd6f193-e8e1-4a5f-bd81-ecaee4bda9ec', 200, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('1b6e832e-481f-48e1-a20a-0e323c34321e', 210, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('b7f832dc-f3eb-4fd8-9a2b-5a74d6b4ac3a', 220, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('6a054862-015e-4e10-8c24-4215beec5d3e', 230, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('5944cb14-ca9a-426b-ae94-95cd99334d2f', 240, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('681d5c6d-3830-4d33-9bd9-1b2e0165dda0', 250, 3)
    ON CONFLICT (precinct_uuid) DO NOTHING;


--senat
INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('ec4144e5-5df2-40de-9a01-c39b60d98764', 30, 4)
    ON CONFLICT (precinct_uuid) DO NOTHING;

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES('174857a5-cb83-413c-bfe6-f652e66c4923', 230, 4)
    ON CONFLICT (precinct_uuid) DO NOTHING;


INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           10,
           '1988-04-20',
           'inżynier informatyki',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-11_211139026.png',
           'Cos tam cos tam.',
           'Michał',
           'Kot',
           'Szefunio',
           10,
           10,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           20,
           '1980-03-25',
           'doktor nauk prawnych',
           'https://storage.googleapis.com/evote_c/kan1.png',
           'Zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. Walka z nierównościami społecznymi poprzez wprowadzenie programów pomocy socjalnej i podniesienie płacy minimalnej.',
           'Andrzej',
           'Piaseczny',
           'Prawnik',
           10,
           10,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;



INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           30,
           '1988-04-20',
           'inżynier informatyki',
           'https://storage.googleapis.com/evote_c/obraz_2024-05-22_085300374.png',
           'Mój plan wyborczy zakłada wzmocnienie gospodarki przez obniżenie podatków dla małych i średnich przedsiębiorstw oraz inwestycje w nowoczesne technologie i infrastrukturę.',
           'Anna',
           'Małomówna',
           'Administrator baz danych',
           10,
           20,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           40,
           '1960-01-22',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_025042065.png',
           'Oczywiście Polska tylko dla Polaków. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Krzysztof',
           'Waligóra',
           'doradca podatkowy',
           10,
           20,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           50,
           '1989-06-22',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_025451889.png',
           'Dodatki socjalne dla rodzin z dziećmi, zwiększenie dostępu do opieki medycznej oraz walka z korupcją w administracji publicznej.',
           'Maria',
           'Laskowska',
           'profesor prawa',
           10,
           30,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           60,
           '1974-04-21',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_030253175.png',
           'Zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. ',
           'Piotr',
           'Guzek',
           'rolnik',
           10,
           30,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           70,
           '1984-04-21',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031428363.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Michał',
           'Klimaczak',
           'prawnik',
           10,
           40,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           70,
           '1984-04-21',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031428363.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. ',
           'Michał',
           'Klimaczak',
           'prawnik',
           10,
           40,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           80,
           '1980-07-11',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_031806775.png',
           'Wolna i suwerenna Polska. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Wojciech',
           'Kaczmarek',
           'programista Java',
           10,
           40,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           90,
           '1970-02-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_032105345.png',
           'Stop korupcji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Aleksander',
           'Maruda',
           'komornik sądowy',
           10,
           50,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           100,
           '1960-11-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_032345581.png',
           'Zmniejszenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach.',
           'Elżbieta',
           'Kotek',
           'nauczycielka',
           10,
           50,
           '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc'
       )
    ON CONFLICT (candidateid) DO NOTHING;


INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           110,
           '1977-11-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_033522952.png',
           'Wszystko dla Polski. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Michał',
           'Kotecki',
           'nauczyciel',
           10,
           10,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           120,
           '1979-01-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_033752771.png',
           'Podatki tylko dla bogatych. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Szymon',
           'Kołecki',
           'sportowiec',
           10,
           10,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           130,
           '1989-01-24',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034045514.png',
           'Ograniczenie biurokracji, zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo.',
           'Michalina',
           'Piotrowska',
           'prawniczka',
           10,
           20,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           140,
           '1982-06-24',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034305890.png',
           'Polska powinna wystąpić z Unii Europejskiej. Wprowadzenie surowych kar dla przestępców oraz zaostrzenie kar dla handlarzy narkotyków.',
           'Piotr',
           'Nowak',
           'programista',
           10,
           20,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
    ON CONFLICT (candidateid) DO NOTHING;


INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           150,
           '1972-06-24',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034631231.png',
           'Głosuj na mnie a Polska będzie silna. Bóg, Honor, Ojczyzna.',
           'Jakub',
           'Kowalski',
           'przedstawiciel handlowy',
           10,
           30,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
    ON CONFLICT (candidateid) DO NOTHING;


INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           160,
           '1988-09-24',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_034840978.png',
           'Podać Polskę w ręce młodych. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Anna',
           'Kowalska',
           'naukowiec',
           10,
           30,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           170,
           '1982-03-21',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_035135548.png',
           'Ta Polska to nasza Polska. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Piotr',
           'Myślak',
           'przedsiębiorca',
           10,
           40,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           180,
           '1987-07-04',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_035445767.png',
           'Jeszcze Polska nie zginęła. Unia Europejska to zło. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Krzysztof',
           'Piątek',
           'sportowiec',
           10,
           40,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           190,
           '1985-09-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_035842525.png',
           'Już czas na zmiany. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Anita',
           'Piąteczek',
           'sprzedawca',
           10,
           50,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           200,
           '1990-09-14',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_040705009.png',
           'Polska dla Polaków. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Piotr',
           'Kowalski',
           'programista',
           10,
           50,
           '0c2cdf82-08e1-410c-bc41-55ae53171391'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           210,
           '1962-03-19',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_041232980.png',
           'Zakaz handlu w niedziele. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Adam',
           'Kaczmarek',
           'przedsiębiorca',
           20,
           10,
           'ec4144e5-5df2-40de-9a01-c39b60d98764'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           220,
           '1972-03-19',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_041526081.png',
           'Nowe miejsca pracy. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Karolina',
           'Wójcik',
           'nauczycielka',
           20,
           20,
           'ec4144e5-5df2-40de-9a01-c39b60d98764'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           230,
           '1982-03-19',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_041838954.png',
           'Nie dla Unii Europejskiej. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Mikołaj',
           'Michalski',
           'programista',
           20,
           30,
           'ec4144e5-5df2-40de-9a01-c39b60d98764'
       )
    ON CONFLICT (candidateid) DO NOTHING;


INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           240,
           '1982-05-19',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_041838954.png',
           'Nie dla Unii Europejskiej. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Piotr',
           'Kołeczek',
           'rolnik',
           20,
           10,
           '174857a5-cb83-413c-bfe6-f652e66c4923'
       )
    ON CONFLICT (candidateid) DO NOTHING;


INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           250,
           '1989-05-19',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_043828059.png',
           'Podatki tylko dla bogatych. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Marta',
           'Kwiecień',
           'nauczycielka',
           20,
           20,
           '174857a5-cb83-413c-bfe6-f652e66c4923'
       )
    ON CONFLICT (candidateid) DO NOTHING;

INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           260,
           '1979-09-29',
           'wykształcenie wyższe',
           'https://storage.googleapis.com/evote_c/obraz_2024-06-12_044124541.png',
           'Uniwersalne 500+ dla wszystkich. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
           'Krzysztof',
           'Piotrowski',
           'przedsiębiorca',
           20,
           30,
           '174857a5-cb83-413c-bfe6-f652e66c4923'
       )
    ON CONFLICT (candidateid) DO NOTHING;
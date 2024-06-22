INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (1, 'Nowogrodzka 84/86', 'Warszawa', 'Polska', '02-018');

INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (2, 'Wiejska 12a', 'Warszawa', 'Polska', '00-490');

INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (3, 'Wiejska 12a', 'Warszawa', 'Polska', '00-490');

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (10, 'Prawo i Sprawiedliwość', 1);

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (11, 'Koalicja Obywatelska', 2);

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES ('7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc', 1, 'Parliamentary');

INSERT INTO precinct (precinct_uuid, precinct_id, electiontype)
VALUES ('ec4144e5-5df2-40de-9a01-c39b60d98764', 3, 'Senate');

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (1, 'Wybory parlamentarne - sejm', '2024-06-24', '2024-06-24', 'Parliamentary');

INSERT INTO election (electionid, electionname, enddate, startdate, type)
VALUES (2, 'Wybory parlamentarne - senat', '2024-06-24', '2024-06-24', 'Senate');

INSERT INTO candidate (candidate_id, birthdate, education, image, info, name, surname, profession, election_id,
                       political_party_id, precinct_id)
VALUES (1,
        '1988-04-20',
        'inżynier informatyki',
        'https://storage.googleapis.com/evote_c/obraz_2024-06-11_211139026.png',
        'Cos tam cos tam.',
        'Michał',
        'Kot',
        'Szefunio',
        1,
        10,
        '7d47bf12-1e1b-4c4e-9f62-aa669e17bcfc');

INSERT INTO candidate (candidate_id, birthdate, education, image, info, name, surname, profession, election_id,
                       political_party_id, precinct_id)
VALUES (2,
        '1962-03-19',
        'wykształcenie POST_SECONDARY',
        'https://storage.googleapis.com/evote_c/obraz_2024-06-12_041232980.png',
        'Zakaz handlu w niedziele. Polska powinna opierać się na wartościach chrześcijańskich oraz tradycyjnych wartościach polskiej rodziny.',
        'Adam',
        'Kaczmarek',
        'przedsiębiorca',
        2,
        11,
        'ec4144e5-5df2-40de-9a01-c39b60d98764');
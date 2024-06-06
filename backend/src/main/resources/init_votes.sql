INSERT INTO address (address_id, address_line, city, country, zip_code)
VALUES (1, 'address', 'Brzeziny', 'Polska', 12-000);

INSERT INTO election (electionid, electionname, enddate, startdate)
VALUES (1, 'Wybory parlamentarne','2024-06-30','2024-06-01');

INSERT INTO election (electionid, electionname, enddate, startdate)
VALUES (2, '','2024-06-30','2024-06-01');

INSERT INTO political_party (politicalpartyid, name, address_id)
VALUES (1,'Prawo i Sprawiedliwość', 1);

INSERT INTO precinct (precinct_id)
VALUES (1);


INSERT INTO precinct (precinct_id)
VALUES (42);


INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           1,
           '1980-03-25',
           'doktor nauk prawnych',
           'https://storage.googleapis.com/evote_c/kan1.png',
           'Zwiększenie dostępu do edukacji poprzez inwestycje w szkolnictwo publiczne oraz wsparcie dla uczniów z rodzin o niższych dochodach. Walka z nierównościami społecznymi poprzez wprowadzenie programów pomocy socjalnej i podniesienie płacy minimalnej.',
           'Andrzej',
           'Piaseczny',
           'Prawnik',
           1,
           1,
           1
       );


INSERT INTO candidate (candidateid, birthdate, education,image, info, name, surname, profession, election_id, political_party_id, precinct_id)
VALUES (
           2,
           '1988-04-20',
           'inżynier informatyki',
           'https://storage.googleapis.com/evote_c/obraz_2024-05-22_085300374.png',
           'Mój plan wyborczy zakłada wzmocnienie gospodarki przez obniżenie podatków dla małych i średnich przedsiębiorstw oraz inwestycje w nowoczesne technologie i infrastrukturę.',
           'Anna',
           'Małomówna',
           'Administrator baz danych',
           2,
           1,
           42
       );
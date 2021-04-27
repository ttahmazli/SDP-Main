-- CONTACT TABLE AND OPERATIONS--

-- addedBy VARCHAR can be added to these tables for multiuser test;

DROP TABLE IF EXISTS contacts;

CREATE TABLE IF NOT EXISTS contacts
(
    id
        serial
        PRIMARY
            KEY,
    addedby
        VARCHAR,
    name
        VARCHAR,
    surname
        VARCHAR,
    phone
        VARCHAR,
    email
        VARCHAR,
    type
        VARCHAR,
    info
        VARCHAR

);

INSERT INTO contacts(addedby, name, surname, phone, email, type, info)
VALUES ('user', 'User', 'User', '50 541 12 12', 'ttahmazli@g.co', 'PARTNER', 'My friend'),
       ('togrul', 'Togrul', 'Tahmazli', '50 541 13 13', 'ayusifzada@g.co', 'CLIENT', 'My friend'),
       ('user', 'Useeeer', 'Useeeer', '50 541 12 12', 'ttah@g.co', 'CLIENT', 'My friend'),
       ('togrul', 'Azada', 'Yusifzada', '50 541 13 13', 'azada@g.co', 'COWORKER', 'My friend');

-- END OF CONTACTS --

-- TICKET TABLE --

DROP TABLE IF EXISTS tickets;

CREATE TABLE IF NOT EXISTS tickets
(
    id
        serial
        PRIMARY
            KEY,
    addedby
        VARCHAR,
    heading
        VARCHAR,
    category
        VARCHAR,
    date
        TIMESTAMP,
    status
        VARCHAR,
    problem
        VARCHAR,
    answer
        VARCHAR
);

INSERT INTO tickets(addedby, heading, category, date, status, problem)
VALUES ('user', 'No contacts', 'Credentials', '2021-03-04', 'PENDING', 'I cannot see my contacts when I log in'),
       ('togrul', 'Incorrect contacts', 'UI', '2021-02-04', 'PENDING', 'I cannot see contacts properly when I log in'),
       ('user', 'No contacts', 'UI', '2021-03-04', 'PENDING', 'I cannot log out'),
       ('togrul', 'Incorrect contacts', 'UI', '2021-02-04', 'PENDING', 'UI is freezing');

-- END OF TICKETS


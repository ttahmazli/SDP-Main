-- BILL TABLE AND OPERATIONS--

DROP TABLE IF EXISTS bills;

CREATE TABLE IF NOT EXISTS bills
(
    id
        serial
        PRIMARY
            KEY,
    bill_date
        TIMESTAMP,
    due_date
        TIMESTAMP,
    vendor
        VARCHAR,
    item
        VARCHAR,
    category
        VARCHAR,
    description
        VARCHAR,
    cost
        bigint,
    currency
        VARCHAR,
    count
        bigint,
    status
        VARCHAR

);

INSERT INTO bills(bill_date, due_date, vendor, item, category, description, cost, currency, count, status)
VALUES ('2021-04-04', '2021-04-04', 'Toghrul Tahmazli', 'Tomato', 'Goods Sold', 'Sold tomatoes', 2, 'AZN', 400,
        'PENDING'),
       ('2021-04-04', '2021-04-04', 'Toghrul Tahmazli', 'Tomato', 'Goods Sold', 'Sold tomatoes', 4, 'AZN', 500,
        'PENDING');

-- END OF BILLS --

-- VENDOR TABLE --

DROP TABLE IF EXISTS vendors;

CREATE TABLE IF NOT EXISTS vendors
(
    id
        serial
        PRIMARY KEY,
    full_name
        VARCHAR,
    email
        VARCHAR,
    phone
        VARCHAR,
    deposit
        bigint,
    currency
        VARCHAR
);

INSERT INTO vendors(full_name, email, phone, deposit, currency)
VALUES ('Tom Jones', 'info@tomjones.com', '50 500 15 15', 5000, 'AZN'),
       ('John Wick', 'info@johnwick.com', '70 777 77 77', 50000, 'USD');

-- END OF VENDORS --

-- ORDER TABLE --

DROP TABLE IF EXISTS orders;

CREATE TABLE IF NOT EXISTS orders
(
    id
        serial
        PRIMARY KEY,
    status
        VARCHAR,
    vendor
        VARCHAR,
    price
        bigint,
    currency
        VARCHAR,
    date
        TIMESTAMP,
    phone
        VARCHAR,
    address
        VARCHAR,
    notes
        VARCHAR
);

INSERT INTO orders(status, vendor, price, currency, date, phone, address, notes)
VALUES ('PENDING', 'Tom Jones', 550, 'AZN', '2021-03-04', '50 500 15 15', 'Rashid Behbudov 57', 'This is a note');

-- END OF ORDERS --

-- EXPENSE TABLE --

DROP TABLE IF EXISTS expenses;

CREATE TABLE IF NOT EXISTS expenses
(
    id
        serial
        PRIMARY KEY,
    item
        VARCHAR,
    category
        VARCHAR,
    cost
        bigint,
    date
        TIMESTAMP,
    notes
        VARCHAR
);

INSERT INTO expenses(item, category, cost, date, notes)
VALUES ('Paper', 'Office', 5, '2021-03-04', 'This is a note');

-- END OF EXPENSES --

-- EXPENSE TABLE --

DROP TABLE IF EXISTS invoices;

CREATE TABLE IF NOT EXISTS invoices
(
    id
        serial
        PRIMARY KEY,
    receiver
        VARCHAR,
    item
        VARCHAR,
    phone
        VARCHAR,
    amount
        bigint,
    date
        TIMESTAMP,
    payment_date
        TIMESTAMP
);

INSERT INTO invoices(receiver, item, phone, amount, date, payment_date)
VALUES ('Friend', 'Car', '50 555 44 44', 50000, '2021-03-04', '2021-03-08');

-- END OF EXPENSES --
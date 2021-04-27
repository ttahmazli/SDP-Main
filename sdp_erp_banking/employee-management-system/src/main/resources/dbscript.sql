-- TABLE FOR REQUEST DETAILS OF THE USER --
DROP TABLE IF EXISTS leave_details;

CREATE TABLE IF NOT EXISTS leave_details
(
	id SERIAL,
	employee_name VARCHAR NOT NULL,
	username VARCHAR NOT NULL,
	leave_type VARCHAR NOT NULL,
	reason VARCHAR NOT NULL,
	duration INTEGER,
	from_date TIMESTAMP NOT NULL,
	to_date TIMESTAMP NOT NULL,
	accept_reject_flag BOOLEAN,
	active BOOLEAN,
	CONSTRAINT leave_pkey PRIMARY KEY (id)
);

-- END OF TABLE --


-- TABLE FOR USER --

DROP TABLE IF EXISTS userinfo;

CREATE TABLE IF NOT EXISTS userinfo
(
  id SERIAL,
  email VARCHAR NOT NULL,
  active BOOLEAN,
  last_name VARCHAR,
  first_name VARCHAR NOT NULL,
  password VARCHAR,
  role VARCHAR,
  CONSTRAINT users_pkey PRIMARY KEY (id)
);

INSERT INTO userinfo (email,active,last_name,first_name,password,role) VALUES ('shuseynova@email.com',TRUE,'Senuber','Huseynova','$2a$10$pNOQHgXFKcfrqzdgsPI2oOBJlXaGiAWQqh8fy2sAV9cOtpzfiyBf.','MANAGER');

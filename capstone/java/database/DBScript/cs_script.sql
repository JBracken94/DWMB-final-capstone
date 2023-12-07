BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, beer, brewery, beer_review, brewery_review, favorite_beer, favorite_brewery;

CREATE TABLE users 
(
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE brewery 
(
    brewery_id SERIAL,
    brewery_name VARCHAR(50) NOT NULL UNIQUE,
    street_address VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(2) NOT NULL,
    zip_code VARCHAR(10) NOT NULL,
    date_est DATE NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    about_us VARCHAR (1000) NOT NULL,
    logo_image VARCHAR(1000),
    website VARCHAR (50),
    founder_id INT NOT NULL,

    CONSTRAINT PK_brewery PRIMARY KEY (brewery_id),
    CONSTRAINT FK_brewery_users FOREIGN KEY (founder_id) REFERENCES users(user_id)
);

CREATE TABLE beer 
(
    beer_id SERIAL,
    beer_name VARCHAR(100) NOT NULL UNIQUE,
    brewery_id INT NOT NULL,
    beer_type VARCHAR(50) NOT NULL,
    abv DECIMAL(3, 1) NOT NULL,
    label_image VARCHAR(1000),
    description VARCHAR(200),

    CONSTRAINT PK_beer PRIMARY KEY (beer_id),
    CONSTRAINT FK_beer_brewery FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id)
);

CREATE TABLE beer_review 
(
    beer_review_id SERIAL,
    beer_id INT NOT NULL,
    reviewer_id INT NOT NULL,
    beer_rating DECIMAL(2,1) NOT NULL,
    beer_review VARCHAR(500) NOT NULL,
    date_posted timestamp with time zone NOT NULL,

    CONSTRAINT PK_beer_review PRIMARY KEY (beer_review_id),
    CONSTRAINT FK_beer_review_beer FOREIGN KEY (beer_id) REFERENCES beer(beer_id),
    CONSTRAINT FK_beer_review_users FOREIGN KEY (reviewer_id) REFERENCES users(user_id)
);

CREATE TABLE brewery_review 
(
    brewery_review_id SERIAL,
    brewery_id INT NOT NULL,
    reviewer_id INT NOT NULL,
    brewery_rating DECIMAL(2,1) NOT NULL,
    brewery_review VARCHAR(500) NOT NULL,
    date_posted timestamp with time zone NOT NULL,

    CONSTRAINT PK_brewery_review_id PRIMARY KEY (brewery_review_id),
    CONSTRAINT FK_brewery_review_brewery FOREIGN KEY (brewery_id) REFERENCES brewery(brewery_id),
    CONSTRAINT FK_brewery_review_users FOREIGN KEY (reviewer_id) REFERENCES users(user_id)
);

CREATE TABLE favorite_beer 
(
    fav_beer_id SERIAL,
    user_id INT NOT NULL,
    beer_id INT NOT NULL,

    CONSTRAINT PK_favorite_beer PRIMARY KEY (fav_beer_id),
    CONSTRAINT FK_favorite_beer_user FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_favorite_beer_beer FOREIGN KEY (beer_id) REFERENCES beer(beer_id)
);

CREATE TABLE favorite_brewery 
(
    fav_brewery_id SERIAL,
    user_id INT NOT NULL,
    brewery_id INT NOT NULL,

    CONSTRAINT PK_favorite_brewery PRIMARY KEY (fav_brewery_id),
    CONSTRAINT FK_favorite_brewery_users FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_favorite_brewery_brewery FOREIGN KEY (user_id) REFERENCES brewery(brewery_id)
);

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;

-- starting users
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('brewertest', '$2a$10$rbU.wF/L6JIVX6C.opN78eDrcDh525uOzn2v7AP70Q/nnz2Qcby/e', 'ROLE_BREWER'); --pass
INSERT INTO users  (username,password_hash,role) VALUES('lovertest','$2a$10$kQtB2r.rMiB.G6XBJxflGepgERn9rjFQUfZ7KW0hC.e7FbR.rw9iq','ROLE_LOVER'); -- pass
INSERT INTO users  (username,password_hash,role) VALUES('brewtoo','$2a$10$tZE.X5Kn/Iqmz91X1AD/qeIAkZxDVmpdfTOKidMNPpwmXRVr.1pDi','ROLE_BREWER'); -- pass

--starting breweries
INSERT INTO brewery (brewery_name, street_address, city, state, zip_code, date_est, phone_number, about_us, logo_image, website, founder_id)
VALUES ('Brew Bois', '123 Address Street', 'Pittsburgh', 'PA', 90210, NOW(), '(724) 555-5555',
		'We are a brewery founded for testing purposes', 'brewboislogo.png', 'www.brewboisPA.com', 3);
INSERT INTO brewery (brewery_name, street_address, city, state, zip_code, date_est, phone_number, about_us, logo_image, website, founder_id)
VALUES ('That Other Brewery', '82 Repo Place', 'Columbus', 'OH', 15555, NOW(), '(555) 555-5555',
	   'You should see the other guy...', 'otherlogo.jph', 'www.otherguys.com', 5);
INSERT INTO brewery (brewery_name, street_address, city, state, zip_code, date_est, phone_number, about_us, logo_image, website, founder_id)
VALUES ('Sargetown Brew Works', '7 Puppy Road', 'Derry', 'PA', 15627, NOW(), '(777) 777-5555',
	   'Bark bark, yum yum!', 'picofdog.jpg','www.pugdrunk.com', 2);


--starting beers
INSERT INTO beer (beer_name, brewery_id, beer_type, abv, label_image, description)
VALUES ('Junk in the Trunk', 1, 'Hazy IPA', 6.5, 'imagegoesher.png', 'This''ll junk your trunk!');
INSERT INTO beer (beer_name, brewery_id, beer_type, abv, label_image, description)
VALUES ('Beer for Drinking', 2, 'Amber Ale', 4.6, 'bfdlabel.jpg', 'You can drink it!');
INSERT INTO beer (beer_name, brewery_id, beer_type, abv, label_image, description)
VALUES ('Brew Bois Lager', 2, 'Lager', 5.2, 'bbl.jpg', 'Best beer in town!');
INSERT INTO beer (beer_name, brewery_id, beer_type, abv, label_image, description)
VALUES ('Slurp Juice', 3, 'Sour', 9.9, 'sj.jpg', '1 Victory Royale...');

--starting saved beer list
INSERT INTO favorite_beer (user_id, beer_id) VALUES (2,4); -- admin
INSERT INTO favorite_beer (user_id, beer_id) VALUES (2,2);
INSERT INTO favorite_beer (user_id, beer_id) VALUES (4,1); -- lovertest
INSERT INTO favorite_beer (user_id, beer_id) VALUES (4,2);
INSERT INTO favorite_beer (user_id, beer_id) VALUES (4,3);
INSERT INTO favorite_beer (user_id, beer_id) VALUES (4,4);
INSERT INTO favorite_beer (user_id, beer_id) VALUES (3,1); --brewertest

COMMIT TRANSACTION;

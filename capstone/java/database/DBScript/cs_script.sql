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
    brewery_name VARCHAR(50) NOT NULL,
    street_address VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(2) NOT NULL,
    zip_code INT NOT NULL,
    date_est INT NOT NULL,
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
    beer_name VARCHAR(100) NOT NULL,
    brewery_id INT NOT NULL,
    beer_type VARCHAR(50) NOT NULL,
    abv DECIMAL(2, 1) NOT NULL,
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
    beer_rating DECIMAL(2,2) NOT NULL,
    beer_review VARCHAR(500) NOT NULL,
    date_posted DATE NOT NULL,

    CONSTRAINT PK_beer_review PRIMARY KEY (beer_review_id),
    CONSTRAINT FK_beer_review_beer FOREIGN KEY (beer_id) REFERENCES beer(beer_id),
    CONSTRAINT FK_beer_review_users FOREIGN KEY (reviewer_id) REFERENCES users(user_id)
);

CREATE TABLE brewery_review 
(
    brewery_review_id SERIAL,
    brewery_id INT NOT NULL,
    reviewer_id INT NOT NULL,
    brewery_rating DECIMAL(2,2) NOT NULL,
    brewery_review VARCHAR(500) NOT NULL,
    date_posted DATE NOT NULL,

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


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;

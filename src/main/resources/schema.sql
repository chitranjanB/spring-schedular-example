CREATE TABLE users(
	username varchar_ignorecase(50) NOT NULL PRIMARY KEY,
	password varchar_ignorecase(50) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
	username varchar_ignorecase(50) NOT NULL,
	authority varchar_ignorecase(50) NOT NULL,
	CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE UNIQUE INDEX ix_auth_username ON authorities (username,authority);
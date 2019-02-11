CREATE TABLE category (
	id long,
	name varchar(50),
	primary key(id)
);

CREATE TABLE product (
	id long,
	name varchar(50),
	description varchar(100),
	price decimal(8,2),
	cat_id long,
	primary key(id)
);


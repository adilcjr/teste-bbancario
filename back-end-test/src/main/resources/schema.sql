CREATE TABLE category (
	id int NOT NULL AUTO_INCREMENT,
	name varchar(50),
	primary key (id)
 );

CREATE TABLE product (
	id int NOT NULL AUTO_INCREMENT,
	name varchar(50),
	cat_id int,
	primary key (id),
	foreign key (cat_id) references category(id)
);

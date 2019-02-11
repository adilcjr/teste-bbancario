CREATE TABLE category (
	id int primary key,
	name varchar(50)
 );

CREATE TABLE product (
	id int primary key,
	name varchar(50),
	cat_id int,
	foreign key (cat_id) references category(id)
);

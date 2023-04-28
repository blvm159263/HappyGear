create table tbl_discount (
	id int not null,
	name varchar(255) not null,
	description varchar(255) not null,
	discount_type varchar(255) not null,
	discount_value int not null,
	primary key (id)
);
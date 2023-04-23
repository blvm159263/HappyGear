create table tbl_role(
	role_id int not null primary key auto_increment,
	role_name nvarchar(50) not null,
    `status` bool not null default 1
);

create table tbl_user(
	user_name nvarchar(100) primary key not null, 
	full_name nvarchar(50) not null,
    `password` nvarchar(150) not null,
    address nvarchar(150) not null,
    email nvarchar(100) not null,
    phone_number nvarchar(100) not null,
    role_id int default null,
    gender bool not null,
    `status` bool not null default 1,
    Foreign key (role_id) references tbl_role(role_id)
);

create table tbl_category(
	category_id bigint not null primary key auto_increment,
    category_name nvarchar(100) not null,
    `status` bool not null default 1
);

create table tbl_brand(
	brand_id bigint not null primary key auto_increment,
    brand_name nvarchar(100),
	`status` bool not null default 1
);

create table tbl_product(
	product_id bigint not null primary key auto_increment,
    product_name nvarchar(100) not null,
    price double,
    quantity int,
    insurance_info nvarchar(500) not null,
    `status` bool not null default 1,
    category_id bigint not null,
	brand_id bigint not null,
    picture nvarchar(500) not null,
    Foreign key (category_id) references tbl_category(category_id),
    Foreign key (brand_id) references tbl_brand(brand_id)
);

create table tbl_product_picture(
	picture_id bigint not null primary key auto_increment,
    picture_url nvarchar(300),
    product_id bigint not null,
    `status` bool not null default 1,
    Foreign key (product_id) references tbl_product(product_id)
);

create table tbl_product_description(
	product_id bigint not null primary key auto_increment ,
    foreign key (product_id) references tbl_product(product_id),
    category_id bigint not null,
    keycap varchar(50),
    switch varchar(50),
    type_keyboard varchar(50),
    connect varchar(50),
    led varchar(50),
    freigh varchar(50),
    item_dimensions varchar(50),
    `cpu` varchar(50),
    ram varchar(50),
    operating_system varchar(50),
    battery varchar(50),
    hard_disk varchar(50),
    graphic_card varchar(50),
    key_board varchar(50),
    audio varchar(50),
    wifi varchar(50),
    bluetooth varchar(50),
    color varchar(50),
    frame_rate varchar(50),
    screen_size varchar(50),
    screen_type varchar(50),
	Foreign key (category_id) references tbl_category(category_id)
);

create table tbl_order(
	order_id bigint not null primary key auto_increment,
    user_name nvarchar(100) not null,
    `date` date,
    total double,
    `status` int not null default 0,
    Foreign key (user_name) references tbl_user(user_name)
);

create table tbl_order_detail(
	detail_id bigint not null primary key auto_increment,
    order_id bigint not null,
    price double,
    quantity int,
    `status` bool not null default 1,
    product_id bigint not null,
    Foreign key (order_id) references tbl_order(order_id),
    Foreign key (product_id) references tbl_product(product_id)
);

create table tbl_comment(
	comment_id bigint not null primary key auto_increment,
    content nvarchar(1000),
    user_name nvarchar(100) not null, 
    product_id bigint not null,
    Foreign key (user_name) references tbl_user(user_name),
    Foreign key (product_id) references tbl_product(product_id)
);
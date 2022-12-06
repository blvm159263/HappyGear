create database happygear;
use happygear;

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

INSERT INTO tbl_role(`role_name`) 
VALUES('role_admin'),('role_user');

INSERT INTO tbl_user(`user_name`,`full_name`,`password`,`address`,`email`,`phone_number`,`role_id`,`gender`,`status`) 
VALUES
('nguyenhuy','Nguyen Hoang Duc Huy','123','48 Le Loi, Q Tan Binh','nguyenhuy@gmail.com','0912345678',1,1,1),
('hungtran','Tran The Hung','123','49 Tran Xuan Soan, Q 7','hungtran@gmail.com','0912345678',2,1,1),
('hongtran','Tran Hong','123','78 Huong Lo 2, Q Binh Tan','hongtran@gmail.com','0912345678',2,1,1);

INSERT INTO tbl_product (`product_id`,`product_name`,`price`,`quantity`,`insurance_info`,`status`,`category_id`,`brand_id`) 
VALUES 
(1,'Laptop Acer Swift 3 SF314 512 56QN',23990000,10,'12 tháng',1,1,1),
(2,'Laptop Acer Swift 3 SF314 71 74WD',33990000,12,'12 tháng',1,1,1),
(3,'Màn hình ACER VG240Y 24\" IPS 75Hz FreeSync chuyên game',3990000,22,'12 tháng',1,2,1),
(4,'Màn hình Acer Predator XB273U NV 27\" IPS 2K 170Hz Gsync',11990000,5,'12 tháng',1,2,1),
(5,'Laptop Asus VivoBook 14 X1402ZA EK084W',16490000,9,'12 tháng',1,1,2),
(6,'Laptop ASUS Zenbook 14X OLED Space Edition UX5401ZAS KN130W',30990000,4,'12 tháng',1,1,2),
(7,'Màn hình ASUS VA24DQLB 24\" IPS viền mỏng',4290000,7,'12 tháng',1,2,2),
(8,'Màn hình Asus ROG SWIFT PG32UQX 32\" IPS 4K 144Hz G-SYNC ULTIMATE',98900000,3,'12 tháng',1,2,2),
(9,'Bàn phím ASUS TUF Gaming K1',1050000,15,'12 tháng',1,5,2),
(10,'Bàn phím Asus ROG Strix Flare',3750000,8,'12 tháng',1,5,2),
(11,'Tai nghe Asus ROG STRIX GO (USB-C)',2190000,4,'12 tháng',1,3,2),
(12,'Tai Nghe Asus ROG Delta Gundam Edition',4990000,7,'12 tháng',1,3,2),
(13,'Chuột Gaming ASUS ROG Keris',1250000,20,'12 tháng',1,4,2),
(14,'Chuột ASUS ROG Keris Wireless',1779000,12,'12 tháng',1,4,2),
(15,'Laptop HP Pavilion 14 dv2032TU 6K768PA',21949000,15,'12 tháng',1,1,3),
(16,'Laptop HP Spectre x360 14 ef0030TU 6K773PA',51990000,2,'12 tháng',1,1,3),
(17,'Chuột HP X4000b',490000,6,'12 tháng',1,4,3),

(18,'Laptop Dell Inspiron 15 3520 i3U082W11BLU',14290000,100,'12 months',1,1,4),
(19,'Laptop Dell Inspiron 15 3520 N5I5122W1 Black',17490000,100,'12 months',1,1,4),
(20,'Laptop Dell Inspiron 15 3520 71001747',20690000,100,'12 months',1,1,4),
(21,'Laptop Dell Vostro 5620 V6I5001W1 Gray',21490000,100,'12 months',1,1,4),
(22,'Laptop Dell Inspiron 14 5420 70295791',29490000,100,'12 months',1,1,4),
(23,'Laptop Gaming Dell G15 5511 70266676',19990000,100,'12 months',1,1,4),
(24,'Laptop gaming Dell G15 5525 R5H085W11GR3050',25490000,100,'12 months',1,1,4),
(25,'Màn hình Dell E2722H 27 IPS',4390000,100,'12 months',1,2,4),
(26,'Màn hình Dell UltraSharp U2422H 24 IPS',6690000,100,'12 months',1,2,4),
(27,'Màn hình Dell UltraSharp U2422HE 24 IPS USBC RJ45',7990000,100,'12 months',1,2,4),
(28,'Màn hình Dell UltraSharp U2422HE 24 IPS USBC RJ45',7990000,100,'12 months',1,2,4),

(29,'Tai nghe Gaming Logitech G Pro Gen 2',1690000,100,'12 months',1,3,5),
(30,'Tai nghe Logitech G333 có Mic và Màng loa kép',929000,100,'12 months',1,3,5),
(31,'Tai nghe Logitech G435 Lightspeed Wireless Black',1550000,100,'12 months',1,3,5),
(32,'Tai nghe Logitech G535 LIGHTSPEED Wireless Black',2390000,100,'12 months',1,3,5),
(33,'Tai nghe Logitech G735 Off White',4799000,100,'12 months',1,3,5),
(34,'Chuột Logitech G102 Lightsync RGB Black',400000,100,'12 months',1,4,5),
(35,'Chuột Logitech G402 Hyperion',650000,100,'12 months',1,4,5),
(36,'Chuột Logitech G502 Hero',990000,100,'12 months',1,4,5),
(37,'Bàn phím Logitech Mechanical Gaming G413 TKL SE',1390000,100,'12 months',1,5,5),
(38,'Bàn phím Logitech Mechanical Gaming G413 SE',1590000,100,'12 months',1,5,5),
(39,'Bàn phím Logitech G610 Orion',2090000,100,'12 months',1,5,5),

(40,'Chuột gaming Corsair Harpoon Pro RGB',450000,100,'12 months',1,4,6),
(41,'Chuột Corsair Sabre RGB Pro Wireless',1790000,100,'12 months',1,4,6),
(42,'Chuột Corsair Katar Pro Wireless',890000,100,'12 months',1,4,6),
(43,'Bàn phím Corsair K70 PRO',2890000,100,'12 months',1,5,6),
(44,'Bàn phím Corsair K55 RGB Pro',1050000,100,'12 months',1,5,6),
(45,'Bàn phím Corsair K68 RGB',2590000,100,'12 months',1,5,6);

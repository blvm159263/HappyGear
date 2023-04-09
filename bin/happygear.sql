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

INSERT INTO tbl_role(`role_name`) 
VALUES('role_admin'),('role_user');

INSERT INTO tbl_user(`user_name`,`full_name`,`password`,`address`,`email`,`phone_number`,`role_id`,`gender`,`status`) 
VALUES
('nguyenhuy','Nguyen Hoang Duc Huy','123','48 Le Loi, Q Tan Binh','nguyenhuy@gmail.com','0912345678',1,1,1),
('hungtran','Tran The Hung','123','49 Tran Xuan Soan, Q 7','hungtran@gmail.com','0912345678',2,1,1),
('hongtran','Tran Hong','123','78 Huong Lo 2, Q Binh Tan','hongtran@gmail.com','0912345678',2,1,1);

INSERT INTO tbl_category(`category_id`,`category_name`,`status`)
VALUES
(1,'LAPTOP',1),
(2,'MONITOR',1),
(3,'HEADPHONE',1),
(4,'MOUSE',1),
(5,'KEYBOARD',1);

INSERT INTO tbl_brand(`brand_id`,`brand_name`,`status`)
VALUES
(1,'ACER',1),
(2,'ASUS',1),
(3,'HP',1),
(4,'DELL',1),
(5,'LOGITECH',1),
(6,'CORSAIR',1);

INSERT INTO tbl_product (`product_id`,`product_name`,`price`,`quantity`,`insurance_info`,`status`,`category_id`,`brand_id`,`picture`) 
VALUES 
(1,'Laptop Acer Swift 3 SF314 512 56QN',23990000,10,'12 tháng',1,1,1,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png'),
(2,'Laptop Acer Swift 3 SF314 71 74WD',33990000,12,'12 tháng',1,1,1,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png'),
(3,'Màn hình ACER VG240Y 24\" IPS 75Hz FreeSync chuyên game',3990000,22,'12 tháng',1,2,1,'https://product.hstatic.net/1000026716/product/dell_e2722h_gearvn_a9938cc0f1d54c5ea764c57a949aed62.jpg'),
(4,'Màn hình Acer Predator XB273U NV 27\" IPS 2K 170Hz Gsync',11990000,5,'12 tháng',1,2,1,'https://product.hstatic.net/1000026716/product/dell_e2722h_gearvn_a9938cc0f1d54c5ea764c57a949aed62.jpg'),
(5,'Laptop Asus VivoBook 14 X1402ZA EK084W',16490000,9,'12 tháng',1,1,2,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png'),
(6,'Laptop ASUS Zenbook 14X OLED Space Edition UX5401ZAS KN130W',30990000,4,'12 tháng',1,1,2,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png'),
(7,'Màn hình ASUS VA24DQLB 24\" IPS viền mỏng',4290000,7,'12 tháng',1,2,2,'https://product.hstatic.net/1000026716/product/dell_e2722h_gearvn_a9938cc0f1d54c5ea764c57a949aed62.jpg'),
(8,'Màn hình Asus ROG SWIFT PG32UQX 32\" IPS 4K 144Hz G-SYNC ULTIMATE',98900000,3,'12 tháng',1,2,2,'https://product.hstatic.net/1000026716/product/dell_e2722h_gearvn_a9938cc0f1d54c5ea764c57a949aed62.jpg'),
(9,'Bàn phím ASUS TUF Gaming K1',1050000,15,'12 tháng',1,5,2,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg'),
(10,'Bàn phím Asus ROG Strix Flare',3750000,8,'12 tháng',1,5,2,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg'),
(11,'Tai nghe Asus ROG STRIX GO (USB-C)',2190000,4,'12 tháng',1,3,2,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(12,'Tai Nghe Asus ROG Delta Gundam Edition',4990000,7,'12 tháng',1,3,2,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(13,'Chuột Gaming ASUS ROG Keris',1250000,20,'12 tháng',1,4,2,'https://product.hstatic.net/1000026716/product/sdfsdfs_6bb1e2c96b5d4f3fbb28a8dd04d63277.png'),
(14,'Chuột ASUS ROG Keris Wireless',1779000,12,'12 tháng',1,4,2,'https://product.hstatic.net/1000026716/product/sdfsdfs_6bb1e2c96b5d4f3fbb28a8dd04d63277.png'),
(15,'Laptop HP Pavilion 14 dv2032TU 6K768PA',21949000,15,'12 tháng',1,1,3,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png'),
(16,'Laptop HP Spectre x360 14 ef0030TU 6K773PA',51990000,2,'12 tháng',1,1,3,'https://product.hstatic.net/1000026716/product/i3u082w11blu-fix_6024858859ea443fa4bb8436e9fcda54.png'),
(17,'Chuột HP X4000b',490000,6,'12 tháng',1,4,3,'https://product.hstatic.net/1000026716/product/sdfsdfs_6bb1e2c96b5d4f3fbb28a8dd04d63277.png'),

(18,'Laptop Dell Inspiron 15 3520 i3U082W11BLU',14290000,100,'12 months',1,1,4,'https://product.hstatic.net/1000026716/product/i3u082w11blu-fix_6024858859ea443fa4bb8436e9fcda54.png'),
(19,'Laptop Dell Inspiron 15 3520 N5I5122W1 Black',17490000,100,'12 months',1,1,4,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png'),
(20,'Laptop Dell Inspiron 15 3520 71001747',20690000,100,'12 months',1,1,4,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png'),
(21,'Laptop Dell Vostro 5620 V6I5001W1 Gray',21490000,100,'12 months',1,1,4,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-4_e16c7f8048bb4bc986f5e99e060b225d.png'),
(22,'Laptop Dell Inspiron 14 5420 70295791',29490000,100,'12 months',1,1,4,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-4_e16c7f8048bb4bc986f5e99e060b225d.png'),
(23,'Laptop Gaming Dell G15 5511 70266676',19990000,100,'12 months',1,1,4,'https://product.hstatic.net/1000026716/product/g15-5511-i5_6fb23ec04c4f49f494011149bd627482.png'),
(24,'Laptop gaming Dell G15 5525 R5H085W11GR3050',25490000,100,'12 months',1,1,4,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-5_90c2e13760124c8d8dfc3b5f7f8d4b37.png'),
(25,'Màn hình Dell E2722H 27 IPS',4390000,100,'12 months',1,2,4,'https://product.hstatic.net/1000026716/product/dell_e2722h_gearvn_a9938cc0f1d54c5ea764c57a949aed62.jpg'),
(26,'Màn hình Dell UltraSharp U2422H 24 IPS',6690000,100,'12 months',1,2,4,'https://product.hstatic.net/1000026716/product/dell_u2422h_gearvn_e8dfce5719b0455aa386bf41352592cd.jpg'),
(27,'Màn hình Dell UltraSharp U2422HE 24 IPS USBC RJ45',7990000,100,'12 months',1,2,4,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg'),
(28,'Màn hình Dell UltraSharp U2422HE 24 IPS USBC RJ45',7990000,100,'12 months',1,2,4,'https://product.hstatic.net/1000026716/product/tai_nghe_gaming_logitech_g_pro_gen_2_958a8caa12d7468a90043e60bf1c1619.png'),

(29,'Tai nghe Gaming Logitech G Pro Gen 2',1690000,100,'12 months',1,3,5,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(30,'Tai nghe Logitech G333 có Mic và Màng loa kép',929000,100,'12 months',1,3,5,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(31,'Tai nghe Logitech G435 Lightspeed Wireless Black',1550000,100,'12 months',1,3,5,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(32,'Tai nghe Logitech G535 LIGHTSPEED Wireless Black',2390000,100,'12 months',1,3,5,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(33,'Tai nghe Logitech G735 Off White',4799000,100,'12 months',1,3,5,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(34,'Chuột Logitech G102 Lightsync RGB Black',400000,100,'12 months',1,4,5,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(35,'Chuột Logitech G402 Hyperion',650000,100,'12 months',1,4,5,'https://product.hstatic.net/1000026716/product/sdfsdfs_6bb1e2c96b5d4f3fbb28a8dd04d63277.png'),
(36,'Chuột Logitech G502 Hero',990000,100,'12 months',1,4,5,'https://product.hstatic.net/1000026716/product/dell_e2722h_gearvn_a9938cc0f1d54c5ea764c57a949aed62.jpg'),
(37,'Bàn phím Logitech Mechanical Gaming G413 TKL SE',1390000,100,'12 months',1,5,5,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg'),
(38,'Bàn phím Logitech Mechanical Gaming G413 SE',1590000,100,'12 months',1,5,5,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg'),
(39,'Bàn phím Logitech G610 Orion',2090000,100,'12 months',1,5,5,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg'),

(40,'Chuột gaming Corsair Harpoon Pro RGB',450000,100,'12 months',1,4,6,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(41,'Chuột Corsair Sabre RGB Pro Wireless',1790000,100,'12 months',1,4,6,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(42,'Chuột Corsair Katar Pro Wireless',890000,100,'12 months',1,4,6,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png'),
(43,'Bàn phím Corsair K70 PRO',2890000,100,'12 months',1,5,6,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg'),
(44,'Bàn phím Corsair K55 RGB Pro',1050000,100,'12 months',1,5,6,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg'),
(45,'Bàn phím Corsair K68 RGB',2590000,100,'12 months',1,5,6,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg');

INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (1,'https://product.hstatic.net/1000026716/product/i3u082w11blu-fix_6024858859ea443fa4bb8436e9fcda54.png',18,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (2,'https://product.hstatic.net/1000026716/product/in3520nt-cnb-00060lb055-bk_b97c424017ec470bb03ed47b13fabd99.png',18,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (3,'https://product.hstatic.net/1000026716/product/in3520nt-cnb-00060rb055-bk_6fa7d1a700314c19adf6617e48435bb7.png',18,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (4,'https://product.hstatic.net/1000026716/product/in3520nt-cnb-00090lp090-bk_cabd0d28b1744a778af27d79ec5545d6.png',18,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (5,'https://product.hstatic.net/1000026716/product/notebook-inspiron-15-3520-black-gallery-8_cc51802b03cb419181b5b75ed711fa12.png',18,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (6,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png',19,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (7,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-2_3ab988c88c9b4582b76e00d930ef2bc6.png',19,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (8,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-4_e16c7f8048bb4bc986f5e99e060b225d.png',19,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (9,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-5_90c2e13760124c8d8dfc3b5f7f8d4b37.png',19,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (10,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-6_fe9e26507eae4d3c9d8a2599dc010552.png',19,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (11,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png',20,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (12,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-2_3ab988c88c9b4582b76e00d930ef2bc6.png',20,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (13,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-4_e16c7f8048bb4bc986f5e99e060b225d.png',20,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (14,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-5_90c2e13760124c8d8dfc3b5f7f8d4b37.png',20,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (15,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-6_fe9e26507eae4d3c9d8a2599dc010552.png',20,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (16,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png',21,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (17,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-2_3ab988c88c9b4582b76e00d930ef2bc6.png',21,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (18,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-4_e16c7f8048bb4bc986f5e99e060b225d.png',21,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (19,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-5_90c2e13760124c8d8dfc3b5f7f8d4b37.png',21,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (20,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-6_fe9e26507eae4d3c9d8a2599dc010552.png',21,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (21,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png',22,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (22,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-2_3ab988c88c9b4582b76e00d930ef2bc6.png',22,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (23,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-4_e16c7f8048bb4bc986f5e99e060b225d.png',22,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (24,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-5_90c2e13760124c8d8dfc3b5f7f8d4b37.png',22,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (25,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-6_fe9e26507eae4d3c9d8a2599dc010552.png',22,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (26,'https://product.hstatic.net/1000026716/product/g15-5511-i5_6fb23ec04c4f49f494011149bd627482.png',23,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (27,'https://product.hstatic.net/1000026716/product/notebook-g-15-5525-black-coralkb-gallery-2_e8c925c5fafb4a5faf37f63208635d57.png',23,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (28,'https://product.hstatic.net/1000026716/product/laptops_g-series_g15_5511_dark_shadow_gray_rgb_kb_media_gallery_3_51b4653b72c74ce1842d6ca268ed6b0d.png',23,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (29,'https://product.hstatic.net/1000026716/product/notebook-g-15-5525-black-coralkb-gallery-1_d48d3a581a6f48879f9e7a4af82c77d6.png',23,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (30,'https://product.hstatic.net/1000026716/product/notebook-g-15-5525-black-coralkb-gallery-3_a10d034eeb9042c49b9a8426722237b0.png',23,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (31,'https://product.hstatic.net/1000026716/product/gearvn-laptop-gaming-dell-g15-5525-r5h085w11gr3050-1_668f40d1e8e740bbbea8e138ca070b70.png',24,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (32,'https://product.hstatic.net/1000026716/product/gearvn-laptop-gaming-dell-g15-5525-r5h085w11gr3050-2_81d389e8a9dc446b8c57ed476b618f2b.png',24,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (33,'https://product.hstatic.net/1000026716/product/gearvn-laptop-gaming-dell-g15-5525-r5h085w11gr3050-3_4be3bb55c86c4dfb9ed168060016ed26.png',24,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (34,'https://product.hstatic.net/1000026716/product/gearvn-laptop-gaming-dell-g15-5525-r5h085w11gr3050-4_942c0132f33e4b6d8e9338c02a84e1b4.png',24,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (35,'https://product.hstatic.net/1000026716/product/gearvn-laptop-gaming-dell-g15-5525-r5h085w11gr3050-5_0ae134d0035346f4a6350591f31012da.png',24,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (36,'https://product.hstatic.net/1000026716/product/dell_e2722h_gearvn_a9938cc0f1d54c5ea764c57a949aed62.jpg',25,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (37,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-e2722h-27-ips-1_9372ded441a248c3b9ea9fc4f107aa97.jpg',25,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (38,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-e2722h-27-ips-2_e8902c7eef2b48fdb988242d0f91f445.jpg',25,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (39,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-e2722h-27-ips-3_4aaa7e040bb3408c9e40443d0995bd07.jpg',25,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (40,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-e2722h-27-ips-4_ba687dc4de8f429d835dcb1060153e01.jpg',25,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (41,'https://product.hstatic.net/1000026716/product/dell_u2422h_gearvn_e8dfce5719b0455aa386bf41352592cd.jpg',26,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (42,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-1_b6e681778b26484cbe62d5a054433f54.jpg',26,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (43,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-2_c610a79f562b491e9181ef8d76eed75e.jpg',26,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (44,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-3_940f2976eb704ca3889b7b54e08be1ba.jpg',26,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (45,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',26,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (46,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',27,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (47,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',27,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (48,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',27,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (49,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',27,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (50,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',27,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (51,'https://product.hstatic.net/1000026716/product/tai_nghe_gaming_logitech_g_pro_gen_2_958a8caa12d7468a90043e60bf1c1619.png',28,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (52,'https://product.hstatic.net/1000026716/product/tai_nghe_gaming_logitech_g_pro_gen_2_958a8caa12d7468a90043e60bf1c1619.png',28,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (53,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png',29,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (54,'https://product.hstatic.net/1000026716/product/logitech-g333-black-3_28e4b9790a5448a2adcbdb8d55fc38d9.jpg',29,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (55,'https://product.hstatic.net/1000026716/product/logitech-g333-black-5_428fd2b2fd264b948340a8b8e22f7066.jpg',29,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (56,'https://product.hstatic.net/1000026716/product/logitech-g333-black-4_de4536e369a14326be2389083efd7942.jpg',29,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (57,'https://product.hstatic.net/1000026716/product/logitech-g333-purple-2_ba09a61d402f4121832eb5a08a6b5db5.jpg',29,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (58,'https://product.hstatic.net/1000026716/product/artboard_1_2ff4ba55c7be43a89f8ea1b2c2e577d6.png',30,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (59,'https://product.hstatic.net/1000026716/product/logitech-g102-lightsync-rgb-black-1_bf4f5774229c4a0f81b8e8a2feebe4d8.jpg',30,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (60,'https://product.hstatic.net/1000026716/product/logitech-g102-lightsync-rgb-black-2_7788492f5ed748248bd8cb2e967f9cc3.jpg',30,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (61,'https://product.hstatic.net/1000026716/product/artboard_1_da260270af0547c39559266fe9f44cb5.png',31,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (62,'https://product.hstatic.net/1000026716/product/z3420520962871_ebb1fcb446d1c8edec7dedb3f80b0bc6_950afe9464b349b78465f70f37b39340.jpg',31,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (63,'https://product.hstatic.net/1000026716/product/logitech-g402-hyperion-fury-ultr_f70b6cf060ce4690965f2664ab204159.png',31,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (64,'https://product.hstatic.net/1000026716/product/logitech-g402-hyperion-fury-ultr__1__e963208d9f634260bc0ac1a224c5be36.png',31,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (65,'https://product.hstatic.net/1000026716/product/ban_phim_logitech_mechanical_gaming_g413_tkl_se_89630a79e48b40278807ff48159ee32c.png',32,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (66,'https://product.hstatic.net/1000026716/product/thumbphim_c89f6d836d1844afadb2b4cb6ec33bf8.png',32,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (67,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-tkl-se-1_0269776db50c4f80ad5f18a4cae26389.jpg',32,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (68,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-tkl-se-2_16deeeba50374ad28070721366f8f688.jpg',32,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (69,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-tkl-se-3_4b3579cb52e647ec94ea24f9c88ad55b.jpg',32,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (70,'https://product.hstatic.net/1000026716/product/ban_phim_logitech_mechanical_gaming_g413_se_885f68b74d0841328f2dda07f41ccb56.png',33,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (71,'https://product.hstatic.net/1000026716/product/thumbphim_493ce5210abf4961838c8273ce21c152.png',33,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (72,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-se-2_af55de9fa1c244e68c747387d79cbb92.png',33,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (73,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-se-1_44c4757cc23e4fd197435f5736e0e475.png',33,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (74,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-se-3_0fe5bbdfb854404794c6432b683fd599.png',33,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (75,'https://product.hstatic.net/1000026716/product/chuot_corsair_sabre_rgb_pro_wireless_fa8b62329e8a420b94bd5c8d72cf21c3.png',34,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (76,'https://product.hstatic.net/1000026716/product/a12_a6259101668f48caa6ed483beb4405d7.png',34,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (77,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-sabre-rgb-pro-wireless-1_0fa28298c14040d3aae0254c996ddd21.jpg',34,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (78,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-sabre-rgb-pro-wireless-2_774533b939514ced84a5bc5c6d999ccd.jpg',34,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (79,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-sabre-rgb-pro-wireless-3_492b172a9b224b55833533ddea306201.jpg',34,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (80,'https://product.hstatic.net/1000026716/product/sdfsdfs_6bb1e2c96b5d4f3fbb28a8dd04d63277.png',35,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (81,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-666_23333dfd6ea64129b9627324097a4955.png',35,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (82,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-8_310a9ee208f94bb6b494ba71c2795b42.png',35,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (83,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-9_c9ea6ede82d34472a6f3f417ff64bae8.png',35,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (84,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-7_43e19bd5a57f460c9e59cccae9f91d78.png',35,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (85,'https://product.hstatic.net/1000026716/product/thumbphim_f34d4d3ca4fc41188e68ad60a6d8fcf8.png',36,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (86,'https://product.hstatic.net/1000026716/product/z3473894478619_0663dd314d81f9d694338446fff06d8f_7b5a73f781224b0dbfacf895ee29191d.jpg',36,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (87,'https://product.hstatic.net/1000026716/product/z3473894473467_d01ca2bc3b10b34db309160fdf49a1dd_a898840ed5ff4ad1b58c28fe72d0c6ca.jpg',36,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (88,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg',37,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (89,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-22_7ba2ffdcdb314b99a72b6df0b4094ef2.jpg',37,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (90,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-23_6f011f0aced9460f8fca38b98d753791.jpg',37,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (91,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-26_c277e990eda54e6fa04f6d9ea47f6f8f.jpg',37,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (92,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-29_63e94f70641f43a6943f8c01b1dc49c1.jpg',37,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (93,'https://product.hstatic.net/1000026716/product/56qn_e18801a135f84e67945adbe9b4c54ea4.png',1,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (94,'https://product.hstatic.net/1000026716/product/ft-3-sf314-512-56qn-i5-1240p-1_949d740b19b74e1b8cb113b28beeff77_master_717e98c499fb45e8b7edece755390f2c.png',1,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (95,'https://product.hstatic.net/1000026716/product/ft-3-sf314-512-56qn-i5-1240p-3_ac3ac245f4b2448a86aeec37eb2a8d34_master_272743bc991b433b8a087bd96653813f.png',1,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (96,'https://product.hstatic.net/1000026716/product/ft-3-sf314-512-56qn-i5-1240p-5_8369b08c3e9a4cd8a8cbb57f7142b093_master_55d8d528a7984858ad213459dfdbbe8a.png',1,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (97,'https://product.hstatic.net/1000026716/product/ft-3-sf314-512-56qn-i5-1240p-4_2313ac68cbdb48109769184b592b73a3_master_c94e7f9740a240748687e7689b11fe83.png',1,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (98,'https://product.hstatic.net/1000026716/product/gearvn-laptop-acer-swift-3-sf314-71-74wd-1_57c9c62d7df9469c9bd2551e9ce9e3dd.png',2,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (99,'https://product.hstatic.net/1000026716/product/gearvn-laptop-acer-swift-3-sf314-71-74wd-2_1bc2b391a01b4f469916ec5b8c5b8799.png',2,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (100,'https://product.hstatic.net/1000026716/product/gearvn-laptop-acer-swift-3-sf314-71-74wd-3_dbff36e729474bacabec86ea51135b36.png',2,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (101,'https://product.hstatic.net/1000026716/product/gearvn-laptop-acer-swift-3-sf314-71-74wd-5_feb6246be83f4f11ae4ff492f66d50b0.png',2,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (102,'https://product.hstatic.net/1000026716/product/gearvn-laptop-acer-swift-3-sf314-71-74wd-5_feb6246be83f4f11ae4ff492f66d50b0.png',2,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (103,'https://product.hstatic.net/1000026716/product/vg240y_gearvn_a167bb0d529043709c380fc4f57ea4d9.jpg',3,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (104,'https://product.hstatic.net/1000026716/product/vg240y_gearvn_a167bb0d529043709c380fc4f57ea4d9.jpg',3,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (105,'https://product.hstatic.net/1000026716/product/gearvn-ips-24-acer-vg240y-24-chuyen-gaming-75hz-freesync-1_0fba6476686e4df6bc1d824d4b354064.jpg',3,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (106,'https://product.hstatic.net/1000026716/product/gearvn-ips-24-acer-vg240y-24-chuyen-gaming-75hz-freesync-2_72a7df7f0b1e4291a1afa474b6a83037.jpg',3,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (107,'https://product.hstatic.net/1000026716/product/gearvn-ips-24-acer-vg240y-24-chuyen-gaming-75hz-freesync-4_a411ae9200154f0a8224488c3c48ef67.jpg',3,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (108,'https://product.hstatic.net/1000026716/product/acer_xb273u_nv_gearvn_34c6555662524ce9bfa237825b3ed4ea.jpg',4,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (109,'https://product.hstatic.net/1000026716/product/predator_xb273u_nv_2_16bebfa459d0440da02d6805e121eea4.png',4,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (110,'https://product.hstatic.net/1000026716/product/predator_xb273u_nv_3_799a8f24d39c440dab48dbadc555bfc7.png',4,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (111,'https://product.hstatic.net/1000026716/product/predator_xb273u_nv_5_ffe9cf11e1b54bb3b50480099a6bcae0.png',4,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (112,'https://product.hstatic.net/1000026716/product/predator_xb273u_nv_4_71a9c440c0f346b2bb113483ebac18da.png',4,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (113,'https://product.hstatic.net/1000026716/product/gearvn-laptop-asus-vivobook-x1402za-ek084w-1_7ed8fcbdbe814af9b7c696bc05288c18.png',5,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (114,'https://product.hstatic.net/1000026716/product/gearvn-laptop-asus-vivobook-x1402za-ek084w-2_caa217442e67408abcf6f9bc6e870d66.png',5,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (115,'https://product.hstatic.net/1000026716/product/gearvn-laptop-asus-vivobook-x1402za-ek084w-3_eef35b81e491474580571cf0c67160a4.png',5,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (116,'https://product.hstatic.net/1000026716/product/gearvn-laptop-asus-vivobook-x1402za-ek084w-4_b3bf53c098ec41d6a222d5f4507a9e64.png',5,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (117,'https://product.hstatic.net/1000026716/product/gearvn-laptop-asus-vivobook-x1402za-ek084w-5_446caaeab21446639c1b9ad73b54a28b.png',5,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (118,'https://product.hstatic.net/1000026716/product/ux5401zas-kn130w-fix_066bf89a0a43484fa8de5a8fb5eb669c.png',6,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (119,'https://product.hstatic.net/1000026716/product/n-ux5401zas-kn070w-i7-12700h-1_566f25bc332e42428fc49e119646b9a5_master_2e49603af2394d89a66636d265625c3b.png',6,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (120,'https://product.hstatic.net/1000026716/product/n-ux5401zas-kn070w-i7-12700h-2_1afa157f147449b0a3a4bb999a58ac8a_master_cce4bdd6104047b9b4148597cfe85edf.png',6,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (121,'https://product.hstatic.net/1000026716/product/ion-ux5401zas-kn070w-i7-12700h_98cea4dfc46f4ce1a7d98bee3e7d4150_master_e15d0ca537794c4481626cdd9dfe38fd.png',6,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (122,'https://product.hstatic.net/1000026716/product/ion-ux5401zas-kn070w-i7-12700h_98cea4dfc46f4ce1a7d98bee3e7d4150_master_e15d0ca537794c4481626cdd9dfe38fd.png',6,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (123,'https://product.hstatic.net/1000026716/product/asus_vg24dqlb_gearvn_fe66eb8ce8444925b466e93fd886a565.jpg',7,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (124,'https://product.hstatic.net/1000026716/product/asus_vg24dqlb_gearvn_7270b31740c84eb88a090eb334285d24.jpg',7,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (125,'https://product.hstatic.net/1000026716/product/vg24dqlb-04_284480aa2ffb4ed4b7fabd9e48085b66.jpg',7,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (126,'https://product.hstatic.net/1000026716/product/vg24dqlb-06_71bb0abca4394d74bb5db1e4cb925b53.jpg',7,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (127,'https://product.hstatic.net/1000026716/product/vg24dqlb-07_14093fee79534c6d8c02a00d7f162cd5.jpg',7,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (128,'https://product.hstatic.net/1000026716/product/asus_pg32uqx_gearvn_0b6b7bebe3ff4ea4b340ba4da867dbf8.jpg',8,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (129,'https://product.hstatic.net/1000026716/product/eyecare_pg_series_d89ad91ec73c4d69b1a742a966a9b1bd.jpg',8,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (130,'https://product.hstatic.net/1000026716/product/pg32uqx-01-t_8dcc38095d9e4f1389c4f0f03f9301e8.jpg',8,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (131,'https://product.hstatic.net/1000026716/product/pg32uqx-02-t_622d3037461b4d49a0a79f64f4f471b8.jpg',8,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (132,'https://product.hstatic.net/1000026716/product/pg32uqx-03-t_66938aa78e7e4f9089535b88996aab3d.jpg',8,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (133,'https://product.hstatic.net/1000026716/product/ban_phim_asus_tuf_gaming_k1_98bd8d5d30844857945e8b7eafada212.png',9,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (134,'https://product.hstatic.net/1000026716/product/ban-phim-gaming-asus-tuf-k1-rgb-1_df3951a60fb04477b7d24ccc9c5e8e9b.jpg',9,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (135,'https://product.hstatic.net/1000026716/product/ban-phim-gaming-asus-tuf-k1-rgb-2_0dc2757ac2f742c89f8b491b1f31330e.jpg',9,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (136,'https://product.hstatic.net/1000026716/product/ban-phim-gaming-asus-tuf-k1-rgb-3_b2212bdc1d164fb483942074e41063ac.jpg',9,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (137,'https://product.hstatic.net/1000026716/product/h732_0d28c6b39f5d462ca8a3fc232b198d40.png',10,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (138,'https://product.hstatic.net/1000026716/product/untitled-1_adf7827dfc1946d8b8643e27823338f0.jpg',10,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (139,'https://product.hstatic.net/1000026716/product/gearvn-asus-rog_strix_flare-8_6c8aee5893ae4e0283e6132c60324669.jpg',10,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (140,'https://product.hstatic.net/1000026716/product/gearvn-asus-rog_strix_flare-9_e3ec9baf93b94767b9271c363440a550.jpg',10,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (141,'https://product.hstatic.net/1000026716/product/gearvn-asus-rog_strix_flare-11_41ed7525e9c645cbbb311c2cb0ede363.jpg',10,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (142,'https://product.hstatic.net/1000026716/product/asus-rog-strix-go-usb-c_5669f00580834aa0b27e040583145d8c.jpg',11,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (143,'https://product.hstatic.net/1000026716/product/h732_93d33616eca748149592ac41f2719b2c.png',11,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (144,'https://product.hstatic.net/1000026716/product/asus-rog-strix-go-usb-c-1_8fbe6b95aef04ad79281d0a9d17fa7ff.jpg',11,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (145,'https://product.hstatic.net/1000026716/product/asus-rog-delta-gundam_compressed_29673577eba24fe5b43aa04e0f1d1b1b.jpg',12,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (146,'https://product.hstatic.net/1000026716/product/asus-rog-delta-gundam-1_compressed_52622c4df6944e909d53c05cfe18ba13.jpg',12,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (147,'https://product.hstatic.net/1000026716/product/asus-rog-delta-gundam-3_compressed_43a00b1023d24dc7b24b8bca8eb7a664.jpg',12,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (148,'https://product.hstatic.net/1000026716/product/asus-rog-delta-gundam-4_compressed_072d1866671e4c1d9234b8f701ef36f6.jpg',12,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (149,'https://product.hstatic.net/1000026716/product/asus-rog-delta-gundam-2_compressed_b09adbc568c34aab894c8c3f4fa1a099.jpg',12,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (150,'https://product.hstatic.net/1000026716/product/sdfsdfs_e3393312c6f24c8484bdb294019cdd05.png',13,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (151,'https://product.hstatic.net/1000026716/product/h732_compressed_57b01e04867c4ab89befde641e2080ca.jpg',13,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (152,'https://product.hstatic.net/1000026716/product/h732-1_compressed_679677665cc14e6baade905a67c5a83a.jpg',13,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (153,'https://product.hstatic.net/1000026716/product/sdfsdfs_636cd5a671424d14af5b25225d23d0c6.png',14,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (154,'https://product.hstatic.net/1000026716/product/sdfsdfs_636cd5a671424d14af5b25225d23d0c6.png',14,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (155,'https://product.hstatic.net/1000026716/product/h732-wl1_compressed_ffa74b27e9224458baf81ef496716c72.jpg',14,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (156,'https://product.hstatic.net/1000026716/product/i7_aa6921e8f7764ce9b7657b505f72c5b7.png',15,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (157,'https://product.hstatic.net/1000026716/product/14-dv2032tu-6k768pa-i7-1255u-1_863ddf02ac0840a7a9aeba63a0da6cbd_master_2c0ee4a722c74f4886fef1f240049bbe.png',15,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (158,'https://product.hstatic.net/1000026716/product/14-dv2032tu-6k768pa-i7-1255u-2_d36c0aba5a08489e803348d9e7955a53_master_32a3a8f63c304656a94c3539f326dd5f.png',15,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (159,'https://product.hstatic.net/1000026716/product/14-dv2032tu-6k768pa-i7-1255u-2_d36c0aba5a08489e803348d9e7955a53_master_32a3a8f63c304656a94c3539f326dd5f.png',15,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (160,'https://product.hstatic.net/1000026716/product/14-dv2032tu-6k768pa-i7-1255u-3_c461aa31c68d409eb54563c6f1840d12_master_14d54f2dc17b49edb5970c5fe5de6b0b.png',15,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (161,'https://product.hstatic.net/1000026716/product/14-dv2032tu-6k768pa-i7-1255u-4_7eeb9ad6683e49e4adbd4ab38754baa1_master_89987ba54f4244a496ad668503528b41.png',15,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (162,'https://product.hstatic.net/1000026716/product/6k773pa_119755cd23624f1d8878aca7a055f8a8.png',16,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (163,'https://product.hstatic.net/1000026716/product/14-ef0030tu-6k773pa-i7-1255u-3_f548034c585b4b7caaca492c200c444b_master_b7a12a680090417c9adde0c6c4813cef.png',16,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (164,'https://product.hstatic.net/1000026716/product/14-ef0030tu-6k773pa-i7-1255u-3_f548034c585b4b7caaca492c200c444b_master_b7a12a680090417c9adde0c6c4813cef.png',16,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (165,'https://product.hstatic.net/1000026716/product/14-ef0030tu-6k773pa-i7-1255u-4_b392deeed87e4a98afd6a0e505215e5a_master_84af0fbda59441eaa71fb8d4fa8b6a7e.png',16,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (166,'https://product.hstatic.net/1000026716/product/14-ef0030tu-6k773pa-i7-1255u-5_631e343bb97849f3b46fb65da7f0743a_master_18a91948c9d74f27affcf7c838854aec.png',16,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (167,'https://product.hstatic.net/1000026716/product/gearvn.com-products-chuot-hp-x4000b-1_5d4bf0663f7141a8b28ba235cd000651.jpg',17,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (168,'https://product.hstatic.net/1000026716/product/gearvn.com-products-chuot-hp-x4000b-2_74317a586b8e41f7b6621bbc89144e7a.jpg',17,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (169,'https://product.hstatic.net/1000026716/product/gearvn.com-products-chuot-hp-x4000b-3_053ba9da448847f7bf4fe2baacf96ece.jpg',17,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (170,'https://product.hstatic.net/1000026716/product/gearvn.com-products-chuot-hp-x4000b-3_053ba9da448847f7bf4fe2baacf96ece.jpg',17,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (171,'https://product.hstatic.net/1000026716/product/gearvn.com-products-chuot-hp-x4000b-5_f6ec930b786048ff9e342cf2fbf78e60.jpg',17,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (172,'https://product.hstatic.net/1000026716/product/ban_phim_logitech_mechanical_gaming_g413_se_885f68b74d0841328f2dda07f41ccb56.png',38,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (173,'https://product.hstatic.net/1000026716/product/thumbphim_493ce5210abf4961838c8273ce21c152.png',38,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (174,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-se-2_af55de9fa1c244e68c747387d79cbb92.png',38,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (175,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-se-1_44c4757cc23e4fd197435f5736e0e475.png',38,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (176,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-se-1_44c4757cc23e4fd197435f5736e0e475.png',38,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (177,'https://product.hstatic.net/1000026716/product/ban_phim_logitech_g610_orion_d6e006503db748318861212c50276afb.png',39,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (178,'https://product.hstatic.net/1000026716/product/thumbphim_18ed9c8ad36142d5b8338c582d9d54ae.png',39,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (179,'https://product.hstatic.net/1000026716/product/thumbphim_18ed9c8ad36142d5b8338c582d9d54ae.png',39,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (180,'https://product.hstatic.net/1000026716/product/gearvn-logitech-g610-orion-2_447de345b1534a76ac70c1508b8ebd0d.png',39,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (181,'https://hstatic.net/716/1000026716/1/2016/5-18/logitech_g610_678x452.jpg',39,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (182,'https://product.hstatic.net/1000026716/product/sdfsdfs_03e22fa6a9ef4790bd8da3c30bc99dd7.png',40,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (183,'https://product.hstatic.net/1000026716/product/gearvn.com-products-chuot-gaming-corsair-harpoon-pro-rgb-1_-_copy_8fd71a20c88e4d5ba2231e87ca404bdf.png',40,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (184,'https://product.hstatic.net/1000026716/product/gearvn.com-products-chuot-gaming-corsair-harpoon-pro-rgb-2_-_copy_0dc51dedfb8048b49c0b37a1ada5054f.png',40,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (185,'https://product.hstatic.net/1000026716/product/gearvn.com-products-chuot-gaming-corsair-harpoon-pro-rgb-3_-_copy_7fd87eee70254496b29487d401b15991.png',40,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (186,'https://product.hstatic.net/1000026716/product/gearvn.com-products-chuot-gaming-corsair-harpoon-pro-rgb-4_-_copy_815e39c00dba43ca8a02344d06b58327.png',40,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (187,'https://product.hstatic.net/1000026716/product/chuot_corsair_sabre_rgb_pro_wireless_fa8b62329e8a420b94bd5c8d72cf21c3.png',41,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (188,'https://product.hstatic.net/1000026716/product/a12_a6259101668f48caa6ed483beb4405d7.png',41,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (189,'https://product.hstatic.net/1000026716/product/a12_a6259101668f48caa6ed483beb4405d7.png',41,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (190,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-sabre-rgb-pro-wireless-1_0fa28298c14040d3aae0254c996ddd21.jpg',41,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (191,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-sabre-rgb-pro-wireless-2_774533b939514ced84a5bc5c6d999ccd.jpg',41,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (192,'https://product.hstatic.net/1000026716/product/sdfsdfs_6bb1e2c96b5d4f3fbb28a8dd04d63277.png',42,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (193,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-666_23333dfd6ea64129b9627324097a4955.png',42,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (194,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-8_310a9ee208f94bb6b494ba71c2795b42.png',42,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (195,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-10_afdf48abbede4ad3b7175fb7c6ad6147.png',42,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (196,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-10_afdf48abbede4ad3b7175fb7c6ad6147.png',42,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (197,'https://product.hstatic.net/1000026716/product/artboard_1_db5b520b96524f63b1b56acec3308f24.png',43,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (198,'https://product.hstatic.net/1000026716/product/thumbphim_4a3aab289f9746468afc73decb791dab.png',43,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (199,'https://product.hstatic.net/1000026716/product/z3473830734546_a748687a1c33fcf320cdc6bcdcd93f11_07c26e042cb740918f836d0ca547be49.jpg',43,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (200,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg',44,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (201,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-22_7ba2ffdcdb314b99a72b6df0b4094ef2.jpg',44,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (202,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-22_7ba2ffdcdb314b99a72b6df0b4094ef2.jpg',44,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (203,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-25_798d4fcb13f44bbeb393c25b7cf9db5a.jpg',44,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (204,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-23_6f011f0aced9460f8fca38b98d753791.jpg',44,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (205,'https://product.hstatic.net/1000026716/product/thumbphim_9c80488821f9404bbda90a001d86a63b.png',45,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (206,'https://product.hstatic.net/1000026716/product/gearvn-corsair-k68-rgb_01.png',45,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (207,'https://product.hstatic.net/1000026716/product/gearvn-corsair-k68-rgb_02.png',45,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (208,'https://product.hstatic.net/1000026716/product/gearvn-corsair-k68-rgb_02.png',45,1);
INSERT INTO `tbl_product_picture` (`picture_id`,`picture_url`,`product_id`,`status`) VALUES (209,'https://product.hstatic.net/1000026716/product/gearvn-corsair-k68-rgb_03.png',45,1);
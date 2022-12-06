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

INSERT INTO tbl_product_picture(`picture_id`,`picture_url`,`product_id`,`status`)
VALUES
(1,'https://product.hstatic.net/1000026716/product/i3u082w11blu-fix_6024858859ea443fa4bb8436e9fcda54.png',18,1),
(2,'https://product.hstatic.net/1000026716/product/in3520nt-cnb-00060lb055-bk_b97c424017ec470bb03ed47b13fabd99.png',18,1),
(3,'https://product.hstatic.net/1000026716/product/in3520nt-cnb-00060rb055-bk_6fa7d1a700314c19adf6617e48435bb7.png',18,1),
(4,'https://product.hstatic.net/1000026716/product/in3520nt-cnb-00090lp090-bk_cabd0d28b1744a778af27d79ec5545d6.png',18,1),
(5,'https://product.hstatic.net/1000026716/product/notebook-inspiron-15-3520-black-gallery-8_cc51802b03cb419181b5b75ed711fa12.png',18,1),

(6,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png',19,1),
(7,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-2_3ab988c88c9b4582b76e00d930ef2bc6.png',19,1),
(8,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-4_e16c7f8048bb4bc986f5e99e060b225d.png',19,1),
(9,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-5_90c2e13760124c8d8dfc3b5f7f8d4b37.png',19,1),
(10,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-6_fe9e26507eae4d3c9d8a2599dc010552.png',19,1),

(11,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png',20,1),
(12,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-2_3ab988c88c9b4582b76e00d930ef2bc6.png',20,1),
(13,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-4_e16c7f8048bb4bc986f5e99e060b225d.png',20,1),
(14,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-5_90c2e13760124c8d8dfc3b5f7f8d4b37.png',20,1),
(15,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-6_fe9e26507eae4d3c9d8a2599dc010552.png',20,1),

(16,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png',21,1),
(17,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-2_3ab988c88c9b4582b76e00d930ef2bc6.png',21,1),
(18,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-4_e16c7f8048bb4bc986f5e99e060b225d.png',21,1),
(19,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-5_90c2e13760124c8d8dfc3b5f7f8d4b37.png',21,1),
(20,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-6_fe9e26507eae4d3c9d8a2599dc010552.png',21,1),

(21,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-1_48258b668e224dc391f31649931443f3.png',22,1),
(22,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-2_3ab988c88c9b4582b76e00d930ef2bc6.png',22,1),
(23,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-4_e16c7f8048bb4bc986f5e99e060b225d.png',22,1),
(24,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-5_90c2e13760124c8d8dfc3b5f7f8d4b37.png',22,1),
(25,'https://product.hstatic.net/1000026716/product/gearvn-laptop-dell-inspiron-15-3520-n5i5122w1-black-6_fe9e26507eae4d3c9d8a2599dc010552.png',22,1),

(26,'https://product.hstatic.net/1000026716/product/g15-5511-i5_6fb23ec04c4f49f494011149bd627482.png',23,1),
(27,'https://product.hstatic.net/1000026716/product/notebook-g-15-5525-black-coralkb-gallery-2_e8c925c5fafb4a5faf37f63208635d57.png',23,1),
(28,'https://product.hstatic.net/1000026716/product/laptops_g-series_g15_5511_dark_shadow_gray_rgb_kb_media_gallery_3_51b4653b72c74ce1842d6ca268ed6b0d.png',23,1),
(29,'https://product.hstatic.net/1000026716/product/notebook-g-15-5525-black-coralkb-gallery-1_d48d3a581a6f48879f9e7a4af82c77d6.png',23,1),
(30,'https://product.hstatic.net/1000026716/product/notebook-g-15-5525-black-coralkb-gallery-3_a10d034eeb9042c49b9a8426722237b0.png',23,1),

(31,'https://product.hstatic.net/1000026716/product/gearvn-laptop-gaming-dell-g15-5525-r5h085w11gr3050-1_668f40d1e8e740bbbea8e138ca070b70.png',24,1),
(32,'https://product.hstatic.net/1000026716/product/gearvn-laptop-gaming-dell-g15-5525-r5h085w11gr3050-2_81d389e8a9dc446b8c57ed476b618f2b.png',24,1),
(33,'https://product.hstatic.net/1000026716/product/gearvn-laptop-gaming-dell-g15-5525-r5h085w11gr3050-3_4be3bb55c86c4dfb9ed168060016ed26.png',24,1),
(34,'https://product.hstatic.net/1000026716/product/gearvn-laptop-gaming-dell-g15-5525-r5h085w11gr3050-4_942c0132f33e4b6d8e9338c02a84e1b4.png',24,1),
(35,'https://product.hstatic.net/1000026716/product/gearvn-laptop-gaming-dell-g15-5525-r5h085w11gr3050-5_0ae134d0035346f4a6350591f31012da.png',24,1),

(36,'https://product.hstatic.net/1000026716/product/dell_e2722h_gearvn_a9938cc0f1d54c5ea764c57a949aed62.jpg',25,1),
(37,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-e2722h-27-ips-1_9372ded441a248c3b9ea9fc4f107aa97.jpg',25,1),
(38,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-e2722h-27-ips-2_e8902c7eef2b48fdb988242d0f91f445.jpg',25,1),
(39,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-e2722h-27-ips-3_4aaa7e040bb3408c9e40443d0995bd07.jpg',25,1),
(40,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-e2722h-27-ips-4_ba687dc4de8f429d835dcb1060153e01.jpg',25,1),

(41,'https://product.hstatic.net/1000026716/product/dell_u2422h_gearvn_e8dfce5719b0455aa386bf41352592cd.jpg',26,1),
(42,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-1_b6e681778b26484cbe62d5a054433f54.jpg',26,1),
(43,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-2_c610a79f562b491e9181ef8d76eed75e.jpg',26,1),
(44,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-3_940f2976eb704ca3889b7b54e08be1ba.jpg',26,1),
(45,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',26,1),

(46,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',27,1),
(47,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',27,1),
(48,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',27,1),
(49,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',27,1),
(50,'https://product.hstatic.net/1000026716/product/gearvn-man-hinh-dell-ultrasharp-u2422h-24-ips-4_2ada3331e157438dbbe7a67ca59ece23.jpg',27,1),

(51,'https://product.hstatic.net/1000026716/product/tai_nghe_gaming_logitech_g_pro_gen_2_958a8caa12d7468a90043e60bf1c1619.png',28,1),
(52,'https://product.hstatic.net/1000026716/product/tai_nghe_gaming_logitech_g_pro_gen_2_958a8caa12d7468a90043e60bf1c1619.png',28,1),

(53,'https://product.hstatic.net/1000026716/product/tai_nghe_logitech_g333_co_mic_va_mang_loa_kep_add4f35181384545859bdddf48667df9.png',29,1),
(54,'https://product.hstatic.net/1000026716/product/logitech-g333-black-3_28e4b9790a5448a2adcbdb8d55fc38d9.jpg',29,1),
(55,'https://product.hstatic.net/1000026716/product/logitech-g333-black-5_428fd2b2fd264b948340a8b8e22f7066.jpg',29,1),
(56,'https://product.hstatic.net/1000026716/product/logitech-g333-black-4_de4536e369a14326be2389083efd7942.jpg',29,1),
(57,'https://product.hstatic.net/1000026716/product/logitech-g333-purple-2_ba09a61d402f4121832eb5a08a6b5db5.jpg',29,1),

(58,'https://product.hstatic.net/1000026716/product/artboard_1_2ff4ba55c7be43a89f8ea1b2c2e577d6.png',30,1),
(59,'https://product.hstatic.net/1000026716/product/logitech-g102-lightsync-rgb-black-1_bf4f5774229c4a0f81b8e8a2feebe4d8.jpg',30,1),
(60,'https://product.hstatic.net/1000026716/product/logitech-g102-lightsync-rgb-black-2_7788492f5ed748248bd8cb2e967f9cc3.jpg',30,1),

(61,'https://product.hstatic.net/1000026716/product/artboard_1_da260270af0547c39559266fe9f44cb5.png',31,1),
(62,'https://product.hstatic.net/1000026716/product/z3420520962871_ebb1fcb446d1c8edec7dedb3f80b0bc6_950afe9464b349b78465f70f37b39340.jpg',31,1),
(63,'https://product.hstatic.net/1000026716/product/logitech-g402-hyperion-fury-ultr_f70b6cf060ce4690965f2664ab204159.png',31,1),
(64,'https://product.hstatic.net/1000026716/product/logitech-g402-hyperion-fury-ultr__1__e963208d9f634260bc0ac1a224c5be36.png',31,1),

(65,'https://product.hstatic.net/1000026716/product/ban_phim_logitech_mechanical_gaming_g413_tkl_se_89630a79e48b40278807ff48159ee32c.png',32,1),
(66,'https://product.hstatic.net/1000026716/product/thumbphim_c89f6d836d1844afadb2b4cb6ec33bf8.png',32,1),
(67,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-tkl-se-1_0269776db50c4f80ad5f18a4cae26389.jpg',32,1),
(68,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-tkl-se-2_16deeeba50374ad28070721366f8f688.jpg',32,1),
(69,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-tkl-se-3_4b3579cb52e647ec94ea24f9c88ad55b.jpg',32,1),

(70,'https://product.hstatic.net/1000026716/product/ban_phim_logitech_mechanical_gaming_g413_se_885f68b74d0841328f2dda07f41ccb56.png',33,1),
(71,'https://product.hstatic.net/1000026716/product/thumbphim_493ce5210abf4961838c8273ce21c152.png',33,1),
(72,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-se-2_af55de9fa1c244e68c747387d79cbb92.png',33,1),
(73,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-se-1_44c4757cc23e4fd197435f5736e0e475.png',33,1),
(74,'https://product.hstatic.net/1000026716/product/gearvn-ban-phim-logitech-mechanical-gaming-g413-se-3_0fe5bbdfb854404794c6432b683fd599.png',33,1),

(75,'https://product.hstatic.net/1000026716/product/chuot_corsair_sabre_rgb_pro_wireless_fa8b62329e8a420b94bd5c8d72cf21c3.png',34,1),
(76,'https://product.hstatic.net/1000026716/product/a12_a6259101668f48caa6ed483beb4405d7.png',34,1),
(77,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-sabre-rgb-pro-wireless-1_0fa28298c14040d3aae0254c996ddd21.jpg',34,1),
(78,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-sabre-rgb-pro-wireless-2_774533b939514ced84a5bc5c6d999ccd.jpg',34,1),
(79,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-sabre-rgb-pro-wireless-3_492b172a9b224b55833533ddea306201.jpg',34,1),

(80,'https://product.hstatic.net/1000026716/product/sdfsdfs_6bb1e2c96b5d4f3fbb28a8dd04d63277.png',35,1),
(81,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-666_23333dfd6ea64129b9627324097a4955.png',35,1),
(82,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-8_310a9ee208f94bb6b494ba71c2795b42.png',35,1),
(83,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-9_c9ea6ede82d34472a6f3f417ff64bae8.png',35,1),
(84,'https://product.hstatic.net/1000026716/product/gearvn-chuot-corsair-katar-pro-wireless-7_43e19bd5a57f460c9e59cccae9f91d78.png',35,1),

(85,'https://product.hstatic.net/1000026716/product/thumbphim_f34d4d3ca4fc41188e68ad60a6d8fcf8.png',36,1),
(86,'https://product.hstatic.net/1000026716/product/z3473894478619_0663dd314d81f9d694338446fff06d8f_7b5a73f781224b0dbfacf895ee29191d.jpg',36,1),
(87,'https://product.hstatic.net/1000026716/product/z3473894473467_d01ca2bc3b10b34db309160fdf49a1dd_a898840ed5ff4ad1b58c28fe72d0c6ca.jpg',36,1),

(88,'https://product.hstatic.net/1000026716/product/base-k55-rgb-pro-config-gallery-k55-rgb-pro-01_383e5e6b6c1448ec8ea2774436fc35bb.jpg',37,1),
(89,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-22_7ba2ffdcdb314b99a72b6df0b4094ef2.jpg',37,1),
(90,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-23_6f011f0aced9460f8fca38b98d753791.jpg',37,1),
(91,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-26_c277e990eda54e6fa04f6d9ea47f6f8f.jpg',37,1),
(92,'https://product.hstatic.net/1000026716/product/-base-k55-rgb-pro-config-gallery-k55-rgb-pro-29_63e94f70641f43a6943f8c01b1dc49c1.jpg',37,1);

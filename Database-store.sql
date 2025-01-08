USE [master]
GO

/*******************************************************************************
   Drop database if it exists
********************************************************************************/
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = 'Sport_shop')
BEGIN
	ALTER DATABASE Sport_shop SET OFFLINE WITH ROLLBACK IMMEDIATE;
	ALTER DATABASE Sport_shop SET ONLINE;
	DROP DATABASE Sport_shop;
END
--=========================================================================
-- create database

CREATE DATABASE Sport_shop
GO

USE Sport_shop
GO
--=========================================================================
-- create table

CREATE TABLE Roles
(
	role int primary key,
	[name] varchar(20) NOT NULL unique,
	[describe] nvarchar(255)
)

CREATE TABLE Admin
(
	[name] nvarchar(30),
	username varchar(30) primary key,
	password varchar(30) NOT NULL,
	telephone varchar(15),
	[address] nvarchar(50),
	role int references Roles(role)
)

CREATE TABLE Categories
(
	c_id int IDENTITY(1,1) primary key,
	[name] nvarchar(60) Not null unique,
	[describe] nvarchar(255)
)

CREATE TABLE Types
(
	t_id int IDENTITY(1,1) primary key,
	[name] nvarchar(60) Not null unique,
	[describe] nvarchar(255)
)

CREATE TABLE Products 
(
	p_id int IDENTITY(1,1) primary key,
	[name] nvarchar(255) NOT NULL unique,
	price money NOT NULL check (price > 0),
	quantity int  NOT NULL DEFAULT 1,
	c_id int NOT NULL,
    t_id int NOT NULL, 
	[describe] nvarchar(255) default null,
	[image] nvarchar(255) default null,
	dateRelease date not null,
	discount decimal(5,2) CHECK (discount <= 100 AND discount >=0) -- Không vượt quá 100
	foreign key(c_id) references Categories(c_id),
	foreign key(t_id) references Types(t_id),
	CONSTRAINT chk_quantity_positive CHECK (quantity > 0)
)

CREATE TABLE Status
(
	s_id int IDENTITY(1,1) primary key,
	s_name varchar(30) CHECK (s_name in ('Processing', 'Completed', 'Cancelled'))
)

CREATE TABLE Orders
(
	o_id int IDENTITY(1,1)  primary key,
	order_date date NOT NULL,
	shipped_date date ,
	s_id int not null,
	total_price	money,
	foreign key (s_id) references Status(s_id),
	customer_id varchar(30) not null references Admin([username]),
)

CREATE TABLE OrderDetails
(
	o_id int references Orders(o_id),
	p_id int references Products(p_id),
	primary key (o_id, p_id),
	quantity int NOT NULL,
	price money NOT NULL,
	CONSTRAINT chk_quantity_positive_1 CHECK (quantity > 0)
)

--============================================================
-- them du lieu

INSERT INTO Roles (role, [name], [describe]) VALUES
(1, 'Admin', 'Quản trị viên toàn hệ thống'),
(2, 'Customer', 'Khách hàng sử dụng hệ thống');

--==============================================================

INSERT INTO Admin ([name], username, password, telephone, [address], role) VALUES
(N'Nguyễn Văn A', 'admin', 'admin123', '0123456789', N'Hà Nội', 1),
(N'Trần Thị B', 'customer1', 'password1', '0987654321', N'Đà Nẵng', 2);

--=============================================================

INSERT INTO Categories ([name], [describe]) VALUES

(N'Thời trang thể thao', N'Quần áo và phụ kiện thể thao'),
(N'Bóng', N'Dùng để đá, đập'),
(N'Giày', N'Hỗ trợ di chuyển'),
(N'Vợt', N'Dùng để đánh');
(N'Bàn',N'môi trường chơi')

--============================================================

INSERT INTO Types (name, describe) VALUES
(N'Bóng đá', N'thể thao'),
(N'Cầu lông', N'thể thao'),
(N'Pickleball', N'thể thao'),
(N'Bóng rổ', N'thể thao'),
(N'Chạy bộ', N'thể thao'),
(N'Bóng bàn', N'thể thao');


--===============================================================

INSERT INTO Products 
([name], price, quantity, c_id, t_id, [describe], [image], dateRelease, discount) VALUES
-- Môn Bóng đá (t_id = 1)
-- Môn Bóng đá (t_id = 1)
(N'Bóng đá Nike Mercurial', 500000, 20, 2, 1, N'Bóng đá Nike chính hãng, thiết kế Mercurial', 'nike-soccer-ball.jpg', '2023-03-15', 15),
(N'Áo bóng đá Adidas', 450000, 15, 1, 1, N'Áo bóng đá Adidas chất lượng cao, thiết kế thoáng mát', 'adidas-soccer-shirt.jpg', '2024-02-10', 10),
(N'Giày đá bóng Puma Future', 1700000, 10, 3, 1, N'Giày đá bóng Puma Future, tăng độ bám và ổn định', 'puma-soccer-shoes.jpg', '2023-12-20', 5),
(N'Quần bóng đá Nike', 400000, 12, 1, 1, N'Quần bóng đá Nike phù hợp cho thi đấu chuyên nghiệp', 'nike-soccer-pants.jpg', '2024-05-11', 20),
(N'Bóng đá Molten F5G', 450000, 18, 2, 1, N'Bóng đá Molten, chuẩn thi đấu quốc tế', 'molten-soccer-ball.jpg', '2023-09-14', 10),

-- Môn Cầu lông (t_id = 2)
(N'Vợt cầu lông Yonex Astrox', 2500000, 8, 4, 2, N'Vợt cầu lông Yonex Astrox chính hãng, hỗ trợ lực tốt', 'yonex-badminton-racket.jpg', '2024-03-28', 15),
(N'Giày cầu lông Victor Thruster', 1400000, 15, 3, 2, N'Giày cầu lông Victor, giảm chấn tối ưu', 'victor-badminton-shoes.jpg', '2023-06-17', 5),
(N'Áo cầu lông Li-Ning', 420000, 20, 1, 2, N'Áo cầu lông Li-Ning nhẹ và thoáng khí', 'lining-badminton-shirt.jpg', '2024-01-22', 10),
(N'Quần cầu lông Yonex', 400000, 12, 1, 2, N'Quần cầu lông Yonex, thiết kế thể thao', 'yonex-badminton-pants.jpg', '2023-11-09', 20),
(N'Bóng cầu lông RSL', 250000, 25, 2, 2, N'Bóng cầu lông RSL, độ bền cao và nhẹ', 'rsl-shuttlecock.jpg', '2024-06-05', 30),

-- Môn Pickleball (t_id = 3)
(N'Vợt pickleball Selkirk Amped', 1700000, 8, 4, 3, N'Vợt pickleball Selkirk nhẹ và linh hoạt', 'selkirk-pickleball-racket.jpg', '2024-04-19', 20),
(N'Bóng pickleball Onix', 200000, 30, 2, 3, N'Bóng pickleball Onix, độ bền cao và nhẹ', 'onix-pickleball.jpg', '2023-08-13', 30),
(N'Áo pickleball Puma', 450000, 18, 1, 3, N'Áo pickleball Puma co giãn và thoải mái', 'puma-pickleball-shirt.jpg', '2023-12-01', 10),
(N'Quần pickleball Adidas', 400000, 15, 1, 3, N'Quần pickleball Adidas phong cách hiện đại', 'adidas-pickleball-pants.jpg', '2024-02-15', 5),
(N'Giày pickleball Wilson', 1200000, 10, 3, 3, N'Giày pickleball Wilson hỗ trợ tối ưu', 'wilson-pickleball-shoes.jpg', '2024-05-29', 40),

-- Môn Bóng rổ (t_id = 4)
(N'Bóng rổ Spalding Commander', 520000, 10, 2, 4, N'Bóng rổ Spalding chất lượng cao, chuẩn NBA', 'spalding-basketball.jpg', '2023-04-11', 5),
(N'Giày bóng rổ Jordan', 2500000, 8, 3, 4, N'Giày bóng rổ Jordan, phong cách thời thượng', 'jordan-basketball-shoes.jpg', '2024-03-07', 20),
(N'Áo bóng rổ Nike', 450000, 15, 1, 4, N'Áo bóng rổ Nike, thoáng mát và linh hoạt', 'nike-basketball-shirt.jpg', '2023-10-03', 50),
(N'Quần bóng rổ Adidas', 400000, 18, 1, 4, N'Quần bóng rổ Adidas thoải mái và bền bỉ', 'adidas-basketball-pants.jpg', '2024-06-22', 15),
(N'Bóng rổ Wilson Evolution', 600000, 12, 2, 4, N'Bóng rổ Wilson Evolution, chất lượng cao', 'wilson-basketball.jpg', '2024-01-19', 5),

-- Môn Chạy bộ (t_id = 5)
(N'Giày chạy bộ Asics Gel', 1200000, 12, 3, 5, N'Giày chạy bộ Asics hỗ trợ tối đa khi luyện tập', 'asics-running-shoes.jpg', '2024-03-12', 10),
(N'Áo chạy bộ Nike Dri-FIT', 550000, 20, 1, 5, N'Áo chạy bộ Nike thoáng khí và nhẹ', 'nike-running-shirt.jpg', '2023-05-21', 5),
(N'Quần chạy bộ Under Armour', 480000, 18, 1, 5, N'Quần chạy bộ Under Armour bền và co giãn tốt', 'underarmour-running-pants.jpg', '2023-09-26', 15),
(N'Dây đeo tay chạy bộ Xiaomi', 150000, 25, 1, 5, N'Dây đeo tay hỗ trợ theo dõi nhịp tim khi chạy', 'xiaomi-running-band.jpg', '2024-05-03', 20),
(N'Nón chạy bộ Adidas', 300000, 30, 1, 5, N'Nón chạy bộ Adidas chống tia UV', 'adidas-running-cap.jpg', '2023-07-18', 50);

--================================================================
INSERT INTO Status (s_name) VALUES
('Processing'),
('Accept'),
('Completed'),
('Cancelled');

--============================================================	
INSERT INTO Orders (order_date, shipped_date, s_id, customer_id, total_price) VALUES
('2024-12-05', NULL, 1, 'customer1', 1235000),
('2024-12-01', '2024-12-03', 2, 'customer1', 1215000);

--===================================================================
INSERT INTO OrderDetails (o_id, p_id, quantity, price) VALUES
(1, 1, 1, 500000),
(1, 2, 2,450000),
(2, 2, 3,1700000);

select * from Products where t_id = (select t_id from products where p_id=1) and p_id <>1
select * from Admin



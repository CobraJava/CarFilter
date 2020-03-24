CREATE TABLE brand
(
    id int not null AUTO_INCREMENT,
    name varchar(100) not null,
    PRIMARY KEY (id)
);

CREATE TABLE attribute
(
    id int not null AUTO_INCREMENT,
    name varchar(100) not null,
    PRIMARY KEY (id)
);

CREATE TABLE car
(
    id int not null AUTO_INCREMENT,
    name varchar(200) not null,
    description varchar(1000),
    price float not null,
    amount int default 0,
    brand_id int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (brand_id) REFERENCES brand(id)
);

CREATE TABLE picture
(
    id int not null AUTO_INCREMENT,
    url varchar(300) not null,
    car_id int,
    primary key (id),
    foreign key (car_id) references car(id)
);

CREATE TABLE car_attribute
(
    id int not null auto_increment,
    car_id int,
    attribute_id int not null,
    value varchar(100),
    primary key (id),
    foreign key (car_id) references car(id),
    foreign key (attribute_id) references attribute(id)
)


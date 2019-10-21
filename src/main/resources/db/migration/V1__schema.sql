CREATE TABLE category
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

CREATE TABLE item
(
    id int not null AUTO_INCREMENT,
    name varchar(200) not null,
    description varchar(1000),
    price float not null,
    amount int default 0,
    category_id int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE TABLE picture
(
    id int not null AUTO_INCREMENT,
    url varchar(300) not null,
    item_id int,
    primary key (id),
    foreign key (item_id) references item(id)
);

CREATE TABLE item_attribute
(
    id int not null auto_increment,
    item_id int,
    attribute_id int not null,
    value varchar(100),
    primary key (id),
    foreign key (item_id) references item(id),
    foreign key (attribute_id) references attribute(id)
)


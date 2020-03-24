create table user(
    id int not null auto_increment primary key,
    username varchar(30) not null,
    password varchar(200),
    email varchar(200),
    role varchar(30) not null
    )
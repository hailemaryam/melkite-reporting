create table UserDetail (
    id varchar(255) not null,
    email varchar(255),
    name varchar(255),
    password varchar(255),
    phone varchar(255),
    role varchar(255),
    salt varchar(255),
    username varchar(255),
    primary key (id)
) engine=InnoDB;

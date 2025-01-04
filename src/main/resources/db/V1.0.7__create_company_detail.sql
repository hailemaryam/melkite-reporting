create table CompanyDetail (
    id BIGINT not null auto_increment,
    address varchar(255),
    city varchar(255),
    country varchar(255),
    name varchar(255),
    spId varchar(255),
    hash varchar(255),
    serviceId varchar(255),
    productId varchar(255),
    state varchar(255),
    zipCode varchar(255),
    primary key (id)
) engine=InnoDB;
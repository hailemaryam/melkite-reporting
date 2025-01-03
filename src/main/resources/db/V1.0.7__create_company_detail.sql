create table CompanyDetail (
    id varchar(255) not null,
    address varchar(255),
    city varchar(255),
    country varchar(255),
    name varchar(255),
    serviceId varchar(255),
    productId varchar(255),
    state varchar(255),
    zipCode varchar(255),
    primary key (id)
) engine=InnoDB;
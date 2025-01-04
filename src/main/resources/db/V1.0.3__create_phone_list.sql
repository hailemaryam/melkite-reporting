create table PhoneList (
    id BIGINT not null auto_increment,
    customerSegmentGroup varchar(255),
    phone varchar(255),
    productId varchar(255),
    registrationTime datetime(6),
    serviceId varchar(255),
    status bit,
    updateTime datetime(6),
    primary key (id)
) engine=InnoDB;

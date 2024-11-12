create table SentPayDump (
    id varchar(255) not null,
    atDateOf varchar(255),
    customerSegmentGroup varchar(255),
    deliveryStatus varchar(255),
    deliveryStatusMessage varchar(255),
    deliveryStatusTime datetime(6),
    phone varchar(255),
    productId varchar(255),
    serviceId varchar(255),
    status bit,
    primary key (id)
) engine=InnoDB;

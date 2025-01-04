create table SentPay (
    id BIGINT not null auto_increment,
    atDateOf varchar(255),
    customerSegmentGroup BIGINT,
    expiryTime datetime(6),
    failedCount integer,
    productId varchar(255),
    sentTime datetime(6),
    serviceId varchar(255),
    successfulCount integer,
    totalNoOfRequestSent integer,
    primary key (id)
) engine=InnoDB;

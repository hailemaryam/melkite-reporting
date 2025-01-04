create table CustomerSegmentGroup (
    id BIGINT not null auto_increment,
    customerSegmentGroupName varchar(255),
    productId varchar(255),
    serviceId varchar(255),
    subscriberCount integer,
    unSubscriberCount integer,
    active bit not null,
    primary key (id)
) engine=InnoDB;

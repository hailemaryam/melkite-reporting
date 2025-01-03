create table CustomerSegmentGroup (
    id varchar(255) not null,
    customerSegmentGroupName varchar(255),
    productId varchar(255),
    serviceId varchar(255),
    subscriberCount integer,
    unSubscriberCount integer,
    active bit not null,
    primary key (id)
) engine=InnoDB;

create table DailySubscriberCounter (
    id varchar(255) not null,
    atDateOf varchar(255),
    createdAt datetime(6),
    currentCustomerSegmentGroup varchar(255),
    productId varchar(255),
    serviceId varchar(255),
    subscriberCount integer,
    unSubscriberCount integer,
    updatedAt datetime(6),
    primary key (id)
) engine=InnoDB;

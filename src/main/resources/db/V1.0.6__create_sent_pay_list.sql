create table SentPayList (
    id varchar(255) not null,
    customerSegmentGroup varchar(255),
    dayRetryLimitExceededCount integer,
    fetchedTime datetime(6),
    hourRetryLimitExceededCount integer,
    internalErrorCount integer,
    invalidSubscriptionCount integer,
    lastPicked datetime(6),
    noBalanceCount integer,
    noSubscriptionCount integer,
    phone varchar(255),
    pickedStatus bit,
    productId varchar(255),
    serviceId varchar(255),
    successfulCount integer,
    totalNoOfRequestSent integer,
    primary key (id)
) engine=InnoDB;

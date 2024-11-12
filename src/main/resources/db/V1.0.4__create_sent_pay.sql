create table SentPay (
    id varchar(255) not null,
    atDateOf varchar(255),
    customerSegmentGroup varchar(255),
    dayRetryLimitExceededCount integer,
    expiryTime datetime(6),
    hourRetryLimitExceededCount integer,
    internalErrorCount integer,
    invalidSubscriptionCount integer,
    noBalanceCount integer,
    noSubscriptionCount integer,
    productId varchar(255),
    sentTime datetime(6),
    serviceId varchar(255),
    successfulCount integer,
    totalNoOfRequestSent integer,
    primary key (id)
) engine=InnoDB;

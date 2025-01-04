package com.hmmk.melkite.entity.charging;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "SentPayList")
@Cacheable
public class SentPayList extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String serviceId;
    public String productId;
    public String spId;
    public String hash;
    public Long sentPayId;
    public Long customerSegmentGroup;
    public String phone;
    public Instant fetchedTime;
    public Instant lastPicked;
    public Boolean pickedStatus;
    public Integer successfulCount;
    public Integer noBalanceCount;
    public Integer internalErrorCount;
    public Integer noSubscriptionCount;
    public Integer hourRetryLimitExceededCount;
    public Integer dayRetryLimitExceededCount;
    public Integer invalidRenewalPeriodCount;
    public Integer invalidSubscriberStatusCount;
    public Integer userNotEligibleCount;
    public Integer unknownErrorCount;
    public Integer totalNoOfRequestSent;
}

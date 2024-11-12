package com.hmmk.melkite.entity.charging;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;

@Entity
@Table(name = "SentPay")
@Cacheable
public class SentPay extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String id;
    public String serviceId;
    public String productId;
    public String customerSegmentGroup;
    public String atDateOf;
    public Instant sentTime;
    public Instant expiryTime;
    public Integer successfulCount;
    public Integer noBalanceCount;
    public Integer invalidSubscriptionCount;
    public Integer internalErrorCount;
    public Integer noSubscriptionCount;
    public Integer hourRetryLimitExceededCount;
    public Integer dayRetryLimitExceededCount;
    public Integer totalNoOfRequestSent;
}

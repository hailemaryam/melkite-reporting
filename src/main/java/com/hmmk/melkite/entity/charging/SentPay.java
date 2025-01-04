package com.hmmk.melkite.entity.charging;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "SentPay")
@Cacheable
public class SentPay extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String serviceId;
    public String productId;
    public Long customerSegmentGroup;
    public String atDateOf;
    public Instant sentTime;
    public Instant expiryTime;
    public Integer successfulCount;
    public Integer failedCount;
    public Integer totalNoOfRequestSent;
}
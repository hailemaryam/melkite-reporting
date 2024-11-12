package com.hmmk.melkite.entity.subscription;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;

@Entity
@Table(name = "DailySubscriberCounter")
@Cacheable
public class DailySubscriberCounter extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String id;
    public String serviceId;
    public String productId;
    public String currentCustomerSegmentGroup;
    public Integer subscriberCount;
    public Integer unSubscriberCount;
    public String atDateOf;
    public Instant createdAt;
    public Instant updatedAt;
}

package com.hmmk.melkite.entity.charging;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;

@Entity
@Table(name = "SentPayDump")
@Cacheable
public class SentPayDump extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String id;
    public String serviceId;
    public String productId;
    public String customerSegmentGroup;
    public String sentPayId;
    public String phone;
    public String atDateOf;
    public String deliveryStatus;
    public String deliveryStatusMessage;
    public Instant deliveryStatusTime;
    public Boolean status;
}

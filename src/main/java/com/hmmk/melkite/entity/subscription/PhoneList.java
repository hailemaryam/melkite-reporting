package com.hmmk.melkite.entity.subscription;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.Instant;

@Entity
@Table(name = "PhoneList")
@Cacheable
public class PhoneList extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String id;
    public String serviceId;
    public String productId;
    public String customerSegmentGroup;
    public String phone;
    public Boolean status;
    public Instant registrationTime;
    public Instant updateTime;
}
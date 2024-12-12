package com.hmmk.melkite.entity.subscription;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CustomerSegmentGroup")
@Cacheable
public class CustomerSegmentGroup extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String id;
    public String serviceId;
    public String productId;
    public String customerSegmentGroupName;
    public Boolean active;
    public Integer subscriberCount;
    public Integer unSubscriberCount;
}

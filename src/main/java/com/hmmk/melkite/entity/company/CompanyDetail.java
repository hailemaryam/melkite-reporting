package com.hmmk.melkite.entity.company;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "CompanyDetail")
@Cacheable
public class CompanyDetail extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String spId;
    public String hash;
    public String serviceId;
    public String productId;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public String country;
    @ManyToMany
    @JoinTable(
            name = "company_user",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    public List<UserDetail> users;
}

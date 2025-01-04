package com.hmmk.melkite.entity.company;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "UserDetail")
@Cacheable
public class UserDetail extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String email;
    public String username;
    public String phone;
    public String password;
    public String salt;
    public String role;
    @ManyToMany(mappedBy = "users")
    public List<CompanyDetail> companies;
}

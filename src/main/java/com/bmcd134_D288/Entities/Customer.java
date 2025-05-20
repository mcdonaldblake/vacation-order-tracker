package com.bmcd134_D288.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "customer_id",  nullable = false)
    private long id;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @Column(name = "address",  nullable = false)
    private String address;

    @Column(name = "postal_code",  nullable = false)
    private String postal_code;

    @Column(name = "phone",  nullable = false)
    private String phone;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDateTime create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime last_update;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "division_id", nullable = true)
    private Division division;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Cart> carts = new HashSet<>();




}

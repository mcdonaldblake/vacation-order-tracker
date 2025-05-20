package com.bmcd134_D288.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "division_id")
    private long id;

    @Column(name = "division")
    private String division_name;

    @Column(name = "create_date")
    private LocalDateTime create_date;

    @Column(name = "last_update")
    private LocalDateTime last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @OneToMany(mappedBy = "division",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private Set<Customer> customers = new HashSet<>();

    @Column(name = "country_id")
    private long country_id;
    public void setCountry(Country country) {
        this.country = country;
        setCountry_id(country.getId());
    }
}


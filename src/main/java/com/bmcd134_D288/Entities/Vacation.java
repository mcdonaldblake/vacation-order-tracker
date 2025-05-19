package com.bmcd134_D288.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vacations")
@Data
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacation_title;

    @Column(name = "description")
    private String description;

    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    @Column(name = "image_url")
    private String image_URL;

    @Column(name = "create_date")
    private LocalDateTime create_date;

    @Column(name = "last_update")
    private LocalDateTime last_update;

    @OneToMany(mappedBy = "vacation",
    cascade = CascadeType.ALL,
    orphanRemoval = true
    )
    private Set<Excursion> excursions = new HashSet<>();

    @OneToMany(mappedBy = "vacation",
    cascade = CascadeType.ALL,
    orphanRemoval = true
    )
    private Set<CartItem> cartItems = new HashSet<>();
}

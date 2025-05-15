package com.bmcd134_D288.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart_items")
@Data
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany
    @JoinTable(name = "cartitem_excursion",
            joinColumns = @JoinColumn(name = "cart_item_id"),
            inverseJoinColumns = @JoinColumn(name = "excursion_id")
    )
    private Set<Excursion> excursions = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id",  nullable = false)
    private Cart cart;

    @Column(name = "create_date")
    private LocalDateTime create_date;

    @Column(name = "last_update")
    private LocalDateTime last_update;

}

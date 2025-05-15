package com.bmcd134_D288.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
@Data
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "country_id")
    private Long id;

    @Column(name = "country")
    private String country_name;

    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDateTime create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime last_update;

    @OneToMany(
            mappedBy = "country",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Division> divisions = new HashSet<>();


}

package com.PFE.RH.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "prime")
public class Prime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    private int year;
    private int month;
    private Double montant;
    private String motif;
    @ManyToOne
    @JoinColumn(name = "type_prime_id")
    private TypePrime typePrime;
    // Getters and Setters (Omitted for brevity)
}

package com.PFE.RH.DTO;

import lombok.Data;

@Data
public class PrimeDTO {
    private Long primeId;
    private Long contactId;
    private int year;
    private int month;
    private Double montant;
    private String motif;
    private Long typePrimeId; // Include TypePrimeId only
    private String typePrimeCode; // Include TypePrimeCode only

    // Getters and Setters (Omitted for brevity)
}

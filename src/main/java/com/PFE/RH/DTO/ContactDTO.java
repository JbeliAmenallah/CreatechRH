package com.PFE.RH.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ContactDTO {
    private Long contactId;
    private String name;
    private String username;
    private String email;
    private String location;
    private String phone;
    private List<AbsenceDTO> absences = new ArrayList<>();
    private List<PrimeDTO> primes = new ArrayList<>(); // Add list of PrimeDTO
    private List<AutorisationDTO> autorisations = new ArrayList<>(); // Add list of AutorisationDTO
    private List<CongeDTO> conges = new ArrayList<>(); // Add list of CongeDTO

    // Getters and setters
    // Omitted for brevity
}

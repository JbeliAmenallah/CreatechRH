package com.PFE.RH.DTO;

import com.PFE.RH.Entities.Cotisation;
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
    private List<AbsenceWithHiddenContactIdDTO> absences = new ArrayList<>();
    private List<PrimeDTO> primes = new ArrayList<>(); // Add list of PrimeDTO
    private List<AutorisationDTO> autorisations = new ArrayList<>(); // Add list of AutorisationDTO
    private List<CongeWithHiddenContactIdDTO> conges = new ArrayList<>(); // Add list of CongeDTO
    private List<CotisationDTO> cotisations=new ArrayList<>();

    // Getters and setters
    // Omitted for brevity
}

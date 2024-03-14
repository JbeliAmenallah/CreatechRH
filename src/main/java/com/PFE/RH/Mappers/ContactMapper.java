package com.PFE.RH.Mappers;

import com.PFE.RH.DTO.AutorisationDTO;
import com.PFE.RH.DTO.ContactDTO;
import com.PFE.RH.DTO.PrimeDTO;
import com.PFE.RH.Entities.Autorisation;
import com.PFE.RH.Entities.Contact;
import com.PFE.RH.Entities.Prime;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    @Mappings({
            @Mapping(source = "contact.absences", target = "absences"),
            @Mapping(source = "contact.primes", target = "primes"),
            @Mapping(source = "contact.autorisations", target = "autorisations"),
            @Mapping(source = "contact.contactId", target = "contactId"),
            @Mapping(source = "contact.name", target = "name"),
            @Mapping(source = "contact.username", target = "username"),
            @Mapping(source = "contact.email", target = "email"),
            @Mapping(source = "contact.location", target = "location"),
            @Mapping(source = "contact.phone", target = "phone")
    })
    ContactDTO contactToContactDTO(Contact contact);

    @Mapping(target = "absences", ignore = true)
    @Mapping(target = "primes", ignore = true)
    @Mapping(target = "autorisations", ignore = true)
    Contact contactDTOToContact(ContactDTO contactDTO);

    @Mappings({
            @Mapping(source = "primeId", target = "primeId"),
            @Mapping(source = "contact.contactId", target = "contactId"),
            @Mapping(source = "montant", target = "montant"),
            @Mapping(source = "year", target = "year"),
            @Mapping(source = "month", target = "month"),
            @Mapping(source = "motif", target = "motif"),
            @Mapping(target = "typePrimeId", expression = "java(prime.getTypePrime() != null ? prime.getTypePrime().getTypePrimeId() : null)"),
            @Mapping(target = "typePrimeCode", expression = "java(prime.getTypePrime() != null ? prime.getTypePrime().getCode() : null)")
    })
    PrimeDTO primeToPrimeDTO(Prime prime);

    @Mappings({
            @Mapping(source = "primeDTO.primeId", target = "primeId"),
            @Mapping(source = "primeDTO.contactId", target = "contact.contactId"),
            @Mapping(source = "primeDTO.montant", target = "montant"),
            @Mapping(source = "primeDTO.year", target = "year"),
            @Mapping(source = "primeDTO.month", target = "month"),
            @Mapping(source = "primeDTO.motif", target = "motif"),
            @Mapping(target = "typePrime", ignore = true) // Ignore typePrime mapping
    })
    Prime primeDTOToPrime(PrimeDTO primeDTO);

    @Mappings({
            @Mapping(source = "autorisationId", target = "autorisationId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "contact.contactId", target = "contactId"),
            @Mapping(source = "contact.name", target = "contactName")
    })
    AutorisationDTO autorisationToAutorisationDTO(Autorisation autorisation);

    @Mappings({
            @Mapping(source = "autorisationDTO.autorisationId", target = "autorisationId"),
            @Mapping(source = "autorisationDTO.date", target = "date"),
            @Mapping(source = "autorisationDTO.contactId", target = "contact.contactId")
    })
    Autorisation autorisationDTOToAutorisation(AutorisationDTO autorisationDTO);
}

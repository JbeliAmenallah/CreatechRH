package com.PFE.RH.Services;

import com.PFE.RH.DTO.ContactDTO;
import com.PFE.RH.Entities.Contact;
import com.PFE.RH.Mappers.ContactMapper;
import com.PFE.RH.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapper contactMapper;

    public List<ContactDTO> getAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contactMapper::contactToContactDTO)
                .collect(Collectors.toList());
    }

    public ContactDTO saveContact(ContactDTO contactDTO) {
        Contact contact = contactMapper.contactDTOToContact(contactDTO);
        Contact savedContact = contactRepository.save(contact);
        return contactMapper.contactToContactDTO(savedContact);
    }

    public ContactDTO updateContact(Long id, ContactDTO updatedContactDTO) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            Contact existingContact = optionalContact.get();
            existingContact.setName(updatedContactDTO.getName());
            existingContact.setUsername(updatedContactDTO.getUsername());
            existingContact.setEmail(updatedContactDTO.getEmail());
            existingContact.setLocation(updatedContactDTO.getLocation());
            existingContact.setPhone(updatedContactDTO.getPhone());

            Contact updatedContact = contactRepository.save(existingContact);
            return contactMapper.contactToContactDTO(updatedContact);
        } else {
            throw new NoSuchElementException("Contact not found with ID: " + id);
        }
    }

    public boolean deleteContact(Long id) {
        try {
            contactRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException("Contact not found with ID: " + id);
        }
    }
}

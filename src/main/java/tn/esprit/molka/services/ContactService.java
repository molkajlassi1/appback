package tn.esprit.molka.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.molka.entities.Contact;
import tn.esprit.molka.repository.ContactRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Contact getContactById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }




    public List<Contact> getAllContacts() {
    log.info("In Method getAllContact ");
        ArrayList<Contact> listc =(ArrayList<Contact>) contactRepository.findAll();
        log.info("Contact : "+listc.size());

        for (Contact c:listc) {
           log.info("Details de contact: " +c);
        }

  return listc;

    }

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, Contact updatedContact) {
        Contact existingContact = contactRepository.findById(id).orElse(null);
        if (existingContact != null) {
            // Update fields as needed
            existingContact.setNom(updatedContact.getNom());
            existingContact.setPrenom(updatedContact.getPrenom());
            existingContact.setCin(updatedContact.getCin());
            existingContact.setEmail(updatedContact.getEmail());
            existingContact.setPassword(updatedContact.getPassword());
            existingContact.setImage(updatedContact.getImage());
            existingContact.setDateNaissance(updatedContact.getDateNaissance());
            existingContact.setTelephone(updatedContact.getTelephone());
            existingContact.setAdresse(updatedContact.getAdresse());
            existingContact.setRole(updatedContact.getRole());
            existingContact.setEtudiant(updatedContact.getEtudiant());

            return contactRepository.save(existingContact);
        } else {
            return null;
        }
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}

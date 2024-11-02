package tn.esprit.molka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.molka.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}

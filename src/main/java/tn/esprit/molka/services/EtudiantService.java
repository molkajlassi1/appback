package tn.esprit.molka.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.molka.entities.Etudiant;
import tn.esprit.molka.repository.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant updateEtudiant(Long id, Etudiant updatedEtudiant) {
        Etudiant existingEtudiant = etudiantRepository.findById(id).orElse(null);
        if (existingEtudiant != null) {
            // Update fields as needed
            existingEtudiant.setFaculte(updatedEtudiant.getFaculte());
            existingEtudiant.setIdentifiant(updatedEtudiant.getIdentifiant());
            existingEtudiant.setTypeEtudiant(updatedEtudiant.getTypeEtudiant());
            existingEtudiant.setContact(updatedEtudiant.getContact());
            existingEtudiant.setNiveauSpecialite(updatedEtudiant.getNiveauSpecialite());

            return etudiantRepository.save(existingEtudiant);
        } else {
            return null; // Handle not found case
        }
    }

    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }

    public List<Etudiant> getEtudiantsByIdentifiant(String identifiant) {
        return etudiantRepository.findByIdentifiant(identifiant);
    }
}

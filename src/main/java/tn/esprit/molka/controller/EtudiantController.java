package tn.esprit.molka.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.molka.entities.Etudiant;
import tn.esprit.molka.services.EtudiantService;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("find/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiantById(id);
        return ResponseEntity.ok(etudiant);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        return ResponseEntity.ok(etudiants);
    }

    @PostMapping("/add")
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant createdEtudiant = etudiantService.createEtudiant(etudiant);
        return ResponseEntity.ok(createdEtudiant);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Etudiant updatedEtudiant = etudiantService.updateEtudiant(id, etudiant);
        return ResponseEntity.ok(updatedEtudiant);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/searchByIdentifiant/{identifiant}")
    public ResponseEntity<List<Etudiant>> searchEtudiantsByIdentifiant(@PathVariable String identifiant) {
        List<Etudiant> etudiants = etudiantService.getEtudiantsByIdentifiant(identifiant);
        return ResponseEntity.ok(etudiants);
    }
}

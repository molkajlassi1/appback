package tn.esprit.molka.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContact;
    private String nom;
    private String prenom;
    private Long cin;
    private String email;
    private String password;
    private String image;
    private Date dateNaissance;
    private Long telephone;
    private String adresse;
    private TypeRole role;
    @OneToOne
    private Etudiant etudiant;





}

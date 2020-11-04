package com.example.demo.user;

import com.example.demo.compteCourant.CompteCourant;
import com.example.demo.compteEpargne.CompteEpargne;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String identifiant;

    private String nom;

    private String prenom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compteCourant", referencedColumnName = "id")
    private CompteCourant compteCourant;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "compteEpargne", referencedColumnName = "id")
    private CompteEpargne compteEpargne;



/*    @Override
    public String toString() {
        return  name + " " +  email ;
    }*/

    //<editor-fold desc="Getter-Setter">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public CompteCourant getCompteCourant() {
        return compteCourant;
    }

    public void setCompteCourant(CompteCourant compteCourant) {
        this.compteCourant = compteCourant;
    }

    public CompteEpargne getCompteEpargne() {
        return compteEpargne;
    }

    public void setCompteEpargne(CompteEpargne compteEpargne) {
        this.compteEpargne = compteEpargne;
    }
    //</editor-fold>
}
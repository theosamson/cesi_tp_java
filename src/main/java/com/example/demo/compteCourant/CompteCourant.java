package com.example.demo.compteCourant;

import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class CompteCourant {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String numero;

    private String intitule;

    private Double solde;

    private Double montantDecouvertAutorise;

    @OneToOne(mappedBy = "compteCourant")
    @JsonIgnore
    private User user;


    //<editor-fold desc="Getter-Setter">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Double getMontantDecouvertAutorise() {
        return montantDecouvertAutorise;
    }

    public void setMontantDecouvertAutorise(Double montantDecouvertAutorise) {
        this.montantDecouvertAutorise = montantDecouvertAutorise;
    }
    //</editor-fold>
}
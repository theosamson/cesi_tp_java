package com.example.demo.compteEpargne;

import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class CompteEpargne {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String numero;

    private String intitule;

    private Double solde;

    private Double tauxInteret;

    @OneToOne(mappedBy = "compteEpargne")
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

    public Double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(Double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
    //</editor-fold>
}
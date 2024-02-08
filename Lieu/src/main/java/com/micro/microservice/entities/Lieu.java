package com.micro.microservice.entities;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table( name = "Lieu")

public class Lieu implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="idLieu")
private Long idLieu;
private String nom;
private String adresse;
private String codePostal;
private String ville;

    public Long getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(Long idLieu) {
        this.idLieu = idLieu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Lieu{" +
                "idLieu=" + idLieu +
                ", nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }

    public Lieu() {
    }

    public Lieu(Long idLieu, String nom, String adresse, String codePostal, String ville) {
        this.idLieu = idLieu;
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
    }
}

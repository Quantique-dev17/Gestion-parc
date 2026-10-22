package com.gestionparc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "voitures")
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String plaqueImmatriculation;

    @NotBlank
    private String marque;

    @NotBlank
    private String modele;

    private String couleur;

    @ManyToOne
    @JoinColumn(name = "proprietaire_id")
    private Utilisateur proprietaire;

    @ManyToOne
    @JoinColumn(name = "place_parking_id")
    private PlaceParking placeParking;

    private LocalDateTime dateEntree;
    private LocalDateTime dateSortie;

    @Enumerated(EnumType.STRING)
    private Statut statut = Statut.STATIONNEE;

    public enum Statut {
        STATIONNEE, EN_TRANSIT, SORTIE
    }

    public Voiture() {}

    public Voiture(String plaqueImmatriculation, String marque, String modele, String couleur, Utilisateur proprietaire) {
        this.plaqueImmatriculation = plaqueImmatriculation;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.proprietaire = proprietaire;
        this.dateEntree = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaqueImmatriculation() {
        return plaqueImmatriculation;
    }

    public void setPlaqueImmatriculation(String plaqueImmatriculation) {
        this.plaqueImmatriculation = plaqueImmatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public PlaceParking getPlaceParking() {
        return placeParking;
    }

    public void setPlaceParking(PlaceParking placeParking) {
        this.placeParking = placeParking;
    }

    public LocalDateTime getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(LocalDateTime dateEntree) {
        this.dateEntree = dateEntree;
    }

    public LocalDateTime getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(LocalDateTime dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
}

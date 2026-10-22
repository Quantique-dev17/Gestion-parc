package com.gestionparc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "places_parking")
public class PlaceParking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true)
    private String numero;

    @NotBlank
    private String zone;

    @Enumerated(EnumType.STRING)
    private Statut statut = Statut.LIBRE;

    private String description;

    public enum Statut {
        LIBRE, OCCUPEE, RESERVEE, EN_MAINTENANCE
    }

    public PlaceParking() {}

    public PlaceParking(String numero, String zone, String description) {
        this.numero = numero;
        this.zone = zone;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

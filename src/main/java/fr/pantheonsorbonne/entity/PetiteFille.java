package fr.pantheonsorbonne.entity;

import jakarta.persistence.Entity;

@Entity
public class PetiteFille extends Joueur {
    @Override
    public String doStuff() {
        return "fille";
    }
}

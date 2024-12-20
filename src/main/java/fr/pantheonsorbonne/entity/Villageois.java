package fr.pantheonsorbonne.entity;

import jakarta.persistence.Entity;

@Entity
public class Villageois extends Joueur {
    @Override
    public String doStuff() {
        return "village";
    }
}

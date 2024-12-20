package fr.pantheonsorbonne.entity;

import jakarta.persistence.Entity;

@Entity
public class Loup extends Joueur {
    @Override
    public String doStuff() {
        return "aouuuuuuuuu";
    }
}

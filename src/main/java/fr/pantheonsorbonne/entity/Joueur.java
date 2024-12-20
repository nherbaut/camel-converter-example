package fr.pantheonsorbonne.entity;

import jakarta.persistence.*;

@Entity
public abstract class Joueur {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;



    public abstract String doStuff();
}

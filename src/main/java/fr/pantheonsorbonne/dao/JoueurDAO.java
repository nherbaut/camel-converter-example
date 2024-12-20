package fr.pantheonsorbonne.dao;

import fr.pantheonsorbonne.entity.Joueur;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@Named("JoueurDAO")
@RegisterForReflection
@ApplicationScoped
public class JoueurDAO {

    @Inject
    EntityManager em;

    @Transactional
    public void saveJoueur(Joueur joueur) {
        em.persist(joueur);
    }

    @Transactional
    public List<Joueur> getAllJoueurs() {
        return em.createQuery("select j from Joueur j", Joueur.class).getResultList();
    }

}

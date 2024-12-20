package fr.pantheonsorbonne.camel;

import fr.pantheonsorbonne.entity.Joueur;
import fr.pantheonsorbonne.entity.PetiteFille;
import fr.pantheonsorbonne.entity.Villageois;
import jakarta.inject.Inject;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import java.util.List;

public class RouterBuilder extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        from("direct:sendRole")
                .delay(10000) // optionnel, histoire d'avoir quelques cris vides avant d'afficher les joueurs
                .split()
                .body()
                .multicast()
                .convertBodyTo(Joueur.class)
                .bean("JoueurDAO", "saveJoueur").end();

        from("scheduler://joueurPlay?delay=2000")
                .log("Les joueurs crient")
                .bean("JoueurDAO", "getAllJoueurs")
                .split().body()
                .log("${body.getName()} dit ${body.doStuff()}")
                .end().log("fin des cris!");


    }
}

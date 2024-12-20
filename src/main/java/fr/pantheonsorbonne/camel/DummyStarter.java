package fr.pantheonsorbonne.camel;

import fr.pantheonsorbonne.entity.Joueur;
import fr.pantheonsorbonne.entity.Loup;
import fr.pantheonsorbonne.entity.PetiteFille;
import fr.pantheonsorbonne.entity.Villageois;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;

import java.util.Map;

@ApplicationScoped
public class DummyStarter {


    @EndpointInject("direct:sendRole")
    ProducerTemplate producerTemplate;

    public void onStartup(@Observes StartupEvent startupEvent) {
        producerTemplate.sendBody(
                Map.of("Nicolas", Loup.class,
                        "Elio", Villageois.class,
                        "Deborah", PetiteFille.class));


    }
}

package fr.pantheonsorbonne.camel;


import fr.pantheonsorbonne.entity.Joueur;
import org.apache.camel.*;
import org.apache.camel.support.TypeConverterSupport;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Converter
public class JoueurConverter {

    @Converter
    public static Joueur toJoueur(Map.Entry<String, Class<? extends Joueur>> entry) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Joueur res = entry.getValue().getConstructor().newInstance();
        res.setName(entry.getKey());
        return res;
    }

}

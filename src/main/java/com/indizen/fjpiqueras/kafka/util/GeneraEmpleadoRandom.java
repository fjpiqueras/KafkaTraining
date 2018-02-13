package com.indizen.fjpiqueras.kafka.util;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GeneraEmpleadoRandom {

    public Empleado generaEmpleadoRandom() {

        Empleado empleado = new Empleado();

        empleado.setNombre(getNombreRandom());
        empleado.setApellidos(getApellidoRandom());
        empleado.setEmail(new Random().nextInt() + "@realmadrid.com");
        empleado.setTelefono(new Random().nextInt());
        empleado.setSkills(getSkill(ThreadLocalRandom.current().nextInt(0, 5)));

        return empleado;
    }

    private String getNombreRandom() {
        List<String> nombres = new ArrayList<>();

        nombres.add("Ronaldo");
        nombres.add("Karim");
        nombres.add("Gareth");
        nombres.add("Mateo");
        nombres.add("Toni");
        nombres.add("Keylor");
        nombres.add("Sergio");

        return nombres.get(getRandomInt(nombres));
    }

    private int getRandomInt(List<String> lista) {
        return (int) Math.floor(Math.random() * lista.size());
    }

    private String getApellidoRandom() {
        List<String> nombres = new ArrayList<>();

        nombres.add("Nazario");
        nombres.add("Benzemal");
        nombres.add("Bale");
        nombres.add("Kovacic");
        nombres.add("Kroos");
        nombres.add("Navas");
        nombres.add("Ramos");

        return nombres.get(getRandomInt(nombres));
    }

    private List<String> getSkill(int numSkills) {
        List<String> skills = new ArrayList<>();

        skills.add("Goleador");
        skills.add("Corte");
        skills.add("Visión de juego");
        skills.add("Cono");
        skills.add("Fotogénico");
        skills.add("Olfato");
        skills.add("Técnica");

        List<String> skillsJugador = new ArrayList<>();

        for (int i = 0; i<numSkills; i++){
            skillsJugador.add(skills.get(getRandomInt(skills)));
        }


        return skillsJugador;
    }
}

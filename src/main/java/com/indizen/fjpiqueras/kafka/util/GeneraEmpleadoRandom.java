package com.indizen.fjpiqueras.kafka.util;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

public class GeneraEmpleadoRandom {

    private final static Logger logger = Logger.getLogger(GeneraEmpleadoRandom.class.getName());


    public GenericRecord generaEmpleadoRandomAvro() {

        Schema empleadoSchema = SchemaFactory.getSchemaRegistrySchema("http://127.0.0.1:8081","empleadoSchemaRegistry-value");
        GenericRecord empleado = new GenericData.Record(empleadoSchema);

        empleado.put("dni", String.valueOf(new Random().nextInt()));
        empleado.put("nombre", getNombreRandom());
        empleado.put("apellidos", getApellidoRandom());
        empleado.put("email", new Random().nextInt() + "@indizen.com");
        empleado.put("telefono", new Random().nextInt());
        empleado.put("skills", getSkill(ThreadLocalRandom.current().nextInt(1, 6)));
        empleado.put("estrella", false);

        logger.info(empleado.toString());

        return empleado;
    }

    public Empleado generaEmpleadoRandom() {

        Empleado empleado = new Empleado();

        empleado.setDni(String.valueOf(new Random().nextInt()));
        empleado.setNombre(getNombreRandom());
        empleado.setApellidos(getApellidoRandom());
        empleado.setEmail(new Random().nextInt() + "@indizen.com");
        empleado.setTelefono(new Random().nextInt());
        empleado.setSkills(getSkill(ThreadLocalRandom.current().nextInt(1, 6)));

        logger.info(empleado.toString());

        return empleado;
    }

    private String getNombreRandom() {
        List<String> nombres = new ArrayList<>();

        nombres.add("García");
        nombres.add("Pérez");
        nombres.add("Ruiz");
        nombres.add("Piqueras");
        nombres.add("Fernández");
        nombres.add("Sánchez");
        nombres.add("González");

        return nombres.get(getRandomInt(nombres));
    }

    private int getRandomInt(List<String> lista) {
        return (int) Math.floor(Math.random() * lista.size());
    }

    private String getApellidoRandom() {
        List<String> nombres = new ArrayList<>();

        nombres.add("Jose");
        nombres.add("Javier");
        nombres.add("Alberto");
        nombres.add("Aitor");
        nombres.add("Paco");
        nombres.add("Dani");
        nombres.add("Roberto");

        return nombres.get(getRandomInt(nombres));
    }

    private List<String> getSkill(int numSkills) {
        List<String> skills = new ArrayList<>();

        skills.add("Front");
        skills.add("Back");
        skills.add("Analytics");
        skills.add("Blockchain");
        skills.add("Movilidad");
        skills.add("Big Data");
        skills.add("PNL");

        List<String> skillsJugador = new ArrayList<>();

        for (int i = 0; i<numSkills; i++){
            skillsJugador.add(skills.get(getRandomInt(skills)));
        }


        return skillsJugador;
    }
}

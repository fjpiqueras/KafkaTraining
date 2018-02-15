package com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.streamjob;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.serialization.Serde;

import java.util.Properties;

public class Ejercicio7KStreamsJob {

    public static void init(String topicName) {

        //TODO Implementa el job de KafkaStreams
        //Consume los mensajes de tópico
        //Aplica un filtrado (ver paquete filter)
        //Aplica un mapeo (ver paqueta map)
        //Imprime la stream por pantalla

    }

    private static Serde<GenericRecord> getSerdeEmpleado() {

        //TODO Declara el serializador y deserializador de Empleado
        return null;
    }

    private static Properties loadConfig() {
        //TODO implementa la configuración de Kafka
        return null;
    }
}

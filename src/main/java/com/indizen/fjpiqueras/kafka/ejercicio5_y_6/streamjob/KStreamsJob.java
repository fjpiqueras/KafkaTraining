package com.indizen.fjpiqueras.kafka.ejercicio5_y_6.streamjob;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import org.apache.kafka.common.serialization.Serde;

import java.util.Properties;

public class KStreamsJob {

    public static void init(String topicName) {

        //TODO Implementa el job de KafkaStreams
        //Consume los mensajes de tópico
        //Aplica un filtrado (ver paquete filter)
        //Aplica un mapeo (ver paqueta map)
        //Imprime la stream por pantalla
    }

    private static Serde<Empleado> getSerdeEmpleado() {
        //TODO Declara el serializador y deserializador de Empleado
        return null;
    }

    private static Properties loadConfig() {
        Properties streamsConfiguration = new Properties();

        //TODO implementa la configuración de Kafka
        return streamsConfiguration;
    }
}

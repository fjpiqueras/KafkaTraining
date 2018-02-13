package com.indizen.fjpiqueras.kafka.streamjob;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import com.indizen.fjpiqueras.kafka.serde.EmpleadoDeserializer;
import com.indizen.fjpiqueras.kafka.serde.EmpleadoSerializer;
import org.apache.kafka.common.serialization.Serde;

import java.util.Properties;

public class KStreamsJob {

    public static void init(String topicName) {
        //TODO Inicializa los objetos necesarios para crear un job de KStreams
        //TODO Desarrolla un Kstreams que consuma del tópico empleadp
    }

    public static Serde<Empleado> getSerdeEmpleado() {
        EmpleadoSerializer empleadoSerializer = new EmpleadoSerializer();
        EmpleadoDeserializer empleadoDeserializer = new EmpleadoDeserializer();


        //TODO devuelve el serde resultante
        return null;
    }

    public static Properties loadConfig() {
        //TODO Implementa properties con la configuración necesaria

        return new Properties();
    }
}

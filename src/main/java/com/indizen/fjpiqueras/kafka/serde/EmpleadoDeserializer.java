package com.indizen.fjpiqueras.kafka.serde;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

public class EmpleadoDeserializer implements Deserializer<Empleado> {
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    public Empleado deserialize(String topic, byte[] data) {
        Object obj = null;
       //TODO Implementa un deserializador para el objeto Empleado

        return (Empleado) obj;
    }

    public void close() {

    }
}

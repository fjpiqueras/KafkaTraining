package com.indizen.fjpiqueras.kafka.ejercicio5_y_6.serde;

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

        //TODO Implementa el deserializador de Empleado
        return null;
    }

    public void close() {

    }
}

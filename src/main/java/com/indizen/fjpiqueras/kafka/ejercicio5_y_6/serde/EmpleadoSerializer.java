package com.indizen.fjpiqueras.kafka.ejercicio5_y_6.serde;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

public class EmpleadoSerializer implements Serializer<Empleado> {
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    public byte[] serialize(String topic, Empleado obj) {

        //TODO implementa el serializador de Empleado
        return null;
    }

    public void close() {

    }
}

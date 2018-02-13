package com.indizen.fjpiqueras.kafka.serde;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class EmpleadoSerializer implements Serializer<Empleado> {
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    public byte[] serialize(String topic, Empleado obj) {
        byte[] bytes = null;
        //TODO implementa un serializador del objeto empleado

        return bytes;
    }

    public void close() {

    }
}

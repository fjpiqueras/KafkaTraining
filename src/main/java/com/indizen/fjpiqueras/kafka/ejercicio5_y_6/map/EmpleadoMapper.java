package com.indizen.fjpiqueras.kafka.ejercicio5_y_6.map;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KeyValueMapper;

public class EmpleadoMapper implements KeyValueMapper<String, Empleado, KeyValue<String, Empleado>> {

    @Override
    public KeyValue<String, Empleado> apply(String s, Empleado empleado) {

        //TODO Calcula si un empleado es una estrella. (Estrella si tiene más de 2 skills)
        return null;
    }
}

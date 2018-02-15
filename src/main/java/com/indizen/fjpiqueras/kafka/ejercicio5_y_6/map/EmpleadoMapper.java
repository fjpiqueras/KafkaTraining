package com.indizen.fjpiqueras.kafka.ejercicio5_y_6.map;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KeyValueMapper;

public class EmpleadoMapper implements KeyValueMapper<String, Empleado, KeyValue<String, Empleado>> {

    @Override
    public KeyValue<String, Empleado> apply(String s, Empleado empleado) {
        Empleado empleadoNuevo = new Empleado(empleado.getDni(), empleado.getNombre(),
                empleado.getApellidos(), empleado.getEmail(),
                empleado.getTelefono(), empleado.getSkills());

        if (empleado.getSkills().size() > 2)
            empleadoNuevo.setEstrella(true);

        return new KeyValue<>(s, empleadoNuevo);
    }
}

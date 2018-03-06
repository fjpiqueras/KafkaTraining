package com.indizen.fjpiqueras.kafka.ejercicio5_y_6.filter;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import org.apache.kafka.streams.kstream.Predicate;

public class FilterPredicate implements Predicate<String, Empleado> {

    public FilterPredicate(){

    }

    @Override
    public boolean test(String s, Empleado empleado) {
        return !(empleado.getNombre().equals("Jose") && empleado.getApellidos().equals("García"));
    }
}


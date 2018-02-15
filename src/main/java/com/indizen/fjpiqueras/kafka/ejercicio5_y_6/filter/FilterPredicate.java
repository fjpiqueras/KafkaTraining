package com.indizen.fjpiqueras.kafka.ejercicio5_y_6.filter;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import org.apache.kafka.streams.kstream.Predicate;

public class FilterPredicate implements Predicate<String, Empleado> {

    public FilterPredicate(){

    }

    @Override
    public boolean test(String s, Empleado empleado) {
        //TODO filtra aquellos empleados que se llamen Karim Benzema
        return false;
    }
}


package com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.filter;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.streams.kstream.Predicate;

public class FilterPredicateGenericRecord implements Predicate<String, GenericRecord> {

    public FilterPredicateGenericRecord(){

    }

    @Override
    public boolean test(String s, GenericRecord record) {
        return !(record.get("nombre").equals("Karim") && record.get("apellidos").equals("Benzema"));
    }
}


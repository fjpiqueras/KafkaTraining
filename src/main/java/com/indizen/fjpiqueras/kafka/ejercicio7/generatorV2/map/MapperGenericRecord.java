package com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.map;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KeyValueMapper;

public class MapperGenericRecord implements KeyValueMapper<String, GenericRecord, KeyValue<String, GenericRecord>> {

    @Override
    public KeyValue<String, GenericRecord> apply(String s, GenericRecord genericRecord) {
        //TODO Calcula si un empleado es una estrella. (Estrella si tiene más de 2 skills)
        return null;
    }
}

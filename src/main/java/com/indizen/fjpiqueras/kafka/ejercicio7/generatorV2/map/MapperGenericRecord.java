package com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.map;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KeyValueMapper;

import java.util.List;

public class MapperGenericRecord implements KeyValueMapper<String, GenericRecord, KeyValue<String, GenericRecord>> {

    @Override
    public KeyValue<String, GenericRecord> apply(String s, GenericRecord genericRecord) {

        if (((List) genericRecord.get("skills")).size() > 2) {
            genericRecord.put("estrella", true);
        }

        return new KeyValue<>(s, genericRecord);
    }
}

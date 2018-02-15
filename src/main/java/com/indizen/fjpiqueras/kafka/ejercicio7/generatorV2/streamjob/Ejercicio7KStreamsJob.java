package com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.streamjob;

import com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.filter.FilterPredicateGenericRecord;
import com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.map.MapperGenericRecord;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.GenericAvroDeserializer;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerializer;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class Ejercicio7KStreamsJob {

    public static void init(String topicName) {

        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, GenericRecord> dealMessageStream = builder.stream(new Serdes.StringSerde(),
                getSerdeEmpleado(), topicName).filter(new FilterPredicateGenericRecord())
                .map(new MapperGenericRecord());

        dealMessageStream.print();

        KafkaStreams streams = new KafkaStreams(builder, loadConfig());
        streams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    }

    private static Serde<GenericRecord> getSerdeEmpleado() {

        final Map<String, String> serdeConfig = Collections.singletonMap(
                AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");

        GenericAvroSerializer empleadoSerializer = new GenericAvroSerializer();
        empleadoSerializer.configure(serdeConfig, false);

        GenericAvroDeserializer empleadoDeserializer = new GenericAvroDeserializer();
        empleadoDeserializer.configure(serdeConfig, false);

        return Serdes.serdeFrom(empleadoSerializer, empleadoDeserializer);
    }

    private static Properties loadConfig() {
        Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "KafkaTraining");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "http://127.0.0.1:9092");
        streamsConfiguration.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.TIMESTAMP_EXTRACTOR_CLASS_CONFIG, "org.apache.kafka.streams.processor.WallclockTimestampExtractor");

        return streamsConfiguration;
    }
}

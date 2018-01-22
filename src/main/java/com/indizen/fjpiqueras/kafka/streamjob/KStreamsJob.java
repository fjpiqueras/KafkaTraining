package com.indizen.fjpiqueras.kafka.streamjob;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import com.indizen.fjpiqueras.kafka.serde.EmpleadoDeserializer;
import com.indizen.fjpiqueras.kafka.serde.EmpleadoSerializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import java.util.Properties;

public class KStreamsJob {

    public static void init() {

        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, Empleado> dealMessageStream = builder.stream(new Serdes.StringSerde(),
                getSerdeEmpleado(), "empleado");

        dealMessageStream.print();

        KafkaStreams streams = new KafkaStreams(builder, loadConfig());
        streams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    }

    public static Serde<Empleado> getSerdeEmpleado() {
        EmpleadoSerializer empleadoSerializer = new EmpleadoSerializer();
        EmpleadoDeserializer empleadoDeserializer = new EmpleadoDeserializer();
        return Serdes.serdeFrom(empleadoSerializer, empleadoDeserializer);
    }

    public static Properties loadConfig() {
        Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "KafkaTraining");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        streamsConfiguration.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.TIMESTAMP_EXTRACTOR_CLASS_CONFIG, "org.apache.kafka.streams.processor.WallclockTimestampExtractor");

        return streamsConfiguration;
    }
}
package com.indizen.fjpiqueras.kafka.ejercicio5_y_6.streamjob;

import com.indizen.fjpiqueras.kafka.ejercicio5_y_6.filter.FilterPredicate;
import com.indizen.fjpiqueras.kafka.ejercicio5_y_6.map.EmpleadoMapper;
import com.indizen.fjpiqueras.kafka.ejercicio5_y_6.serde.EmpleadoDeserializer;
import com.indizen.fjpiqueras.kafka.ejercicio5_y_6.serde.EmpleadoSerializer;
import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;

import java.util.Properties;

public class KStreamsJob {

    public static void init(String topicName) {

        KStreamBuilder builder = new KStreamBuilder();

        KStream<String, Empleado> empleadoStream = builder.stream(new Serdes.StringSerde(),
                getSerdeEmpleado(), topicName).filter(new FilterPredicate()).map(new EmpleadoMapper());

        empleadoStream.print();

        KafkaStreams streams = new KafkaStreams(builder, loadConfig());
        streams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

    }

    private static Serde<Empleado> getSerdeEmpleado() {
        EmpleadoSerializer empleadoSerializer = new EmpleadoSerializer();
        EmpleadoDeserializer empleadoDeserializer = new EmpleadoDeserializer();
        return Serdes.serdeFrom(empleadoSerializer, empleadoDeserializer);
    }

    private static Properties loadConfig() {
        Properties streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "KafkaTraining");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        streamsConfiguration.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.TIMESTAMP_EXTRACTOR_CLASS_CONFIG, "org.apache.kafka.streams.processor.WallclockTimestampExtractor");

        return streamsConfiguration;
    }
}

package com.indizen.fjpiqueras.kafka.ejercicio3.generator;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import com.indizen.fjpiqueras.kafka.ejercicio5_y_6.serde.EmpleadoSerializer;
import com.indizen.fjpiqueras.kafka.util.GeneraEmpleadoRandom;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class KafkaRandomGenerator {

    private final static Logger logger = Logger.getLogger(KafkaRandomGenerator.class.getName());

    public static void init(int numMensajes, String topicName) throws ExecutionException, InterruptedException {

        KafkaProducer<String, Empleado> producer = new KafkaProducer<>(getKafkaProps());
        GeneraEmpleadoRandom empleadoRandom = new GeneraEmpleadoRandom();

        for (int i = 0; i < numMensajes; i++) {

            Future<RecordMetadata> metadata = enviaEmpleadoTopico(topicName, empleadoRandom.generaEmpleadoRandom(), producer);

            RecordMetadata m = metadata.get();

            logger.info("Empleado: " + i + " - " + m.topic() + " - " + m.offset() + " - " + m.partition() + " - " + new Date(m.timestamp()));
        }
    }

    private static Properties getKafkaProps() {
        Properties kafkaProps = new Properties();

        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, new EmpleadoSerializer().getClass().getName());

        return kafkaProps;
    }

    private static Future<RecordMetadata> enviaEmpleadoTopico(String topicName, Empleado empleado, KafkaProducer<String, Empleado> producer) {

        return producer.send(new ProducerRecord(topicName, "key", empleado));
    }
}

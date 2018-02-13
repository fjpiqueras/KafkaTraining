package com.indizen.fjpiqueras.kafka.generator;

import com.indizen.fjpiqueras.kafka.pojo.Empleado;
import com.indizen.fjpiqueras.kafka.serde.EmpleadoSerializer;
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

    final static Logger logger = Logger.getLogger(KafkaRandomGenerator.class.getName());

    public static void init(int numMensajes) throws ExecutionException, InterruptedException {

        KafkaProducer<String, Empleado> producer = new KafkaProducer<String, Empleado>(getKafkaProps());
        GeneraEmpleadoRandom empleadoRandom = new GeneraEmpleadoRandom();

        for (int i = 0; i < numMensajes; i++) {

            Future<RecordMetadata> metadata = enviaEmpleadoTopico("empleado", empleadoRandom.generaEmpleadoRandom(), producer);

            RecordMetadata m = metadata.get();

            logger.info("Empleado: " + i + " - " + m.topic() + " - " + m.offset() + " - " + m.partition() + " - " + new Date(m.timestamp()));
        }
    }

    public static Properties getKafkaProps() {

        return new Properties();
    }

    public static Future<RecordMetadata> enviaEmpleadoTopico(String nombreTopico, Empleado empleado, KafkaProducer<String, Empleado> producer) {

        //TODO envía el mensaje usando el objeto producer.
        return null;
    }
}

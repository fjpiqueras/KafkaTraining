package com.indizen.fjpiqueras.kafka;

import com.indizen.fjpiqueras.kafka.ejercicio3.generator.KafkaRandomGenerator;

import java.util.logging.Logger;

public class KafkaGeneratorApplication {

    final static Logger logger = Logger.getLogger(String.valueOf(KafkaGeneratorApplication.class));

    public static void main(String[] args) throws Exception {

        if (args.length == 1) {
            KafkaRandomGenerator.init(Integer.parseInt(args[0]));
        } else {
            throw new Exception("La applicación recibe un argumento: número de mensajes que envía al tópico");
        }
    }
}

package com.indizen.fjpiqueras.kafka;

import com.indizen.fjpiqueras.kafka.ejercicio3.generator.KafkaRandomGenerator;

import java.util.logging.Logger;

public class KafkaGeneratorApplication {

    public static void main(String[] args) throws Exception {

        if (args.length == 2) {
            KafkaRandomGenerator.init(Integer.parseInt(args[0]), args[1]);
        } else {
            throw new Exception("La applicación recibe 2 argumento: <mensajes> <nombreTopic>");
        }
    }
}

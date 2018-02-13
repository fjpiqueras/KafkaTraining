package com.indizen.fjpiqueras.kafka;

import com.indizen.fjpiqueras.kafka.ejercicio3.generator.KafkaRandomGenerator;
import com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.KafkaRandomGeneratorSchemaRegistry;

import java.util.logging.Logger;

public class KafkaGeneratorApplicationSchemaRegistry {

    public static void main(String[] args) throws Exception {

        if (args.length == 1) {
            KafkaRandomGeneratorSchemaRegistry.init(Integer.parseInt(args[0]));
        } else {
            throw new Exception("La applicación recibe un argumento: número de mensajes que envía al tópico");
        }
    }
}

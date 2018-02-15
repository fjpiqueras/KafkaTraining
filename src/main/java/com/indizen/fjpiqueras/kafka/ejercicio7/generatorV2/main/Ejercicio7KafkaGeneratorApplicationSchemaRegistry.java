package com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.main;

import com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.KafkaRandomGeneratorSchemaRegistry;

public class Ejercicio7KafkaGeneratorApplicationSchemaRegistry {

    public static void main(String[] args) throws Exception {

        if (args.length == 2) {
            KafkaRandomGeneratorSchemaRegistry.init(Integer.parseInt(args[0]), args[1]);
        } else {
            throw new Exception("La applicación recibe un argumento: número de mensajes que envía al tópico");
        }
    }
}

package com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.main;

import com.indizen.fjpiqueras.kafka.ejercicio7.generatorV2.streamjob.Ejercicio7KStreamsJob;

public class Ejercicio7KafkaStreamsApplication {

    public static void main(String[] args) throws Exception {

        if(args.length==1) {
            Ejercicio7KStreamsJob.init(args[0]);
        } else{
            throw new Exception("La applicación recibe un argumento: nombre del tópico");
        }
    }

}

package com.indizen.fjpiqueras.kafka;

import com.indizen.fjpiqueras.kafka.ejercicio5_y_6.streamjob.KStreamsJob;

public class KafkaStreamsApplication {

    public static void main(String[] args) throws Exception {

        if(args.length==1) {
            KStreamsJob.init(args[0]);
        } else{
            throw new Exception("La applicación recibe un argumento: nombre del tópico");
        }
    }

}

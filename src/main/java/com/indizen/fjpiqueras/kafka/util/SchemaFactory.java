package com.indizen.fjpiqueras.kafka.util;

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import org.apache.avro.Schema;

import java.io.IOException;
import java.io.Serializable;

public class SchemaFactory implements Serializable {

    //SchemaRegistry Client
    private transient static CachedSchemaRegistryClient schemaRegistryClient;

    public static Schema getSchemaRegistrySchema(String url, String schemaName) {
        schemaRegistryClient = new CachedSchemaRegistryClient(url, 1000);
        Schema schema = null;

        try {
            schema = new Schema.Parser().parse(schemaRegistryClient.getLatestSchemaMetadata(schemaName).getSchema());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return schema;
    }
}

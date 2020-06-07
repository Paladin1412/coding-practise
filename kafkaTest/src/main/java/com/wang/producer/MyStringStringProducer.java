package com.wang.producer;

import com.wang.config.ConfigEnum;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-06 19:25
 **/
public class MyStringStringProducer {
    private static Properties properties = new Properties();
    private static KafkaProducer producer;

    static {
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ConfigEnum.BOOTSTRAP_SERVERS_CONFIG.getValue());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, ConfigEnum.STRING_SERIALIZER.getValue());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ConfigEnum.STRING_SERIALIZER.getValue());
        producer = new KafkaProducer<String, String>(properties);
    }

    public void send(ProducerRecord<String, String> record) {
        producer.send(record);
    }

    public void send2(ProducerRecord<String, String> record) {
        try {
            RecordMetadata recordMetadata = (RecordMetadata) producer.send(record).get();
            long offset = recordMetadata.offset();
            System.out.println(offset);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void send3(ProducerRecord<String, String> record) {
        producer.send(record, new DemoProducerCallback());
    }

    public static void main(String[] args) {
        ProducerRecord<String, String> record = new ProducerRecord<>("kafka_test1", "Precision Products", "France");
        MyStringStringProducer producer = new MyStringStringProducer();
//        while (true) {
//            producer.send(record);
//        }
//        while (true) {
//            producer.send2(record);
//        }
        while (true) {
            producer.send3(record);
        }
    }
}

class DemoProducerCallback implements Callback {
    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if (exception != null) {
            exception.printStackTrace();
        }
    }
}

package com.cmegroup.demo.engine;

import java.io.IOException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cmegroup.demo.parser.Csv2Json;
import com.cmegroup.demo.parser.Xml2Json;

@Service
public class Consumer {
	
    private final Producer producer;
    
    @Autowired
    Consumer(Producer producer) {
        this.producer = producer;
    }

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);


    @KafkaListener(topics = "${csvTopicName}", groupId = "user1")
    public void consumeCsv(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message from csv_message_q -> %s", message));
        producer.processResevedMessages(new Csv2Json(message));
    }
    
    @KafkaListener(topics = "${xmlTopicName}", groupId = "user1")
    public void consumeXml(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message from xml_message_q -> %s", message));
        producer.processResevedMessages(new Xml2Json(message));
    }
}
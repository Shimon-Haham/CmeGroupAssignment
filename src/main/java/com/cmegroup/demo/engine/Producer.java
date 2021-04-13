package com.cmegroup.demo.engine;

import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cmegroup.demo.model.ParsingResult;
import com.cmegroup.demo.parser.Parsable;


@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    
    @Value("${errorTopicName}")
    private String errorTopic;
    
    @Value("${sinkTopicName}")
    private String sinkTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    
    public void sendMessage(String topic, String message) {
    	logger.info(String.format("#### -> Producing message to %s -> %s", topic, message));
        this.kafkaTemplate.send(new ProducerRecord<String, String>(topic,String.valueOf(message.hashCode()), message));
    }
        
    public void processResevedMessages(Parsable parsedMessages) {
    	List<ParsingResult> messages = parsedMessages.getParsedData();
    	for (ParsingResult parsingResult : messages) {
    		String send2topic = parsingResult.isValid()?sinkTopic:errorTopic;
    		this.sendMessage(send2topic, parsingResult.getData());
		}
    }    
}

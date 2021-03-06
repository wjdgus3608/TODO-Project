package com.jung.app.randomnumber.service;

import com.jung.client.kafka.KafkaConnector;
import com.jung.domain.dto.GenerateRandomNumberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jung.app.randomnumber.util.RandomNumberGenerator;

@Slf4j
@Service
public class ResponseRandomNumberProducer {
    private static final String TOPIC = "responseRandomNumber";
    private final KafkaConnector kafkaConnector;
    private final RandomNumberGenerator randomNumberGenerator;

    @Autowired
    public ResponseRandomNumberProducer(KafkaConnector kafkaConnector, RandomNumberGenerator randomNumberGenerator){
        this.kafkaConnector = kafkaConnector;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void produce(GenerateRandomNumberDTO json) {
        String randomNumber = randomNumberGenerator.generateRandomNumber();
        json.setRandomNumber(randomNumber);

        log.info("Produce message : "+json);

        kafkaConnector.send(TOPIC, json.toString());
    }
}

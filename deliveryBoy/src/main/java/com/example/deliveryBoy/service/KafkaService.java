package com.example.deliveryBoy.service;

import com.example.deliveryBoy.config.AppConstants;
//import com.example.deliveryBoy.model.Location;
import com.example.shared_location_model.SharedLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    //spring class sending msges to kafka topics
    private KafkaTemplate<String, SharedLocation>kafkaTemplate;
//    private KafkaTemplate<String, Location>kafkaTemplate;

    private Logger logger= LoggerFactory.getLogger(KafkaService.class);


    public boolean updateLocation(SharedLocation location){

            this.kafkaTemplate.send(AppConstants.LOCATION_TOPIC_NAME, location);
       return true;
    }
}
//The KafkaService.updateLocation(String location) method sends
// each location string to
// the Kafka topic
// defined in AppConstants.LOCATION_TOPIC_NAME.


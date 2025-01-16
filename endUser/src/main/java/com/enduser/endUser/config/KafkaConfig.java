package com.enduser.endUser.config;

//import com.enduser.endUser.model.Location;
import com.example.shared_location_model.SharedLocation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @KafkaListener(topics= AppConstants.LOCATION_UPDATE_TOPIC, groupId = AppConstants.GROUP_ID)
    public void updatedLocation(SharedLocation location){

        System.out.println(location);
    }
}

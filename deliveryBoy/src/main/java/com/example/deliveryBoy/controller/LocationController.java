package com.example.deliveryBoy.controller;

//import com.example.deliveryBoy.model.Location;
import com.example.deliveryBoy.service.KafkaService;
import com.example.shared_location_model.SharedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        for(int i=0;i<20;i++) {
//            this.kafkaService.updateLocation("( " + Math.round(Math.random() * 100) + " , " + Math.random() * 100 + ")");

//            double latitude = Math.round(Math.random() * 100);
//            double longitude = Math.random() * 100;
//            Location location = new Location(latitude, longitude, "Location " + i, i);
//            this.kafkaService.updateLocation(location);  // Sending Location object to Kafka


            double latitude = Math.round(Math.random() * 100);
            double longitude = Math.random() * 100;

            // Create a SharedLocation object with random data
            SharedLocation location = new SharedLocation("User" + i, latitude, longitude);

            // Send the SharedLocation object to Kafka
            this.kafkaService.updateLocation(location);

        }
        return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
//Here, the <?> allows someObject to be of any type.
    }
}
//It generates random location data in the format (x, y)
// (200,000 times).
//For each location, it calls the updateLocation(String location)
// method in KafkaService.

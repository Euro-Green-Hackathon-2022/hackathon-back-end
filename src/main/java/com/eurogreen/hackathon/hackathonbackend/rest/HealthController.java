package com.eurogreen.hackathon.hackathonbackend.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("health")
    public ResponseEntity<String> getHealth(){
        return ResponseEntity.ok().build();
    }
}

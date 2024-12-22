package org.sports.sport.controller;

import java.util.List;

import org.sports.sport.dto.sport;
import org.sports.sport.service.sportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class sportController {

    @Autowired
    sportService service;


    /*Saving or Creating The Sport Records*/
    //To Save Single Record
    @PostMapping("/sports")
    public ResponseEntity<Object> saveSport(@RequestBody sport sport) {
        return service.saveSport(sport);
    }

    //To Save Multiple Records
    @PostMapping("/sports/all")
    public ResponseEntity<Object> saveSports(@RequestBody List<sport>sports) {
        return service.saveSports(sports);
    }
    
    
}

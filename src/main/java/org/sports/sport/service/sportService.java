package org.sports.sport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.sports.sport.dto.sport;
import org.sports.sport.repositories.sportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class sportService {

    @Autowired
    sportRepository repostiory;


    /* Logic To Save or create the sport records */
    public ResponseEntity<Object> saveSport(sport sport) {
        if(repostiory.existsByName(sport.getName())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Sport already existe with name: " +sport.getName());

            return new ResponseEntity<Object>(map, HttpStatus.IM_USED);
        }else{
            repostiory.save(sport);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record created successfull");
            map.put("Data", sport);

            return new ResponseEntity<Object>(map, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> saveSports(List<sport> sports) {
        for(sport sport: sports){
            if(repostiory.existsByName(sport.getName())){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("error", "Sport already existe with name: " +sport.getName());

                return new ResponseEntity<Object>(map, HttpStatus.IM_USED);
            }
        }

        repostiory.saveAll(sports);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", "Records created successfully");
        map.put("Data", sports);

        return new ResponseEntity<Object>(map, HttpStatus.CREATED);
    }





    /* Logic to fetch the sport records */
    public ResponseEntity<Object> getAllSports() {
        List<sport> sports = repostiory.findAll();

        if(sports.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No sports found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
        else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Sport Records Found");
            map.put("Data", sports);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }

    public ResponseEntity<Object> FetchSportName(String name) {
        Optional<sport> sport = repostiory.findByName(name);

        if(sport.isPresent()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Sport Found");
            map.put("Data", sport);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No sport found with name: " + name);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> FetchSportType(String type) {
        List<sport> sports = repostiory.findByType(type);

        if(sports.isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No sport found with type: " + type);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Sport Records Found");
            map.put("Data", sports);

            return new ResponseEntity<Object>(map, HttpStatus.FOUND);
        }
    }
    
    
}

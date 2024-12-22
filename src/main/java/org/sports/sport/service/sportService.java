package org.sports.sport.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    
}

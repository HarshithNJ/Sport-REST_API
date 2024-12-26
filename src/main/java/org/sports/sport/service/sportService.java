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

            return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
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

                return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
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



    /* Logic to delete the sport records */
    public ResponseEntity<Object> deleteById(int id) {
        Optional<sport> sport = repostiory.findById(id);

        if(sport.isPresent()){
            repostiory.deleteById(id);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "Record Deleted Successfully");
            map.put("Data", sport.get());

            return new ResponseEntity<Object>(map, HttpStatus.ACCEPTED);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No sport found with id: " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // public ResponseEntity<Object> deleteByName(String name) {
    //     Optional<sport> sport = repostiory.findByName(name);

    //     if(sport.isPresent()){
    //         repostiory.deleteByName(name);

    //         Map<String, Object> map = new HashMap<String, Object>();
    //         map.put("success", "Record Deleted Successfully");
    //         map.put("Data", sport.get());

    //         return new ResponseEntity<Object>(map, HttpStatus.ACCEPTED);
    //     }else{
    //         Map<String, Object> map = new HashMap<String, Object>();
    //         map.put("error", "No sport found with name: " + name);

    //         return new ResponseEntity<Object>(map, HttpStatus.NOT_ACCEPTABLE);
    //     }
    // }





    /* Logic to update the sport records */
    public ResponseEntity<Object> Update(sport sport) {
        repostiory.save(sport);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", "Record Updated Successfully");
        map.put("Data", sport);

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    public ResponseEntity<Object> UpdateSport(int id, sport sport) {
        if(repostiory.findById(id).isPresent()){
            sport s = repostiory.findById(id).get();

            if(sport.getName() != null)
                s.setName(sport.getName());

            if(sport.getAgeLimit() != 0)
                s.setAgeLimit(sport.getAgeLimit());

            if(sport.getOrigin() != null)
                s.setOrigin(sport.getOrigin());

            if(sport.getType() != null)
                s.setType(sport.getType());

            if(sport.getMaxPlayers() != 0)
                s.setMaxPlayers(sport.getMaxPlayers());

            if(sport.getMinPlayers() !=0)
                s.setMinPlayers(sport.getMinPlayers());
            
            repostiory.save(s);

            Map<String,Object> map = new HashMap<String,Object>();
            map.put("success", "Record Updated Successfully");
            map.put("Data", s);

            return new ResponseEntity<Object>(map, HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No sport found with id: " + id);

            return new ResponseEntity<Object>(map, HttpStatus.NO_CONTENT);
        }
    }
    
    
}

package org.sports.sport.controller;

import java.util.List;

import org.sports.sport.dto.sport;
import org.sports.sport.service.sportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





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
    


    /*Fetching the Sport Records */
    //To Fetch all the Records
    @GetMapping("/sports")
    public ResponseEntity<Object> getAllSports() {
        return service.getAllSports();
    }

    //To Fetch  a recoird by Sport Name
    @GetMapping("/sports/{name}")
    public ResponseEntity<Object> FetchSportName(@PathVariable String name){
        return service.FetchSportName(name);
    }

    //To fetch a record by the type of sport
    @GetMapping("/sports/type/{type}")
    public ResponseEntity<Object> FetchSportType(@PathVariable String type){
        return service.FetchSportType(type);
    }



    /*Deleting the Sport Record */
    //To Delete a reocrd by Id
    @DeleteMapping("/sports/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id){
        return service.deleteById(id);
    }

    //To Delete a Record By Name
    // @DeleteMapping("/sports/name/{name}")
    // public ResponseEntity<Object> deleteByName(@PathVariable String name){
    //     return service.deleteByName(name);
    // }






    /*Updating the Sport Record */
    //To Update a Record by using put mappping
    @PutMapping("/sports")
    public ResponseEntity<Object> Update(@RequestBody sport sport) {
        return service.Update(sport);
    }

    //To Update a Record by using patch mapping
    @PatchMapping("/sports/{id}")
    public ResponseEntity<Object> UpdateSport(@PathVariable int id, @RequestBody sport sport){
        return service.UpdateSport(id, sport);
    }
}

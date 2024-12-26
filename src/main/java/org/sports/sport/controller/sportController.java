package org.sports.sport.controller;

import java.util.List;

import org.sports.sport.dto.sport;
import org.sports.sport.service.sportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@Tag(name = "Sport Controller", description = "A Controller To store sport information")
public class sportController {

    @Autowired
    sportService service;


    /*Saving or Creating The Sport Records*/
    @Operation(summary = "Saving or Creating The Sport Records", description = "To Create a new Sport Record")
    @ApiResponse(responseCode = "201", description = "Successfully Created")
    @ApiResponse(responseCode = "400", description = "Sport Data Already Exists")
    @PostMapping("/sports")
    public ResponseEntity<Object> saveSport(@RequestBody sport sport) {
        return service.saveSport(sport);
    }

    @Operation(summary = "Saving or Creating The Sport Records", description = "To Create multiple new Sport Records")
    @ApiResponse(responseCode = "201", description = "Successfully Created")
    @ApiResponse(responseCode = "400", description = "Sport Data Already Exists")
    @PostMapping("/sports/all")
    public ResponseEntity<Object> saveSports(@RequestBody List<sport>sports) {
        return service.saveSports(sports);
    }
    


    /*Fetching the Sport Records */
    @Operation(summary = "Fetching the Sport Records", description = "To Fetch All the Sport Records")
    @ApiResponse(responseCode = "302", description = "Data Retrieved Successfully")
    @ApiResponse(responseCode = "402", description = "Data Doesn't Exists")
    @GetMapping("/sports")
    public ResponseEntity<Object> getAllSports() {
        return service.getAllSports();
    }

    @Operation(summary = "Fetch  a record by Sport Name", description = "To Fetch a Sport Record by Name")
    @ApiResponse(responseCode = "302", description = "Data Retrieved Successfully")
    @ApiResponse(responseCode = "402", description = "Data Doesn't Exists")
    @GetMapping("/sports/{name}")
    public ResponseEntity<Object> FetchSportName(@PathVariable String name){
        return service.FetchSportName(name);
    }

    @Operation(summary = "Fetch  a record by Sport Type", description = "To Fetch a Sport Record by Type")
    @ApiResponse(responseCode = "302", description = "Data Retrieved Successfully")
    @ApiResponse(responseCode = "402", description = "Data Doesn't Exists")
    @GetMapping("/sports/type/{type}")
    public ResponseEntity<Object> FetchSportType(@PathVariable String type){
        return service.FetchSportType(type);
    }



    /*Deleting the Sport Record */
    @Operation(summary = "Deleting the Sport Record", description = "To Delete a Sport Record")
    @ApiResponse(responseCode = "202", description = "Data Successfully Deleted")
    @ApiResponse(responseCode = "406", description = "No Data Found with the given ID")
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
    @Operation(summary = "Updating the Sport Record", description = "To Update a Sport Record By using Put Method")
    @ApiResponse(responseCode = "200", description = "Data Successfully Updated")
    @PutMapping("/sports")
    public ResponseEntity<Object> Update(@RequestBody sport sport) {
        return service.Update(sport);
    }

    @Operation(summary = "Updating the Sport Record", description = "To Update a Sport Record BY Patch Method")
    @ApiResponse(responseCode = "200", description = "Data Successfully Updated")
    @ApiResponse(responseCode = "204", description = "No Data Found with the given ID")
    @PatchMapping("/sports/{id}")
    public ResponseEntity<Object> UpdateSport(@PathVariable int id, @RequestBody sport sport){
        return service.UpdateSport(id, sport);
    }
}

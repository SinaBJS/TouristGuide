package com.example.touristguideapi.controllers;

import com.example.touristguideapi.models.TouristAttraction;
import com.example.touristguideapi.services.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/attractions")
public class TouristController {
    private final TouristService touristService;


    @Autowired
    public TouristController(TouristService touristService){
        this.touristService = touristService;
    }

// get all attractions
    @GetMapping("/{allattractions}")
    public ResponseEntity<List<TouristAttraction>> findAllAttractions(){
        return ResponseEntity.ok(touristService.findAllAttractions());
    }
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> findAttractionByName(@PathVariable String attractionName){
        return ResponseEntity.ok(touristService.findAttractionByName(attractionName));
    }
    @PostMapping
    public ResponseEntity<?> addAttraction(@RequestBody TouristAttraction touristAttraction){
        touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}

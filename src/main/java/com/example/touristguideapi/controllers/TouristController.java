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
    @GetMapping
    public ResponseEntity<List<TouristAttraction>> findAllAttractions(){
        return ResponseEntity.ok(touristService.findAllAttractions());
    }
    @GetMapping("/{attractionName}")
    public ResponseEntity<TouristAttraction> findAttractionByName(@PathVariable String attractionName){
        return ResponseEntity.ok(touristService.findAttractionByName(attractionName));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addAttraction(@RequestBody TouristAttraction touristAttraction){
        touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/edit")
    public ResponseEntity<?> editAttraction(@RequestBody String nameOfAttraction, String newName, String newDescription){
        touristService.editAttraction(nameOfAttraction, newName, newDescription);
        return new ResponseEntity<>(HttpStatus.OK);

}
    @GetMapping("/delete/{attractionName}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String attractionName) {
        touristService.deleteAttractions(attractionName);
        return  new ResponseEntity<>(HttpStatus.OK);

    }
}
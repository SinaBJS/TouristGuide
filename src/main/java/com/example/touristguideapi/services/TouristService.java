package com.example.touristguideapi.services;

import com.example.touristguideapi.models.TouristAttraction;
import com.example.touristguideapi.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
private final TouristRepository touristRepository;
@Autowired
    public TouristService(TouristRepository touristRepository){
this.touristRepository =  new TouristRepository();
    }

    public TouristAttraction findAttractionByName(String attractionName){
        return touristRepository.findAttractionByName(attractionName);
    }
    public List<TouristAttraction> findAllAttractions(){
        return touristRepository.findAllAttractions();
    }
    public void addAttraction(TouristAttraction attractionToAdd){
        touristRepository.addAttraction(attractionToAdd);
    }
    public void editAttraction(String nameAttractionToUpdate, String newName, String newDescription){
        touristRepository.editAttraction(nameAttractionToUpdate, newName, newDescription);
    }
    public void deleteAttractions(String nameOfAttractionToRemove){
        touristRepository.deleteAttraction(nameOfAttractionToRemove);

    }
}

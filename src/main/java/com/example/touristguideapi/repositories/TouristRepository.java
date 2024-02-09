package com.example.touristguideapi.repositories;

import com.example.touristguideapi.models.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    List<TouristAttraction> touristAttractions;

    public TouristRepository() {
        this.touristAttractions = new ArrayList<>();
        touristAttractions.add(new TouristAttraction("Little Mermaid",
                "The Little Mermaid from Hans Christian Andersens stories"));
        touristAttractions.add(new TouristAttraction("Rundetårn",
                "Historical building built during Christian IV"));
    }

    public TouristAttraction findAttractionByName(String attractionName) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (attractionName.equalsIgnoreCase(touristAttraction.getName())) {
                return touristAttraction;
            }

        }
            return null;
        }

        public List<TouristAttraction> findAllAttractions(){
        return touristAttractions;
        }

    public void addAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);

    }

    public void deleteAttraction(String nameOfattractionToRemove) {
        for (TouristAttraction touristAttraction : touristAttractions) {
            if (nameOfattractionToRemove.equalsIgnoreCase(touristAttraction.getName())) {
                touristAttractions.remove(touristAttraction);
            }
        }

    }

    public void editAttraction(String nameAttractionToUpdate, String newName, String newDescription) {

        for (TouristAttraction touristAttraction : touristAttractions) {
            if (nameAttractionToUpdate.equalsIgnoreCase(touristAttraction.getName())) {
                touristAttraction.setName(newName);
                touristAttraction.setDescription(newDescription);

            }

        }


    }

}

package com.assignmentDemo.demo2.service;

import com.assignmentDemo.demo2.dao.LocationRepo;
import com.assignmentDemo.demo2.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    LocationRepo locationRepository;
    public Location addLocationService(Location location){
        return locationRepository.save(location);
    }
    public List<Location> locationList (){
        return locationRepository.findAll();
    }
    public Optional<Location> findLocationById(int id){
        return locationRepository.findById(id);
    }
    public Location findByName(String name){
        return locationRepository.findByLocationName(name);
    }
    public Location updateLocation(Location location){
        Optional<Location> tempLocation = findLocationById(location.getLocationKey());
        if(tempLocation.isPresent()){
            tempLocation.get().setLocationName(location.getLocationName());
            tempLocation.get().setPostalCode(location.getPostalCode());

            return locationRepository.save(tempLocation.get());
        }
        return locationRepository.save(location);
    }
    public String deleteLocation(Location location){
        locationRepository.delete(location);
        return "record deleted for "+ location;
    }
    public Location findByPostalCode(int postalCode){
        return locationRepository.findByPostalCode(postalCode);
    }
}

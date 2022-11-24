package com.assignmentDemo.demo2.controller;

import com.assignmentDemo.demo2.dao.LocationRepo;
import com.assignmentDemo.demo2.model.Location;
import com.assignmentDemo.demo2.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/travel")

public class TravelController {
    @Autowired
    LocationService locationService;
    @PostMapping("/addLocation")
    public Location addLocation(@RequestBody Location location){
        return locationService.addLocationService(location);
    }
    @GetMapping("/locations")
    public List<Location> getAllLocations (){
        return locationService.locationList();
    }
    @GetMapping("/location/{locationId}")
    public Optional<Location> getLocationById(@PathVariable int locationId){
        return locationService.findLocationById(locationId);
    }
    @GetMapping("/location/name/{locationName}")
    public Location getLocationByName(@PathVariable String locationName) {
        return locationService.findByName(locationName);
    }
    @GetMapping("/location/postalCode/{postalCode}")
    public Location getLocationByPostalCode(@PathVariable int postalCode){
        return locationService.findByPostalCode(postalCode);
    }

    @PutMapping("/location/update")
    public Location updateLocation(@RequestBody Location location){
        return locationService.updateLocation(location);
    }
    @DeleteMapping
    public String deleteLocation (@RequestBody Location location){
        return locationService.deleteLocation(location);
    }


}

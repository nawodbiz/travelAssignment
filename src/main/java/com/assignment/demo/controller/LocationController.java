package com.assignment.demo.controller;

import com.assignment.demo.model.Location;
import com.assignment.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/travel")

public class LocationController {
    @Autowired
    LocationService locationService;

    @PostMapping("/addLocation")
    public Location addLocation(@RequestBody Location location) {
        return locationService.addLocationService(location);
    }

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationService.locationList();
    }

    @GetMapping("/location/{locationId}")
    public Optional<Location> getLocationById(@PathVariable int locationId) {
        return locationService.findLocationById(locationId);
    }

    @GetMapping("/location/name/{locationName}")
    public Location getLocationByName(@PathVariable String locationName) {
        return locationService.findByName(locationName);
    }

    @GetMapping("/location/postalCode/{postalCode}")
    public Location getLocationByPostalCode(@PathVariable int postalCode) {
        return locationService.findByPostalCode(postalCode);
    }

    @PutMapping("/location/update")
    public Location updateLocation(@RequestBody Location location) {
        return locationService.updateLocation(location);
    }

    @DeleteMapping("/location/delete/{locationKey}")
    public String deleteLocation(@PathVariable int locationKey) {
        return locationService.deleteLocation(locationKey);
    }

    @DeleteMapping("/location/deleteAll")
    public String deleteAllLocations() {
        return locationService.deleteAllLocations();
    }


}

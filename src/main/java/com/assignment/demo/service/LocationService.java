package com.assignment.demo.service;

import com.assignment.demo.model.Location;
import com.assignment.demo.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    LocationRepo locationRepository;

    public Location addLocationService(Location location) {
        return locationRepository.save(location);
    }

    public int getLocationId(String locationName) {
        Location location = locationRepository.findByLocationName(locationName);
        return location.getLocationId();
    }

    public List<Location> locationList() {
        return locationRepository.findAll();
    }

    public Optional<Location> findLocationById(int id) {
        return locationRepository.findById(id);
    }

    public Location findByName(String name) {
        return locationRepository.findByLocationName(name);
    }

    public Location findByLocationCode(String locationCode) {
        return locationRepository.findByLocationCode(locationCode);
    }

    public Location updateLocation(Location location) {
        Optional<Location> tempLocation = findLocationById(location.getLocationId());
        if (tempLocation.isPresent()) {
            tempLocation.get().setLocationName(location.getLocationName());
            tempLocation.get().setPostalCode(location.getPostalCode());

            return locationRepository.save(tempLocation.get());
        }
        return locationRepository.save(location);
    }

    public String deleteLocation(int loccationKey) {
        locationRepository.delete(findLocationById(loccationKey).get());
        return "record deleted for " + loccationKey;
    }

    public Location findByPostalCode(int postalCode) {
        return locationRepository.findByPostalCode(postalCode);
    }

    public String deleteAllLocations() {
        locationRepository.deleteAll();
        return "all Locations deleted";
    }
}

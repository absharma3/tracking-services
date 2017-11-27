package com.frudo.controllers;

import com.frudo.model.Trip;
import com.frudo.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by abhimanyus on 11/26/17.
 */

@RequestMapping("/api/trip")
@RestController
public class TripServices {

    @Autowired
    TripRepository tripRepository;

    @RequestMapping(path = "/create" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Trip createTrip(@RequestBody Trip tripDetails){
            return tripRepository.save(tripDetails);
    }

    @RequestMapping(path = "/updateDriver/{tripid}" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Trip updateTrip(@PathVariable("tripid") String tripId,@RequestBody Trip tripDetails){
        Trip trip =  tripRepository.findOne(tripId);
        trip.setDriverId(tripDetails.getDriverId());
        return tripRepository.save(trip);
    }

}

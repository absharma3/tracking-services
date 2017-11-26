package com.frudo.controllers;

import com.frudo.model.Trip;
import com.frudo.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by abhimanyus on 11/26/17.
 */

@RequestMapping("/api/trip")
@RestController
public class TripServices {

    @Autowired
    TripRepository tripRepository;

    @RequestMapping(path = "/create" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Trip createTrip(Trip tripDetails){
            return tripRepository.save(tripDetails);
    }

}

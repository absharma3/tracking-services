package com.frudo.controllers;

import com.frudo.datacontracts.TrackingInfo;
import com.frudo.model.Trip;
import com.frudo.model.Vehicle;
import com.frudo.repository.TrackingRepository;
import com.frudo.repository.TripRepository;
import com.frudo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by abhimanyus on 11/23/17.
 */

@RequestMapping("/api/track/asset")
@RestController
public class AssetTrackingService implements TrackingServices {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    TripRepository tripRepository;
    @Autowired
    TrackingRepository trackingRepository;

    @RequestMapping(path = "/" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public TrackingInfo track(TrackingInfo trackingInfo) {
            Vehicle vehicle = vehicleRepository.findByVehicleTrackerId(trackingInfo.getTrackerId());
            if(vehicle != null){
                Trip trip = tripRepository.findByVehicleId(vehicle.getVehicleId());
                if(trip != null){
                    return trackingRepository.save(trackingInfo);
                }
            }


    }


}

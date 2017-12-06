package com.frudo.controllers;

import com.frudo.datacontracts.TrackingInfo;
import com.frudo.model.Trip;
import com.frudo.model.Vehicle;
import com.frudo.repository.TrackingRepository;
import com.frudo.repository.TripRepository;
import com.frudo.repository.VehicleRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

/**
 * Created by abhimanyus on 11/23/17.
 */

@RequestMapping("/api/asset")
@RestController
public class AssetTrackingService implements TrackingServices {

    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    TripRepository tripRepository;
    @Autowired
    TrackingRepository trackingRepository;

    @Value("${server.tracking.timeinterval}")
    int timeInterval;

    @RequestMapping(path = "/track" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public TrackingInfo track(TrackingInfo trackingInfo) {
            Vehicle vehicle = vehicleRepository.findByVehicleTrackerId(trackingInfo.getTrackerId());
            if(vehicle != null){
                Trip trip = tripRepository.findByVehicleId(vehicle.getVehicleId());
                if(trip != null){
                    List<TrackingInfo> trackingInfos = trackingRepository.findAll(new Sort(Sort.Direction.ASC,"createTimestamp"));
                    TrackingInfo tracking  = trackingInfos.get(trackingInfos.size()-1);
                    DateTime permissibleTimeGap = tracking.getCreateTimestamp().plusMillis(timeInterval);
                    if( permissibleTimeGap.compareTo(trackingInfo.getCreateTimestamp()) > 0)
                    return trackingRepository.save(trackingInfo);
                }
            }
            return null;

    }


}

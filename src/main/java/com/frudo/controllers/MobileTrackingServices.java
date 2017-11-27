package com.frudo.controllers;

import com.frudo.datacontracts.TrackingInfo;
import com.frudo.model.Trip;
import com.frudo.model.User;
import com.frudo.repository.TrackingRepository;
import com.frudo.repository.TripRepository;
import com.frudo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by abhimanyus on 11/26/17.
 */

@RequestMapping("/api/track/mobile")
@RestController
public class MobileTrackingServices implements TrackingServices {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TripRepository tripRepository;
    @Autowired
    TrackingRepository trackingRepository;

    @RequestMapping(path = "/" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public TrackingInfo track(TrackingInfo trackingInfo){

        //Assuming that for mobile we will be passed a mobile number
        // otherwise we will need to maintain IMEI number and tracking id
            User user = userRepository.findByMobileNumber(trackingInfo.getMobileNumber());
            if(user != null){
                Trip trip = tripRepository.findByDriverId(user.getUserId());
                return trackingRepository.save(trackingInfo);

            }
            return null;
    }

}

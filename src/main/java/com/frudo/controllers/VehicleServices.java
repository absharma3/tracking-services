package com.frudo.controllers;

import com.frudo.model.Vehicle;
import com.frudo.model.VehicleImpl;
import com.frudo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by abhimanyus on 11/26/17.
 */

@Controller
@RequestMapping("/api/vehicle")
public class VehicleServices {

    @Autowired
    VehicleRepository vehicleRepository;

    @RequestMapping(path = "/register" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public VehicleImpl register(@RequestBody VehicleImpl vehicleDetails){
        VehicleImpl vehicle = vehicleRepository.save(vehicleDetails);
        return vehicle;
    }


}

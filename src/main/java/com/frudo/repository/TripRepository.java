package com.frudo.repository;

import com.frudo.model.Trip;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by abhimanyus on 11/26/17.
 */
public interface TripRepository extends MongoRepository<Trip, String> {

    Trip findByDriverId(String driverId);
    Trip findByVehicleId(String vehicleId);

}

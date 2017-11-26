package com.frudo.repository;

import com.frudo.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by abhimanyus on 11/26/17.
 */
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    public Vehicle findByVehicleTrackerId(String trackerId);

}

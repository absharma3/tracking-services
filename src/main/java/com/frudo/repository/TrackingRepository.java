package com.frudo.repository;

import com.frudo.datacontracts.TrackingInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by abhimanyus on 11/26/17.
 */
public interface TrackingRepository extends MongoRepository<TrackingInfo, String> {


}

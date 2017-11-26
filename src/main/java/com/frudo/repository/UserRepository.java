package com.frudo.repository;

import com.frudo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by abhimanyus on 11/26/17.
 */
public interface UserRepository extends MongoRepository<User, String> {

    public User findByMobileNumber(Number mobile);
    public User findByUserId(String id);


}

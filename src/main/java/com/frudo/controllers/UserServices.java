package com.frudo.controllers;

import com.frudo.model.User;
import com.frudo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by abhimanyus on 11/26/17.
 */

@Controller
@RequestMapping("/api/user")
public class UserServices {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/add" , method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User addUser(@RequestBody User userDetails){
        User user =  userRepository.save(userDetails);
        return user;
    }

    @RequestMapping(path = "/find/{id}" , method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User findUser(@PathVariable("id") String userId){
        User user =  userRepository.findByUserId(userId);
        return user;
    }


    @RequestMapping(path = "/find/{number}/mobile" , method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody User findUserByMobile(@PathVariable("number") Long mobileNumber){

//        List users = userRepository.findAll();
        User user =  userRepository.findByMobileNumber(mobileNumber);
//        User user1 = userRepository.findByEmail("master.abhimanyu@gmail.com");
        return user;
    }

}

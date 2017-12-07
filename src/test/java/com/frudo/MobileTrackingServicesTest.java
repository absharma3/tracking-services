package com.frudo;

import com.frudo.controllers.AssetTrackingService;
import com.frudo.controllers.MobileTrackingServices;
import com.frudo.datacontracts.TrackingInfo;
import com.frudo.model.Trip;
import com.frudo.model.User;
import com.frudo.model.Vehicle;
import com.frudo.model.VehicleImpl;
import com.frudo.repository.TrackingRepository;
import com.frudo.repository.TripRepository;
import com.frudo.repository.UserRepository;
import com.frudo.repository.VehicleRepository;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by abhimanyus on 12/7/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(MobileTrackingServices.class)
public class MobileTrackingServicesTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    VehicleRepository vehicleRepository;
    @MockBean
    TripRepository tripRepository;
    @MockBean
    TrackingRepository trackingRepository;

    @MockBean
    UserRepository userRepository;

    @Test
    public void testTrack() throws Exception {

        TrackingInfo trackingInfo = getTrackingInfo();
        Trip trip = getTrip();
        User user = new User();
        user.setUserId("12345");
        given(trackingRepository.save(any(TrackingInfo.class))).willReturn(trackingInfo);
        given(tripRepository.findByDriverId("12345")).willReturn(trip);
        given(userRepository.findByMobileNumber(any(Long.class))).willReturn(user);
        given(trackingRepository.findAll(any(Sort.class))).willReturn(Collections.singletonList(trackingInfo));
        mvc.perform(post("/api/mobile/track").contentType(MediaType.APPLICATION_JSON).content(getTrackingJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentLocation.longitude", is(trackingInfo.getCurrentLocation().getLongitude())));

    }

    private String getTrackingJson() {
        return "{" +
                "\"mobileNumber\" : \"9663824250\"," +
                "\"currentLocation\" : {" +
                "\"longitude\" : 123.65," +
                "\"latitude\" : 123.65" +
                "}," +
                "\"createTimestamp\" : 1409175049" +
                "}";
    }



    private Trip getTrip(){
        Trip trip = new Trip();
        trip.setTripId("12345");
        trip.setDriverId("12345");
        trip.setVehicleId("12345");
        return trip;
    }

    private TrackingInfo getTrackingInfo(){
        TrackingInfo trackingInfo = new TrackingInfo();
        trackingInfo.setTrackerId("12345");
        trackingInfo.getCurrentLocation().setLatitude(123.65);
        trackingInfo.getCurrentLocation().setLongitude(123.65);
        trackingInfo.setCreateTimestamp(new DateTime(1409175049));
        return trackingInfo;
    }

}

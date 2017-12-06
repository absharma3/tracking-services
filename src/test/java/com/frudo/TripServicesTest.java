package com.frudo;

import com.frudo.controllers.TripServices;
import com.frudo.controllers.VehicleServices;
import com.frudo.model.Trip;
import com.frudo.model.Vehicle;
import com.frudo.model.VehicleImpl;
import com.frudo.repository.TripRepository;
import com.frudo.repository.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by abhimanyus on 12/6/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(TripServices.class)
public class TripServicesTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    TripRepository tripRepository;

    @Test
    public void testCreateTrip() throws Exception {
        Trip trip = getTrip();
        given(tripRepository.save(any(Trip.class))).willReturn(trip);
        mvc.perform(post("/api/trip/create").contentType(MediaType.APPLICATION_JSON).content(getTripJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vehicleId", is(trip.getVehicleId())));

    }

    @Test
    public void testUpdateTrip() throws Exception {
        Trip trip = getTrip();
        given(tripRepository.save(any(Trip.class))).willReturn(trip);
        given(tripRepository.findOne("12345")).willReturn(trip);
        mvc.perform(put("/api/trip/updateDriver/12345").contentType(MediaType.APPLICATION_JSON).content(getTripJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vehicleId", is(trip.getVehicleId())))
                .andExpect(jsonPath("$.driverId", is(trip.getDriverId())));

    }

    private String getTripJson() {
        String vehicleJson = "{" +
                "\"tripId\" : \"12345\"," +
                "\"driverId\" : \"12345\"," +
                "\"vehicleId\" : \"12345\"" +
                "}";
        return vehicleJson;
    }

    private Trip getTrip(){
        Trip trip = new Trip();
        trip.setTripId("12345");
        trip.setDriverId("12345");
        trip.setVehicleId("12345");
        return trip;
    }


}

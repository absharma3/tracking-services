package com.frudo;

import com.frudo.controllers.AssetTrackingService;
import com.frudo.controllers.TrackingServices;
import com.frudo.controllers.TripServices;
import com.frudo.datacontracts.TrackingInfo;
import com.frudo.model.Trip;
import com.frudo.model.Vehicle;
import com.frudo.model.VehicleImpl;
import com.frudo.repository.TrackingRepository;
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
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by abhimanyus on 12/6/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(AssetTrackingService.class)
public class AssetTrackingServicesTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    VehicleRepository vehicleRepository;
    @MockBean
    TripRepository tripRepository;
    @MockBean
    TrackingRepository trackingRepository;

    @Test
    public void testTrack() throws Exception {

        TrackingInfo trackingInfo = new TrackingInfo();
        Vehicle vehicle = getVehicle();
        Trip trip = getTrip();
        given(trackingRepository.save(any(TrackingInfo.class))).willReturn(trackingInfo);
        given(tripRepository.findByVehicleId("12345")).willReturn(trip);
        given(vehicleRepository.findByVehicleTrackerId("12345")).willReturn(vehicle);
        mvc.perform(post("/api/asset/track").contentType(MediaType.APPLICATION_JSON).content(getTrackingJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currentLocation.longitude", is(trackingInfo.getCurrentLocation().getLongitude())));

    }

    private String getTrackingJson() {
        return "";
    }

    private Vehicle getVehicle(){
        VehicleImpl vehicle = new VehicleImpl();
        vehicle.setVehicleId("12345");
        return vehicle;
    }

    private Trip getTrip(){
        Trip trip = new Trip();
        trip.setTripId("12345");
        trip.setDriverId("12345");
        trip.setVehicleId("12345");
        return trip;
    }


}

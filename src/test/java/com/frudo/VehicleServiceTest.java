package com.frudo;

import com.frudo.controllers.UserServices;
import com.frudo.controllers.VehicleServices;
import com.frudo.model.User;
import com.frudo.model.Vehicle;
import com.frudo.model.VehicleImpl;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by abhimanyus on 12/6/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(VehicleServices.class)
public class VehicleServiceTest {

    @MockBean
    VehicleRepository vehicleRepository;

    @Autowired
    private MockMvc mvc;

    @Test
    public void testRegisterVehicle() throws Exception {
        VehicleImpl vehicle = new VehicleImpl();
        vehicle.setVehicleId("12345");
        given(vehicleRepository.save(any(Vehicle.class))).willReturn(vehicle);
        mvc.perform(post("/api/vehicle/register").contentType(MediaType.APPLICATION_JSON).content(getVehicleJson()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vehicleId", is(vehicle.getVehicleId())));

    }

    private String getVehicleJson() {
        String vehicleJson = "{" +
                "    \"vehicleName\": \"Name1\"," +
                "    \"vehicleId\": \"12345\"," +
                "    \"vehicleType\": \"Four Wheeler\"," +
                "    \"vehicleTrackerId\": \"12345\"" +
                "}";
        return vehicleJson;
    }

}

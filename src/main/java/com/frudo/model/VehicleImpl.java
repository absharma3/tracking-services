package com.frudo.model;

import org.springframework.data.annotation.Id;

/**
 * Created by abhimanyus on 11/27/17.
 */
public class VehicleImpl implements Vehicle {

    String vehicleName;
    @Id
    String vehicleId;
    String vehicleType;
    String vehicleTrackerId;

    @Override
    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Override
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String getVehicleTrackerId() {
        return vehicleTrackerId;
    }

    public void setVehicleTrackerId(String vehicleTrackerId) {
        this.vehicleTrackerId = vehicleTrackerId;
    }
}

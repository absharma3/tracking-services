package com.frudo.datacontracts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhimanyus on 11/24/17.
 */
public class TrackingInfo {

    String trackerId;
    Location currentLocation;
    Number mobileNumber;
    Map<Object, Object> additionalInfo = new HashMap<Object, Object>();

    public String getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(String trackerId) {
        this.trackerId = trackerId;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Map<Object, Object> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<Object, Object> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Number getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Number mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

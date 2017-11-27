package com.frudo.datacontracts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhimanyus on 11/24/17.
 */
public class TrackingInfo {

    String trackerId;
    Location currentLocation;
    Long mobileNumber;
    Map<String, Object> additionalInfo = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(Map<String, Object> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

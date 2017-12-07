package com.frudo.datacontracts;

import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abhimanyus on 11/24/17.
 */
public class TrackingInfo {

    String trackerId;
    Location currentLocation = new Location();
    Long mobileNumber;
//    Map<String, Object> additionalInfo = new HashMap<String, Object>();
    DateTime createTimestamp;

    public DateTime getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(DateTime createTimestamp) {
        this.createTimestamp = createTimestamp;
    }

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

//    public Map<String, Object> getAdditionalInfo() {
//        return additionalInfo;
//    }
//
//    public void setAdditionalInfo(Map<String, Object> additionalInfo) {
//        this.additionalInfo = additionalInfo;
//    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

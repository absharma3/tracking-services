package com.frudo.model;

import org.joda.time.DateTime;

/**
 * Created by abhimanyus on 11/26/17.
 */

public abstract class  Trip {
    private String tripId;
    private String driverId;
    private String from;
    private String to;
    private String vehicleId;
    private DateTime startTime;
    private DateTime endTime;
}

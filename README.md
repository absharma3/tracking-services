**Tracking Services**

A set of APIs to track vehicles, mobiles or any orher kind of gps enabled device. 
There is a certain pre-requisites that are required in order to track.

* The person driving the vehicle has to be registered.
* The vehicle whose tracking has to be done needs to be registered.

Tracking will only be done in case the user and vehicle are on a trip.

There are different controllers for different kind of services:

UserServices - apis related to user registration and retrieval. 
APIS: 
* localhost:8080/api/user/add POST  POJO:User
* localhost:8080/api/user/find/{id} GET Path param: userid
* localhost:8080/api/user/find/{number}/mobile GET Path param: mobileNumber 


VehicleServices - apis related to vehicle registration and retrieval.
APIS:
* localhost:8080/api/vehicle/register POST POJO: VehicleImpl

TripServices - apis related to trip creation.
APIS:
* localhost:8080/api/trip/create POST POJO: Trip
* localhost:8080/api/trip/updateDriver/{tripid} PUT Path param: tripId POJO: Trip

AssetTrackingServices - apis related to tracking a vehicle on a trip.
* localhost:8080/api/asset/track POST POJO: TrackingInfo

MobileTracking Services - apis realted to tracking a mobile with a user on a trip.
* localhost:8080/api/mobile/track POST POJO: TrackingInfo


**Build:**
To build the project just run
mvn clean install

**Run:**
For running the application you need an instance of mongodb running on the default port.
Start the application by running 
mvn spring-boot:run


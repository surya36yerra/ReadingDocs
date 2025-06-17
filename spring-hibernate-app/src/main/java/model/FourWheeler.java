package model;


import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("Car")

public class FourWheeler extends Vehicle{

  private String SteeringHandle;

  public String getSteeringHandle() {
    return SteeringHandle;
  }

  public void setSteeringHandle(String steeringHandle) {
    SteeringHandle = steeringHandle;
  }




}

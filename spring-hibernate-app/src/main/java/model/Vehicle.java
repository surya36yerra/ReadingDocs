package model;

import org.hibernate.annotations.NotFound;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn{name = "VEHICLE_TYPE",discriminatorType = DiscriminatorType.STRING
    }
public class Vehicle {

  @Id
  @GeneratedValue
  private int vehicleId;
  private String vehicleName;

  public UserDetails getUserDetails() {
    return userDetails;
  }

  public void setUserDetails(UserDetails userDetails) {
    this.userDetails = userDetails;
  }

  @ManyToOne
  @NotFound
   //used to specify the action to be done, when the specific relation is not found
  private UserDetails userDetails;


  public int getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(int vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getVehicleName() {
    return vehicleName;
  }

  public void setVehicleName(String vehicleName) {
    this.vehicleName = vehicleName;
  }


}

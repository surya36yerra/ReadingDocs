package model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


//@Table(name = "user_dtl", schema = "vpayngen")


@Getter
@Setter
@Entity(name = "USER_DETAILS")
@Table(name = "USER_DETAILS")
public class UserDetails
{



  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
   //used to generate a value
  @Column(name = "USER_ID")
  private Integer userId;

  @Basic(fetch = true ,optional = false)
  //default mode that used to tell hibernate to do default mapping from java types to database types
  @Column(name ="FIRST_NM")
  private String firstName;

  @OneToOne
  @JoinColumn(name = "VEHICLE_ID")
  private Vehicle vehicle;


  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "USER_VEHICLE",joinColumns = @JoinColumn(name = "USER_ID"),inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
  private Collection<Vehicle> vehicleCollection = new ArrayList<Vehicle>();

  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }



  @ElementCollection
  //to persisit the entire  collection
  @JoinTable(name = "USER_ADDRESS",joinColumns = @JoinColumn(name = "USER_ID"))
  private Set<Address> addressSet = new HashSet<Address>();

  @GenericGenerator(name = "hilo-gen", strategy = "hilo")
  @CollectionId(columns = {@Column(name = "ADDRESS_ID")}, type = null, generator = "hilo-gen", type ="long")
  private Collection<Address> listOfAddress = new ArrayList<Address>();


  public Set<Address> getAddressSet() {
    return addressSet;
  }

  public void setAddressSet(Set<Address> addressSet) {
    this.addressSet = addressSet;
  }




  @Column
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME"}},
      @AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE"}},
      @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")}

  })
  //used to override the column name for a specific Address
  private  Address homeAddress;

  @Embedded
  private  Address officeAddress;

  @Transient
  //used to ignore the persisitence of lastname field
  @Column(name ="LST_NM")


  @Temporal(TemporalType.DATE)
  //tells hibernate to save only date,but not whole timestamp
  @Column(name ="LST_UPDT_TS")
  private Timestamp lastUpdateTimestamp;

  @Lob
  //used to specify a large object
  @Column(name ="LST_UPDT_USER_ID")
  private String lastUpdateUserId;



  @Override
  public Integer getId() {
    return this.userId=userId;
  }

  @Override
  public boolean isNew() {
    return true;
  }


  @Id
  @Column(name = "USER_ID")
  public int getUserId(){
    return userId;
  }

  @Column(name = "USER_NAME")
  public String getUserName(){
    return userName + " from getter";
  }


}



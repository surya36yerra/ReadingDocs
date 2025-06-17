package model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Set;


//@Table(name = "user_dtl", schema = "vpayngen")


@Getter
@Setter
@Entity
@NamedQuery(name = "UserDetails.byId", query="from UserDetails where userId = ?") //hql knows abt result set here
@NamedNativeQuery(name = "UserDetails.byName", query="select * from User_details where userName = ?,resultClass = UserDetails.class")-//hql doesnt know abt result set here
@Table(name = "User_Details")
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class UserDetails3
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "USER_ID")
  private Integer userId;


  @Column(name ="FIRST_NM")
  private String firstName;


  private Vehicle vehicle;



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

  @Id
  @Column(name = "USER_ID")
  public int getUserId(){
    return userId;
  }

  @Column(name = "USER_NAME")
  public String getUserName(){
    return userName + " from getter";
  }


  public Vehicle getVehicle() {
    return vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }




  public Set<Address> getAddressSet() {
    return addressSet;
  }

  public void setAddressSet(Set<Address> addressSet) {
    this.addressSet = addressSet;
  }




  @Override
  public Integer getId() {
    return this.userId=userId;
  }

  @Override
  public boolean isNew() {
    return true;
  }




}



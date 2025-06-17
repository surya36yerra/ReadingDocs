package model;

import javax.persistence.*;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;


//@Table(name = "user_dtl", schema = "vpayngen")



@Getter
@Setter
@Entity(name = "USER_DETAILS")
@Table(name = "USER_DETAILS")
public class User
{


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
   //used to generate a value
  @Column("USER_ID")
  private Integer userId;

  @Basic(fetch = true ,optional = false)
  //default mode that used to tell hibernate to do default mapping from java types to database types
  @Column("FIRST_NM")
  private String firstName;

  @Transient
  //used to ignore the persisitence of lastname field
  @Column("LST_NM")

  private String lastName;
  @Column("ELEC_AD_TX")
  private String emailAddress;
  @Column("EMP_ID_NO")
  private String employeeId;
  @Column("CMPL_PHONE_NO")
  private String phoneNumber;
  @Column("ACT_CD")
  private String accountCode;
  @Column("GUID_ID")
  private String guidId;
  @Column("ACT_STA_CD")
  private String accountStatusCode;
  @Column("ACT_TRY_CT")
  private String accountTryCode;
  @JsonFormat(pattern="dd-MMM-yy")
  @Column("ACT_EXPR_DT")
  private LocalDate accountExpiryDate;
  @JsonFormat(pattern="dd-MMM-yy")
  @Column("LST_ACS_DT")
  private LocalDate lastAccessDate;

  @Temporal(TemporalType.DATE)
  //tells hibernate to save only date,but not whole timestamp
  @Column("LST_UPDT_TS")
  private Timestamp lastUpdateTimestamp;

  @Lob
  //used to specify a large object
  @Column("LST_UPDT_USER_ID")
  private String lastUpdateUserId;


  @Column("VRFY_CD")
  private String verifyCode;
  @Column("THLD_NTFY_EMAIL_TX")
  private String notifyEmail;
  @Column("WEB_USER_ID")
  private String webUserId;

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



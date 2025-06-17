import model.Address;
import model.UserDetails;
import model.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest4 {

  public static void main(String[] args) {
    UserDetails user = new UserDetails();


  //  user1.setUserId(1234); - //no need to be passed if we use @generatedValue
    user.setFirstName("surya");

    Address address1 = new Address();
    address1.setCity("phoenix");
    address1.setPincode("85032");
    address1.setState("AZ");
    address1.setStreet("tatum blvd");


    Address address2 = new Address();
    address2.setCity("phoenix");
    address2.setPincode("85032");
    address2.setState("AZ");
    address2.setStreet("tatum blvd");

    user.getAddressSet().add(address1);
    user.getAddressSet().add(address2);

    Vehicle vehicle1 = new Vehicle();
    vehicle1.setVehicleId(1234);
    vehicle1.setVehicleName("Tesla");

    Vehicle vehicle2 = new Vehicle();
    vehicle2.setVehicleId(1234);
    vehicle2.setVehicleName("BMW-X3");

    user.setVehicle(vehicle1);
    user.getVehicle().add(vehicle1);
    user.getVehicle().add(vehicle2);

    vehicle1.setUserDetails(user);
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    // Session session = sessionFactory.getCurrentSession();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.persist(session);
    session.save(user);
    session.save(vehicle);
    session.save(vehicle1);
    session.save(vehicle2);
    session.getTransaction().commit();
    session.close();







  }
}

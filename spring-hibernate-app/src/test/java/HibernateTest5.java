import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest5 {

  public static void main(String[] args) {
    UserDetails user = new UserDetails();


  //  user1.setUserId(1234); - //no need to be passed if we use @generatedValue

    Vehicle vehicle1 = new Vehicle();
    vehicle1.setVehicleId(1234);
    vehicle1.setVehicleName("Tesla");

    TwoWheeler bike = new TwoWheeler();
    bike.setVehicleName("bike");
    bike.setSteeringHandle("bike steering handle");

    FourWheeler car = new FourWheeler();
    car.setVehicleName("porsche");
    car.setSteeringHandle("porsche steering wheel");




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

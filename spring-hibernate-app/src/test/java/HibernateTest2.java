import model.Address;
import model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

public class HibernateTest2 {

  public static void main(String[] args) {
    UserDetails user1 = new UserDetails();
    UserDetails user2 = new UserDetails();

    UserDetails user3 = new UserDetails();

  //  user1.setUserId(1234); - //no need to be passed if we use @generatedValue
    user1.setFirstName("surya");

    Address address = new Address();
    address.setCity("phoenix");
    address.setPincode("85032");
    address.setState("AZ");
    address.setStreet("tatum blvd");
    user1.setAddress(address);



    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    // Session session = sessionFactory.getCurrentSession();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(user1);
    session.save(user2);
    session.getTransaction().commit();
    session.close();

    user1 = null;
    session = sessionFactory.openSession();
    session.beginTransaction();
    user1 = (UserDetails) session.get(UserDetails.class,1234);
    System.out.println("userName retrieved is "+ user1.getFirstName());





  }
}

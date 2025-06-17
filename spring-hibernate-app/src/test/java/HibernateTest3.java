import model.Address;
import model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest3 {

  public static void main(String[] args) {
    UserDetails user1 = new UserDetails();
    UserDetails user2 = new UserDetails();

    UserDetails user3 = new UserDetails();

  //  user1.setUserId(1234); - //no need to be passed if we use @generatedValue
    user1.setFirstName("surya");

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

    user1.getAddressSet().add(address1);
    user1.getAddressSet().add(address2);

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
    session.close();
    System.out.println(user3.getListOfAddress().size());
    System.out.println("userName retrieved is "+ user1.getFirstName());





  }
}

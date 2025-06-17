import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest6 {

  public static void main(String[] args) {



  user1.setUserId(1234); - //no need to be passed if we use @generatedValue

    Vehicle vehicle1 = new Vehicle();
    vehicle1.setVehicleId(1234);
    vehicle1.setVehicleName("Tesla");




    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    // Session session = sessionFactory.getCurrentSession();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    //CRUD operations
    //Read
    UserDetails2 userDetails2 = (UserDetails2) session.get(UserDetails2.class,6);
    System.out.println("user name pulled up is: "+userDetails2.getUserName());

    //delete
    session.delete(userDetails2);

    //update
    UserDetails2 ud2 = (UserDetails2) session.get(UserDetails2.class,5);
    ud2.setUserId("updated user");
    session.update(user);




    for(int i=0;i<10;i++) {
      UserDetails user = new UserDetails();
      user.setUserId(1234);
      user.setFirstName("surya");
      session.save(user);
    }
    System.out.println("user name retrieved is "+userDetails2.getUserName());


    session.persist(session);
    session.getTransaction().commit();
    session.close();







  }
}

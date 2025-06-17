import model.UserDetails2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest8 {

  public static void main(String[] args) {


    UserDetails2 ud3 = new UserDetails2();
    ud3.setUserId(1234);
    ud3.setFirstName("surya");//transient state of object

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    // Session session = sessionFactory.getCurrentSession();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    UserDetails2 ud4 = (UserDetails2)session.get(UserDetails2.class,1);

    session.getTransaction().commit();
    session.close();//detached state of object

    ud4.setFirstName("updated username after session close");

     session = sessionFactory.openSession();
     session.beginTransaction();
     session.update(ud4);
     ud4.setFirstName("change after update");
     session.getTransaction().commit();
     session.close();
















  }
}

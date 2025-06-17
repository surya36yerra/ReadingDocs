import model.UserDetails;
import model.UserDetails2;
import model.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest7 {

  public static void main(String[] args) {


    UserDetails2 ud2 = new UserDetails2();
    ud2.setUserId(1234);
    ud2.setFirstName("surya");//transient state of object

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    // Session session = sessionFactory.getCurrentSession();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    session.save(ud2);
    ud2.setFirstName("updated surya"); //persiistent state of object
    ud2.setFirstName("updated surya again"); //here updated surya will be saved in DB,as a last transaction on user

    session.getTransaction().commit();
    session.close();//detached state of object
    ud2.setFirstName("updated surya after session close"); //this is detached and not updated in db







  }
}

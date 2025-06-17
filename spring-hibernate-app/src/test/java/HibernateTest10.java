import model.UserDetails2;
import model.UserDetails3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class HibernateTest10 {

  public static void main(String[] args) {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    // Session session = sessionFactory.getCurrentSession();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    Query query = session.getNamedQuery("UserDetails.byId");
    query.setInteger(0,2);

    Query query2 = session.getNamedQuery("UserDetails.byName");
    query.setString(0,"User10");



    List<UserDetails3> users = (List<String>)query2.list();

    session.getTransaction().commit();
    session.close();//detached state of object
    System.out.println("size of list-"+users.size());

     session = sessionFactory.openSession();
     session.beginTransaction();

     session.getTransaction().commit();
     session.close();


  }
}

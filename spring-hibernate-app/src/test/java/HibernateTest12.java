import model.UserDetails3;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class HibernateTest12 {

  public static void main(String[] args) {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    // Session session = sessionFactory.getCurrentSession();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    UserDetails3 ud31 = (UserDetails3)session.get(UserDetails3.class,1);
    UserDetails3 ud32 = (UserDetails3)session.get(UserDetails3.class,1);
    session.getTransaction().commit();
    session.close();//since session is closed, its cache will also be closed

    Session session2 = sessionFactory.openSession();
    session2.beginTransaction();
    UserDetails3 ud33 = (UserDetails3)session2.get(UserDetails3.class,1);
    session2.getTransaction().commit();
    session2.close();


  }
}

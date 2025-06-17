import model.UserDetails2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class HibernateTest9 {

  public static void main(String[] args) {


    UserDetails2 ud3 = new UserDetails2();
    ud3.setUserId(1234);
    ud3.setFirstName("surya");//transient state of object

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    // Session session = sessionFactory.getCurrentSession();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    Query query = session.createQuery("from UserDetails");

    Query query2 = session.createQuery("from UserDetails where userId > 5");
    query2.setFirstResult(5); //nth point from where to get the records
    query2.setMaxResults(4); //stops after fetching the 4 records

    List <UserDetails2> users = (List<UserDetails2>) query.list();


    Query query3 = session.createQuery("select userName from UserDetails");
    Query query4 = session.createQuery("select new map(userId,userName) from UserDetails");

    String minUserId ="5";
    Query query5 = session.createQuery("from UserDetails where userId > "+minUserId);//this has sqlInjection attack risk

    Query query6 = session.createQuery("from UserDetails where userId >? and userName =?");//this is solution to avoid sqlInjection attack risk
    query6.setInteger(0,Integer.parseInt(minUserId));
    query6.setString(1,userName));

    Query query7 = session.createQuery("from UserDetails where userId >:userId and userName = :userName");//this is solution to avoid sqlInjection attack risk
    query7.setInteger("userId",Integer.parseInt(minUserId));
    query7.setString("userName",userName);
    query7.setString(1,userName));








    query2.setFirstResult(5); //nth point from where to get the records
    query2.setMaxResults(4); //stops after fetching the 4 records

    List<String> userNames = (List<String>)query3.list();

    session.getTransaction().commit();
    session.close();//detached state of object
    System.out.println("size of list-"+users.size());

     session = sessionFactory.openSession();
     session.beginTransaction();

     session.getTransaction().commit();
     session.close();
















  }
}

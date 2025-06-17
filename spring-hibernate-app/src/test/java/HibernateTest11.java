import model.UserDetails;
import model.UserDetails3;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;

import java.util.List;


public class HibernateTest11 {

  public static void main(String[] args) {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    // Session session = sessionFactory.getCurrentSession();
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    Criteria criteria = session.createCriteria(UserDetails3.class);
    criteria.add(Restrictions.or(Restrictions.between("userId",0,3),Restrictions.between("userId",7,10)));


    criteria.add(Restrictions.eq("userName","User 10"))//similar to where clause in sql
             .add(Restrictions.gt("userId",5))//chaining where clauses
             .add(Restrictions.like("dob","07/28/1988"))
             .add(Restrictions.between("userId","50","500"));


    UserDetails3 ud3 = new UserDetails3();
    ud3.setUserId(5);
    ud3.setUserName("user 5");
    ud3.setUserName("user 1%");

    Example example = Example.create(ud3);
    Example example2 = Example.create(ud3).excludeProperty("userName");
    Example example3   = Example.create(ud3).enableLike();

    Criteria criteria2 = session.createCriteria(UserDetails3.class) //returns user5
        .add(example);

    Criteria criteria3 = session.createCriteria(UserDetails3.class) //returns user5
        .add(example);

    Criteria criteria1 =session.createCriteria(UserDetails3.class) // here return type will be only user-Id,but not the whole UserType
                                .setProjection{Projections.property("userId")};
                                .setProjection{Projections.max("userId")};
                                .setProjection{Projections.count( "userId")};
                                .addOrder(Order.desc("userId"));


    List<UserDetails3> users = (List<String>)criteria.list();

    session.getTransaction().commit();
    session.close();//detached state of object
    System.out.println("size of list-"+users.size());

     session = sessionFactory.openSession();
     session.beginTransaction();

     session.getTransaction().commit();
     session.close();


  }
}

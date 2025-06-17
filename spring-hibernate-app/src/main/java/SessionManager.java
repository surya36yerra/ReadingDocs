//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//
//import javax.imageio.spi.ServiceRegistry;
//import java.util.HashMap;
//import java.util.Map;
//
//public class SessionManager {
//
//  public static Session getCurrentSession() {
//    // Hibernate 5.4 SessionFactory example without XML
//    Map<String, String> settings = new HashMap<String, String>();
//    settings.put("connection.driver_class", "com.mysql.jdbc.Driver");
//    settings.put("dialect", "org.hibernate.dialect.MySQL8Dialect");
//    settings.put("hibernate.connection.url",
//        "jdbc:mysql://localhost/hibernate_examples");
//    settings.put("hibernate.connection.username", "root");
//    settings.put("hibernate.connection.password", "password");
//    settings.put("hibernate.current_session_context_class", "thread");
//    settings.put("hibernate.show_sql", "true");
//    settings.put("hibernate.format_sql", "true");
//
//    ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//        .applySettings(settings).build();
//
//    MetadataSources metadataSources = new MetadataSources(serviceRegistry);
//    // metadataSources.addAnnotatedClass(Player.class);
//    Metadata metadata = metadataSources.buildMetadata();
//
//    // here we build the SessionFactory (Hibernate 5.4)
// //   SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//
//    // Session session = sessionFactory.getCurrentSession();
//    Session session = sessionFactory.openSession();
//    session.beginTransaction();
//    session.save(use)
//    return session;
//  }
//}

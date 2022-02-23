package util;
import java.util.Properties; 

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.mysql.cj.xdevapi.Client;

import model.Achats;
import model.Clients;
import model.ElementAchats;
import model.ElementVente;
import model.Fournisseur;
import model.Produit;
import model.User;
import model.Vente;

/**
 * Java based configuration
 * @author ramesh Fadatare
 *
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/projet_jee");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "27666242");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                
                System.out.println("impossible");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Clients.class);
                configuration.addAnnotatedClass(Produit.class);
                configuration.addAnnotatedClass(Vente.class);
                configuration.addAnnotatedClass(ElementVente.class);
                configuration.addAnnotatedClass(Achats.class);
              	configuration.addAnnotatedClass(ElementAchats.class);
              	configuration.addAnnotatedClass(Fournisseur.class);
                
                


                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate est bien cree");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
//                e.printStackTrace();
            	System.out.println("impossible de connecter");
            }
        }
        return sessionFactory;
    }
}

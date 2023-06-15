package Datos;

import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import javax.imageio.spi.ServiceRegistry;

import javax.persistence.metamodel.EntityType;

import java.io.File;
import java.util.Map;

public class  HibernateUtil {
    private static final SessionFactory ourSessionFactory;

    public void HibernateUtil(){

    }

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure(new File(".\\src\\main\\java\\hibernate.cfg.xml"));

            /*StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            ourSessionFactory =  configuration
                    .buildSessionFactory(serviceRegistry);*/

           ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
}

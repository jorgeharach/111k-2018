/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campos.utils;

import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author George
 */
public class HibernateUtils {

    private static StandardServiceRegistry registry = null;
    private static SessionFactory sessionFactory = null;

    public static void initHibernate() {

        registry = new StandardServiceRegistryBuilder()
                .configure("resources/hibernate.cfg.xml")
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {

            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "La aplicación no puede iniciar"
            );
            System.exit(-1);
        }
    }
    
    public static void finalizeHibernate(){
        if(registry != null){
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    
    public static Session openSession() throws HibernateException{
        return sessionFactory.openSession();
    }

}

package org.example;

import org.example.config.PropertiesSessionFactoryProvider;
import org.example.entity.Device;
import org.example.entity.Port;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Example3 {
    public static void main(String[] args) {

        PropertiesSessionFactoryProvider propertiesSessionFactoryProvider = new PropertiesSessionFactoryProvider();
        SessionFactory sessionFactory = propertiesSessionFactoryProvider.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            // ВЫБОРКА ВСЕХ ЗНАЧЕНИЙ ИЗ ТАБЛИЦЫ port
//            Query<Port> query = session.createQuery("from Port", Port.class);
//            for (Port el : query.list()){
//                System.out.println(el);
//            }
            Query<Port> portQuery = session.createQuery("from Port", Port.class);
            for (Port port : portQuery.list()){
                System.out.println(port);
            }

        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }
}

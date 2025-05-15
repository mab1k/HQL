package org.example;

import org.hibernate.query.Query;
import org.example.config.PropertiesSessionFactoryProvider;
import org.example.entity.Device;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        PropertiesSessionFactoryProvider propertiesSessionFactoryProvider = new PropertiesSessionFactoryProvider();
        SessionFactory sessionFactory = propertiesSessionFactoryProvider.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            // ВЫБОРКА ВСЕХ ЗНАЧЕНИЙ ИЗ ТАБЛИЦЫ devices
            Query<Device> query = session.createQuery("from Device where installationDate = current_date()", Device.class);
            List<Device> resultList = query.getResultList();
            for (Device el : resultList){
                System.out.println(el);
            }

        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

}

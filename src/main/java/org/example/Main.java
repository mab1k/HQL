package org.example;

import org.example.config.PropertiesSessionFactoryProvider;
import org.example.entity.Device;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PropertiesSessionFactoryProvider propertiesSessionFactoryProvider = new PropertiesSessionFactoryProvider();
        SessionFactory sessionFactory = propertiesSessionFactoryProvider.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            // ВЫБОРКА ВСЕХ ЗНАЧЕНИЙ ИЗ ТАБЛИЦЫ devices
//            Query<Device> query = session.createQuery("from Device", Device.class);
//            List<Device> resultList = query.getResultList();
//            for (int i = 0; i < resultList.size(); i++) {
//                System.out.println(resultList.get(i));
//            }

            // ВЫБОРКА ОДНОЙ ЗАПИСИ
            Query<Device> query = session.createQuery("from Device where id = 1", Device.class);
            Device singleResult = query.getSingleResult();
            System.out.println(singleResult);
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }
}
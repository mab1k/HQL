package org.example;

import org.example.config.PropertiesSessionFactoryProvider;
import org.example.entity.Device;
import org.example.entity.Port;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Example4 {
    public static void main(String[] args) {

        PropertiesSessionFactoryProvider propertiesSessionFactoryProvider = new PropertiesSessionFactoryProvider();
        SessionFactory sessionFactory = propertiesSessionFactoryProvider.getSessionFactory();

        try(Session session = sessionFactory.openSession()){
            // ВЫБОРКА ВСЕХ ЗНАЧЕНИЙ ИЗ ТАБЛИЦЫ port
//            Query<Port> query = session.createQuery("from Port", Port.class);
//            for (Port el : query.list()){
//                System.out.println(el);
//            }
            List<Integer> integers = List.of(2, 3, 4);
            Query<Device> query = session.createQuery("select device from Port where bandwidth in (:list)", Device.class);
            query.setParameterList("list", integers);

            for (Device device : query.list()) {
                System.out.println(device);
            }


        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }
}

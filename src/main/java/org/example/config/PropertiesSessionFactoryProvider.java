package org.example.config;

import org.example.entity.Device;
import org.example.entity.Port;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PropertiesSessionFactoryProvider implements SessionFactoryProvider{
    @Override
    public SessionFactory getSessionFactory() {
        return new Configuration()
                .addAnnotatedClass(Device.class)
                .addAnnotatedClass(Port.class)
                .buildSessionFactory();
    }
}

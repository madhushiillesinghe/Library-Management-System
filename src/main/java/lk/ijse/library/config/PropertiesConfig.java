package lk.ijse.library.config;

import lk.ijse.library.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PropertiesConfig {
    private static PropertiesConfig factoryPropertiesConfig;
    private final SessionFactory sessionFactory;

    private PropertiesConfig(){

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .loadProperties("hibernate.properties")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Users.class)
                .getMetadataBuilder()
                .build();

        sessionFactory = metadata.buildSessionFactory();
    }

    public static PropertiesConfig getInstance(){
        return (factoryPropertiesConfig == null)
                ? factoryPropertiesConfig = new PropertiesConfig()
                : factoryPropertiesConfig;
    }

    public Session getSession(){
        return sessionFactory.openSession();
    }
}

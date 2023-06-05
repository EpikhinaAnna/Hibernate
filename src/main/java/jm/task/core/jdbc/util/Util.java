package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Util {
    private static final String DO_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DO_URL = "jdbc:mysql://localhost:3306/mysql";
    private static final String DO_USERNAME = "root";
    private static final String DO_PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DO_DRIVER);
            connection = DriverManager.getConnection(DO_URL, DO_USERNAME, DO_PASSWORD);
            //System.out.println("Ok");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.driver_class", DO_DRIVER)
                        .setProperty("hibernate.connection.url", DO_URL)
                        .setProperty("hibernate.connection.username", DO_USERNAME)
                        .setProperty("hibernate.connection.password", DO_PASSWORD)
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                        .addAnnotatedClass(User.class)
                        .setProperty("hibernate.c3p0.min_size", "5")
                        .setProperty("hibernate.c3p0.max_size", "200")
                        .setProperty("hibernate.c3p0.max_statements", "200");
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}






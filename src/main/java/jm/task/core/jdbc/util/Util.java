package jm.task.core.jdbc.util;

import com.mysql.cj.jdbc.Driver;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class Util {
private  static  final  String DO_DRIVER ="com.mysql.cj.jdbc.Driver";
   private static final String DO_URL="jdbc:mysql://localhost:3306/mysql";
    private static final String DO_USERNAME="root";
    private static final String DO_PASSWORD="root";

    public static  Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DO_DRIVER);
            connection = DriverManager.getConnection(DO_URL, DO_USERNAME, DO_PASSWORD);
            //System.out.println("Ok");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }}




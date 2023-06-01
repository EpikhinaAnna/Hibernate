package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    public void createUsersTable()  {
        userDaoJDBC.createUsersTable();

    }

    public void dropUsersTable() throws SQLException {
        userDaoJDBC.dropUsersTable();

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDaoJDBC.saveUser(name,lastName,age);
        System.out.println("User с именем - "+ name+" добавлен в базу данных" );

    }

    public void removeUserById(long id)  {
        userDaoJDBC.removeUserById(id);

    }

    public List<User> getAllUsers() throws SQLException {
        List<User>users = userDaoJDBC.getAllUsers();
        for (User user : users){
            System.out.println(user);
        }
        return users;
    }

    public void cleanUsersTable()  {
        userDaoJDBC.cleanUsersTable();

    }
}

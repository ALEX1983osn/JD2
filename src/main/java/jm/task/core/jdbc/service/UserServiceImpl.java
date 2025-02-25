package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import javax.transaction.SystemException;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl  implements UserService {
    public UserDao userDaoHibernate = new UserDaoHibernateImpl();

    @Override
    public void createUsersTable() throws SQLException {
        userDaoHibernate.createUsersTable();
    }

    @Override
    public void dropUsersTable() throws SQLException {
        userDaoHibernate.dropUsersTable();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) throws SQLException {
        userDaoHibernate.saveUser(name, lastName, age);
        System.out.println("User с именем " + name + " добавлен в базу данных");
    }

    @Override
    public void removeUserById(long id) throws SQLException {
        userDaoHibernate.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        userDaoHibernate.getAllUsers();
        return userDaoHibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() throws SQLException {
        userDaoHibernate.cleanUsersTable();
    }


}
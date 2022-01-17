package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();

        userDao.saveUser("Alexey ", "Ovsyannikov", (byte) 40);
        userDao.saveUser("Maria", "Ovsaynnikova", (byte) 13);
        userDao.saveUser("Maxim", "Galkin", (byte) 51);
        userDao.saveUser("Umma", "Turman", (byte) 47);

        userDao.removeUserById(1);
        userDao.getAllUsers();
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
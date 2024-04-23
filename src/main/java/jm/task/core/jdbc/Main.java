package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

import static jm.task.core.jdbc.util.Util.closeConnection;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();

        userService.saveUser("Alexey ", "Ovsyannikov", (byte) 40);
        userService.saveUser("Maria", "Ovsaynnikova", (byte) 13);
        userService.saveUser("Maxim", "Galkin", (byte) 51);
        userService.saveUser("Umma", "Turman", (byte) 47);

        userService.removeUserById(1);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        closeConnection();
    }
}



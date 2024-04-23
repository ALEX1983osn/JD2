//package jm.task.core.jdbc.dao;
//
//import jm.task.core.jdbc.model.User;
//import jm.task.core.jdbc.util.Util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoJDBCImpl implements UserDao {
//
//    Connection connection;
//
//    public UserDaoJDBCImpl() {
//        connection = Util.getConnection();
//    }
//
//    @Override
//    public void createUsersTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS `users` (" +
//                " id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
//                " name VARCHAR(45), " +
//                " lastName VARCHAR(45), " +
//                " age TINYINT); ";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS users";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setByte(3, age);
//            preparedStatement.executeUpdate();
//            System.out.println("User name:" + name + "; lastName:" + lastName + "; age:" + age + " has been saved");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void removeUserById(long id) {
//        String sql = "DELETE FROM users WHERE id = ?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setLong(1, id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        List<User> list = new ArrayList<>();
//        String sql = "SELECT * FROM users";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                User tempUser = new User(resultSet.getString("name"),
//                        resultSet.getString("lastName"),
//                        resultSet.getByte("age"));
//                tempUser.setId(resultSet.getLong("id"));
//                list.add(tempUser);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }
//
//    @Override
//    public void cleanUsersTable() {
//        String sql = "DELETE FROM users";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
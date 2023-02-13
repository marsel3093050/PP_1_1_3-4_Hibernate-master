/*
package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static jm.task.core.jdbc.util.Util.conn;


public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        Util.getConn();

        String sqlCommand = "CREATE TABLE user (Id INT PRIMARY KEY AUTO_INCREMENT, firstName VARCHAR(45), lastName VARCHAR(45), age INT)";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlCommand);
            conn.commit();
            conn.close();
            System.out.println("Таблица была создана!");
        } catch (SQLException a) {
            }
        }


    public void dropUsersTable() {
        Util.getConn();

        String sqlCommand = "DROP TABLE IF EXISTS user";
        try  {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlCommand);
            conn.commit();
            conn.close();

            System.out.println("Таблица была удалена!");
        } catch (SQLException e) {
            try  {
                conn.rollback();
            } catch (SQLException e1) {

            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Util.getConn();
        try {
            String sql = "INSERT INTO user (firstName, lastName, age) Values (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            int rows = preparedStatement.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("User с именем - " + name + " добавлен в базу данных!");
        } catch (SQLException e) {
            System.out.println("Ошибка при добавлении!");
            try {
                conn.rollback();
            } catch (SQLException e1) {

            }
        }
    }

    public void removeUserById(long id) {
        Util.getConn();

        try  {
            String sql = "DELETE FROM user WHERE Id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            int rows = preparedStatement.executeUpdate();
            conn.commit();
            conn.close();
            System.out.println("User с id – " + id + " удалён из базы данных!");
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении!");
            try  {
                conn.rollback();
            } catch (SQLException a) {
            }
        }
    }

    public List<User> getAllUsers() {
        Util.getConn();
        String sqlCommand = "SELECT * FROM user";
        List<User> users = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            while (resultSet.next()) {
                User user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getByte(4));
//                user.setId(resultSet.getLong(1));
                users.add(user);
            }
            conn.commit();
            conn.close();
            for (int j = 0; j < users.size(); j++) {
                System.out.println(users.get(j).toString());
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при выводе пользователей!");
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException a) {
            }
        }
        return users;
    }

    public void cleanUsersTable() {
        Util.getConn();

        String sqlCommand = "DELETE FROM user";
        try {
            conn.createStatement().executeUpdate(sqlCommand);
            conn.commit();
            System.out.println("Данные из таблицы удалены!");
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении данных!");
            try {
                conn.rollback();
            } catch (SQLException a) {
            }
        }
    }
}

*/

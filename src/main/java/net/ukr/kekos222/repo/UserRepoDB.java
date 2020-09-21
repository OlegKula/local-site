package net.ukr.kekos222.repo;

import net.ukr.kekos222.model.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepoDB implements UserRepo {

    private String url;
    private String driver;
    private String db_user;
    private String db_password;

    public UserRepoDB() {
        this.url = "jdbc:mysql://localhost:3306/db_app?useUnicode=true&characterEncoding=utf8";
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.db_user = "root";
        this.db_password = "";
    }


    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try{
            Class.forName(driver).getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(url, db_user, db_password);

            String query = "SELECT * FROM users";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                users.add(new User(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }

            connection.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean isExist(String email, String password) {
        boolean isExist = false;

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(url, db_user, db_password);

            String query = "SELECT * FROM users WHERE user_email=?";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,email);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                if(BCrypt.checkpw(password,resultSet.getString(5)))
                    isExist = true;
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }

    @Override
    public void save(User user) {

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection(url, db_user, db_password);

            String query = "INSERT INTO users (" +
                    "user_firstName, " +
                    "user_secondName, " +
                    "user_email, " +
                    "user_password)" +
                    "values(?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.execute("set character set utf8");
            preparedStatement.execute("set names utf8");

            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getSecondName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));

            preparedStatement.executeUpdate();

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

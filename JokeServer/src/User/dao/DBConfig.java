package User.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {


    private static Connection con;

    public static Connection getCon() {

        String url = "jdbc:mysql://localhost:3306/jokeserver";
        String username = "root";
        String password = "root";

        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException | ClassNotFoundException e) {
                System.out.println("Error establishing connection");
            }
        }
        return con;
    }

    public static void main(String[] args) {
        getCon();
    }
}

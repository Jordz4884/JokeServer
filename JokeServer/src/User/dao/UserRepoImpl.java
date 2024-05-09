package User.dao;

import User.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepoImpl extends User implements UserRepo{

    static Connection con = DBConfig.getCon();

    public UserRepoImpl() {
    }

    public static void createUser(String username, String password) {
        try {
            String query = "INSERT INTO user (username, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("User was created successfully");
        } catch (SQLException e) {
            System.out.println("Error creating user");
        }
    }

    @Override
    public boolean createMember(String username) {
        try {
            String query = "UPDATE user SET member = 1 WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
            System.out.println("Member was registered successfully");
        } catch (SQLException e) {
            System.out.println("Error making user a member");
        }
        return false;
    }

    @Override
    public boolean createAdmin(String username) {
        try {
            String query = "UPDATE user SET admin = 1 WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
            System.out.println("Admin was registered successfully");
        } catch (SQLException e) {
            System.out.println("Error making member an admin");
        }
        return false;
    }

    public static void userLogin(String username, String password) {
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeQuery();
            System.out.println("User was logged in successfully");
        } catch (SQLException e) {
            System.out.println("Error logging in user");
        }
    }

    @Override
    public void memberLogin(String username, String password) {
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ? AND member = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeQuery();
            System.out.println("Member was logged in successfully");
        } catch (SQLException e) {
            System.out.println("Error logging in member");
        }
    }

    @Override
    public void adminLogin(String username, String password) {
        try {
            String query = "SELECT * FROM user WHERE username = ? AND password = ? AND member = 1 AND admin = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            System.out.println("Admin was logged in successfully");
        } catch (SQLException e) {
            System.out.println("Error logging in admin");
        }
    }

    @Override
    public void updateUser(String password, String newPassword, String username) {
        try {
            String query = "UPDATE user SET password = ? WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.executeUpdate();
            System.out.println("User was updated successfully");
        } catch (SQLException e) {
            System.out.println("Error updating user");
        }
    }

    @Override
    public void deleteUser(String username) {
        try {
            String query = "DELETE FROM user WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate();
            System.out.println("User was deleted successfully");
        } catch (SQLException e) {
            System.out.println("Error deleting user");
        }
    }
}

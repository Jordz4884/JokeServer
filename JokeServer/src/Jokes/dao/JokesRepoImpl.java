package Jokes.dao;

import Jokes.Model.Jokes;

import java.sql.*;
import java.util.concurrent.TimeUnit;

public class JokesRepoImpl implements JokesRepo {
    static Connection con = DBConfig.getCon();
    @Override
    public void createJoke(String jokeText, String categoryID) {
        try {
            String query = "INSERT INTO jokes (jokeText) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, jokeText);
            int affectedRows = ps.executeUpdate();
            int jokeID = 0;
            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        jokeID = rs.getInt(1);
                    }
                }
            }
            finalizeJoke(jokeID, categoryID);
        } catch (SQLException e) {
            System.out.println("Error creating joke");
        }
    }

    public void finalizeJoke(int jokeID, String categoryID) {
        try {
            String query = "INSERT INTO jokes_categories (jokeID, categoryID) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, jokeID);
            ps.setString(2, categoryID);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error finalizing joke");
        }
    }

    public static void getJokes(String jokeCategory) {
        try {
            String query = " SELECT * from jokes j LEFT JOIN jokes_categories jc ON j.jokeID = jc.jokeID LEFT JOIN categories c ON c.categoryID = jc.categoryID WHERE c.categoryName = ?;";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, jokeCategory);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("jokeText"));
            }
        } catch (SQLException e) {
            System.out.println("Error getting jokes");
        }
    }

    public static void getVerifiedJokes() {
        try {
            String query = "SELECT * FROM jokes WHERE verified = 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("jokeText"));
            }
        } catch (SQLException e) {
            System.out.println("Error getting jokes");
        }
    }

    public static void getJokeOfTheDay(){
        try{
            String query = "SELECT jokeText FROM jokes ORDER BY RAND() LIMIT 1";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("jokeText"));
                TimeUnit.HOURS.sleep(24);
            }
        } catch (SQLException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateJoke(String jokeText) {
        try {
            String query = "UPDATE jokes SET jokeText = ? WHERE jokeText = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, jokeText);
            ps.setString(2, jokeText);
            ps.executeUpdate();
            System.out.println("Joke updated successfully");

        } catch (SQLException e) {
            System.out.println("Error updating joke");
        }
    }

    @Override
    public void deleteJoke(String jokeText) {
        try {
            String query = "DELETE FROM jokes WHERE jokeText = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, jokeText);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting joke");
        }
    }

    public static void verifyJoke(String jokeText) {
        try {
            String query = "UPDATE jokes SET verified = 1 WHERE jokeText = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, jokeText);
            ps.executeUpdate();
            System.out.println("Joke verified successfully");

        } catch (SQLException e) {
            System.out.println("Error verifying joke");
        }
    }
}

package Categories.dao;

import Categories.Model.Categories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriesRepoImpl extends Categories implements CategoriesRepo{
    static Connection con = DBConfig.getCon();

    @Override
    public void createCategory(String categoryName) {
        try {
            String query = "INSERT INTO categories (categoryName) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, categoryName);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error creating category");
        }
    }

    public static void getCategories() {
        try {
            String query = "SELECT * FROM categories";
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("categoryName"));
            }
        } catch (SQLException e) {
            System.out.println("Error getting categories");
        }
    }

    @Override
    public void updateCategory(String categoryName) {
        try {
            String query = "UPDATE categories SET categoryName = ? WHERE categoryName = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, categoryName);
            ps.setString(2, categoryName);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating category");
        }
    }

    @Override
    public void deleteCategory(String categoryName) {
        try {
            String query = "DELETE FROM categories WHERE categoryName = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, categoryName);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting category");
        }
    }
}

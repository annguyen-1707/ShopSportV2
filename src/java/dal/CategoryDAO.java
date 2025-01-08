/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author -Asus-
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("c_id"),
                        rs.getString("name"),
                        rs.getString("describe"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Category getCategoryById(int c_id) {
        String sql = "select * from Categories where c_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category(rs.getInt("c_id"),
                        rs.getString("name"),
                        rs.getString("describe"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insert(Category c) {
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "([c_id]\n"
                + " ,[name]\n"
                + " ,[describe])\n"
                + " VALUES(?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getC_id());
            st.setString(2, c.getName());
            st.setString(3, c.getDescribe());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int c_id) {
        String sql = "DELETE FROM [dbo].[Categories]\n"
                + " WHERE c_id=?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Category c) {
        String sql = "UPDATE [dbo].[Categories]\n"
                + " SET [name] = ?, [describe] = ?\n"
                + " WHERE c_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getDescribe());
            st.setInt(3, c.getC_id());
            st.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
        }
    }

    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        List<Category> list = c.getAll();
        Category c1=c.getCategoryById(1);
        for (Category category : list) {
            System.out.println(category.toString());
        }
        System.out.println(c1.toString());
    }

}

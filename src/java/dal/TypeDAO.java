/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Type;

/**
 *
 * @author -Asus-
 */
public class TypeDAO extends DBContext{
    public List<Type> getAll() {
        List<Type> list = new ArrayList<>();
        String sql = "select * from Types";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Type c = new Type(rs.getInt("t_id"),
                        rs.getString("name"),
                        rs.getString("describe"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Type getTypeById(int t_id) {
        String sql = "select * from Types where t_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, t_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Type c = new Type(rs.getInt("t_id"),
                        rs.getString("name"),
                        rs.getString("describe"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insert(Type c) {
        String sql = "INSERT INTO [dbo].[Types]\n"
                + "([t_id]\n"
                + " ,[name]\n"
                + " ,[describe])\n"
                + " VALUES(?,?,?);";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getT_id());
            st.setString(2, c.getName());
            st.setString(3, c.getDescribe());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(int t_id) {
        String sql = "DELETE FROM [dbo].[Types]\n"
                + " WHERE t_id=?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, t_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Type c) {
        String sql = "UPDATE [dbo].[Types]\n"
                + " SET [name] = ?, [describe] = ?\n"
                + " WHERE t_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getDescribe());
            st.setInt(3, c.getT_id());
            st.executeUpdate();
        } catch (SQLException e) {
            // Handle exception
        }
    }

    public static void main(String[] args) {
        TypeDAO c = new TypeDAO();
        List<Type> list = c.getAll();
        Type c1=c.getTypeById(1);
        for (Type category : list) {
            System.out.println(category.toString());
        }
        System.out.println(c1.toString());
    }
}

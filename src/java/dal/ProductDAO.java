/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import dal.CategoryDAO;
import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.Category;
import model.Product;
import model.Type;

/**
 *
 * @author -Asus-
 */
public class ProductDAO extends DBContext {

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        CategoryDAO cdao = new CategoryDAO();
        TypeDAO tdao = new TypeDAO();
        String sql = "Select * from products where 1=1";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setP_id(rs.getInt("p_id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = cdao.getCategoryById(rs.getInt("c_id"));
                p.setCategory(c);
                Type t = tdao.getTypeById(rs.getInt("t_id"));
                p.setType(t);
                p.setDateRelease(rs.getDate("dateRelease"));
                p.setDiscount(rs.getDouble("discount"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> getProductsRelated(int p_id) {
        List<Product> list = new ArrayList<>();
        CategoryDAO cdao = new CategoryDAO();
        TypeDAO tdao = new TypeDAO();
        String sql = "select * from Products where t_id = (select t_id from products where p_id="+p_id+")and p_id <>"+p_id;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setP_id(rs.getInt("p_id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = cdao.getCategoryById(rs.getInt("c_id"));
                p.setCategory(c);
                Type t = tdao.getTypeById(rs.getInt("t_id"));
                p.setType(t);
                p.setDateRelease(rs.getDate("dateRelease"));
                p.setDiscount(rs.getDouble("discount"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    } 

    public List<Product> getProductsByCid(int c_id) {
        List<Product> list = new ArrayList<>();
        CategoryDAO cdao = new CategoryDAO();
        TypeDAO tdao = new TypeDAO();
        String sql = "Select * from products where 1=1";
        if (c_id != 0) {
            sql += " and c_id =" + c_id;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setP_id(rs.getInt("p_id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = cdao.getCategoryById(rs.getInt("c_id"));
                p.setCategory(c);
                Type t = tdao.getTypeById(rs.getInt("t_id"));
                p.setType(t);
                p.setDateRelease(rs.getDate("dateRelease"));
                p.setDiscount(rs.getDouble("discount"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductsByTid(int t_id) {
        List<Product> list = new ArrayList<>();
        CategoryDAO cdao = new CategoryDAO();
        TypeDAO tdao = new TypeDAO();
        String sql = "Select * from products where 1=1";
        if (t_id != 0) {
            sql += " and t_id =" + t_id;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setP_id(rs.getInt("p_id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = cdao.getCategoryById(rs.getInt("c_id"));
                p.setCategory(c);
                Type t = tdao.getTypeById(rs.getInt("t_id"));
                p.setType(t);
                p.setDateRelease(rs.getDate("dateRelease"));
                p.setDiscount(rs.getDouble("discount"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> search(int t_id, int c_id, String key, double price1, double price2, Date from, Date to) {
        List<Product> list = new ArrayList<>();
        CategoryDAO cdao = new CategoryDAO();
        TypeDAO tdao = new TypeDAO();
        String sql = "Select * from products where 1=1";
        if (t_id != 0) {
            sql += " and t_id =" + t_id;
        }
        if (c_id != 0) {
            sql += " and c_id =" + c_id;
        }
        if (price1 != 0) {
            sql += " and price >" + price1;
        }
        if (price2 != 0) {
            sql += " and price <" + price2;
        }
        if (from != null) {
            sql += " and dateRelease > '" + from + "'";
        }
        if (to != null) {
            sql += " and dateRelease < '" + to + "'";
        }
        if (key != null && !key.equals("")) {
            sql += " and (name like N'%" + key + "%' or describe like N'%" + key + "%')";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setP_id(rs.getInt("p_id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = cdao.getCategoryById(rs.getInt("c_id"));
                p.setCategory(c);
                Type t = tdao.getTypeById(rs.getInt("t_id"));
                p.setDateRelease(rs.getDate("dateRelease"));
                p.setDiscount(rs.getDouble("discount"));
                p.setType(t);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> topBuy(int n) {
        String sql = "select * from Products where p_id IN(select TOP "+n+" p_id from OrderDetails od\n"
                + "         JOIN Orders o ON o.o_id=od.o_id WHERE s_id IN(2,3) ORDER BY od.quantity DESC)";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryDAO cdao = new CategoryDAO();
                TypeDAO tdao = new TypeDAO();
                Product p = new Product();
                p.setP_id(rs.getInt("p_id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = cdao.getCategoryById(rs.getInt("c_id"));
                p.setCategory(c);
                Type t = tdao.getTypeById(rs.getInt("t_id"));
                p.setDateRelease(rs.getDate("dateRelease"));
                p.setDiscount(rs.getDouble("discount"));
                p.setType(t);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getProductsByPid(int p_id) {
        CategoryDAO cdao = new CategoryDAO();
        TypeDAO tdao = new TypeDAO();
        Product p = null;
        String sql = "Select * from products where 1=1";
        if (p_id != 0) {
            sql += " and p_id =" + p_id;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                p = new Product();
                p.setP_id(rs.getInt("p_id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = cdao.getCategoryById(rs.getInt("c_id"));
                p.setCategory(c);
                Type t = tdao.getTypeById(rs.getInt("t_id"));
                p.setDateRelease(rs.getDate("dateRelease"));
                p.setDiscount(rs.getDouble("discount"));
                p.setType(t);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }

    public void insertProduct(Product p) {
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([name]\n"
                + "           ,[price]\n"
                + "           ,[quantity]\n"
                + "           ,[c_id]\n"
                + "           ,[t_id]\n"
                + "           ,[describe]\n"
                + "           ,[image]\n"
                + "           ,[dateRelease]\n"
                + "           ,[discount])\n"
                + "     VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setInt(3, p.getQuantity());
            st.setInt(4, p.getCategory().getC_id());
            st.setInt(5, p.getType().getT_id());
            st.setString(6, p.getDescribe());
            st.setString(7, p.getImage());
            st.setDate(8, new java.sql.Date(p.getDateRelease().getTime()));
            st.setDouble(9, p.getDiscount());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteProduct(int p_id) {
        String sql = "DELETE FROM [dbo].[Products]\n"
                + "      WHERE p_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateProduct(Product p) {
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [name] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[c_id] = ?\n"
                + "      ,[t_id] = ?\n"
                + "      ,[describe] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[dateRelease] = ?\n"
                + "      ,[discount] = ?\n"
                + " WHERE p_id= ?"; // Ensure the WHERE clause uses the correct number of placeholders
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setInt(3, p.getQuantity());
            st.setInt(4, p.getCategory().getC_id());
            st.setInt(5, p.getType().getT_id());
            st.setString(6, p.getDescribe());
            st.setString(7, p.getImage());
            st.setDate(8, new java.sql.Date(p.getDateRelease().getTime()));
            st.setDouble(9, p.getDiscount());
            st.setInt(10, p.getP_id()); // This should be the last parameter as per the WHERE clause

            st.executeUpdate(); // Execute the update statement
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Product> getProductTop(int num, boolean order, String attribute) {
        List<Product> list = new ArrayList<>();
        CategoryDAO cdao = new CategoryDAO();
        TypeDAO tdao = new TypeDAO();
        String sql = "select Top " + num + " * from products order by " + attribute;
        if (order == true) {// moi nhat
            sql += " DESC";
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setP_id(rs.getInt("p_id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                Category c = cdao.getCategoryById(rs.getInt("c_id"));
                p.setCategory(c);
                Type t = tdao.getTypeById(rs.getInt("t_id"));
                p.setDateRelease(rs.getDate("dateRelease"));
                p.setDiscount(rs.getDouble("discount"));
                p.setType(t);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        ProductDAO pdao = new ProductDAO();
        List<Product> list = pdao.topBuy(4);
        for (Product product : list) {
            System.out.println(product.toString());
        }

    }

}

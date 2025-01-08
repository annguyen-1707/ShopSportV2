/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.OrderDetail;

/**
 *
 * @author -Asus-
 */
public class OrderDetailDAO extends DBContext {

    public List<OrderDetail> getAll() {
        String sql = "select * from OrderDetails"; // Assuming you have an order_details table
        List<OrderDetail> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setO_id(rs.getInt("o_id"));
                orderDetail.setP_id(rs.getInt("p_id"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetail.setPrice(rs.getDouble("price"));
                list.add(orderDetail);
            }
        } catch (SQLException e) {
            // Handle exception (e.g., log it)
        }
        return list;
    }

    public List<OrderDetail> getOrderByID(int o_id) {
        String sql = "select * from OrderDetails where o_id = " + o_id; // Assuming the table is order_details
        List<OrderDetail> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setO_id(rs.getInt("o_id"));
                orderDetail.setP_id(rs.getInt("p_id"));
                orderDetail.setQuantity(rs.getInt("quantity"));
                orderDetail.setPrice(rs.getDouble("price"));
                list.add(orderDetail);
            }
        } catch (SQLException e) {
            // Handle exception (e.g., log it)
        }
        return list;
    }

    public boolean reduceQuantity(int o_id) {
        OrderDetailDAO o = new OrderDetailDAO();
        ProductDAO pdao = new ProductDAO();
        List<OrderDetail> list = o.getOrderByID(o_id);
        for (OrderDetail od : list) {
            int quantityStore = pdao.getProductsByPid(od.getP_id()).getQuantity();
            if (quantityStore < od.getQuantity()) {
                return false;
            }
        }
        try {
            String sql3 = "UPDATE [dbo].[Products] SET [quantity] = quantity - ? WHERE p_id=?";
            PreparedStatement st3 = connection.prepareStatement(sql3);
            for (OrderDetail od : list) {

                st3.setInt(1, od.getQuantity());
                st3.setInt(2, od.getP_id());
                st3.executeUpdate();
            }
        } catch (SQLException e) {
        }
        //Cập nhật lại số lượng sp
        return true;
    }
    
    public static void main(String[] args) {
        OrderDetailDAO o = new OrderDetailDAO();
        System.out.println(o.reduceQuantity(1));
    }
}

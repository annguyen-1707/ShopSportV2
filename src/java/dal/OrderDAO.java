/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Admin;
import model.Category;
import model.Item;
import model.Order;
import model.OrderDetail;
import model.Product;
import model.Type;

/**
 *
 * @author -Asus-
 */
public class OrderDAO extends DBContext {

    public Order addOrder(Admin c, Cart cart) {
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        int o_id = 0;// id của thằng vừa sắp thêm
        try {
            String sql = "INSERT INTO [dbo].[Orders]\n"
                    + "           ([order_date]\n"
                    + "           ,[shipped_date]\n"
                    + "           ,[total_price]\n"
                    + "           ,[s_id]\n"
                    + "           ,[customer_id])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, date);
            st.setString(2, null);
            st.setDouble(3, cart.getTotalMoney());
            st.setInt(4, 1);
            st.setString(5, c.getUsername());
            st.executeUpdate();

            // lấy ra thằng id vừa them
            String sql1 = "select top 1 o_id from orders order by o_id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);

            ResultSet rs = st1.executeQuery();
            if (rs.next()) {
                o_id = rs.getInt("o_id");
                for (Item i : cart.getItems()) {
                    String sql2 = "INSERT INTO [dbo].[OrderDetails]\n"
                            + "           ([o_id]\n"
                            + "           ,[p_id]\n"
                            + "           ,[quantity]\n"
                            + "           ,[price])\n"
                            + "     VALUES(?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, o_id);
                    st2.setInt(2, i.getProduct().getP_id());
                    st2.setInt(3, i.getQuantity());
                    st2.setDouble(4, i.getPrice());
                    st2.executeUpdate();
                }
            }
        } catch (SQLException e) {
        }

        return getOrderByID(o_id);// tra lại tk order vừa thêm vào
    }

    public Order getOrderByID(int o_id) {
        String sql = "select * from orders where o_id=" + o_id;
        Order order = null;
        AdminDAO adao = new AdminDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                order = new Order();
                order.setO_id(o_id);
                order.setS_id(rs.getInt("s_id"));
                String customer_id = rs.getString("customer_id");
                Admin customer = adao.checkOnlyUser(customer_id);
                order.setCustomer(customer);
                order.setOrder_date(rs.getDate("order_date"));
                order.setShipped_date(rs.getDate("shipped_date"));
                order.setTotal_price(rs.getDouble("total_price"));
            }
        } catch (SQLException e) {
        }
        return order;
    }

    public List<Order> getAll() {
        String sql = "select * from orders";
        List<Order> list = new ArrayList<>();
        AdminDAO adao = new AdminDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setO_id(rs.getInt("o_id"));
                order.setS_id(rs.getInt("s_id"));
                String customer_id = rs.getString("customer_id");
                Admin customer = adao.checkOnlyUser(customer_id);
                order.setCustomer(customer);
                order.setOrder_date(rs.getDate("order_date"));
                order.setShipped_date(rs.getDate("shipped_date"));
                order.setTotal_price(rs.getDouble("total_price"));
                list.add(order);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public List<Order> getOrderByCustomerID(String customer_id) {
        String sql = "select * from orders where customer_id = ?";
        List<Order> list = new ArrayList<>();
        AdminDAO adao = new AdminDAO();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, customer_id);  // Setting the customer_id parameter
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setO_id(rs.getInt("o_id"));
                order.setS_id(rs.getInt("s_id"));
                Admin customer = adao.checkOnlyUser(customer_id);  // Retrieve customer based on customer_id
                order.setCustomer(customer);
                order.setOrder_date(rs.getDate("order_date"));
                order.setShipped_date(rs.getDate("shipped_date"));
                order.setTotal_price(rs.getDouble("total_price"));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Optionally handle the exception (e.g., log it)
        }
        return list;
    }

    public static void main(String[] args) {
        OrderDAO o = new OrderDAO();
        List<Order> list = o.getOrderByCustomerID("customer1");
        for (Order order : list) {
            System.out.println(order.toString());
        }
    }

}

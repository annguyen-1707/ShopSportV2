/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.Admin;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author -Asus-
 */
public class AdminDAO extends DBContext {

    public boolean changeRole(String username, int newRole) {
        Admin a=checkOnlyUser(username);
        String sql = "UPDATE Admin SET role = ? WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, newRole); // Đặt role mới
            st.setString(2, a.getUsername()); // Sử dụng username để xác định admin
            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException e) {
            System.out.println("Error updating role: " + e.getMessage());
        }
        return false; // Trả về false nếu có lỗi
    }

    public Admin check(String username, String password) {
        String sql = "select * from Admin where username = ? and password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Admin a = new Admin(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("telephone"),
                        rs.getString("address"),
                        rs.getInt("role"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Admin> getAll() {
        List<Admin> list = new ArrayList<>();
        String sql = "select * from Admin";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Admin a = new Admin(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("telephone"),
                        rs.getString("address"),
                        rs.getInt("role"));
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Admin checkOnlyUser(String username) {
        String sql = "select * from Admin where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Admin a = new Admin(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("telephone"),
                        rs.getString("address"),
                        rs.getInt("role"));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void signUser(Admin a) {
        String sql = "INSERT INTO [dbo].[Admin]\n"
                + "           ([name]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[role])\n"
                + "     VALUES (? ,?,? ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getName());
            st.setString(2, a.getUsername());
            st.setString(3, a.getPassword());
            st.setInt(4, 2);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void changePass(String user, String newPass) {
        String sql = "UPDATE [dbo].[Admin] SET [password] = ? WHERE [username] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, newPass);  // Set mật khẩu mới
            st.setString(2, user);  // Set username để xác định người dùng
            st.executeUpdate();
        } catch (SQLException e) {
            // Xử lý lỗi SQL
            System.out.println("Lỗi khi cập nhật mật khẩu: " + e.getMessage());
        }
    }

    public void updateInfor(String user, String name, String phone, String address, String pass) {
        String sql = "UPDATE [dbo].[Admin] SET ";
        boolean first = true; // Để kiểm tra trường đầu tiên có dấu phẩy không

        // Cộng thêm các trường cần cập nhật vào câu lệnh SQL
        if (name != null && !name.equals("")) {
            if (!first) {
                sql += ", ";
            }
            sql += "[name] = ?";
            first = false;
        }

        if (pass != null && !pass.equals("")) {
            if (!first) {
                sql += ", ";
            }
            sql += "[password] = ?";
            first = false;
        }

        if (phone != null && !phone.equals("")) {
            if (!first) {
                sql += ", ";
            }
            sql += "[telephone] = ?";
            first = false;
        }

        if (address != null && !address.equals("")) {
            if (!first) {
                sql += ", ";
            }
            sql += "[address] = ?";
            first = false;
        }

        // Thêm điều kiện WHERE vào cuối câu lệnh
        sql += " WHERE [username] = ?";

        try {
            // Tạo PreparedStatement từ câu lệnh SQL động
            PreparedStatement st = connection.prepareStatement(sql);

            int parameterIndex = 1;

            // Gán các giá trị cho PreparedStatement nếu chúng không null
            if (name != null && !name.equals("")) {
                st.setString(parameterIndex++, name);
            }
            if (pass != null && !pass.equals("")) {
                st.setString(parameterIndex++, pass);
            }
            if (phone != null && !phone.equals("")) {
                st.setString(parameterIndex++, phone);
            }
            if (address != null && !address.equals("")) {
                st.setString(parameterIndex++, address);
            }

            // Gán username cuối cùng
            st.setString(parameterIndex, user);
            System.out.println(sql);
            // Thực thi câu lệnh update
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        System.out.println(dao.changeRole("dung", 1));
        List<Admin> list = dao.getAll();
        for (Admin admin : list) {
            System.out.println(admin);
        }

    }

}

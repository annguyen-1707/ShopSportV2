/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Status;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author -Asus-
 */
public class StatusDAO extends DBContext {

    public List<Status> getAll() {
        List<Status> list = new ArrayList<>();
        String sql = "select * from Status"; // Adjust table name if needed
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Status s = new Status(
                        rs.getInt("s_id"), // Assuming s_id is the column for ID
                        rs.getString("s_name") // Assuming s_name is the column for name
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Status getStatusById(int s_id) {
        String sql = "select * from Status where s_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, s_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Status s = new Status(
                        rs.getInt("s_id"),
                        rs.getString("s_name")
                );
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void setStatus(int o_id, int s_id) {
        String sql = "UPDATE [dbo].[Orders] SET [s_id] = ? WHERE o_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, s_id);
            st.setInt(2, o_id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) {
        StatusDAO sdao = new StatusDAO();
        sdao.setStatus(25, 1);

    }
}

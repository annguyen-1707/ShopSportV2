/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Admin;

/**
 *
 * @author -Asus-
 */
@WebServlet(name = "InfoServlet", urlPatterns = {"/info"})
public class InfoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InfoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InfoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("info.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // đối thông tin
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");

        String confirmPassword = request.getParameter("confirmPassword");

        AdminDAO adao = new AdminDAO();
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("account");
        // Kiểm tra nếu mật khẩu mới và xác nhận mật khẩu mới khớp
        if (currentPassword != null && !currentPassword.isEmpty() & !currentPassword.equalsIgnoreCase(admin.getPassword())) {
            request.setAttribute("error", "Mật khẩu không khớp");
            request.getRequestDispatcher("info.jsp").forward(request, response);
            return;
        }
        if (newPassword != null && !newPassword.isEmpty() && !newPassword.equals(confirmPassword)) {
            // Nếu mật khẩu không khớp, trả lại thông báo lỗi
            request.setAttribute("error", "Mật khẩu mới không khớp với xác nhận mật khẩu.");
            request.getRequestDispatcher("info.jsp").forward(request, response);
            return;
        }
        System.out.println(admin.getUsername() + "," + name + "," + phone + "," + address + "," + newPassword);
        adao.updateInfor(admin.getUsername(), name, phone, address, newPassword);
        request.setAttribute("ms", "Cập nhật thông tin thành công");
        Admin adminAfterChange=adao.checkOnlyUser(admin.getUsername());
        session.setAttribute("account", adminAfterChange);
        request.getRequestDispatcher("info.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

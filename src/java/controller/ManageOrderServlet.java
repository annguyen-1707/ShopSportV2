/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.OrderDAO;
import dal.OrderDetailDAO;
import dal.StatusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Order;
import model.OrderDetail;
import model.Status;

/**
 *
 * @author -Asus-
 */
@WebServlet(name = "ManageOrderServlet", urlPatterns = {"/manageOrder"})
public class ManageOrderServlet extends HttpServlet {

    String error;

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
            out.println("<title>Servlet ManageOrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManageOrderServlet at " + request.getContextPath() + "</h1>");
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
        OrderDAO odao = new OrderDAO();
        List<Order> ordersAll = odao.getAll();
        OrderDetailDAO ddao = new OrderDetailDAO();
        List<OrderDetail> orderDetailsAll = ddao.getAll();
        request.setAttribute("ordersAll", ordersAll);
        request.setAttribute("orderDetailsAll", orderDetailsAll);
        request.setAttribute("error", error);
        error="";
        request.getRequestDispatcher("sell/manageOrder.jsp").forward(request, response);
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
        StatusDAO sdao = new StatusDAO();
        OrderDetailDAO oddao = new OrderDetailDAO();
        String o_id_raw = request.getParameter("o_id");
        String action = request.getParameter("action");
        int o_id;
        try {
            o_id = Integer.parseInt(o_id_raw);
            if (action.equals("cancelled")) {
                sdao.setStatus(o_id, 4);
            } else if (action.equals("completed")) {
                sdao.setStatus(o_id, 3);
            } else if (action.equals("accept")) {
                if (oddao.reduceQuantity(o_id)) {// th trong kho du hang
                    sdao.setStatus(o_id, 2);
                } else {
                    // th trong kho ko du hang
                    error = "Không đủ số lượng trong kho ";
                }
            }
        } catch (NumberFormatException e) {
        }
        response.sendRedirect("manageOrder");
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

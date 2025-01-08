/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import model.Product;

/**
 *
 * @author -Asus-
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

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
            out.println("<title>Servlet SearchServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath() + "</h1>");
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
        ProductDAO pdao = new ProductDAO();
        String c_id_raw = request.getParameter("category");
        String t_id_raw = request.getParameter("type");
        String key = request.getParameter("key");
        String price1_raw = request.getParameter("price1");
        String price2_raw = request.getParameter("price2");
        String from_raw = request.getParameter("from");
        String to_raw = request.getParameter("to");
        int c_id, t_id;
        double price1, price2;
        HttpSession session = request.getSession();
        Date from, to;
        try {
            c_id = (c_id_raw == null) ? 0 : Integer.parseInt(c_id_raw);
            t_id = (t_id_raw == null) ? 0 : Integer.parseInt(t_id_raw);
            price1 = (price1_raw == null || price1_raw.equals("")) ? 0 : Double.parseDouble(price1_raw);
            price2 = (price2_raw == null || price2_raw.equals("")) ? 0 : Double.parseDouble(price2_raw);
            from = (from_raw == null || from_raw.equals("")) ? null : Date.valueOf(from_raw);
            to = (to_raw == null || to_raw.equals("")) ? null : Date.valueOf(to_raw);
            List<Product> products = pdao.search(t_id, c_id, key, price1, price2, from, to);
            request.setAttribute("products", products);
            session.setAttribute("key", key);
        } catch (NumberFormatException e) {
        }
        request.getRequestDispatcher("search.jsp").forward(request, response);

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

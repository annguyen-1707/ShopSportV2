/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDAO;
import dal.ProductDAO;
import dal.TypeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import model.Category;
import model.Product;
import model.Type;

/**
 *
 * @author -Asus-
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50, // 50MB
        location = "C:\\Users\\-Asus-\\Documents\\NetBeansProjects\\ShopSportV2\\web\\image" // Set a specific directory
)
@WebServlet(name = "UpdateProductServlet", urlPatterns = {"/updateProduct"})
public class UpdateProductServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProductServlet at " + request.getContextPath() + "</h1>");
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
        String p_id_raw = request.getParameter("p_id");
        int p_id;
        try {
            p_id = Integer.parseInt(p_id_raw);
            request.setAttribute("p_id", p_id);
            ProductDAO pdao = new ProductDAO();
            Product product = pdao.getProductsByPid(p_id);
            request.setAttribute("product", product);
            request.getRequestDispatcher("sell/updateProduct.jsp").forward(request, response);
        } catch (NumberFormatException e) {
        }
        return;
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
        CategoryDAO cdao = new CategoryDAO();
        TypeDAO tdao = new TypeDAO();
        ProductDAO pdao = new ProductDAO();
        String t_id_raw = request.getParameter("type");
        String c_id_raw = request.getParameter("category");
        String quantity_raw = request.getParameter("quantity");
        String price_raw = request.getParameter("price");
        String discount_raw = request.getParameter("discount");
        String dateRelease_raw = request.getParameter("dateRelease");
        String p_id_raw = request.getParameter("p_id");

        String name = request.getParameter("name");
        String describe = request.getParameter("describe");

        int c_id, t_id, quantity, p_id;
        double price, discount;
        Date dateRelease;
        try {
            p_id = (p_id_raw == null || p_id_raw.equals("")) ? 0 : Integer.parseInt(p_id_raw);
            c_id = (c_id_raw == null || c_id_raw.equals("")) ? 0 : Integer.parseInt(c_id_raw);
            t_id = (t_id_raw == null || t_id_raw.equals("")) ? 0 : Integer.parseInt(t_id_raw);
            quantity = (quantity_raw == null) ? 0 : Integer.parseInt(quantity_raw);
            Type type = tdao.getTypeById(t_id);
            Category category = cdao.getCategoryById(c_id);
            price = (price_raw == null || price_raw.equals("")) ? 0 : Double.parseDouble(price_raw);
            discount = (discount_raw == null || discount_raw.equals("")) ? 0 : Double.parseDouble(discount_raw);
            dateRelease = (dateRelease_raw == null || dateRelease_raw.equals("")) ? null : Date.valueOf(dateRelease_raw);
//             Process the image upload
            Part part = request.getPart("image");
            String realPath = request.getServletContext().getRealPath("/image");
            String filename = Path.of(part.getSubmittedFileName()).getFileName().toString();
            System.out.println(filename);
            part.write(filename);
            if (!Files.exists(Path.of(realPath))) {
                Files.createDirectory(Path.of(realPath));
            }
            part.write(realPath + "/" + filename);
            System.out.println(filename);
            pdao.updateProduct(new Product(p_id, name, price, quantity, category, type, describe, filename, dateRelease, discount));
            response.sendRedirect("seller");

        } catch (NumberFormatException e) {
            System.out.println(e);
        }
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

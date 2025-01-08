/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.ProductDAO;

/**
 *
 * @author -Asus-
 */
public class OrderDetail {
    private int o_id,p_id,quantity;
    private double price;
    private String p_name;

    public String getP_name() {
        ProductDAO pdao=new ProductDAO();
       return pdao.getProductsByPid(p_id).getName();
    }
    public OrderDetail() {
    }

    public OrderDetail(int o_id, int p_id, int quantity, double price) {
        this.o_id = o_id;
        this.p_id = p_id;
        this.quantity = quantity;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "o_id=" + o_id + ", p_id=" + p_id + ", quantity=" + quantity + ", price=" + price + '}';
    }

    
    
    
}

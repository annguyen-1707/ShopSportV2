/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.StatusDAO;
import java.sql.Date;

/**
 *
 * @author -Asus-
 */
public class Order {

    private int o_id, s_id;
    private Date order_date;
    private Date shipped_date;
    private double total_price;
    private Admin customer;
    private String s_name;

    public Order() {
    }

    public Order(int o_id, int s_id, Date order_date, Date shipped_date, double total_price, Admin customer) {
        this.o_id = o_id;
        this.s_id = s_id;
        this.order_date = order_date;
        this.shipped_date = shipped_date;
        this.total_price = total_price;
        this.customer = customer;
    }

    public String getS_name() {
        StatusDAO sdao=new StatusDAO();
        return sdao.getStatusById(s_id).getS_name();
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public Admin getCustomer() {
        return customer;
    }

    public void setCustomer(Admin customer) {
        this.customer = customer;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getShipped_date() {
        return shipped_date;
    }

    public void setShipped_date(Date shipped_date) {
        this.shipped_date = shipped_date;
    }

    @Override
    public String toString() {
        return "Order{" + "o_id=" + o_id + ", s_id=" + s_id + ", customer_id=" + customer.getUsername() + ", order_date=" + order_date + ", shipped_date=" + shipped_date + '}';
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
/**
 *
 * @author -Asus-
 */
public class Product {
    private int p_id;
    private String name;
    private double price;
    private int quantity;
    private Category category;
    private Type type;
    private String describe,image;
    private Date dateRelease;
    private double discount;

    public Product() {
    }

    public Product(int p_id, String name, double price, int quantity, Category category, Type type, String describe, String image, Date dateRelease, double discount) {
        this.p_id = p_id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.type = type;
        this.describe = describe;
        this.image = image;
        this.dateRelease = dateRelease;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" + "p_id=" + p_id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", category=" + category + ", type=" + type + ", describe=" + describe + ", image=" + image + ", dateRelease=" + dateRelease + ", discount=" + discount + '}';
    }

    
    
    
}

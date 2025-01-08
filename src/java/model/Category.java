/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author -Asus-
 */
public class Category {
    private int c_id;
    private String name,describe;

    public Category() {
    }

    public Category(int c_id, String name, String describe) {
        this.c_id = c_id;
        this.name = name;
        this.describe = describe;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Category{" + "c_id=" + c_id + ", name=" + name + ", describe=" + describe + '}';
    }

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author -Asus-
 */
public class Type {

    private int t_id;
    private String name, describe;

    public Type() {
    }

    public Type(int t_id, String name, String describe) {
        this.t_id = t_id;
        this.name = name;
        this.describe = describe;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
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
        return "Type{" + "t_id=" + t_id + ", name=" + name + ", describe=" + describe + '}';
    }
    

}

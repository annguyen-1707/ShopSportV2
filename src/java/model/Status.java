/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.StatusDAO;

/**
 *
 * @author -Asus-
 */
public class Status {
    private int s_id;
    private String s_name;

    public Status() {
    }

    public int getS_id() {
        return s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public Status(int s_id, String s_name) {
        this.s_id = s_id;
        this.s_name = s_name;
    }

    @Override
    public String toString() {
        return "Status{" + "s_id=" + s_id + ", s_name=" + s_name + '}';
    }
    
    
}

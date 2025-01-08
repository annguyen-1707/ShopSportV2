/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author -Asus-
 */
public class Admin {

    private String name, username, password, telephone, address;
    private int role;

    public Admin() {
    }

    public Admin(String username, String password, String name, String telephone, String address, int role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.address = address;
        this.role = role;
    }

    public Admin(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Admin{" + "name=" + name + ", username=" + username + ", password=" + password + ", telephone=" + telephone + ", address=" + address + ", role=" + role + '}';
    }
    
    

}

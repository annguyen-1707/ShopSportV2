/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.ProductDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author -Asus-
 */
public class Cart {

    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public int getQuantityById(int id) {
        return getItemByID(id).getQuantity();
    }

    public Item getItemByID(int id) {
        for (Item i : items) {
            if (i.getProduct().getP_id() == id) {
                return i;
            }
        }
        return null;
    }

    public void addItem(Item t, int num) {
        if (getItemByID(t.getProduct().getP_id()) != null) {
            Item m = getItemByID(t.getProduct().getP_id());
            m.setQuantity(m.getQuantity() + num);
            System.out.println("m:" + m.getQuantity() + "t:" + num);
        } else {
            items.add(t);
        }
    }

    public void addItem(Item t) {
        if (getItemByID(t.getProduct().getP_id()) != null) {
            Item m = getItemByID(t.getProduct().getP_id());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItem(int id) {
        if (getItemByID(id) != null) {
            items.remove(getItemByID(id));
        }
    }

    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += (i.getQuantity() * i.getPrice());
        }
        return t;
    }

    private Product getProductById(int id, List<Product> list) {
        for (Product i : list) {
            if (i.getP_id() == id) {
                return i;
            }
        }
        return null;
    }

    public Cart(int p_id, int quantity, List<Product> list) {
        items = new ArrayList<>();
        Product p = getProductById(p_id, list);
        Item t = new Item(p, quantity, p.getPrice() * (100 - p.getDiscount()) / 100);
        addItem(t);
    }

    public Cart(String txt, List<Product> list) {
        items = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("/");
                for (String i : s) {
                    String[] n = i.split(":");
                    int id = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    Product p = getProductById(id, list);
                    Item t = new Item(p, quantity, p.getPrice() * (100 - p.getDiscount()) / 100);
                    addItem(t);
                }
            }
        } catch (NumberFormatException e) {
        }
    }

}

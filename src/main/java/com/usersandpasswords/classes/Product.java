/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usersandpasswords.classes;

/**
 *
 * @author MIDP9
 */
public class Product {
    protected String id;
    protected String name;
    protected int quantity;

    public Product(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void decrementQuantity(int sold){
        this.quantity -= sold;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
}

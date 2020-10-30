/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usersandpasswords.classes;

import java.time.LocalDate;

/**
 *
 * @author MIDP9
 */
public class Employed extends User{
    
    private String dpi;

    public Employed(String dpi, String name, LocalDate birthDate, String password) {
        super(name, birthDate, password);
        this.dpi = dpi;
    }

    @Override
    public String getInfoAsString() {
        return "Name: " + this.name + " DPI: " + this.dpi;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
    
    
      
}

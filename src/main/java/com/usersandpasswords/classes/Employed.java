/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usersandpasswords.classes;

import static com.usersandpasswords.information.ageUtils.AgeUtils.parseDateToString;
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
    
    
    @Override
    public String toString() {
        return "employed," +
                dpi + "," +
                name + "," +
                parseDateToString.apply(birthDate) + "," +
                password + "\n\r";
    }
    
    
      
}

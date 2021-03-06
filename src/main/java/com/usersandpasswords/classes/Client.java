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
public class Client extends User {
    
    private String nit;

    public Client(String nit, String name, LocalDate birthDate, String password) {
        super(name, birthDate, password);
        this.nit = nit;
    }
    
    @Override
    public String getInfoAsString() {
        return "Name: " + this.name + " ";
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "client," +
                nit + "," +
                name + "," +
                parseDateToString.apply(birthDate) + "," +
                password + "\n\r";
    }
    
    
    
}

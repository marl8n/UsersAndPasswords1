/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usersandpasswords.classes;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author MIDP9
 */
public abstract class User {
    protected String name;
    protected LocalDate birthDate;
    protected Integer age;
    protected String password;

    public User(String name, LocalDate birthDate, String password) {
        this.name = name;
        this.birthDate = birthDate;
        this.age = Period.between(birthDate, LocalDate.now()).getYears();
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public abstract String getInfoAsString();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usersandpasswords.information.ageUtils;

/**
 *
 * @author MIDP9
 */
public class AgeUtils {
    public static function<Integer, String> addZeros = x -> x < 9 ? "0" + x : String.valueOf(x);
}

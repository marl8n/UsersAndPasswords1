/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usersandpasswords.information.ageUtils;

import java.time.LocalDate;
import java.util.function.Function;

/**
 *
 * @author MIDP9
 */
public class AgeUtils {
    
    public static Function<Integer, String> addZeros = x -> x < 9 ? "0" + x : String.valueOf(x);
    
    public static Function<String, String[]> separateValues = date -> date.split("/");
    
    public static Function<String[], Integer[]> arrayStringToInteger = array -> {
        Integer[] parsed = new Integer[3];
        parsed[0] = Integer.valueOf(array[0]);
        parsed[1] = Integer.valueOf(array[1]);
        parsed[2] = Integer.valueOf(array[2]);
        return parsed;
    };
    
    public static TriFunction<Integer, Integer, Integer, LocalDate> parseDateTri = 
            (day, month, year) -> LocalDate.parse(
                    year + "-" + addZeros.apply(month) + "-" + addZeros.apply(day)
            );
    
    
    
    public static Function<String, LocalDate> parseDate = textDate -> {
        Integer[] dateIntegers = arrayStringToInteger.apply(separateValues.apply(textDate));
        return parseDateTri.apply(dateIntegers[0], dateIntegers[1], dateIntegers[2]);
    };
    
    public static Function<LocalDate, String> parseDateToString = localDate -> {
            int day = localDate.getDayOfMonth();
            int month = localDate.getMonthValue();
            int year = localDate.getYear();
            return day + "/" + month + "/" + year;
            };
    
    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
            
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usersandpasswords.information;

import com.usersandpasswords.classes.Client;
import com.usersandpasswords.classes.Employed;
import com.usersandpasswords.classes.Product;
import static com.usersandpasswords.information.ageUtils.AgeUtils.parseDate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 *
 * @author MIDP9
 */
public class CollectionsAndData {
    
    private static String directory = System.getProperty("user.home");
    private static String fileName = "data.txt";
    private static String filePath = directory + File.separator + fileName;
    
    private static LinkedList<Client> clients = new LinkedList<Client>();
    private static LinkedList<Employed> employeds = new LinkedList<Employed>();
    private static LinkedList<Product> products = new LinkedList<Product>();
    
    public static void addEmployed(Employed employed){
        employeds.add(employed);
    }
    
    public static Stream<Employed> getEmployedsAsStream(){
        return employeds.stream();
    }
    
    public static void addClient(Client client){
        clients.add(client);
    }
    
    public static Stream<Client> getClientsAsStream(){
        return clients.stream();
    }
    
    public static void addProduct(Product product){
        products.add(product);
    }
    
    public Stream<Product> getProductsAsString(){
        return products.stream();
    }
    
    public static void readFileClients(){
        
        Pattern pat = Pattern.compile("^client,\\w+,\\w+,\\w+,\\w+,\\w$");
        
        try {
            FileReader r = new FileReader(filePath);
            BufferedReader br = new BufferedReader(r);
            String line;
            while ( (line = br.readLine() ) != null){
                Matcher matcher = pat.matcher(line);
                if(matcher.find()){
                    String [] dataClient = line.split(",");
                    //String nit, String name, LocalDate birthDate, String password
                    addClient(
                            new Client(
                            dataClient[1],
                            dataClient[2],
                            parseDate.apply(dataClient[3]),
                            dataClient[4]
                            )
                    );
                }
            }
            r.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CollectionsAndData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CollectionsAndData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void readFileEmployed() {
        Pattern pat = Pattern.compile("^employed,\\w+,\\w+,\\w+,\\w+,\\w+");
        
        try {
            FileReader r = new FileReader(filePath);
            BufferedReader br = new BufferedReader(r);
            String line;
            while ( (line = br.readLine() ) != null){
                Matcher matcher = pat.matcher(line);
                if(matcher.find()){
                    String [] dataEmployed = line.split(",");
                    // String dpi, String name, LocalDate birthDate, String password
                    addEmployed(
                            new Employed(
                            dataEmployed[1],
                            dataEmployed[2],
                            parseDate.apply(dataEmployed[3]),
                            dataEmployed[4]
                            )
                    );
                }
            }
            r.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CollectionsAndData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CollectionsAndData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void readFileProduct() {
        Pattern pat = Pattern.compile("^product,\\w+,\\w+,\\w+$");
        try {
            FileReader r = new FileReader(filePath);
            BufferedReader br = new BufferedReader(r);
            String line;
            while ( (line = br.readLine() ) != null ) {
                Matcher matcher = pat.matcher(line);
                if(matcher.find()){
                    String [] dataProduct = line.split(",");
                    //String id, String name, int quantity
                    addProduct(
                            new Product(
                            dataProduct[1],
                            dataProduct[2],
                            Integer.valueOf(dataProduct[3])
                            )
                    );
                }
            }
            r.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CollectionsAndData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CollectionsAndData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void saveInfo(){
        String doc = "";
        try {
            FileWriter w = new FileWriter(filePath);
            for(int i = 0; i < clients.size(); i++){
                doc = doc.concat(clients.get(i).toString());
            }
            for(int i = 0; i < employeds.size(); i++ ) {
                doc = doc.concat(employeds.get(i).toString());
            }
            for(int i = 0; i < products.size(); i++ ) {
                doc = doc.concat(products.get(i).toString());
            }
            w.close();
        } catch (IOException ex) {
            Logger.getLogger(CollectionsAndData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
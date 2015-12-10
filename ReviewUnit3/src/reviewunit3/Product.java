/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reviewunit3;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author tecnologic
 */
public class Product implements Comparable{
    int idNum = 0;
    double price = 0.0;
    
    /*public void Product(){
        
    }*/
    
    public Product(int id, double value){
        idNum = id;
        price = value;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public int compareTo(Object o){
        Product proC = (Product)o;
        
        if(proC.price < this.price){
            return 1;
        }else if(this.price < proC.price){
            return -1;
        }
        
        return 0;
    }
    
    @Override
    public String toString(){
        DecimalFormat pFormat = new DecimalFormat("0.00");
        NumberFormat idFormat = new DecimalFormat("000000");
        
        return "Product ID: " + idFormat.format(idNum) + " -- Price $" + pFormat.format(price);
    }
}

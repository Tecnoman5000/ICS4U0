/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursionpratice;

/**
 *
 * @author tecnologic
 */
public class RecursionMethods {
    
    public int fact(int n){
        if(n == 1){
            return n;
        }else{
            return n * fact(n-1);
        }
    }
    
    public int sum(int n){
        if(n == 1){
            return n;
        }else{
            return n + sum(n-1);
        }
    }
    
    public void countUp(int n){
        if(n == 1){
            System.out.println(n);
        }else{
            this.countUp(n-1);
            System.out.println(n);
        }
    }
    
    public void countDown(int n){
        if(n == 1){
            System.out.println(n);
        }else{
            System.out.println(n);
            this.countDown(n-1);
        }
    }
    
    public void reverse(String s){
        if(s.length() ==1){
            System.out.print(s);
        }else{
            this.reverse(s.substring(1, s.length()));
            System.out.print(s.charAt(0));
        }
    }
}

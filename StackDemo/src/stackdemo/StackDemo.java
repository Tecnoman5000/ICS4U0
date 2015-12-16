/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackdemo;

import java.util.Random;

/**
 *
 * @author tecnologic
 */
public class StackDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack s = new Stack();
        Random rand = new Random();
        
        for(int i=0; i < rand.nextInt(100); i++){
            s.push(rand.nextInt(1000));
        }
        
        System.out.println("Top of stack: " + s.top() 
                + "\nWhole Stack: " + s.toString());
        
        s.pop();
        System.out.println("One removed, New Stack: " + s.toString());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetask;

import java.util.Random;

/**
 *
 * @author tecnologic
 */
public class PrimeTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UtilityMethods um = new UtilityMethods();
        Random rand = new Random();
        //System.out.println(um.isPrime(-4));
        for(int i=rand.nextInt(100); i > 0; i--){
            int tmp = rand.nextInt(1000)-500;
            System.out.println("Is " + tmp + " prime? -- " + um.isPrime(tmp));
        }
        
        
    }
    
}

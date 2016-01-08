/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primetask;

/**
 *
 * @author tecnologic
 */
public class UtilityMethods{    
    
    public boolean isPrime(int n){
        if(this.isNeg(n)){
            n = n * -1;
        }
        for(int i = n-1; i > 1; i--){
            //System.out.println(n + "/" +i+": " + (n%i == 0));
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    
    public boolean isNeg(int n){
        return (n < 0);
    }
}

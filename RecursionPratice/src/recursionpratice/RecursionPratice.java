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
public class RecursionPratice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RecursionMethods rm = new RecursionMethods();
        
        System.out.println(rm.fact(4)+"\n");
        System.out.println(rm.sum(3)+"\n");
        rm.countUp(5);
        System.out.println();
        rm.countDown(5);
        System.out.println();
        System.out.print("peanut -- ");
        rm.reverse("peanut");
        System.out.println("\n");
    }
}

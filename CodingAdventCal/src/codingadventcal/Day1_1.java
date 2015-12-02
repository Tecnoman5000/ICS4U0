/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingadventcal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tecnologic
 */
public class Day1_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        ArrayList<Integer> d1Results = new ArrayList<>();
        d1Results = dayOne("d1.txt");
        System.out.println("End Level: " + d1Results.get(0));
        System.out.println("Pos: " + d1Results.get(1));
        
        
    }
    /*public static ArrayList<Integer> dayTwo(String fileName){
        
    }*/
    
    public static ArrayList<Integer> dayOne(String fileName){
        ArrayList<Character> levels = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();
        String text = "";
        String output = "";
        
        try{
            File inputFile = new File(fileName);
            Scanner input = new Scanner(inputFile);
            text = input.next();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        for(int i=0; i < text.length(); i++){
            levels.add(text.charAt(i));
        }
        
        boolean posFound = false;
        int pos = 0;
        int index = 0;
        int level = 0;
        for(Character move : levels){
            if(move == '('){
                level++;
                output += ("Moves up ( '" + move + "' ) \n");
            }else if(move == ')'){
                level--;
                output += ("Moves down ( '" + move + "' ) \n");
            }
            if(level == -1 && !posFound){
                pos = index+1;
                posFound = true;
            }
            index++;
        }
        
        results.add(level);
        results.add(pos);
        return results;
    }
    
}

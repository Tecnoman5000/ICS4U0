/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingadventcal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
        /*ArrayList<Integer> d1Results = new ArrayList<>();
        d1Results = dayOne("d1.txt");
        System.out.println("End Level: " + d1Results.get(0));
        System.out.println("Pos: " + d1Results.get(1));*/
        
        dayTwo("d2.txt");
        
    }
    public static ArrayList<Integer> dayTwo(String fileName){
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<Integer> dimensions = new ArrayList<>();
        try{
            File inputFile = new File(fileName);
            Scanner input = new Scanner(inputFile);
            while(input.hasNext()){
                String line = input.nextLine();
                int intStart = 0;
                for(int i=0; i<line.length(); i++){
                    if(line.charAt(i) == 'x'){
                        dimensions.add(Integer.parseInt(line.substring(intStart, i)));
                        intStart = i+1;
                    }else if(i == line.length()-1){
                        dimensions.add(Integer.parseInt(line.substring(intStart, i+1)));
                    }
                }
                int[] values = new int[3];
                int index = 0;
                for(int i=1; i <= 3;i++){
                    int value = dimensions.get(dimensions.size()-i);
                    values[i-1] = value;
                }
                System.out.println(line + " : " + Arrays.toString(values));
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        System.out.println("Number of Values: " + dimensions.size());
        
        int[][] dimensionsArray = new int[dimensions.size()/3][3];
        for(int i=0; i<dimensionsArray.length*3; i += 3){
            for(int d=0; d<3; d++){
                int index = i + d;
                dimensionsArray[i/3][d] = dimensions.get(index);
            }
        }
        System.out.println("Number of presents: " + dimensionsArray.length);
        
        int totalWrap = 0;
        int totalRibbon = 0;
        for(int[] dim : dimensionsArray){
            Arrays.sort(dim); // Sort the Array
            
            // First Challenge
            totalWrap += 2 * dim[0] * dim[1];
            totalWrap += 2 * dim[1] * dim[2];
            totalWrap += 2 * dim[0] * dim[2];
            totalWrap += dim[0] * dim[1];
            
            // Second Challenge
            totalRibbon += (dim[0] * 2) + (dim[1] * 2);
            totalRibbon += dim[0] * dim[1] * dim[2];
        }
        results.add(totalWrap);
        results.add(totalRibbon);
        
        /*String output = "";
        for(int[] dimA : dimensionsArray){
            for(int dim : dimA){
                output += dim + "\t";
            }
            output += "\n";
        }*/
        
        System.out.println("Total Paper Needed: " + totalWrap);
        System.out.println("Total Ribbon Needed: " + totalRibbon);
        return results;
    }
    
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

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
        ArrayList<Integer> d1Results = dayOne("d1.txt");
        System.out.println("----------- Day One ------------");
        System.out.println("End Level: " + d1Results.get(0));
        System.out.println("Pos: " + d1Results.get(1));
        
        ArrayList<Integer> d2Results = dayTwo("d2.txt");
        System.out.println("----------- Day Two ------------");
        System.out.println("Total Paper Needed: " + d2Results.get(0));
        System.out.println("Total Ribbon Needed: " + d2Results.get(1));
        
        System.out.println("----------- Day Three ------------");
        ArrayList<Integer> d3Results = dayThree("d3.txt");
    }
    
    public static ArrayList<Integer> dayThree(String fileName){
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<Character> directions = new ArrayList<>();
        String text = "";
        try{
            File inputFile = new File(fileName);
            Scanner input = new Scanner(inputFile);
            text = input.next();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        for(int i=0; i < text.length(); i++){
            directions.add(text.charAt(i));
        }
        System.out.println("Number of Directions: " + directions.size());
        
        ArrayList<int[]> locs = new ArrayList<>();
        int houses = 0;
        for(char move : directions){
            if(locs.isEmpty()){
                System.out.println("Locs is Empty");
                int[] initLoc = {0,0};
                locs.add(calcMove(initLoc, move));
                houses++;
            }else{
                int[] current = calcMove(locs.get(locs.size()-1), move);
                System.out.println(locs.contains(current) + " vs " + containsLoc(current, locs));
                if(!locs.contains(current)){
                    locs.add(current);
                    houses++;
                }
            }
            //System.out.println("Num House: " + houses);
            
        }
        System.out.println("Houses w/ > 0 presents: " + houses);
        
        return results;
    }
    
    public static boolean containsLoc(int[] current, ArrayList locs){
        boolean contains = false;
        ArrayList<int []> givenLocs = locs;
        for(int[] loc : givenLocs){
            System.out.println(loc[0] + "," + loc[1] +" vs " + current[0] + "," + current[1]);
            if(loc[0] == current[0] && loc[1] == current[1]){
                contains = true;
            }
        }
        return contains;
    }
    
    public static int[] calcMove(int[] loc, char move){
        int[] previous = loc;
        System.out.print("Previous: " + Arrays.toString(previous));
        if(move == '<'){
            previous[0]--;
        }
        if(move == '>'){
            previous[0]++;
        }
        if(move == '^'){
            previous[1]++;
        }
        if(move == 'v'){
            previous[1]--;
        }
        System.out.println(" Move: " + move + " Current: " 
            + Arrays.toString(previous));
        return previous;
    }
    
    public static ArrayList<Integer> dayTwo(String fileName){
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<Integer> dimensions = new ArrayList<>();
        String output = "";
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
                output += (line + " : " + Arrays.toString(values) + "\n");
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        
        output += ("Number of Values: " + dimensions.size() + "\n");
        
        int[][] dimensionsArray = new int[dimensions.size()/3][3];
        for(int i=0; i<dimensionsArray.length*3; i += 3){
            for(int d=0; d<3; d++){
                int index = i + d;
                dimensionsArray[i/3][d] = dimensions.get(index);
            }
        }
        output += ("Number of presents: " + dimensionsArray.length + "\n");
        
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

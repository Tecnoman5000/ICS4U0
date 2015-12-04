/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingadventcal;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.security.MessageDigest;

/**
 *
 * @author tecnologic
 */
public class Challenges {
            
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
        // Challenge 1 complete, 2 incomplete (broken)
        ArrayList<Integer> d3Results = dayThree("d3.txt");
        
        System.out.println("----------- Day Four ------------");
        ArrayList<Integer> d4Results = dayFour("ckczppom");
        System.out.println("Answer 1: " + d4Results.get(0));
        System.out.println("Answer 2: " + d4Results.get(1));
    }
    
    public static ArrayList<Integer> dayFour(String input){
        ArrayList<Integer> results = new ArrayList<>();
        String stringMD5 = "";
        
        boolean ansFnd1 = false;
        boolean ansFnd2 = false;
        int index = 1;
        while(!ansFnd1 && !ansFnd2){
            stringMD5 = getMD5(input + index);
            if(stringMD5.substring(0, 5).equals("00000")){
                results.add(index);
                System.out.println(index);
                ansFnd1 = true;
            }
            if(stringMD5.substring(0, 6).equals("000000")){
                results.add(index);
                System.out.println(index);
                ansFnd2 = true;
            }
            if(index%1000 == 0){
                //System.out.println("Tried Between 0 - " + index);
            }
            index++;
        }
        
        //System.out.println("MD5 hash: " + stringMD5 + " -- Answer: " + answer);
        
        return results;
    }
    
    public static String getMD5(String input){
        String hashtext = "";
        try{
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(input.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1,digest);
            hashtext = bigInt.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while(hashtext.length() < 32 ){
              hashtext = "0"+hashtext;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        return hashtext;
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
        
        int houses = getHouses(directions);
        System.out.println("Houses w/ > 0 presents: " + houses);
        
        ArrayList<Character> dirSanta = new ArrayList<>();
        ArrayList<Character> dirRobo = new ArrayList<>();

        boolean robo = false;
        for(char move : directions){
            if(!robo){
                dirSanta.add(move);
                robo = true;
            }else{
                dirRobo.add(move);
                robo = false;
            }
        }
        
        int housesSanta = getHouses(dirSanta);
        int housesRobo = getHouses(dirRobo);
        int housesTotal = housesSanta + housesRobo + 1;
        System.out.println("Total Houses: " + housesTotal);
        
        return results;
    }
    public static int getHouses(ArrayList<Character> dir){
        ArrayList<int[]> locs = new ArrayList<>();
        int houses = 0;
        int[] previous = {0, 0};
        for(char move : dir){
            int[] current = calcMove(previous, move);
            //System.out.println("Locs Size: " + locs.size() + " : " + Arrays.toString(previous));
            //System.out.println(locs.contains(current) + " vs " + containsLoc(current, locs));
            if(!containsLoc(current, locs)){
                //System.out.println("Loc added");
                locs.add(current);
                houses++;
            }else{
                //System.out.println("Same, Loc not added");
            }
            previous = current;
            //System.out.println("Num House: " + houses);
            
        }
        return houses;
    }
    
    public static boolean containsLoc(int[] current, ArrayList locs){
        boolean contains = false;
        ArrayList<int []> givenLocs = locs;
        for(int[] loc : givenLocs){
            //System.out.println(loc[0] + "," + loc[1] +" vs " + current[0] + "," + current[1]);
            if(loc[0] == current[0] && loc[1] == current[1]){
                contains = true;
            }
        }
        return contains;
    }
    
    public static int[] calcMove(int[] loc, char move){
        int[] previous = new int[2];
        previous[0] = loc[0];
        previous[1] = loc[1];
        //System.out.print("Previous: " + Arrays.toString(previous));
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
        //System.out.println(" Move: " + move + " Current: " 
        //    + Arrays.toString(previous));
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

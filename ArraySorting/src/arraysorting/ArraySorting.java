package arraysorting;

import java.util.Arrays;

/**
@author tecnologic
**/
public class ArraySorting {
    
    public static void main(String[] args) {
        int[][] array = new int[2][50]; // Create the array
        setArray(array); // Fill the array with random numbers
        System.out.println("-------- Even Array (Unsorted)---------");
        System.out.println(getArrayString(array[0])); // Print 
        System.out.println("-------- Odd Array (Unsorted)---------");
        System.out.println(getArrayString(array[1])); // Print
        
        Arrays.sort(array[0]); // sort in accending order
        System.out.println("-------- Even Array (Sorted: Ascending)---------");
        System.out.println(getArrayString(array[0])); // Print 
        
        getNegative(array[1]); // Flip values to negative
        Arrays.sort(array[1]); // Sort in accdening order
        getNegative(array[1]); // Flip values back o positive (-1 * -1)
        System.out.println("-------- Odd Array (Sorted: Descending)---------");
        System.out.println(getArrayString(array[1])); // Print
        
    }
    
    // Fill array method
    public static void setArray(int[][] array){
        int l1=0; // even array
        for(int l2=0; l2 < array[l1].length; l2++){
            array[l1][l2] = getNum(0, 198, true); // True for get and Even num
        }
        l1 = 1; // odd array
        for(int l2=0; l2 < array[l1].length; l2++){
            array[l1][l2] = getNum(1, 199, false); // False for get and odd num
        }
    }
    
    // Used to random numbers base on parameters 
    public static int getNum(int min, int max, boolean getEven){
        int num = 0; // hold the num
        max = max - (min - 1); // format the max value
        num = min + (int)(Math.random()*max); // get the random num
        
        //System.out.println(num); // Debugging
        if(getEven){
            if(num%2 != 0){ // if remainder when divided by 2 is not zero 
                num--; // sutract one (197 - 1 = 196; 1 - 1 = 0)
                //System.out.println("Was Odd"); // Debugging
            }else{
                //System.out.println("Is Even"); // Debugging
            }
        }else if(!getEven){
            if(num%2 == 0){ // if remainder when divided by 2 is zero
                num--; // subtract one (198 - 1 = 197; 2 - 1 = 1)
               //System.out.println("Was Even"); // Debugging
            }else{
                //System.out.println("Is Odd"); // Debugging
            }
        }
        return num;
    }
    
    // convert array to negative
    public static void getNegative(int[] array){
        for(int i=0; i < array.length; i++){
            array[i] = -array[i]; // multiply array value by -1
        }
    }
    
    // get formated string of array
    public static String getArrayString(int[] array){
        String aString = ""; // hold print string
        for(int l2=0; l2 < array.length; l2++){
            aString += array[l2]; // add value to String
            if((l2+1)%10 == 0){ // if multiple of 10 goto new line
                aString += "\n";
            }else{ // if not, add tab
                aString += "\t";
            }
        }
        return aString;
    }
}

package goldsearch;

/**
@author tecnologic
**/
public class GoldSearch {
    // Plots Arrays
    static int[][] property = new int[10][10];
    static int[][] propertyRefined = new int[8][8];
    
    // Main thread
    public static void main(String[] args) {
        
        //////////////////
        //// Step One ////
        //////////////////
        initArray(); // Initalize the array; fill with random values
        int max = getMax(); // Get the largest number in the array
        int min = getMin(); // Get the smallest number in the array
        double avg = getAvg(); // Get the avgerage of all the values in the array
        
        // Print out generated information
        System.out.println(getPrintOut(property)); // Use function to print Array
        System.out.println("Max:\t" + max + "\nMin:\t" + min // Print values
                + "\nAverage\t" + avg + "\n");
        
        //////////////////
        //// Step Two ////
        //////////////////
        refineArray(); // Call function to refine the array (look for spots of interest)
        
        // Print out generated values
        System.out.print(getPrintOut(propertyRefined)); // Print array
        System.out.println("Number with value above 50: " + getAbove50());
    }
    
    // Getter method for randum numbers
    public static int getRandomNum(int max, int min){
        max = max - (min - 1); //set max
        int randomNum = min + (int)(Math.random()*max); //grab random num
        return randomNum; // retrun number
    }
    // Void method for filling array
    public static void initArray(){
        for(int l1 = 0; l1 < property.length; l1++){ // Number of arrays in array
            for(int l2 = 0; l2 < property[l1].length; l2++){ // Number of spots in array
                property[l1][l2] = getRandomNum(20, -10); // Fill with random values between -10 to 20
            }
        }
    }
    // Getter "double" method for generating the avgerage 
    public static double getAvg(){
        double avg = 0; // init double cup
        
        // For loop used to get the total value of the arrays 
        for(int l1 = 0; l1 < property.length; l1++){ // Number of arrays in array
            for(int l2 = 0; l2 < property[l1].length; l2++){ // Number of spots in array
                avg += property[l1][l2]; // 
            }
        }
        
        // Get the average (mean)
        avg = avg / (property.length * property[0].length);
        return avg;
    }
    // Getter "intager" method for generating the largest number in the arrays
    public static int getMax(){
        int max = -10; // init int cup; starting at the lowest possible value
        for(int l1 = 0; l1 < property.length; l1++){
            for(int l2 = 0; l2 < property[l1].length; l2++){
                if(max < property[l1][l2]){ // if value larger than minimun
                    max = property[l1][l2]; // set max to current
                }
            }
        }
        return max;
    }
    // Getter "intager" method for generating the smallest numbe in the arrays
    public static int getMin(){
        int min = 20; // init int cup; starting at the highest possible value
        for(int l1 = 0; l1 < property.length; l1++){
            for(int l2 = 0; l2 < property[l1].length; l2++){
                if(min > property[l1][l2]){ // if value smaller than maximun
                    min = property[l1][l2]; // set min to current
                }
            }
        }
        return min;
    }
    // Void method for refining the array
    public static void refineArray(){
        /*
        this is where the fun happens...
            so because we are going from a 10 x 10 plot to an 8 x 8
            we have to put some restriction on what values we are 
            manipulting. Based on the example on the sheet, we are 
            excluding the values in the top and bottom row (array[0 & 9])
            and the first and last columns (array[1-8][0 & 9]). This is 
            reflected in the for loop.
        */
        // Start at array one and end on the second last array
        for(int l1 = 1; l1 < property.length-1; l1++){
            // Start in the first postion and end on the second last position
            for(int l2 = 1; l2 < property[l1].length-1; l2++){
                // Order: Center, Left, Right, Top, Bottom
                propertyRefined[l1-1][l2-1] = property[l1][l2]
                        + property[l1][l2-1] + property[l1][l2+1]
                        + property[l1-1][l2] + property[l1+1][l2];
            }
        }
    }
    // Getter "intager" method for generating the number of values in the
    //  refined array that are above 50
    public static int getAbove50(){
        int numAbove = 0; //  init int cup
        for(int l1 = 0; l1 < propertyRefined.length; l1++){
            for(int l2 = 0; l2 < propertyRefined[l1].length; l2++){
                if(propertyRefined[l1][l2] > 50){ // if greater than 50
                    numAbove++; // Add one to the int cup
                }
            }
        }
        return numAbove;
    }
    
    // Getter "String" method for creating a string for printing out based
    //  on the given 2d int array
    public static String getPrintOut(int[][] array){
        String printOut = ""; // init String cup
        for(int l1 = 0; l1 < array.length; l1++){
            for(int l2 = 0; l2 < array[l1].length; l2++){
                printOut += array[l1][l2]; // add the value
                if(l2 == array[l1].length - 1){ // if end of array add new line
                    printOut += "\n";
                }else{ // if inbetween numbers and tab
                    printOut += "\t";
                }
            }
        }
        return printOut;
    } 
}

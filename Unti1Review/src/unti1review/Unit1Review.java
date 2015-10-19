package unti1review;
public final class Unit1Review {
    int avg = 0;
    int numAbove = 0;
    
    public Unit1Review(){
        init();
    }
    
    public void init(){
        // Step 1
        int[] testArray = new int[100];
        popArray(testArray);
        
        // Step 2
        avg = calcAvg(testArray);
        
        // Step 3
        numAbove = numAboveAvg(testArray, avg);
    }
     
    // Add values to each place in the array
    public void popArray(int[] testArray){
        for(int i=0; i < testArray.length; i++){
            testArray[i] = getRandomNum(10, 1);
        }
    }
    
    // Get the mean average of the array
    public int calcAvg(int[] testArray){
        int total = 0;
        for(int i=0; i < testArray.length; i++){
            total += testArray[i];
        }
        
        int avg = total / 100;
        return avg;
    }
    
    // Count number of values in the array above avg
    public int numAboveAvg(int[] testArray, int avg){
        int numAbove = 0;
        for(int i=0; i < testArray.length; i++){
            if(testArray[i] >= avg){
                numAbove++;
            }
        }
        
        return numAbove;
    }
    
    // Getter method for randum numbers
    public int getRandomNum(int max, int min){
        max = max - (min - 1); //set max
        int randomNum = min + (int)(Math.random()*max); //grab random num
        return randomNum; // retrun number
    }
    
    public int getAvg(){
        return avg;
    }
    
    public int getNumAboveAvg(){
        return numAbove;
    }
    
}

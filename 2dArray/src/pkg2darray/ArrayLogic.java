/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2darray;

/**
 *
 * @author tecnologic
 */
public class ArrayLogic {

    /**
     * @param args the command line arguments
     */
    int[][] randNums = new int[10][10];
    
    public ArrayLogic(){
        this.fillArray();
    }
    
    // Fill Array
    public  void fillArray(){
        for(int l1 = 0; l1 < randNums.length; l1++){
            for(int l2 = 0; l2 < randNums[l1].length; l2++){
                randNums[l1][l2] = getRandomNum(10000, 0);
            }
        }
    }
    
    public double getAvg(){
        double avg = 0;
        for(int l1 = 0; l1 < randNums.length; l1++){
            for(int l2 = 0; l2 < randNums[l1].length; l2++){
                avg += randNums[l1][l2];
            }
        }
        avg = avg / (randNums.length * randNums[0].length);
        return avg;
    }
    
    public int getTotal(){
        int total = 0;
        for(int l1 = 0; l1 < randNums.length; l1++){
            for(int l2 = 0; l2 < randNums[l1].length; l2++){
                total += randNums[l1][l2];
            }
        }
        return total;
    }
    
    public int getMax(){
        int max = 0;
        for(int l1 = 0; l1 < randNums.length; l1++){
            for(int l2 = 0; l2 < randNums[l1].length; l2++){
                if(max < randNums[l1][l2]){
                    max = randNums[l1][l2];
                }
            }
        }
        return max;
    }
    public int getMin(){
        int min = 1000;
        for(int l1 = 0; l1 < randNums.length; l1++){
            for(int l2 = 0; l2 < randNums[l1].length; l2++){
                if(min > randNums[l1][l2]){
                    min = randNums[l1][l2];
                }
            }
        }
        return min;
    }
    public String getPrintOut(){
        String printOut = "";
        for(int l1 = 0; l1 < randNums.length; l1++){
            for(int l2 = 0; l2 < randNums[l1].length; l2++){
                printOut += randNums[l1][l2];
                if(l2 == randNums[l1].length - 1){
                    printOut += "\n";
                }else{
                    printOut += "\t";
                }
            }
        }
        return printOut;
    }
    
    // Getter method for randum numbers
    public int getRandomNum(int max, int min){
        max = max - (min - 1); //set max
        int randomNum = min + (int)(Math.random()*max); //grab random num
        return randomNum; // retrun number
    }
    
}

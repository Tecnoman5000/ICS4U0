package cpcsales;

// imports
import java.io.BufferedWriter; // for writing to file
import java.io.File; // for handeling files
import java.io.FileNotFoundException;
import java.io.FileWriter; // for writting to file
import java.io.IOException; // handeling file io problems
import java.text.DecimalFormat; // for formating currency output
import java.util.Arrays; // for dealing with arrays
import java.util.Scanner; // for handeling file input

public class CPCSales {
    public static void main(String[] args) {
        String[] salesTeam = {"Grew", "Wills", "Kotecha", "Ross"}; // sale person's names
        double[] saleRevenues = {0, 0, 0, 0}; // hold sale amounts per sales person
        int[] saleNums = {0, 0, 0, 0}; // number of sales per person
        
        /*
            These two arrays are connected*. A place in the salesTeam array will hold the
            name of the sales person, the same place in the saleRevenues array holds the 
            revenue associated with the sales person.
                ex: salesTeam[3] holds name, 
                    saleRevenues[3] holds revenue, 
                        saleNums[3] holds number of sales
        */
        
        makeTestFile(getRandomNum(4, 250), "sales.txt"); // Create Random* test file
        
        // Grab file data
        try{
            File sales = new File("sales.txt"); // file remote
            Scanner scanFile = new Scanner(sales); // scanner remote
            while(scanFile.hasNext()){ // while the scanner has a line from the file
                int saleCode = scanFile.nextInt(); // Get sales person number
                double saleAmount = scanFile.nextDouble(); // Get sale amount
                saleRevenues[saleCode-1] += saleAmount; // add amount to sales person's total
                saleNums[saleCode-1]++;
            }
        }catch(FileNotFoundException e){
            System.out.println("'File not Found! :" + e); // print error information
        }
        
        // format log output
        String logOutput = "";
        for(int i=0; i < salesTeam.length; i++){
            // pinrt information for whole sales team
            logOutput += salesTeam[i] + " had " + getCurrencyFormat(saleRevenues[i]) + " in revenue from " + saleNums[i] +" sales. \n";
        }
        System.out.println(logOutput);
        
        double topSale = topSales(saleRevenues); // get top sale
        
        // compare top sale to sale team to find top sales person
        String topPerson = "";
        String topNumSales = "";
        for(int i=0; i < saleRevenues.length; i++){
            if(topSale == saleRevenues[i]){
                topPerson = salesTeam[i]; // set top sales person
                topNumSales = saleNums[i] + ""; // set top person's number of sales
                break; // once found, stop loop
            }
        }
        double bonusCheque = topSale * 0.05; // Get bonus cheque amount
        
        // output top sales information
        System.out.println("Top Sales person was: " + topPerson + ", with " 
                + getCurrencyFormat(topSale) + " in revenue, from " 
                + topNumSales + " sales! Bonus Cheque: " 
                + getCurrencyFormat(bonusCheque));
    }
    
    // Get top sale
    public static double topSales(double[] sales){
        double[] tmpSales = {sales[0], sales[1], sales[2], sales[3]}; // use temporary array for sorting
        Arrays.sort(tmpSales); // sort array in accending order using library
        return tmpSales[tmpSales.length-1]; // return highest value (last position in the array)
    }
    
    // make test file for program
    public static void makeTestFile(int numSales, String fileName){
        try{
            File salesFile = new File(fileName); // create remote for file
            try (BufferedWriter output = new BufferedWriter(new FileWriter(salesFile))) {
                for(int i=0; i < numSales; i++){
                    output.append(getRandomNum(4, 1) + ""); // get random sale code
                    output.newLine(); // new line in file
                    output.append(getRandomDouble(10.00, 250.00) + ""); // get random sale amount 
                    output.newLine(); // new line in file
                }
            }
        }catch(IOException e){
            System.out.println(e); // Print Error information
        }
    }
    
    // get function for output formating
    public static String getCurrencyFormat(double unformated){
        DecimalFormat currency = new DecimalFormat("$00.00"); // set formate
        String formated = currency.format(unformated); // formate double
        return formated; // return formated double as string
    }
    
    // Getter method for randum numbers
    public static int getRandomNum(int max, int min){
        max = max - (min - 1); //set max
        int randomNum = min + (int)(Math.random()*max); //grab random num
        return randomNum; // retrun number
    }
    public static double getRandomDouble(double max, double min){
        max = max - (min - 1); //set max
        double randomNum = min + (Math.random()*max); //grab random num
        return randomNum; // return number
    }
}
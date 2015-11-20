package javapiechart;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 @author tecnologic
**/
public class FileProcessor {
    Scanner file; // File 
    String[] names = new String[3]; // Contestent Names
    int[] votes = new int[3]; // Number of votes
    double[] percents = new double[3]; // percent of votes
    int total; // Total number of votes
    public FileProcessor(String fileName) throws FileNotFoundException{
        try{ // Don't be silly, wrap your exceptions...
            File fileGiven = new File(fileName); // File Reference
            FileReader fw = new FileReader(fileGiven); // File Reader
            BufferedReader bReader = new BufferedReader(fw); // Buff IT
            file = new Scanner(bReader); // add buffed reader to Scanner
        }catch(FileNotFoundException e){
            System.out.println("'File not Found! :" + e); // print error information
        }
    }
    
    // Used to grab the names from the file
    public String[] getNames(){
        for(int n=0; n<3; n++){ // First Three line are the names
            names[n] = file.nextLine();
        }
        return names; 
    }
    
    // Tally the votes; the rest of the line in the file
    public void tallyVotes(){
        while(file.hasNext()){ // While the scanner can get a new line
            votes[file.nextInt()-1]++; // Vote corrisponds with array placement
        }
        total = votes[0] + votes[1] + votes[2]; // total up number of votes
    }
    
    // Generate the percent of votes per contestent
    public double[] getPercents(){
        //String[] perFormated = new String[3];
        //DecimalFormat percent = new DecimalFormat("00.00%");
        for(int p = 0; p < 3; p++){
            // number of votes divided by total votes
            percents[p] = ((double)(votes[p]) / (double)(total));
            //perFormated[p] = percent.format(percents[p]);
        }
        return percents;
    }
    
    // Old code for back in the day when we used bars...
    public int[] getBarSizes(int barH){
        int[] heights = new int[3];
        for(int i=0; i < percents.length; i++){
            heights[i] = (int) (barH * percents[i]);
        }
        return heights;
    }
    
}
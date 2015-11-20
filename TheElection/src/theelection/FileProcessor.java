package theelection;

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
    Scanner file;
    String[] names = new String[3];
    int[] votes = new int[3];
    double[] percents = new double[3];
    int total;
    public FileProcessor(String fileName) throws FileNotFoundException{
        try{
            File fileGiven = new File(fileName);
            FileReader fw = new FileReader(fileGiven);
            BufferedReader bReader = new BufferedReader(fw);
            file = new Scanner(bReader);
        }catch(FileNotFoundException e){
            System.out.println("'File not Found! :" + e); // print error information
        }
    }
    
    public String[] getNames(){
        for(int n=0; n<3; n++){
            names[n] = file.nextLine();
        }
        return names;
    }
    
    public void tallyVotes(){
        while(file.hasNext()){
            votes[file.nextInt()-1]++;
        }
        total = votes[0] + votes[1] + votes[2];
    }
    
    public String[] getPercents(){
        String[] perFormated = new String[3];
        DecimalFormat percent = new DecimalFormat("00.00%");
        for(int p = 0; p < 3; p++){
            percents[p] = ((double)(votes[p]) / (double)(total));
            perFormated[p] = percent.format(percents[p]);
        }
        return perFormated;
    }
    
    public int[] getBarSizes(int barH){
        int[] heights = new int[3];
        for(int i=0; i < percents.length; i++){
            heights[i] = (int) (barH * percents[i]);
        }
        return heights;
    }
    
}
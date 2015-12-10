package reviewunit3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReviewUnit3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getTestFile();
        
        ArrayList<Product> pros = new ArrayList<>();
        try{
            File file = new File("data.txt");
            Scanner fileS = new Scanner(file);
            
            while(fileS.hasNext()){
                pros.add(new Product(fileS.nextInt(), fileS.nextDouble()));
            }
        }catch(Exception e){
            
        }
        
        /*for(Product pro : pros){
            System.out.println(pro.toString());
        }*/
        
        String output = "";
        
        Collections.sort(pros);
        output += "-- Least Expensive 10 -- \n";
        for(int i=0; i < 10; i++){
            output += pros.get(i).toString() + "\n";
        }
        
        Collections.sort(pros, Collections.reverseOrder());
        output += "-- Most Expensive 10 -- \n";
        for(int i=0; i < 10; i++){
            output += pros.get(i).toString() + "\n";
        }
        
        System.out.println(output);
                
    }
    
    public static void getTestFile(){
        Random rand = new Random();
        String output = "";
        DecimalFormat format = new DecimalFormat("0.00");
        NumberFormat idFormat = new DecimalFormat("000000");
        
        for(int i=0; i < rand.nextInt(10000); i++){
            output+= idFormat.format(rand.nextInt(1000000)) + "\n"
                    + format.format(rand.nextDouble()*5000) + "\n";
        }
        
        //System.out.println(output);
        
        try {
            File data = new File("data.txt");
            FileWriter dataW = new FileWriter(data);
            BufferedWriter dataBW = new BufferedWriter(dataW);
            
            dataBW.write(output);
            dataBW.close();
        } catch (IOException ex) {
            Logger.getLogger(ReviewUnit3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

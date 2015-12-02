/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangledetection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author tecnologic
 */
public class RectangleDetection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //setTestFile();
        
        int[][] points = getPointsFile("points.txt");
        
        Rectangle[] recs = new Rectangle[2];
        recs[0] = new Rectangle();
        recs[1] = new Rectangle();
        recs[0].setCoord(points[0]);
        recs[1].setCoord(points[1]);
        
        System.out.println(isAbove(recs) + " " + isBelow(recs) + " " 
                + isLeft(recs) + " " + isRight(recs));
        
        if(!(isAbove(recs) || isBelow(recs) || isLeft(recs) || isRight(recs))){
            System.out.println("Are Interecting");
        }else{
            System.out.println("Are NOT Interecting");
        }
    }
    
    // If first is above second
    public static boolean isAbove(Rectangle[] recs){
        return recs[0].getMinY() < recs[1].getMaxY();
    }
    // If first is below second
    public static boolean isBelow(Rectangle[] recs){
        return recs[0].getMinY() > recs[1].getMaxY();
    }
    // If first is left of second
    public static boolean isLeft(Rectangle[] recs){
        return recs[0].getMaxX() < recs[1].getMinX();
    }
    // If first is right of second
    public static boolean isRight(Rectangle[] recs){
        return recs[0].getMinX() < recs[1].getMaxX();
    }
    
    public static int[][] getPointsFile(String fileName){
        int[][] data = new int[2][8];
        try{
            File pFile = new File(fileName);
            Scanner points = new Scanner(pFile);
            for(int rec=0; rec < 2; rec++){
                for(int line=0; line < 8; line++){
                    if(points.hasNext()){
                        data[rec][line] = points.nextInt();
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    public static void setTestFile(){
        int x = getRandNum(100, 0); // x: top left
        int y = getRandNum(100, 0); // y: top left
        
        int h = getRandNum(20, 1);
        int w = getRandNum(20, 1);
        
        int[][] rec1 = getRec(w, h, x, y);
        
        x = getRandNum(100, 0); // x: top left
        y = getRandNum(100, 0); // y: top left
        
        h = getRandNum(20, 1);
        w = getRandNum(20, 1);
        
        int[][] rec2 = getRec(w, h, x, y);
        
        try{
            File pFile = new File("points.txt");
            FileWriter pwFile = new FileWriter(pFile);
            
            for(int l1=0; l1 < rec1.length; l1++){
                for(int l2=0; l2 < rec1[l1].length; l2++){
                    pwFile.write(rec1[l1][l2] + "\n");
                }
            }
            for(int l1=0; l1 < rec2.length; l1++){
                for(int l2=0; l2 < rec2[l1].length; l2++){
                    pwFile.write(rec2[l1][l2] + "\n");
                }
            }
            
            pwFile.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static int[][] getRec(int w, int h, int x, int y){
        int[][] rec = new int[4][2]; // four conors, tl, tr, bl, br
        rec[0][0] = x;
        rec[0][1] = y;
        
        rec[1][0] = rec[0][0] + w;   // x: top right
        rec[1][1] = rec[0][1];       // y: top right
        rec[2][0] = rec[0][0];       // x: bottom left
        rec[2][1] = rec[0][1] + h;   // y: bottom left
        rec[3][0] = rec[0][0] + w;   // x: bottom right
        rec[3][1] = rec[0][1] + h;   // y: bottom right
        
        return rec;
    }
    
    // Getter method for randum numbers
    public static int getRandNum(int max, int min){
        max = max - (min - 1); //set max
        int randomNum = min + (int)(Math.random()*max); //grab random num
        return randomNum; // retrun number
    }
}

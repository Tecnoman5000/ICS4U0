/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangledetection;

import java.util.Arrays;

/**
 *
 * @author tecnologic
 */
public class Rectangle {
    int[][] coordinates =  new int[2][4]; // x, y
    
    public Rectangle(){
        
    }
    
    public void setCoord(int[] coord){
        int num = 0;
        for(int i=0; i < 4; i++){
                coordinates[0][i] = coord[num];
                num++;
                coordinates[1][i] = coord[num];
                num++;
        }
        Arrays.sort(coordinates[0]);
        Arrays.sort(coordinates[1]);
    }
    
    public int getMinY(){
        return coordinates[1][0];
    }
    public int getMaxY(){
        return coordinates[1][3];
    }
    public int getMinX(){
        return coordinates[0][0];
    }
    public int getMaxX(){
        return coordinates[0][3];
    }
}

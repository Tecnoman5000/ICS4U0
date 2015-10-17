package copter;
/**
 *
 * @author tecnologic
 */

import java.awt.Color;

public class Block {
    Color c = Color.green;
    int xLoc;
    int yLoc;
    int length;
    int width;
    
    public Block(){
        
    }
    
    public Block(int xPosGiven, int panelHeight, boolean isBottom, int widthGiven){
        width = widthGiven;
        xLoc = width * xPosGiven;
        length = getHeight(panelHeight);
        if(!isBottom){
            yLoc = 0;
        }else{
            yLoc = panelHeight - length - 29;
        }
        
    }
    
    // Getter method for randum numbers
    private int getHeight(int x){
        int min = x / 10;
        int max = (x / 4) + (x / 20);
        max = max - (min - 1); //set max
        int randomNum = min + (int)(Math.random()*max); //grab random num
        return randomNum; // retrun number
    }
    
    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

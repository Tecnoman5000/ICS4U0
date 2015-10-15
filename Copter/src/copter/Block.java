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
    
    public Block(int xPosGiven, int yLocGiven, int lengthGiven, int widthGiven){
        width = widthGiven;
        xLoc = width * xPosGiven;
        yLoc = yLocGiven;
        length = lengthGiven;
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

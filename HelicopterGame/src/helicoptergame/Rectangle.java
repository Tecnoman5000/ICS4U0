
package helicoptergame;

import java.awt.Color;

// This is the class that will remember information about the
// rectangles that form the inside of the cave.
public class Rectangle {
    
    int offset;
    int height;
    Color color;
    boolean barrier;

    public Rectangle() {
        offset = 0;
        height = 0;
        color = Color.BLACK;
        barrier = false;
    }

    public Rectangle(int offset,int height, Color color, boolean barrier) {
        this.offset = offset;
        this.height = height;
        this.color = color;
        this.barrier = barrier;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
    
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isBarrier() {
        return barrier;
    }

    public void setBarrier(boolean barrier) {
        this.barrier = barrier;
    }

}

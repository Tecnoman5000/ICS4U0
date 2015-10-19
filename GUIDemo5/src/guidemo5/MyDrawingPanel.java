
package guidemo5;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyDrawingPanel extends JPanel{
    
    Color currentColor = Color.BLACK;
    int xLoc = 50;
    int yLoc = 50;
    int diam = 25;
    boolean drawCircle = true;
    boolean drawSquare = false;
    
    public MyDrawingPanel()
    {
        
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
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

    public int getDiam() {
        return diam;
    }

    public void setDiam(int diam) {
        this.diam = diam;
    }

    public boolean isDrawCircle() {
        return drawCircle;
    }

    public void setDrawCircle(boolean drawCircle) {
        this.drawCircle = drawCircle;
    }

    public boolean isDrawSquare() {
        return drawSquare;
    }

    public void setDrawSquare(boolean drawSquare) {
        this.drawSquare = drawSquare;
    }
    
    
    public void paintComponent(Graphics g)
    {
       // super.paintComponent(g);
        g.setColor(currentColor);
        
        if (drawCircle == true)
        {
            g.fillOval(xLoc, yLoc, diam, diam);
        }
        if (drawSquare == true)
        {
            g.fillRect(xLoc, yLoc, diam, diam);
        }
    }
    
}

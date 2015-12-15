
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tecnologic
 */
public class ColorPanel extends JComponent{
    Color currentColor;
    
    public ColorPanel(){
        
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color currentColor) {
        this.currentColor = currentColor;
    }
    
    @Override
    public void paintComponent(Graphics g){
       // super.paintComponent(g);
        g.setColor(currentColor);
        g.fillRect(this.getX(), this.getY()-100, this.getWidth(), this.getHeight()+25);
    }
}

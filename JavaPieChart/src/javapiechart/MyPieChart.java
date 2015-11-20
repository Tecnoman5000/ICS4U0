
package javapiechart;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

// The Pie Chart will be our OWN Component
class MyPieChart extends JComponent {
   
    // Keep an ARRAY of slices.  Here is a default
    PieChartSlice[] slices = new PieChartSlice[3];

    // The default constructor - nothing going on here!
    public MyPieChart() 
    {
        slices[0] = new PieChartSlice(5, Color.black); 
        slices[1] = new PieChartSlice(33, Color.green);
        slices[2] = new PieChartSlice(25, Color.red);       
    }
    
    // HMMMMM.  If you wrote a "setter method" here, that would let you
    // "change" the slices, you could change what the pie chart look like!
    
    
    
    
   
    // We will override the paintComponent method to tell the Operating System
    // how to "draw" the component on the screen.
    public void paintComponent(Graphics g) { 
       Graphics2D g2d = (Graphics2D)g;
       drawPieChart(g2d, this.getBounds(), slices);
    }
   
    // This method actually draws the "slices" of the pie.  It uses the
    // fillArc method in the Graphics class to draw the "arcs"
    void drawPieChart(Graphics2D g2d, Rectangle area, PieChartSlice[] slices) {
      
        // ADD UP all of the slices values
        double total = 0.0;
        for (int i = 0; i < slices.length; i++) {
           total += slices[i].getValue();
        }
      
        // Need to keep track of the angles as we go around the circle
        double curValue = 0.0;
        int startAngle = 0;
        for (int i = 0; i < slices.length; i++) {
            // Calculate each slice's starting angle position and arc angle size
            startAngle = (int) ((curValue * 360) / total);
            int arcAngle = (int) ((slices[i].getValue() * 360) / total);
            // Set the right colour and draw it!
            g2d.setColor(slices[i].getColor());
            g2d.fillArc(area.x, area.y, area.width-area.x, area.height-area.y, 
            startAngle, arcAngle);
            curValue += slices[i].getValue();
        }
    }
}


package animationthreaddemo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;


public class AnimationPanel extends JPanel{
    
    int xc = 0;
    int yc = 0;
    int dc = 20;
    Color cc = Color.MAGENTA;
    
    // A pointer to our Animation Thread
    Thread jimmy;
    
    // We need this pointer to we can ask the
    // panel to "repaint()" itself from INSIDE
    // the INNER ElfTask class
    AnimationPanel thisPanel;
    
    
    public AnimationPanel()
    {
        super();
        
        // Create the "clipboard" task for Jimmy
        ElfTask et = new ElfTask();
        // Create Jimmy and give him the clipboard
        jimmy = new Thread(et);
        // Set the panel "selfie" pointer 
        thisPanel = this;
        // Tell Jimmy to get to work!
        jimmy.start();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        // Paint the circles on the screen
        g.setColor(cc);
        g.fillOval(xc, yc, dc, dc);
    }
    
    public void updateScreen()
    {
        // Choose a new location/size for the circle
        Random r = new Random();
        xc = r.nextInt(100);
        yc = r.nextInt(100);
        dc = r.nextInt(40)+10;        
    }
    
    // This is the "clipboard" object we will give Jimmy
    public class ElfTask implements Runnable
    {       
        public void run()
        {
            // Let's run the animation 100 times
            for (int count = 1; count <= 100; count++)
            {
                // change circle position
                updateScreen();
                // repaint the screen
                thisPanel.repaint();
                // have a NAP!!!
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
    }
}

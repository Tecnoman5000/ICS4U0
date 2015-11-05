
package helicoptergame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JPanel;
import java.util.Random;

// Extend the base JPanel class to create a new panel we will
// use to draw our cave on.
public class CavePanel extends JPanel {
    
    Image heli;                 // The helicopter image
    
    Thread jimmy;               // Our "Elf" thread
    ElfJob ej;                  // The job for the elf to do
    CavePanel thisPanel;        // A pointer to this panel (itself).  Without this,
                                // the "Elf Job" couldn't "see" the panel to ask
                                // it to repaint itself
  
    final int MAX_RECTS = 60 ;      // The number of rectangles we will draw
    final int RECT_HEIGHT = 100;    // The height of each "black" rectangle
    final int MIN_RECT_HEIGHT = 50; // The minimum height of each rectangle
    final int MIN_OFFSET = 25;      // The rectangles top will never be less
    final int MAX_OFFSET = 75;      // The rectangles top will never be more
    
    int rectangleWidth;             // The rectangle width (calculated)
    int rectangleTop;               // The current rectangle top
    int verticalChange;             // The vertical change between rectangles
    int prevRectangleTop;           
    
    boolean shrinking;              // Is the cave height shrinking?
    boolean expanding;              // Is the cave height expanding?
   
    Rectangle [] rectangles;        // This array will keep track of the rectangles
                                          
    Random rand;                    // A random number generator
    int ticks;                      // A variable to "count" the number of repaints
    
    
    // The Cave Panel constructor.  Initialize all variables.
    public CavePanel(){
        super();
        
        rectangles = new Rectangle[MAX_RECTS];
        
        // Load the helicopter image file 
        URL imageURL = this.getClass().getClassLoader().getResource("heli.png");
        heli = Toolkit.getDefaultToolkit().getImage(imageURL);
        
        jimmy = new Thread();
        ej = new ElfJob();
        thisPanel = this;
        
        // When first constructed, set all of the rectangles to the same offset
        // and colour
        for (int index=0; index < rectangles.length; ++index){
            rectangles[index] = new Rectangle(MIN_OFFSET,RECT_HEIGHT,Color.BLACK,false);
        }
        
        rand = new Random(); // Create a random number generator  
        ticks = 0;
        shrinking = false;
        expanding = false;
    }
    
    //--------------------------------------------------------------------------
    // The moveScreen method
    //--------------------------------------------------------------------------
    public void moveScreen(){
        
        ticks++;
                  
        // STEP 1: Shift all of the values in the rectangle, height, colours
        //         and barrier arrays to the left
        //----------------------------------------------------------------------

        for(int index = 0; index < rectangles.length - 1; ++index){
            rectangles[index].setOffset(rectangles[index+1].getOffset());
            rectangles[index].setHeight(rectangles[index+1].getHeight());
            rectangles[index].setColor(rectangles[index+1].getColor());
            rectangles[index].setBarrier(rectangles[index+1].isBarrier());
        }
        
        // STEP 2: Choose a new random offset for the new rectangle
        // ---------------------------------------------------------------------
  
        // The vertical change will range from -8 to +8
        verticalChange = rand.nextInt(17) - 8;         
        // Determine where the next rectangle top will be relative to last one
        rectangleTop = rectangles[rectangles.length-1].getOffset() + verticalChange;           
        // Prevent it from exceeding limits
        if (rectangleTop < MIN_OFFSET){
            rectangleTop = MIN_OFFSET;
        }
        if (rectangleTop > MAX_OFFSET){
            rectangleTop = MAX_OFFSET;
        }
        // store this new rectangle top value in the array (last slot)
        rectangles[rectangles.length-1].setOffset(rectangleTop);
        
  
        // STEP 3: Control the shrinking and expanding of cave height (if required)
        // ---------------------------------------------------------------------
  
        // If the cave is currently at the maximum or minimum height, roll a dice
        // to start shrinking or expanding
        if (rectangles[rectangles.length-2].getHeight() == RECT_HEIGHT){
            int roll = rand.nextInt(10);
            if (roll == 0){
                shrinking = true;
                expanding = false;
            }    
        }
        if (rectangles[rectangles.length-2].getHeight() == MIN_RECT_HEIGHT){
            int roll = rand.nextInt(10);
            if (roll == 0){
                shrinking = false;
                expanding = true;
            }    
        }
        
        if ((shrinking)&&(rectangles[rectangles.length-2].getHeight() > MIN_RECT_HEIGHT)){
            rectangles[rectangles.length-1].setHeight(rectangles[rectangles.length-2].getHeight() - 5);
        }
        if ((expanding)&&(rectangles[rectangles.length-2].getHeight() < RECT_HEIGHT)){
            rectangles[rectangles.length-1].setHeight(rectangles[rectangles.length-2].getHeight() + 5);            
        }
     
        // STEP 4: Decide if there is a barrier here
        // ---------------------------------------------------------------------

        rectangles[rectangles.length-1].setBarrier(false);   // Assume no barrier
        // We will only place barriers when the cave height is at its maximum
        if (rectangles[rectangles.length-1].getHeight() == RECT_HEIGHT){
            int barrierNum = rand.nextInt(10);
            // There is a 10% chance of placing a barrier
            if (barrierNum == 0){
                rectangles[rectangles.length-1].setBarrier(true);
            }
        }
        
        // STEP 5: Choose a new random colour for the new rectangles every 10 repaints
        // ---------------------------------------------------------------------
                
        if (ticks % 20 == 0){
            int redNum = rand.nextInt(256);
            int greenNum = rand.nextInt(256);
            int blueNum = rand.nextInt(256);
            Color newColour = new Color(redNum, greenNum,blueNum);
            rectangles[rectangles.length-1].setColor(newColour);
        }
    } 
        
    //--------------------------------------------------------------------------
    // The paintComponent method
    //--------------------------------------------------------------------------
    public void paintComponent(Graphics g){
        super.paintComponent(g);            // Call the parent class

        this.setBackground(Color.GREEN);    // Paint background green
        
         
        // STEP 6: Use the values in the array to draw the cave and barrier on the screen
        // ---------------------------------------------------------------------
      
        rectangleWidth = this.getWidth()/MAX_RECTS; // Calculate rectangle width
        for(int index = 0; index < rectangles.length; ++index){
            g.setColor(rectangles[index].getColor());            // Paint rectangles black
            g.fillRect(index*rectangleWidth, rectangles[index].getOffset(), rectangleWidth, rectangles[index].getHeight());
            if (rectangles[index].isBarrier()){
                g.setColor(Color.GREEN);            // Paint barriers green
                g.fillRect(index*rectangleWidth, rectangles[index].getOffset() + 40, rectangleWidth, 20);
            }  
        }
        
        // STEP 7: Draw the helicopter
        // ---------------------------------------------------------------------
        
        g.drawImage(heli, 75, 75, null);
      
    } 
    
    public void startJimmy(){
        if (!jimmy.isAlive()){
            jimmy = new Thread(ej);
            ej.setDie(false);                   // A new lease on life for Jimmy
        }
        jimmy.start();                          // Get to work!
    }

    public void stopJimmy(){
       ej.setDie(true);                         // R.I.P. Jimmy
    }    
    
    
    //------------------------------------------------------------------------
    // This is the ElfJob class that contains the "run()" method.
    //------------------------------------------------------------------------
    public class ElfJob implements Runnable{
        
        int sleepTime=50;
        
        boolean die = false;

        public void run(){

           while (!die){

                try{
                    
                    Thread.sleep(sleepTime);    // Have a"nap"
                    
                    thisPanel.moveScreen();     // "Move" the screen
                    thisPanel.repaint();        // Tell the panel to "repaint"

                }//end of try
                
                catch(InterruptedException ex){
                    ex.printStackTrace();
                }// end of catch

            }//end while
           
        }// end run


        //This method allows us to change the "die" variable
        //so we can control when the thread stops looping
        public void setDie(boolean d){
            die=d;
        }

    }//end of ElfJob Class    
       
}

package copter;

//import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class CopterPanel extends JPanel{
    int panelWidth = 500;
    int panelHeight = 450;
    int numBlocks = 25;
    Block[] blocks = new Block[numBlocks*2];
    
    Thread blocksThread;
    
    public CopterPanel(){
        super();
        MoveBlocks mBlocks = new MoveBlocks();
        blocksThread =  new Thread(mBlocks);
        
        this.setSize(panelWidth, panelHeight);
        buildBlocks();
        
        blocksThread.start();
    }
    
    // Create All the blocks needed
    private void buildBlocks(){
        // Create the first ten blocks
        for(int bs=0; bs < blocks.length; bs++){
            if(bs < blocks.length/2){    
                blocks[bs] = new Block(bs, panelHeight, false, 
                    this.getWidth()/numBlocks);
            }else if(bs >= blocks.length/2){
                blocks[bs] = new Block(bs-(blocks.length/2), panelHeight, true,
                    this.getWidth()/numBlocks);
            }
        }
    }
    
    // Shift the blocks right one
    public void shiftBlocks(){
        // Move all the blocks up one in the array
        for(int bt=(blocks.length/2)-1; bt > 0; bt--){
            blocks[bt] = blocks[bt-1];
            blocks[bt].setxLoc(bt*(blocks[bt].width));
        }
        blocks[0] = new Block(0, panelHeight, false, 
                this.getWidth()/numBlocks);
        // 20 - 1 = 19; 20 > 10; 20--;
        for(int bt=blocks.length-1; bt > blocks.length/2; bt--){
            blocks[bt] = blocks[bt-1];
            blocks[bt].setxLoc((bt-blocks.length/2)*(blocks[bt].width));
        }
        blocks[blocks.length/2] = new Block(0, panelHeight, true, 
                this.getWidth()/numBlocks);
    }
    
    // Getter method for randum numbers
    public int getRandomNum(int max, int min){
        max = max - (min - 1); //set max
        int randomNum = min + (int)(Math.random()*max); //grab random num
        return randomNum; // retrun number
    }
    
    // Paint objects on screen
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for (int bs=0; bs < blocks.length;bs++){
            g.setColor(blocks[bs].getC());
            g.fillRect(blocks[bs].xLoc, blocks[bs].yLoc, 
                    blocks[bs].width, blocks[bs].length);
        }
    }
    
    // Thread Class
    public class MoveBlocks implements Runnable{
        public void run(){
            while(true){
                // Move Blocks
                shiftBlocks();
                // Repaint Screen
                repaint();
                try {
                    // Sleep Thread
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CopterPanel.class.getName()).log(Level.SEVERE, null, ex);
                    ex.printStackTrace();
                }
            }
        }
    }
}


package copter;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class CopterPanel extends JPanel{
    int panelWidth = 500;
    int panelHeight = 450;
    Block[] blocksTop = new Block[10];
    Block[] blocksBottom = new Block[10];
    
    public CopterPanel(){
        this.setSize(panelWidth, panelHeight);
        buildBlocks();
    }
    
    public void buildBlocks(){
        // Create the first ten blocks
            // Top
        for(int bt=0; bt < blocksTop.length; bt++){
            int randNum = getRandomNum(this.getHeight()/4, this.getHeight()/10);
            blocksTop[bt] = new Block(bt, 0, randNum, this.getWidth()/10);
        }
            // Bottom
        for(int bb=0; bb < blocksBottom.length; bb++){
            int randNum = getRandomNum(this.getHeight()/4, this.getHeight()/10);
            blocksBottom[bb] = new Block(bb, this.getHeight()-randNum+5, randNum, this.getWidth()/10);   
        }
    }
    public void shiftBlocks(){
        // Move all the blocks up one in the array
            // Top
        for(int bt=blocksTop.length-1; bt > 0; bt--){
            blocksTop[bt] = blocksTop[bt-1];
            blocksTop[bt].setxLoc(bt*(blocksTop[bt].width));
        }
            // Bottom
        for(int bt=blocksBottom.length-1; bt > 0; bt--){
            blocksBottom[bt] = blocksBottom[bt-1];
            blocksBottom[bt].setxLoc((bt)*blocksBottom[bt].width);
        }
        // Add new Blocks to the start of the array
            // Top
        int randNum = getRandomNum(this.getHeight()/4, this.getHeight()/10);
        blocksTop[0] = new Block(0, 0, randNum, this.getWidth()/10);
            // Bottom
        randNum = getRandomNum(this.getHeight()/4, this.getHeight()/10);
        blocksBottom[0] = new Block(0, this.getHeight()-randNum+5, randNum, 
                this.getWidth()/10);
    }
    
    // Getter method for randum numbers
    public int getRandomNum(int max, int min){
        max = max - (min - 1); //set max
        int randomNum = min + (int)(Math.random()*max); //grab random num
        return randomNum; // retrun number
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Block blocksTop1 : blocksTop) {
            g.setColor(blocksTop1.getC());
            g.fillRect(blocksTop1.xLoc, blocksTop1.yLoc, 
                    blocksTop1.width, blocksTop1.length);
            //System.out.println("BlockTop" + blocksTop1 + ": " + 
            //        blocksTop1.getxLoc() + " " + blocksTop1.getyLoc());
        }
        for (Block blocksBottom1 : blocksBottom) {
            g.setColor(blocksBottom1.getC());
            g.fillRect(blocksBottom1.xLoc, blocksBottom1.yLoc, 
                    blocksBottom1.width, blocksBottom1.length);
            //System.out.println("BlockBottom" + blocksBottom1 + ": " + 
            //        blocksBottom1.getxLoc() + " " + blocksBottom1.getyLoc());
        }
    }
    
}

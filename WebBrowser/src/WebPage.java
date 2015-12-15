
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tecnologic
 */
public class WebPage {
    String link = "";
    Color contents = new Color(0,0,0);
    
    public WebPage(String url, Color color){
        link = url;
        contents = color;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Color getContents() {
        return contents;
    }

    public void setContents(Color contents) {
        this.contents = contents;
    }
    
    public String toString(){
        
        return "Link: " + link + "\n\tColor: " + contents.toString();
    }
}

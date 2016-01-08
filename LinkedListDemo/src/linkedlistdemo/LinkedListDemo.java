/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlistdemo;

/**
 *
 * @author tecnologic
 */
public class LinkedListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LinkedList ll = new LinkedList();
        System.out.println(ll.isEmpty());
        ll.addNode("A");
        ll.addNode("B");
        ll.addNode("C");
        ll.addNode("D");
        ll.addNode("E");
        ll.addNode("F");
        System.out.println(ll);
        
        ll.removeNode("E");
        System.out.println(ll);
        
        ll.insertNode("A", "Z");
        System.out.println(ll);
    }
    
}

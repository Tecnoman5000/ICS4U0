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
public class LinkedList {
    Node head; // will have next
    Node tail; // will have previous
    int size = 0;
    
    public LinkedList(){
        
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node Tail) {
        this.tail = Tail;
    }
    
    public boolean isEmpty(){
        return !(size > 0);
    }
    
    public void addNode(String value){
        if(this.isEmpty()){
            System.out.println("setting head");
            head = new Node(value);
            size++;
        }else if(size == 1 && tail == null){
            tail = new Node(head, null, value);
            head.setNext(tail);
            size++;
        }else{
            Node current = new Node(tail, null, value);
            tail.setNext(current);
            tail = current;
            size++;
        }
    }
    
    public void removeNode(String value){
        Node current = head;
        while(current != null && !current.getValue().equals(value)){
            current = current.getNext();
        }
        
        current.getNext().setPrev(current.getPrev());
        current.getPrev().setNext(current.getNext());
        current = null;
        size--;
    }
    
    public void insertNode(String beforeValue, String value){
        Node current = head;
        System.out.println("Value: " + beforeValue + " Node Value: " 
                + current.getValue() + " " 
                + current.getValue().equals(beforeValue));
        while(current != null && !current.getValue().equals(beforeValue)){
            current = current.getNext();
        }
        Node newNode = new Node(current.getPrev(), current.getNext(), value);
        size++;
    }

    @Override
    public String toString() {
        String output = "LinkedList{";
        Node current = head;
        while(current != null){
            output += current.getValue() + ", ";
            current = current.getNext();
        }
        
        return output + "} Size: " + this.size;
    }
    
    
}

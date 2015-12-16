/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackdemo;

import java.util.ArrayList;

/**
 *
 * @author tecnologic
 */
public class Stack {
    public Stack(){
        
    }
    
    ArrayList<Integer> stack = new ArrayList<>();

    public void push(int i){
        stack.add(i);
    }
    
    public int pop(){
        int top = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return top;
    }
    
    public int size(){
        return stack.size();
    }
    
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    
    public int top(){
        return stack.get(stack.size()-1);
    }
    
    public String toString(){
        return stack.toString();
    }
}

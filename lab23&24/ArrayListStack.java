package csci152.impl;

import csci152.adt.Stack;
import java.util.ArrayList;

public class ArrayListStack<T> implements Stack<T>{
    
    private ArrayList<T> values;

    public ArrayListStack(){
        values = new ArrayList<T>();
    }
    
    @Override
    public void push(T value) {
        values.add(values.size(), value);
    }
    
    @Override
    public T pop() throws Exception {
        if(values.size()==0)
            throw new Exception("The stack is empty!");
        
        return values.remove(values.size()-1);
    }
   
    @Override
    public int getSize() {
        return values.size();
    }
    
    @Override
    public void clear() {
        values.clear();
    }
    
    public String toString(){
        String str="";
        for(int i = 0; i < values.size(); i++){
            str += values.get(i);
            str += " ";
        }
        return str + "\n" + "Size of the stack: " + values.size();
    }
}

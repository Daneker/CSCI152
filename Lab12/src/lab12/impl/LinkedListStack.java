package lab12.impl;
import lab12.adt.Stack;

public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;
    
    public LinkedListStack(){
        top = null;
        size = 0;
    }
    
    @Override
    public void push(T value) {
        Node<T> newTop = new Node(value);
        if(size>0) newTop.setLink(top);
        top = newTop; 
        size++;
    }

    @Override
    public T pop() throws Exception {
       if(size == 0) throw new Exception("Stack is empty");
       T result = top.getValue(); 
       if( size == 1) top =null;
       else{
        top.setValue(top.getLink().getValue());
        top.setLink(top.getLink().getLink());                 
       }
        size--;
       return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }
    
    @Override
    public String toString(){
        String result = "";
        Node current = top;
        while(current!=null){
            result += current+",";
            current = current.getLink();
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
        
}

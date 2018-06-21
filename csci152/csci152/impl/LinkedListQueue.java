package csci152.impl;
import csci152.adt.Queue;

public class LinkedListQueue<T> implements Queue<T> {
    
    private int size;
    private Node<T> front;
    private Node<T> back;

    public LinkedListQueue(){
        front = null;
        back = null;
        size = 0;
    }
    
    @Override
    public void enqueue(T value){
        Node<T> temp = new Node(value);
        if (size == 0) {
            front = temp;
            back = front;
        } else {
            back.setLink(temp);
            back = temp;     
        }
        size++;
    }
    
    @Override
    public T dequeue() throws Exception {
        if (size == 0) {
            throw new Exception ("Stack is empty");
        }
        T result = front.getValue(); 
        if (size == 1) {
            front = null;
            back = null;
        } else {   
            front = front.getLink();
        }
        size--;
        return result;
    }
        
    @Override    
    public int getSize() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }
       
    @Override
    public String toString(){
        String result = ""; 
        Node<T> c = front;
        while(c != null){
            result += c.getValue() + " ";
            c = c.getLink();
        }
        return result;
    }
 
}


   

    
    
    



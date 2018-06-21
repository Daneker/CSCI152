package lab12.impl;
import lab12.adt.SortedQueue;

public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T> {
    private Node<T> front;
    private int size;
    
    public LinkedListSortedQueue(){
        front = null;
        size = 0;
    }
    
    @Override
    public void insert(T value) {
        Node<T> newNode = new Node(value); 
        
        if(size == 0) {
            front = newNode;
        }else{
           if(value.compareTo(front.getValue()) <=0){
              newNode.setLink(front);
              front = newNode;
           } else{
               Node<T> c = front;
               Node<T> b = null;
               while(c !=null){
                   if(value.compareTo(c.getValue()) <= 0){
                       newNode.setLink(c);
                       b.setLink(newNode);                       
                       break;
                   }
                   b = c;
                   c = c.getLink();
               }
               if(c == null){
                   b.setLink(newNode);
               }    
           }
        }
        size++;
    }

   
    @Override
    public T dequeue() throws Exception {
        if(size == 0) throw new Exception("queue is empty....");
        T result = front.getValue();
        if(size == 1) {
            front = null;  
        } else front = front.getLink();
        size--;
        return result;
    }

    
    @Override
    public int getSize() {  
        return size;
    }

   
    @Override
    public void clear() {
        front = null;
        size = 0;
    }
    
    
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    
    @Override
    public String toString(){
        String result = "";
        Node<T> current = front;
        while(current != null){
            result += current.getValue()+" ";
            current = current.getLink();
        }    
        return result;
    }

    
}

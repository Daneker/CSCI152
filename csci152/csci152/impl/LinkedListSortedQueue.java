package csci152.impl;
import csci152.adt.SortedQueue;

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
        } else {
            // newNode goes before front
            Node<T> temp = front;
            if(value.compareTo(front.getValue()) <= 0){
                newNode.setLink(front);
                front = newNode;
            } 
            // newNode goes somewhere in the middle
            else {
                Node<T> curr = front;
                int l = 0;
                if(value.compareTo(temp.getValue()) > 0) {
                    while(temp!=null && value.compareTo(temp.getValue())>0) {
                        temp = temp.getLink();
                        l++;
                    }
                    for(int i = 0; i < l - 1; i++){
                        curr = curr.getLink();
                    }
                    newNode.setLink(temp);
                    curr.setLink(newNode);
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

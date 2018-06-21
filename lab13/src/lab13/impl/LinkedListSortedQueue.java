package lab13.impl;
import lab13.adt.SortedQueue;


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
		if (size==0) {
			front=newNode;
		}
		else {
			Node<T> temp = front;
			if (value.compareTo(temp.getValue())<=0) {
				newNode.setLink(front);
				front=newNode;
			}
		Node<T> cur = front;
		int l=0;
			if (value.compareTo(temp.getValue())>0){
					while (temp!=null && value.compareTo(temp.getValue())>0){
						temp=temp.getLink();
						l++;
					}
					for (int i=0; i<l-1; i++) {
						cur=cur.getLink();
						}
					
					newNode.setLink(temp);
					cur.setLink(newNode);
					
		}}
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
        String result="";
        Node<T> current = front;
        while(current != null){
            result += current.getValue()+" ";
            current = current.getLink();
        }
        
        return result;
    }

    
}

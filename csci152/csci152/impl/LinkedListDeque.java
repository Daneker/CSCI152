/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;
import csci152.adt.Deque;


/**
 *
 * @author User
 * @param <T>
 */
public class LinkedListDeque <T> implements Deque <T>{    
    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;
    private int size;
    
    public LinkedListDeque(){
        size=0;
        front=null;
        back=null;
    }
   
    @Override
    public void pushToFront(T value) {
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode(value);
        if(size == 0) {
            front = newNode;
            back = newNode;
        } else {
            newNode.setNext(front);
            front.setPrevious(newNode);
            front = newNode;
        }
        size++;
        
    }

    @Override
    public void pushToBack(T value) {
        DoublyLinkedNode<T> newNode= new DoublyLinkedNode(value); 
        if(size == 0) {
            back = newNode;
            front = newNode; 
        } else {
            back.setNext(newNode);
            newNode.setPrevious(back);
            back = newNode;
        }
        size++;
    }

   
    @Override
    public T popFromFront() throws Exception {
        T result = front.getValue();   
        if(size == 0) {
            throw new Exception("Deque is empty");
        } 
        if(size == 1) {
            front = null;
            back = null;
        } else {
            front = front.getNext();
            front.setPrevious(null);
        }
        size--;
        return result; 
        
    }

    @Override
    public T popFromBack() throws Exception {       
        T result = back.getValue();
        if (size == 0) {
            throw new Exception ("The deque is empty");
        }
        if(size == 1) {
            front = null;
            back = null;
        } else {   
            back = back.getPrevious();
            back.setNext(null);
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
        size=0;
        front = null;
        back = null;
    }
    
    @Override
    public String toString(){
        String result = " [";
        DoublyLinkedNode <T> current = front;
        while(current != null){
            result += " " + current.getValue();
            current = current.getNext();   
        }   
        return result + " ] " + "size: " + size;
    }

}


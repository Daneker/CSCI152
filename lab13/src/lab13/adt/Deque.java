/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13.adt;

/**
 *
 * @author User
 * @param <T> generic type T
 */
public interface Deque <T> {
    /**
     * adds an element to the front of the deque
     * @param value element to be added
     */
    public void pushToFront(T value);
    /**
     * adds an element to the back of the deque
     * @param value element to added 
     */
    public void pushToBack(T value);
    /**
     * removes and returns the front most element of the deque
     * @return the front most element of the deque
     * @throws Exception if the deque is empty
     */
    public T popFromFront()throws Exception;
    /**
     * 
     * @return the last element of the deque
     * @throws Exception if the deque is empty
     */
    public T popFromBack() throws Exception;
    /**
     * 
     * @return the size of the deque
     */
    public int getSize();
    /**
     * removes all items from the deque
     */
    public void clear();
    /**
     * 
     * @return the String representation of the deque 
     */
    @Override
    public String toString();
    
}


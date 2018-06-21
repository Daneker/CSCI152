/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.IntQueue;

/**
 *
 * @author Пользователь
 */
public class ArrayIntQueue implements IntQueue {
    
    private int[] values;
    private int size;
    private int front;
    private int back;
    
    public ArrayIntQueue() {
        values = new int[5];
        size = 0;
        front = 0;
        back = 0;
}

    @Override
    public void enqueue(int value) {
        if(size == values.length) {
            int[] newVals = new int[values.length*2];
            int f = front;
            for (int i = 0; i < values.length; i++) {
                newVals[i] = values[f];
                        f = (f + 1) % values.length;
            }
            values = newVals;
            front = 0;
            back = size;
        }

    }

    @Override
    public int dequeue() throws Exception {
        if(size == 0) {
            throw new Exception ("queue is empty!!!");
        }
       int result = values[front];
       front++;
       front = (front + 1) % values.length;
       size--;
       return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        values = new int[5];
        size = 0;
        front = 0;
        back = 0;
    }
    
    @Override
    public String toString() {
        String result = "front[";
        int j = front;
        for (int i = 0; i < size; i++) {
            result += " " + values[j]+ " ";
            j = (j + 1) % values.length;
        }
        return result + "]back";
    }
}

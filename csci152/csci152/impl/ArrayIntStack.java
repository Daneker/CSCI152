/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci152.impl;

import csci152.adt.IntStack;

/**
 *
 * @author Пользователь
 */
public class ArrayIntStack implements IntStack {
    
    private int[] values;
    private  int size;
    
    public ArrayIntStack() {
        values = new int[10];
        size = 0;
    }

    @Override
    public void push(int value) {
        if (size == values.length) {
            int[] newStk = new int[size*2];
            for(int i = 0; i < size; i++) {
                newStk[i] = values[i];
                values = newStk;
            }
        }
            values[size] = value;
            size++;       
    }

    @Override
    public int pop() throws Exception {
        if (size == 0) {
            throw new Exception("stack is empty!!!");
        }
        int result = values[size - 1];
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
       values = new int[10];
       size = 0;
    }
    
    public String toString() {
        String result = "[";
        for(int i = 0; i < size; i++) {
            result += values[i] + ", ";
        }
        return result + "]";
    }
    
}

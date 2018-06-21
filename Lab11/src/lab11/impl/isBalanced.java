package lab11.impl;

import lab11.adt.Queue;
import lab11.impl.LinkedListStack;

public class isBalanced {
 
    public isBalanced(){
    }
    public static boolean arePair(char opening, char closing){
        if(opening == '{' && closing == '{') return true;
        else if(opening == '[' && closing == ']') return true;
        else if(opening == '(' && closing == ')') return true;
        return false;
    }

    public static boolean isBalanced(Queue<Character> q) throws Exception {
       
        LinkedListStack<Character> stack  = new LinkedListStack();
        int size = q.getSize();
        for(int i= 0; i<size; i++){
            char c = q.dequeue();
            if(c == '{' || c =='[' || c =='('){
                stack.push(c);
            } else if(c ==')' || c=='}' || c==']'){
                if(!arePair(stack.pop(), c) || stack.isEmpty()) {
                    return false;
                }
            }
        }
        return true;
        
    }
}


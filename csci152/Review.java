
import csci152.adt.Queue;
import csci152.adt.Stack;
import csci152.impl.ArrayIntStack;
import csci152.impl.DoublyLinkedNode;
import csci152.impl.TreeNode;
import static javafx.scene.input.KeyCode.T;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Пользователь
 */
public class Review {
    // Question 5
//    public Stack<Integer> fibonacci(int n) throws Exception {
//        Stack<Integer> stack = (Stack<Integer>) new ArrayIntStack();
////        for( int i = 0; i < n; i++) {
////            if (i == 1 || i == 0) stack.push(1);
////            else {
////                int top = stack.pop();
////                int almost_top = stack.pop();
////                int new_top = top + almost_top;
////                stack.push(almost_top);
////                stack.push(top);
////                stack.push(new_top);
////            }
////        }
////        return stack;
//        int a = 1, b = 1;
//        for(int i = 0; i < n; i++) {
//            if( i == 1 || i ==0) stack.push(1);
//            else {
//                int new_b = a + b;
//                stack.push(new_b);
//                a = b;
//                b = new_b;
//            }
//        }
//        return stack;
//    }
//    
    // Question 7
//    public static int oddCount(Queue<Integer> myQ) throws Exception {
//        int count = 0;
//        for(int i = 0; i < myQ.getSize(); i++) {
//            int result = myQ.dequeue();
//            if(result % 2 == 1) {
//               count++; 
//            }
//            myQ.enqueue(result);
//        }
//        return count;
//    }
    
    //Question 10
//    DoublyLinkedNode<Integer> first = new DoublyLinkedNode(10);
//    DoublyLinkedNode<Integer> second = new DoublyLinkedNode(62);
//    DoublyLinkedNode<Integer> third = new DoublyLinkedNode(112);
//    
//    first.setNext(second);
//    second.setPrevious(first);
//    
//    second.setNext(third);
//    third.setPrevious(second);
//    
//    third.setNext(first);
//    first.setPrevious(third);
    
    //Question 12
//    public int getSize() {
//        return getSizeHelper(root);
//    }
//    
//    private int getSizeHelper(TreeNode<T> node) {
//        if(node == null) return 0;
//        else {
//            return 1 + getSizeHelper(node.getLeft()) 
//                    + getSizeHelper(node.getRight());
//        }
//    }
    
    //Question 14
    public static TreeNode<Integer> mirror(TreeNode<Integer> node) {
        if (node == null) return null;
        else {
            TreeNode<Integer> result = new TreeNode(node.getValue());
            result.setLeft(mirror(node.getRight()));
            result.setRight(mirror(node.getLeft()));
            return result;
        }
    }
}



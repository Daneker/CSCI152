/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab16;
import lab16.impl.TreeNode;

/**
 *
 * @author Пользователь
 */
public class treeExample {
    public static void main (String[] args) {
        
        TreeNode<Integer> node = new TreeNode(12);
        
        node.setLeft(new TreeNode(25));
        node.setRight(new TreeNode(17));
        
        node.getLeft().setLeft(new TreeNode(85));
        node.getLeft().setRight(new TreeNode(75));
        
        node.getRight().setLeft(new TreeNode(-46));
        node.getRight().setRight(new TreeNode(15));  
        
        printTree(node);
    }
    
    public static void printTree(TreeNode<Integer> node) {
       
        if (node == null) {
            return;
        }
//        //pre-order traversal
//        System.out.println(node.getValue() + " ");
//        printTree(node.getLeft());
//        printTree(node.getRight());
        
//        //in-order traversal
        printTree(node.getLeft());
        System.out.println(node.getValue() + " ");
        printTree(node.getRight());
//        
//        //post-order traversal
//        printTree(node.getLeft());
//        printTree(node.getRight());
//        System.out.println(node.getValue() + " ");
    }
    
    
}

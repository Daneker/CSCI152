package lab11;
import lab11.impl.LinkedListQueue;
import lab11.impl.LinkedListStack;
import lab11.impl.isBalanced;

public class lab11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        lab11_1();
        //lab11_2();
    }
     static void lab11_1(){
        LinkedListQueue<Integer> q = new LinkedListQueue();
        try {
            System.out.println(q.dequeue());
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        for(int i =0; i<8; i++){
            q.enqueue(i);
        } 
        System.out.println(q+", size: "+q.getSize());
 
        for(int i=0; i<3; i++)
            try {
                System.out.println(q.dequeue());
            } catch (Exception ex) {
                System.out.println(ex);
            }
        System.out.println(q+", size: "+q.getSize());
        
        for(int i=0; i<9; i++){
            q.enqueue(i);
            q.enqueue(i);
            try {
                q.dequeue();
                q.dequeue();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            System.out.println(q+", size: "+q.getSize());
        }
        System.out.println(q+", size: "+q.getSize());
        q.clear();
        System.out.println(q+", size: "+q.getSize());
    }
    
    static void lab11_2(){
        isBalanced check = new isBalanced();
        LinkedListQueue<Character> q = new LinkedListQueue();
        q.enqueue('[');
        q.enqueue('{');
        q.enqueue('(');
        q.enqueue('{');
        q.enqueue('}'); 
        q.enqueue(')');
        q.enqueue('}');
        q.enqueue(']');
        try {
            System.out.println(check.isBalanced(q));
        } catch (Exception ex) {
            System.out.println(ex);
        }
            
        
    }
    
}

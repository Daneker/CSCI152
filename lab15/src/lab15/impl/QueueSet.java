package lab15.impl;
import lab15.adt.Set;

public class QueueSet<T> implements Set<T> {
    private LinkedListQueue<T> queue;
    public QueueSet() {
        this.queue = new LinkedListQueue<>();
    }

    
    @Override
    public void add(T value) {
        if(!contains(value)){
            queue.enqueue(value);
        }
    }

    @Override
    public boolean contains(T value) {
        
        for(int i=0; i < queue.getSize(); i++){
            try {
                T curr = queue.dequeue();
                queue.enqueue(curr);
                if(curr.equals(value))
                    return true;
            } catch (Exception ex) {
                System.out.println(ex);
            }           
        }       
        return false;
    }

    @Override
    public boolean remove(T value) {
        if(contains(value)){
            LinkedListQueue<T> out = new LinkedListQueue();
            T curr = null;
            try {
                curr = queue.dequeue();
            } catch (Exception e) {
                System.out.println(e);
            }
            
            while(!value.equals(curr)){
                out.enqueue(curr);
                try {
                   curr = queue.dequeue();
                } catch (Exception e) {
                    System.out.println(e);
                }  
            }
            
            int size = out.getSize();
            for(int i=0; i<size; i++ ){
                try {
                    queue.enqueue(out.dequeue());
                } catch (Exception e) {
                    System.out.println(e);
                }      
            }
            return true;
        
        } else {
            return false;
        }
    }

    @Override
    public T removeAny() throws Exception {
        if(queue.getSize() == 0) {
            throw new Exception("queue is empty");
        }
        T result = queue.dequeue();        
        return result;
    }

    @Override
    public int getSize() {
        return queue.getSize();
    }

    @Override
    public void clear() {
        queue.clear();
    }
    
    public String toString(){
        return queue.toString();
    }
}

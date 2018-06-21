package lab15;
import lab15.adt.Set;
import lab15.impl.StackSet;

public class SetCheck {
    public SetCheck() {
    }

    
    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2){
        int size = set1.getSize();
          Set<Integer> curr = new StackSet();

        for (int i = 0; i < size; i++) {
            try {
              Integer temp = set1.removeAny();
              curr.add(temp);
              if(!set2.contains(temp)) return false;  
            } catch (Exception e) {
                System.out.println(e);
            }
        for (int k = 0; k < curr.getSize(); k++) {  
           try {
               set1.add(curr.removeAny());
           } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        }
        return true;
    }
    
    public static Set<String> union(Set<String> set1, Set<String> set2){
       
        Set<String> curr1 = new StackSet();
        Set<String> curr2 = new StackSet();
        Set<String> result = new StackSet();
        int size1 = set1.getSize();
        int size2 = set2.getSize();
        for (int i = 0; i < size1; i++) {
            try {
                String temp = set1.removeAny();
                curr1.add(temp);
                result.add(temp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }            
        }
        for (int i = 0; i < size2; i++) {
            try {
                String temp = set2.removeAny();
                curr2.add(temp);
                result.add(temp);
            } catch (Exception e) {
                System.out.println(e);
            }            
        }
          for (int k = 0; k < size1; k++) {  
           try {
               set1.add(curr1.removeAny());
           } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
            for (int k = 0; k < size2; k++) {  
           try {
               set2.add(curr2.removeAny());
           } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }
    
    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2){
        
         Set<Integer> curr = new StackSet();
        Set<Integer> result = new StackSet();
        int size = set1.getSize();
        for (int i = 0; i < size; i++) {
            try {
                Integer temp = set1.removeAny();
                curr.add(temp);
                if(set2.contains(temp)) result.add(temp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for (int k = 0; k < size; k++) {  
           try {
               set1.add(curr.removeAny());
           } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
       
        return result;
        
    }

}

package csci152.impl;

import java.util.Map;
import java.util.TreeMap;

public class BSTMapTest {

    public static void main(String[] args) {
       
        Map<Integer, String> bstmap = new TreeMap<Integer, String>();
        
        bstmap.put(13, "Madina");
        bstmap.put(12, "Raushan");
        bstmap.put(11, "Salta");
        bstmap.put(10, "Manshuk");
        bstmap.put(9, "Aizhan");
        
        System.out.println(bstmap);
        
        bstmap.remove(11);
        System.out.println(bstmap);
        
        bstmap.remove(11);
        System.out.println(bstmap);
       
        bstmap.put(13,"Adina");
        bstmap.put(10,"Saina");
        System.out.println(bstmap);
        
        bstmap.put(8, "Kaisar");
        bstmap.put(7, "Leo");
        bstmap.put(6, "Basta");
        System.out.println(bstmap);
        
        bstmap.clear();
        System.out.println(bstmap);
        
        bstmap.put(52, "aspan");
        bstmap.put(23, "Qaiyq");
        System.out.println(bstmap);         
    
    }
}


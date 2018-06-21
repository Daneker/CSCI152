
package robot_world;

public class Tester {
    
    public static void main(String[] args) throws Exception {
      
        SuperRobotWorld rw = new SuperRobotWorld("src/robot_world/map1.txt");
        rw.printCurrentWorldMap();
        
        rw.moveForward();
        rw.moveForward();
        
        rw.printCurrentWorldMap();
        
        rw.undoCommand();
        rw.printCurrentWorldMap();
        
        rw.redoUndoneCommand();
        rw.printCurrentWorldMap();
        
        rw.rotateCounterClockwise();
        rw.undoCommand();
        rw.redoUndoneCommand();
        rw.printCurrentWorldMap();
     
        /*for (int i = 0; i < 5; i++) {
        	rw.moveForward();
        	rw.printCurrentWorldMap();
        }*/
    }
}
